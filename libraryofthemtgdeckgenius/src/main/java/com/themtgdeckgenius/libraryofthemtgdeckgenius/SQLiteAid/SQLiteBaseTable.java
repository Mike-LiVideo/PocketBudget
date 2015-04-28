package com.themtgdeckgenius.libraryofthemtgdeckgenius.SQLiteAid;

import android.provider.BaseColumns;

import java.util.ArrayList;

/**
 * Created by michael.wheeler on 4/2/2015.
 */
public abstract class SQLiteBaseTable
        implements BaseColumns, SQLiteStatementsInterface{

    public final String TABLE_NAME = setTableName();
    public final int NUMBER_OF_COLUMNS = numberOfUsedColumns();
    private String[] PROJECTION  ;

    public String DELETE_TABLE = SSI_DELETE + TABLE_NAME + "; ";

    abstract int numberOfUsedColumns();

    /**
     * This method will return to you the column name at the given position
     * starting with 0
     * @param columnPosition position of column name you want
     * @return column name at given position
     */
    //Dont know how useful this is yet
    public String getColumnName(int columnPosition){
        String[] paresed = PROJECTION;
        String returnString = paresed[columnPosition];
        return returnString;
    }
    abstract String setTableName();
    protected void setColumnNames(String[] columnNames){
        PROJECTION = columnNames;
    }
    public String[] getProjection(){
        return PROJECTION;
    }
}
