package com.themtgdeckgenius.libraryofthemtgdeckgenius.SQLiteAid;

/**
 * Created by michael.wheeler on 4/13/2015.
 */
public interface SQLiteStatementsInterface{

    final static String SSI_TEXT = " TEXT NOT NULL";
    final static String SSI_INTEGER = " INTEGER NOT NULL";
    final static String SSI_PRIMARY_KEY = " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL UNIQUE";
    final static String SSI_COMMA = ",";
    final static String SSI_CREATE_TABLE = "CREATE TABLE ";
    final static String SSI_OPEN_PARENTHESIS = " ( ";
    final static String SSI_CLOSE_PARENTHESIS = " ) ";
    final static String SSI_END_TABLE = " );";
    final static String SSI_DELETE = "DROP TABLE IF EXISTS ";
    final static String SSI_WHERE_END = " = ? ";
    final static String SSI_WHERE_MORE = " = ? AND ";
    final static String SSI_INSERT = "INSERT INTO ";
    final static String SSI_VALUES_FOUR = "VALUES ( ?, ?, ?, ? )";
    final static String SSI_VALUES_FIVE = "VALUES ( ?, ?, ?, ?, ? )";
    final static String SSI_VALUES_SIX = "VALUES ( ?, ?, ?, ?, ?, ? )";

}
