package com.rosu.util;

import java.util.HashMap;

public class DatatypeMapper {

    public static HashMap<String, String> javaToSqlTypes;

    static {
        javaToSqlTypes = new HashMap<>();
        javaToSqlTypes.put("String", "TEXT");
        javaToSqlTypes.put("int", "INTEGER");
        javaToSqlTypes.put("double", "REAL");
    }

    public static HashMap<String, String> attributeDecorators;

    static {
        attributeDecorators = new HashMap<>();
        attributeDecorators.put("ai", " AUTO_INCREMENT ");
        attributeDecorators.put("nn", " NOT NULL ");
        attributeDecorators.put("pk", " PRIMARY KEY ");
        attributeDecorators.put("un", " UNIQUE ");
        attributeDecorators.put("fk", " FOREIGN KEY ");
    }

}
