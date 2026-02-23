package com.example.jobordersystemeimts.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.jobordersystemeimts.repository.AdminRepository;
import com.example.jobordersystemeimts.model.Admin;

@Service
public class AdminService {
    private final AdminRepository adminRepo;

    @Autowired
    public AdminService(AdminRepository adminRepo) {
        this.adminRepo = adminRepo;
    }

    public Admin createAdmin(Admin admin) {
        return adminRepo.save(admin);
    }
}
