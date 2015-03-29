package com.themtgdeckgenius.widgets;

import android.content.Context;

/**
 * Created by MiWheeler on 3/29/2015.
 */
public class AddBillDialog extends DialogBaseActivity{


    public AddBillDialog(Context context) {
        super(context);
    }

    @Override
    protected DIALOG_TYPE getDialogType() {
        return null;
    }

    @Override
    protected int getTitleID() {
        return 0;
    }

    @Override
    protected int getHintID() {
        return 0;
    }
}
