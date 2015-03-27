package com.themtgdeckgenius.datacontrol.database;

import com.themtgdeckgenius.datacontrol.BudgetContentProvider;

import java.util.HashMap;
import java.util.List;

public abstract class SQLiteTable{

    protected HashMap<String, String> gProjectionMap = new HashMap<String, String>();
    private boolean gIsMapInitialized = false;

    protected abstract void initializeProjectionMap();

    //The ID column is unique because Android requires that the ID column be "_id"
    protected synchronized void insertIdColumnIntoProjectionMap(String columnName){
        gProjectionMap.put(columnName, columnName + " AS " + BudgetContentProvider.ID);
    }

    protected synchronized void insertColumnIntoProjectionMap(String columnName){
        gProjectionMap.put(columnName, columnName + " AS " + columnName.substring(columnName.indexOf(".") + 1));
    }

    protected synchronized void insertColumnsIntoProjectionMap(List<String> columnNames){
        for(final String columnName : columnNames)
            gProjectionMap.put(columnName, columnName + " AS " + columnName.substring(columnName.indexOf(".") + 1));
    }

    public synchronized HashMap<String, String> getProjectionMap(){
        if(!gIsMapInitialized){
            initializeProjectionMap();
            gIsMapInitialized = true;
        }
        return gProjectionMap;
    }

}
