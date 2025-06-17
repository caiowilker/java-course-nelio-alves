package org.example.jdbc1.project3.application;


import org.example.jdbc1.project1.db.DB;

import java.sql.*;


public class Program {

    public static void main(String[] args) {

        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = DB.getConnection();

            ps = conn.prepareStatement(
                    "DELETE FROM depatment"
                    + "WHERE"
                    + "Id = ?");

            ps.setInt(1 ,5);

            int rowsAffected = ps.executeUpdate();

            System.out.println("Done! Rows affected: " + rowsAffected);
        }
        catch (SQLException e) {
            throw new DbIntegrytyExeption(e.getMessage());
        }
        finally {
            DB.closeStatement(ps);
            DB.closeConnection();
        }
    }
}
