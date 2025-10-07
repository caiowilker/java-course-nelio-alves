package org.example.jdbc1.demo_dao_jdbc.model.dao;

import org.example.jdbc1.demo_dao_jdbc.model.entities.Department;
import org.example.jdbc1.demo_dao_jdbc.model.entities.Seller;

import java.util.List;

public interface SellerDao {

    void insert(Seller obj);
    void update(Seller obj);
    void delateById(Integer id);
    Seller findById(Integer id);
    List<Seller> findAll();
    List<Seller> findByDepartment(Department department);
}
