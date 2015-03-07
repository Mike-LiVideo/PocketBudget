package com.themtgdeckgenius.widgets;


import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.themtgdeckgenius.pocketbudget.R;

/**
 * Created by michael.wheeler on 3/6/2015.
 */
public abstract class DialogBaseActivity extends AlertDialog implements View.OnClickListener {
    protected DIALOG_TYPE mDialogType;

    protected Context c;
    protected Button mCancel, mSave;
    protected EditText mItemName, mItemAmount;

    protected abstract DIALOG_TYPE getDialogType();
    protected abstract int getTitleID();
    protected abstract int getHintID();

    public static enum DIALOG_TYPE{

        ADD_INCOME,
        ADD_BILL,
        ADD_EXPENSE
    }

    public DialogBaseActivity(Context context){
        super(context, true, null);
        c = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mDialogType = getDialogType();
        setContentView(R.layout.dialog_main);

        setTitle(getTitleID());
        mCancel = (Button) findViewById(R.id.dialog_cancel_button);
        mSave = (Button) findViewById(R.id.dialog_save_button);
        mCancel.setOnClickListener(this);
        mSave.setOnClickListener(this);
        mItemName = (EditText) findViewById(R.id.dialog_item_name);
        mItemName.setHint(getHintID());
        mItemAmount = (EditText) findViewById(R.id.dialog_item_amount);

    }

    @Override
    public void onClick(View v) {
        final int id = v.getId();

        switch (id){
            case R.id.dialog_cancel_button:
                onBackPressed();
                break;
            case R.id.dialog_save_button:
                //Save to database
                break;
            default:
                break;
        }
    }

    @Override
    public void onBackPressed() {
        StringBuilder sb = new StringBuilder();
        sb.append(c.getResources().getString(R.string.alert_quit));
        final AlertDialog d = new Builder(c).create();
        d.setTitle("??????????");
        d.setMessage(sb.toString());
        d.setButton(AlertDialog.BUTTON_POSITIVE, "Yes", new OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which) {
                d.dismiss();
                confirmBack();
            }
        });
        d.setButton(AlertDialog.BUTTON_NEGATIVE, "No", new OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                d.dismiss();
            }
        });
       d.show();
    }
    public void confirmBack(){
        super.onBackPressed();
    }
}
