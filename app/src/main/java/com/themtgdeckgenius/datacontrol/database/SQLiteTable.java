package com.themtgdeckgenius.datacontrol.database;

import java.util.HashMap;
import java.util.List;

import com.themtgdeckgenius.datacontrol.BudgetContentProvider;

public abstract class SQLiteTable {
	
    protected HashMap<String, String> mProjectionMap = new HashMap<String, String>();
    protected abstract void initializeProjectionMap();
    private boolean mIsMapInitialized = false;

    //The ID column is unique because Android requires that the ID column be "_id"
    protected synchronized void insertIdColumnIntoProjectionMap(String columnName) {
    	mProjectionMap.put(columnName, columnName + " AS " + BudgetContentProvider.ID);
    }

    protected synchronized void insertColumnIntoProjectionMap(String columnName) {
    	mProjectionMap.put(columnName, columnName + " AS " + columnName.substring(columnName.indexOf(".") + 1));
    }

	protected synchronized void insertColumnsIntoProjectionMap(List<String> columnNames) {
		for(final String columnName: columnNames)
			mProjectionMap.put(columnName, columnName + " AS " + columnName.substring(columnName.indexOf(".") + 1));
	}

    public synchronized HashMap<String, String> getProjectionMap() {
    	if(!mIsMapInitialized) {
    		initializeProjectionMap();
    		mIsMapInitialized = true;
    	}
    	return mProjectionMap;
    }

}
