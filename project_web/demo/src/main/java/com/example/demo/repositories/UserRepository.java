package org.example.project_web.demo.src.test.java.com.example.demo.repositories;

import org.example.project_web.demo.src.test.java.com.example.demo.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {


}
