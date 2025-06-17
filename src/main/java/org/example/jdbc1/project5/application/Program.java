package org.example.jdbc1.project5.application;


import org.example.jdbc1.project1.db.DB;
import org.example.jdbc1.project5.db.DbIntegrityExeption;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;


public class Program {

    public static void main(String[] args) {

        Connection conn = null;
        Statement st = null;

        try {
            conn = DB.getConnection();

            conn.setAutoCommit(false);

            st = conn.createStatement();

            int rows1 = st.executeUpdate("UPDATE seller SET BaseSalary = 2090 WHERE DepartmentId = 1");
            int rows2 = st.executeUpdate("UPDATE seller SET BaseSalary = 3090 WHERE DepartmentId = 2");

            conn.commit();

            System.out.println("rows1 " + rows1);
            System.out.println("rows2 " + rows2);
        }
        catch (SQLException e) {
            try {
                conn.rollback();
                throw new DbIntegrityExeption("Transaction rolled back! Caused by: " + e.getMessage());
            } catch (SQLException ex) {
                throw new DbIntegrityExeption("Error trying to rollback! Caused by: " + ex.getMessage());
            }

        }
        finally {
            DB.closeStatement(st);
            DB.closeConnection();
        }
    }
}
