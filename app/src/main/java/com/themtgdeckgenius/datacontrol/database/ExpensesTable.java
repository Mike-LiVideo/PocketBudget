package com.themtgdeckgenius.datacontrol.database;

public class ExpensesTable extends SQLiteTable {

    // Table Name
    public static final String EXPENSE_TABLE_NAME = "expenses";

    // Column Names
    public static final String ITEM_ID_COLUMN = EXPENSE_TABLE_NAME + ".item_id";
    public static final String EXPENSE_SOURCE_COLUMN = EXPENSE_TABLE_NAME
            + ".source";
    public static final String EXPENSE_AMOUNT_COLLUMN = EXPENSE_TABLE_NAME
            + ".amount";

    @Override
    protected void initializeProjectionMap() {
        insertIdColumnIntoProjectionMap(ITEM_ID_COLUMN);
        insertColumnIntoProjectionMap(EXPENSE_SOURCE_COLUMN);
        insertColumnIntoProjectionMap(EXPENSE_AMOUNT_COLLUMN);

    }

}
