package org.example.jdbc1.demo_dao_jdbc.model.dao.impl;

import org.example.jdbc1.demo_dao_jdbc.model.dao.SellerDao;
import org.example.jdbc1.demo_dao_jdbc.model.entities.Department;
import org.example.jdbc1.demo_dao_jdbc.model.entities.Seller;
import org.example.jdbc1.project1.db.DB;
import org.example.jdbc1.project1.db.DbException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class SellerDaoJDBC implements SellerDao {

    private Connection conn;

    public SellerDaoJDBC(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insert(Seller obj) {

    }

    @Override
    public void update(Seller obj) {

    }

    @Override
    public void delateById(Integer id) {

    }

    @Override
    public Seller findById(Integer id) {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement(
                    "SELLECT seller.*,department.Name as DepName "
                    + "FROM seller INNER JOIN department "
                    + "ON seller.DepartmentId = department.Id "
                    + "WHERE seller.id = ?");

                st.setInt(1, id);
                rs = st.executeQuery();
                if (rs.next()) {
                    Department dep = new Department();
                    dep.setId(rs.getInt("DepartmentId"));
                    dep.setName(rs.getString("DepName"));
                    Seller obj = new Seller();
                    obj.setId(rs.getInt("Id"));
                    obj.setName(rs.getString("Name"));
                    obj.setEmail(rs.getString("Email"));
                    obj.setBaseSalary(rs.getDouble("BaseSalary"));
                    obj.setBirthDate(rs.getDate("BirthDate"));
                    obj.setDepartment(dep);
                    return obj;
                }
                return null;
        }
        catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
        finally {
            DB.closeStatement(st);
            DB.closeResulset(rs);
        }
    }

    @Override
    public List<Seller> findAll() {
        return null;
    }
}
