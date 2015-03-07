package com.themtgdeckgenius.datacontrol.database;

public class BillsTable extends SQLiteTable {

    // Table Name
    public static final String BILLS_TABLE_NAME = "bills";

    // Column Names
    public static final String ITEM_ID_COLUMN = BILLS_TABLE_NAME + ".item_id";
    public static final String BILLS_SOURCE_COLUMN = BILLS_TABLE_NAME
            + ".source";
    public static final String BILLS_AMOUNT_COLLUMN = BILLS_TABLE_NAME
            + ".amount";
    public static final String BILLS_DUE_DATE_COLLUMN = BILLS_TABLE_NAME
            + ".due_date";

    @Override
    protected void initializeProjectionMap() {
        insertIdColumnIntoProjectionMap(ITEM_ID_COLUMN);
        insertColumnIntoProjectionMap(BILLS_SOURCE_COLUMN);
        insertColumnIntoProjectionMap(BILLS_AMOUNT_COLLUMN);

    }

}
