package com.mycompany.sql;

import com.mycompany.sql.domain.SqlSelect;

public class SqlParser {
    public SqlSelect parse(String query) {
        return new SqlSelect();
    }
}
