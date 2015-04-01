package com.themtgdeckgenius.widgets;


import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.themtgdeckgenius.datacontrol.DatabaseAccessor;
import com.themtgdeckgenius.datacontrol.PocketBudgetContract;
import com.themtgdeckgenius.pocketbudget.R;

/**
 * Created by michael.wheeler on 3/6/2015.
 */
public abstract class DialogBaseActivity
        extends AlertDialog
        implements View.OnClickListener{
    protected DIALOG_TYPE gDialogType;

    protected Context gContext;
    protected Button gCancelButton, gSaveButton;
    protected EditText gItemName, gItemAmount, gItemDate;
    protected TextView gDialogTitle;
    protected CheckBox gAddMultiple;
    private SQLiteDatabase gBudgetDatabase;

    public DialogBaseActivity(Context context){
        super(context, true, null);
        gContext = context;
    }

    protected abstract DIALOG_TYPE getDialogType();

    protected abstract int getTitleID();

    protected abstract int getHintID();

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        gDialogType = getDialogType();
        if(gDialogType == DIALOG_TYPE.ADD_BILL){
            setContentView(R.layout.dialog_bill);
            gItemDate = (EditText) findViewById(R.id.dialog_item_date);
        }
        else{
            setContentView(R.layout.dialog_main);
        }

        final DatabaseAccessor mDatabaseAccessor = new DatabaseAccessor(getContext());
        gBudgetDatabase = mDatabaseAccessor.getWritableDatabase();
        setCanceledOnTouchOutside(false);
        gDialogTitle = (TextView) findViewById(R.id.dialog_title);
        gDialogTitle.setText(getTitleID());
        gCancelButton = (Button) findViewById(R.id.dialog_cancel_button);
        gSaveButton = (Button) findViewById(R.id.dialog_save_button);
        gCancelButton.setOnClickListener(this);
        gSaveButton.setOnClickListener(this);
        gItemName = (EditText) findViewById(R.id.dialog_item_name);
        gItemName.setHint(getHintID());
        gItemName.setOnClickListener(this);
        gItemAmount = (EditText) findViewById(R.id.dialog_item_amount);
        gAddMultiple = (CheckBox) findViewById(R.id.dialog_add_multiple_check_box);
    }

    @Override
    public void onClick(View v){
        final int id = v.getId();
        ContentValues mValues = new ContentValues();
        switch(id){
            case R.id.dialog_cancel_button:
                onBackPressed();
                break;
            case R.id.dialog_save_button:
                if(gItemName.getText().toString().isEmpty() ||  gItemAmount.getText().toString().isEmpty()){
                    Toast.makeText(getContext(), "Save Failed, Please make sure both Source and Amount have values", Toast.LENGTH_LONG).show();
                }else {
                    switch(getDialogType()){
                        case ADD_INCOME:
                            mValues.put(PocketBudgetContract.IncomeTable.COLUMN_NAME_SOURCE, gItemName.getText().toString());
                            mValues.put(PocketBudgetContract.IncomeTable.COLUMN_NAME_AMOUNT, gItemAmount.getText().toString());
                            gBudgetDatabase.insert(PocketBudgetContract.IncomeTable.TABLE_NAME, null, mValues);
                            break;
                        case ADD_BILL:
                            mValues.put(PocketBudgetContract.BillsTable.COLUMN_NAME_SOURCE, gItemName.getText().toString());
                            mValues.put(PocketBudgetContract.BillsTable.COLUMN_NAME_AMOUNT, gItemAmount.getText().toString());
                            mValues.put(PocketBudgetContract.BillsTable.COLUMN_NAME_DUE_DATE, gItemDate.getText().toString());
                            gBudgetDatabase.insert(PocketBudgetContract.BillsTable.TABLE_NAME, null, mValues);
                            break;
                        case ADD_EXPENSE:
                            mValues.put(PocketBudgetContract.ExpenseTable.COLUMN_NAME_SOURCE, gItemName.getText().toString());
                            mValues.put(PocketBudgetContract.ExpenseTable.COLUMN_NAME_AMOUNT, gItemAmount.getText().toString());
                            gBudgetDatabase.insert(PocketBudgetContract.ExpenseTable.TABLE_NAME, null, mValues);
                            break;
                        default:
                            break;
                    }
                    Toast.makeText(getContext(), "Item Successfully Saved", Toast.LENGTH_SHORT).show();
                    gItemName.setText("");
                    gItemAmount.setText("");
                    if(getDialogType() == DIALOG_TYPE.ADD_BILL){
                        gItemDate.setText("");
                    }
                    if (!gAddMultiple.isChecked()){
                        this.dismiss();
                    }

                }
                break;
            default:
                break;
        }
    }

    @Override
    public void onBackPressed(){
        StringBuilder mStringBuilder = new StringBuilder();
        mStringBuilder.append(gContext.getResources().getString(R.string.alert_quit));
        final AlertDialog mAlertDialog = new Builder(gContext).create();
        mAlertDialog.setTitle("??????????");
        mAlertDialog.setMessage(mStringBuilder.toString());
        mAlertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "Yes", new OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which){
                mAlertDialog.dismiss();
                confirmBack();
            }
        });
        mAlertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "No", new OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which){
                mAlertDialog.dismiss();
            }
        });
        mAlertDialog.show();
    }

    public void confirmBack(){
        super.onBackPressed();
    }

    public static enum DIALOG_TYPE{

        ADD_INCOME,
        ADD_BILL,
        ADD_EXPENSE
    }
}