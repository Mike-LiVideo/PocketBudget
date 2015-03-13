package com.themtgdeckgenius.datacontrol.database;

public class IncomeTable
        extends SQLiteTable{
    // Table Name
    public static final String INCOME_TABLE_NAME = "bills";

    // Column Names
    public static final String ITEM_ID_COLUMN = INCOME_TABLE_NAME + ".item_id";
    public static final String INCOME_SOURCE_COLUMN = INCOME_TABLE_NAME
            + ".source";
    public static final String INCOME_AMOUNT_COLLUMN = INCOME_TABLE_NAME
            + ".amount";

    @Override
    protected void initializeProjectionMap(){
        insertIdColumnIntoProjectionMap(ITEM_ID_COLUMN);
        insertColumnIntoProjectionMap(INCOME_SOURCE_COLUMN);
        insertColumnIntoProjectionMap(INCOME_AMOUNT_COLLUMN);

    }

}
