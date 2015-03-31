package com.themtgdeckgenius.datacontrol;

import android.provider.BaseColumns;

public final class PocketBuggetContract{

    private static final String[] INCOME_PROJECTION = {
            IncomeTable._ID,
            IncomeTable.COLUMN_NAME_SOURCE,
            IncomeTable.COLUMN_NAME_AMOUNT
    };
    private static final String[] EXPENSE_PROJECTION = {
            ExpenseTable._ID,
            ExpenseTable.COLUMN_NAME_SOURCE,
            ExpenseTable.COLUMN_NAME_AMOUNT
    };

    public PocketBuggetContract(){
    }

    private static final String[] BILLS_PROJECTION = {
            BillsTable._ID,
            BillsTable.COLUMN_NAME_SOURCE,
            BillsTable.COLUMN_NAME_AMOUNT,
            BillsTable.COLUMN_NAME_DUE_DATE
    };

    public static String[] getBillsTableProjection(){
        return BILLS_PROJECTION;
    }

    public static String[] getIncomeProjection(){
        return INCOME_PROJECTION;
    }

    public static String[] getExpenseProjection(){
        return EXPENSE_PROJECTION;
    }

    public static abstract class BillsTable
            implements BaseColumns{
        public static final String TABLE_NAME = "bills";
        public static final String COLUMN_NAME_SOURCE = "source";
        public static final String COLUMN_NAME_AMOUNT = "amount";
        public static final String COLUMN_NAME_DUE_DATE = "due_date";
    }

    public static abstract class IncomeTable
            implements BaseColumns{
        public static final String TABLE_NAME = "bills";
        public static final String COLUMN_NAME_SOURCE = "source";
        public static final String COLUMN_NAME_AMOUNT = "amount";
    }

    public static abstract class ExpenseTable
            implements BaseColumns{
        public static final String TABLE_NAME = "expenses";
        public static final String COLUMN_NAME_SOURCE = "source";
        public static final String COLUMN_NAME_AMOUNT = "amount";
    }
}
