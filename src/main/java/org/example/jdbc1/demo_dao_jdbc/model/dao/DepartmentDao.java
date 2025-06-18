package org.example.jdbc1.demo_dao_jdbc.model.dao;

import org.example.jdbc1.demo_dao_jdbc.model.entities.Department;

import java.util.List;

public interface DepartmentDao {

    void insert(Department obj);
    void update(Department obj);
    void delateById(Integer id);
    Department findById(Integer id);
    List<Department> findAll();
}
