package org.example.jdbc1.project.db.project.application;


import org.example.jdbc1.project.db.project.db.DB;

import java.sql.Connection;

public class Program {

    public static void main(String[] args) {

        Connection conn = DB.getConnection();
        DB.closeConnection();

    }
}
