package org.example.jdbc1.demo_dao_jdbc.application;

import org.example.jdbc1.demo_dao_jdbc.model.dao.DaoFactory;
import org.example.jdbc1.demo_dao_jdbc.model.dao.SellerDao;
import org.example.jdbc1.demo_dao_jdbc.model.entities.Seller;

public class Program {

    public static void main(String[] args) {

        SellerDao sellerDao = DaoFactory.createSellerDao();

        System.out.println("===== Test 1: seller findById =====");
        Seller seller = sellerDao.findById(3);
        System.out.println(seller);
    }
}
