package org.example.jdbc1.project5.db;

public class DbIntegrityExeption extends RuntimeException{
    
    public DbIntegrityExeption (String msg) {
        super(msg);
    }

}
