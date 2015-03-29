package com.themtgdeckgenius.datacontrol;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

public final class PocketBuggetContract {

    public PocketBuggetContract() {
    }

    public static abstract class BillsTable implements BaseColumns {
        public static final String TABLE_NAME = "bills";
        public static final String COLUMN_NAME_SOURCE = "source";
        public static final String COLUMN_NAME_AMOUNT = "amount";
        public static final String COLUMN_NAME_DUE_DATE = "due_date";
    }

    private static final String[] BILLS_PROJECTION = {
            BillsTable._ID,
            BillsTable.COLUMN_NAME_SOURCE,
            BillsTable.COLUMN_NAME_AMOUNT,
            BillsTable.COLUMN_NAME_DUE_DATE
    };

    public static String[] getBillsTableProjection() {
        return BILLS_PROJECTION;
    }

    public static abstract class IncomeTable implements BaseColumns {
        public static final String TABLE_NAME = "bills";
        public static final String COLUMN_NAME_SOURCE = "source";
        public static final String COLUMN_NAME_AMOUNT = "amount";
    }

    private static final String[] INCOME_PROJECTION = {
            IncomeTable._ID,
            IncomeTable.COLUMN_NAME_SOURCE,
            IncomeTable.COLUMN_NAME_AMOUNT
    };

    public static String[] getIncomeProjection() {
        return INCOME_PROJECTION;
    }

    public static abstract class ExpenseTable implements BaseColumns {
        public static final String TABLE_NAME = "expenses";
        public static final String COLUMN_NAME_SOURCE = "source";
        public static final String COLUMN_NAME_AMOUNT = "amount";
    }

    private static final String[] EXPENSE_PROJECTION = {
            ExpenseTable._ID,
            ExpenseTable.COLUMN_NAME_SOURCE,
            ExpenseTable.COLUMN_NAME_AMOUNT
    };

    public static String[] getExpenseProjection() {
        return EXPENSE_PROJECTION;
    }

    /**
     * The following are the create statements for each table
     */
    private static final String TEXT = " TEXT NOT NULL";
    private static final String INTEGER = " INTEGER NOT NULL";
    private static final String DATE = " DATE NOT NULL";
    private static final String PRIMARY_KEY = " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL UNIQUE";
    private static final String COMMA = ",";
    private static final String TABLE = "CREATE TABLE ";
    private static final String SQL_CREATE_BILLS = TABLE + BillsTable.TABLE_NAME + " ("
            + BillsTable._ID + PRIMARY_KEY
            + COMMA + BillsTable.COLUMN_NAME_SOURCE + TEXT
            + COMMA + BillsTable.COLUMN_NAME_AMOUNT + INTEGER
            + COMMA + BillsTable.COLUMN_NAME_DUE_DATE + DATE + " )";
    private static final String SQL_CREATE_INCOME = TABLE + IncomeTable.TABLE_NAME + " ("
            + IncomeTable._ID + PRIMARY_KEY
            + COMMA + IncomeTable.COLUMN_NAME_SOURCE + TEXT
            + COMMA + IncomeTable.COLUMN_NAME_AMOUNT + INTEGER + " )";
    private static final String SQL_CREATE_EXPENSE = TABLE + ExpenseTable.TABLE_NAME + " ("
            + ExpenseTable._ID + PRIMARY_KEY
            + COMMA + ExpenseTable.COLUMN_NAME_SOURCE + TEXT
            + COMMA + ExpenseTable.COLUMN_NAME_AMOUNT + INTEGER + " )";

    /**
     * The following are the delete statements for each table
     */
    private static final String DELETE = "DROP TABLE IF EXISTS ";
    private static final String SQL_DELETE_BILLS = DELETE + BillsTable.TABLE_NAME;
    private static final String SQL_DELETE_INCOME = DELETE + IncomeTable.TABLE_NAME;
    private static final String SQL_DELETE_EXPENSE = DELETE + ExpenseTable.TABLE_NAME;

    public class DatabaseAccesor
            extends SQLiteOpenHelper {
        public static final int DATABASE_VERSION = 1;
        public static final String DATABASE_NAME = "BudgetStorage.db";

        public DatabaseAccesor(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(SQL_CREATE_BILLS);
            db.execSQL(SQL_CREATE_EXPENSE);
            db.execSQL(SQL_CREATE_INCOME);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }
    }
}
