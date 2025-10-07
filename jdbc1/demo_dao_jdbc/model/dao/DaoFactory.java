package org.example.jdbc1.demo_dao_jdbc.model.dao;

import org.example.jdbc1.demo_dao_jdbc.model.dao.impl.DepartmentDaoJDBC;
import org.example.jdbc1.demo_dao_jdbc.model.dao.impl.SellerDaoJDBC;
import org.example.jdbc1.project.db.DB;

public class DaoFactory {

    public static SellerDao createSellerDao() {

        return new SellerDaoJDBC(DB.getConnection());
    }


    public static DepartmentDao createDepartmentDao() {
        return new DepartmentDaoJDBC(DB.getConnection());

    }
}
