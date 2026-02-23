package com.example.jobordersystemeimts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.jobordersystemeimts.model.Admin;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {

}
