package com.themtgdeckgenius.datacontrol;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by michael.wheeler on 3/30/2015.
 */
public class DatabaseAccessor
        extends SQLiteOpenHelper{
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "BudgetStorage.db";
    /**
     * The following are the create statements for each table
     */
    private static final String TEXT = " TEXT NOT NULL";
    private static final String INTEGER = " INTEGER NOT NULL";
    private static final String DATE = " DATE";
    private static final String PRIMARY_KEY = " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL UNIQUE";
    private static final String COMMA = ",";
    private static final String TABLE = "CREATE TABLE ";
    private static final String SQL_CREATE_BILLS = TABLE + PocketBudgetContract.BillsTable.TABLE_NAME + " ("
            + PocketBudgetContract.BillsTable._ID + PRIMARY_KEY
            + COMMA + PocketBudgetContract.BillsTable.COLUMN_NAME_SOURCE + TEXT
            + COMMA + PocketBudgetContract.BillsTable.COLUMN_NAME_AMOUNT + INTEGER
            + COMMA + PocketBudgetContract.BillsTable.COLUMN_NAME_DUE_DATE + DATE + " );";
    private static final String SQL_CREATE_INCOME = TABLE + PocketBudgetContract.IncomeTable.TABLE_NAME + " ("
            + PocketBudgetContract.IncomeTable._ID + PRIMARY_KEY
            + COMMA + PocketBudgetContract.IncomeTable.COLUMN_NAME_SOURCE + TEXT
            + COMMA + PocketBudgetContract.IncomeTable.COLUMN_NAME_AMOUNT + INTEGER + " );";
    private static final String SQL_CREATE_EXPENSE = TABLE + PocketBudgetContract.ExpenseTable.TABLE_NAME + " ("
            + PocketBudgetContract.ExpenseTable._ID + PRIMARY_KEY
            + COMMA + PocketBudgetContract.ExpenseTable.COLUMN_NAME_SOURCE + TEXT
            + COMMA + PocketBudgetContract.ExpenseTable.COLUMN_NAME_AMOUNT + INTEGER + " );";
    /**
     * The following are the delete statements for each table
     */
    private static final String DELETE = "DROP TABLE IF EXISTS ";
    private static final String SQL_DELETE_BILLS = DELETE + PocketBudgetContract.BillsTable.TABLE_NAME;
    private static final String SQL_DELETE_INCOME = DELETE + PocketBudgetContract.IncomeTable.TABLE_NAME;
    private static final String SQL_DELETE_EXPENSE = DELETE + PocketBudgetContract.ExpenseTable.TABLE_NAME;

    /**
     * Constructor
     *
     * @param context
     */
    public DatabaseAccessor(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL(SQL_CREATE_BILLS + " " + SQL_CREATE_EXPENSE + " " + SQL_CREATE_INCOME);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){

    }
}