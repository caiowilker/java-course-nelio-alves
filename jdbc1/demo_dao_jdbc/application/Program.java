package org.example.jdbc1.demo_dao_jdbc.application;

import org.example.jdbc1.demo_dao_jdbc.model.dao.DaoFactory;
import org.example.jdbc1.demo_dao_jdbc.model.dao.SellerDao;
import org.example.jdbc1.demo_dao_jdbc.model.entities.Department;
import org.example.jdbc1.demo_dao_jdbc.model.entities.Seller;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        SellerDao sellerDao = DaoFactory.createSellerDao();

        System.out.println("===== Test 1: seller findById =====");
        Seller seller = sellerDao.findById(3);
        System.out.println(seller);

        System.out.println("\n===== Test 2: seller findByDepartment =====");
        Department department = new Department(2, null);
        List<Seller> list = sellerDao.findByDepartment(department);
        for (Seller obj : list) {
            System.out.println(obj);
        }

        System.out.println("\n===== Test 3: seller findByAll =====");
        list = sellerDao.findAll();
        for (Seller obj : list) {
            System.out.println(obj);
        }

        System.out.println("\n===== Test 4: seller findByAll =====");
        Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.00,department);
        sellerDao.insert(newSeller);
        System.out.println("Inserted! New Id: " + newSeller.getId());

        System.out.println("\n===== Test 5: seller findByAll =====");
        seller = sellerDao.findById(1);
        seller.setName("Marthe Waine");
        sellerDao.update(seller);
        System.out.println("Update completed");

        System.out.println("\n===== Test 6: seller findByAll =====");
        System.out.print("Enter id for delete test: ");
        int id = sc.nextInt();
        sellerDao.delateById(id);
        System.out.println("Delete completed");

        sc.close();
    }
}
