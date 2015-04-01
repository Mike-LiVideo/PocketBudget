package com.themtgdeckgenius.pocketbudget;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import com.themtgdeckgenius.datacontrol.DatabaseAccessor;
import com.themtgdeckgenius.datacontrol.PocketBudgetContract;

/**
 * Created by michael.wheeler on 3/31/2015.
 */
public class ViewBudgetActivity
        extends Activity{

    protected ListView gViewBudgetList;
    protected SQLiteDatabase gBudgetDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_budget_layout);
        final DatabaseAccessor mDatabaseAccessor = new DatabaseAccessor(this);
        gBudgetDatabase = mDatabaseAccessor.getWritableDatabase();
        Cursor mIncomeListCursor = gBudgetDatabase.query(
                PocketBudgetContract.IncomeTable.TABLE_NAME,
                PocketBudgetContract.getIncomeCursorProjection(),
                null,
                null,
                null,
                null,
                null
        );
        Cursor mBillsListCursor = gBudgetDatabase.query(
                PocketBudgetContract.BillsTable.TABLE_NAME,
                PocketBudgetContract.getBillsTableCursorProjection(),
                null,
                null,
                null,
                null,
                null
        );
        Cursor mExpensesListCursor = gBudgetDatabase.query(
                PocketBudgetContract.ExpenseTable.TABLE_NAME,
                PocketBudgetContract.getExpenseCursorProjection(),
                null,
                null,
                null,
                null,
                null
        );
        CursorAdapter mIncomeCursorAdapter = new SimpleCursorAdapter(this, R.layout.list_item, mIncomeListCursor, PocketBudgetContract.getIncomeCursorProjection(),PocketBudgetContract.getTwoCursorTo(),0);
        gViewBudgetList = (ListView) findViewById(R.id.view_budget_list_view);

    }
}
