package org.example.project_web.demo.src.test.java.com.example.demo.services.exeptions;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(Object id) {
        super("Resource not found. Id " + id);
    }

}
