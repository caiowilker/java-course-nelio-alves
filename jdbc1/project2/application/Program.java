package org.example.jdbc1.project2.application;


import org.example.jdbc1.project1.db.DB;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Program {

    public static void main(String[] args) {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = DB.getConnection();

            ps = conn.prepareStatement(
                    "INSERT INTO seller "
                    + "(Name, Email, BirthDate, BaseSalary, DepartmentId) "
                    + "Values "
                    + "(?, ?, ?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, "Carl Purple");
            ps.setString(2, "calr@gmail.com");
            ps.setDate(3, new java.sql.Date(sdf.parse("11/06/2025").getTime()));
            ps.setDouble(4, 3000.00);
            ps.setInt(5, 4);

            int rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0) {
                ResultSet rs = ps.getGeneratedKeys();
                while (rs.next()) {
                    int id = rs.getInt(1);
                    System.out.println("Done! id = " + id);
                }


            }
            else {
                System.out.println("No rows affected!");
            }
        }
        catch (SQLException | ParseException e) {
            e.printStackTrace();
        }
        finally {
            DB.closeStatement(ps);
            DB.closeConnection();
        }
    }
}
