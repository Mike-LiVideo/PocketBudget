package com.themtgdeckgenius.widgets;


import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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
    protected EditText gItemName, gItemAmount;
    protected TextView gDialogTitle;
    protected View gDialogRoot;

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
        setContentView(R.layout.dialog_main);

        gDialogRoot = findViewById(R.id.dialog_root);
        gDialogRoot.setOnClickListener(this);
        gDialogTitle = (TextView) findViewById(R.id.dialog_title);
        gDialogTitle.setText(getTitleID());
        gCancelButton = (Button) findViewById(R.id.dialog_cancel_button);
        gSaveButton = (Button) findViewById(R.id.dialog_save_button);
        gCancelButton.setOnClickListener(this);
        gSaveButton.setOnClickListener(this);
        gItemName = (EditText) findViewById(R.id.dialog_item_name);
        gItemName.setHint(getHintID());
        gItemName.setShowSoftInputOnFocus(true);
        gItemAmount = (EditText) findViewById(R.id.dialog_item_amount);
        gItemAmount.setShowSoftInputOnFocus(true);

    }

    @Override
    public void onClick(View v){
        final int id = v.getId();

        switch(id){
            case R.id.dialog_cancel_button:
                onBackPressed();
                break;
            case R.id.dialog_save_button:
                //Save to database
                Toast.makeText(gContext,"Not Implemented Yet", Toast.LENGTH_SHORT).show();
                break;
            case R.id.dialog_root:
                onBackPressed();
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
