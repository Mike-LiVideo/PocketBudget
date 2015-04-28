package com.themtgdeckgenius.datacontrol;

/**
 * Created by michael.wheeler on 4/13/2015.
 */
public interface SQLiteStatementsInterface{

    final static String CS_TEXT = " TEXT NOT NULL";
    final static String CS_INTEGER = " INTEGER NOT NULL";
    final static String CS_PRIMARY_KEY = " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL UNIQUE";
    final static String CS_COMMA = ",";
    final static String CS_CREATE_TABLE = "CREATE TABLE ";
    final static String CS_OPEN_PARENTHESIS = " ( ";
    final static String CS_CLOSE_PARENTHESIS = " ) ";
    final static String CS_END_TABLE = " );";
    final static String CS_DELETE = "DROP TABLE IF EXISTS ";
    final static String CS_WHERE_END = " = ? ";
    final static String CS_WHERE_MORE = " = ? AND ";
    final static String CS_INSERT = "INSERT INTO ";
    final static String CS_VALUES_FOUR = "VALUES ( ?, ?, ?, ? )";
    final static String CS_VALUES_FIVE = "VALUES ( ?, ?, ?, ?, ? )";
    final static String CS_VALUES_SIX = "VALUES ( ?, ?, ?, ?, ?, ? )";

}
