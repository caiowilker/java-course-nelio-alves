package org.example.jdbc1.demo_dao_jdbc.db;

public class DbIntegrityExeption extends RuntimeException{
    
    public DbIntegrityExeption (String msg) {
        super(msg);
    }

}
