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
    public static final String DATABASE_NAME = "BudgetStorage.sqlite";
    /**
     * The following are the create statements for each table
     */
    private static final String TEXT = " TEXT NOT NULL";
    private static final String INTEGER = " INTEGER NOT NULL";
    private static final String DATE = " DATE NOT NULL";
    private static final String PRIMARY_KEY = " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL UNIQUE";
    private static final String COMMA = ",";
    private static final String TABLE = "CREATE TABLE ";
    private static final String SQL_CREATE_BILLS = TABLE + PocketBuggetContract.BillsTable.TABLE_NAME + " ("
            + PocketBuggetContract.BillsTable._ID + PRIMARY_KEY
            + COMMA + PocketBuggetContract.BillsTable.COLUMN_NAME_SOURCE + TEXT
            + COMMA + PocketBuggetContract.BillsTable.COLUMN_NAME_AMOUNT + INTEGER
            + COMMA + PocketBuggetContract.BillsTable.COLUMN_NAME_DUE_DATE + DATE + " )";
    private static final String SQL_CREATE_INCOME = TABLE + PocketBuggetContract.IncomeTable.TABLE_NAME + " ("
            + PocketBuggetContract.IncomeTable._ID + PRIMARY_KEY
            + COMMA + PocketBuggetContract.IncomeTable.COLUMN_NAME_SOURCE + TEXT
            + COMMA + PocketBuggetContract.IncomeTable.COLUMN_NAME_AMOUNT + INTEGER + " )";
    private static final String SQL_CREATE_EXPENSE = TABLE + PocketBuggetContract.ExpenseTable.TABLE_NAME + " ("
            + PocketBuggetContract.ExpenseTable._ID + PRIMARY_KEY
            + COMMA + PocketBuggetContract.ExpenseTable.COLUMN_NAME_SOURCE + TEXT
            + COMMA + PocketBuggetContract.ExpenseTable.COLUMN_NAME_AMOUNT + INTEGER + " )";
    /**
     * The following are the delete statements for each table
     */
    private static final String DELETE = "DROP TABLE IF EXISTS ";
    private static final String SQL_DELETE_BILLS = DELETE + PocketBuggetContract.BillsTable.TABLE_NAME;
    private static final String SQL_DELETE_INCOME = DELETE + PocketBuggetContract.IncomeTable.TABLE_NAME;
    private static final String SQL_DELETE_EXPENSE = DELETE + PocketBuggetContract.ExpenseTable.TABLE_NAME;

    public DatabaseAccessor(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL(SQL_CREATE_BILLS + " " +SQL_CREATE_EXPENSE + " " +SQL_CREATE_INCOME);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){

    }
}