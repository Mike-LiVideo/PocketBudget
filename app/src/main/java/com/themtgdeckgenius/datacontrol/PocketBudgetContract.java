package com.themtgdeckgenius.datacontrol;

import android.provider.BaseColumns;

import com.themtgdeckgenius.pocketbudget.R;

public final class PocketBudgetContract{

    //    private static final String[] INCOME_PROJECTION = {
//            IncomeTable._ID,
//            IncomeTable.COLUMN_NAME_SOURCE,
//            IncomeTable.COLUMN_NAME_AMOUNT
//    };
//    private static final String[] EXPENSE_PROJECTION = {
//            ExpenseTable._ID,
//            ExpenseTable.COLUMN_NAME_SOURCE,
//            ExpenseTable.COLUMN_NAME_AMOUNT
//    };
//    private static final String[] BILLS_PROJECTION = {
//            BillsTable._ID,
//            BillsTable.COLUMN_NAME_SOURCE,
//            BillsTable.COLUMN_NAME_AMOUNT,
//            BillsTable.COLUMN_NAME_DUE_DATE
//    };
    private static final int[] THREE_RES_IDS = {
            R.id.list_item_source,
            R.id.list_item_amount,
            R.id.list_item_date
    };
    private static final int[] TWO_RES_IDS = {
            R.id.list_item_source,
            R.id.list_item_amount
    };
    private static final String[] INCOME_CURSOR_PROJECTION = {
            IncomeTable.COLUMN_NAME_SOURCE,
            IncomeTable.COLUMN_NAME_AMOUNT
    };
    private static final String[] EXPENSE_CURSOR_PROJECTION = {
            ExpenseTable.COLUMN_NAME_SOURCE,
            ExpenseTable.COLUMN_NAME_AMOUNT
    };
    private static final String[] BILLS_CURSOR_PROJECTION = {
            BillsTable.COLUMN_NAME_SOURCE,
            BillsTable.COLUMN_NAME_AMOUNT,
            BillsTable.COLUMN_NAME_DUE_DATE
    };

    public PocketBudgetContract(){}

//    public static String[] getBillsTableProjection(){
//        return BILLS_PROJECTION;
//    }
//
//    public static String[] getIncomeProjection(){
//        return INCOME_PROJECTION;
//    }
//
//    public static String[] getExpenseProjection(){
//        return EXPENSE_PROJECTION;
//    }

    public static String[] getBillsTableCursorProjection(){
        return BILLS_CURSOR_PROJECTION;
    }

    public static String[] getIncomeCursorProjection(){
        return INCOME_CURSOR_PROJECTION;
    }

    public static String[] getExpenseCursorProjection(){
        return EXPENSE_CURSOR_PROJECTION;
    }

    public static int[] getThreeCursorTo(){
        return THREE_RES_IDS;
    }

    public static int[] getTwoCursorTo(){
        return TWO_RES_IDS;
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
