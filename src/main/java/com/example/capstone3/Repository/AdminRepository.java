package com.example.capstone3.Repository;

import com.example.capstone3.Model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//waleed
@Repository
public interface AdminRepository extends JpaRepository<Admin,Integer> {

    Admin findAdminById(Integer id);
}
