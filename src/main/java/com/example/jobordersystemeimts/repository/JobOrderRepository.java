package com.example.jobordersystemeimts.repository;

import com.example.jobordersystemeimts.model.JobOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobOrderRepository extends JpaRepository<JobOrder, Long> {
}
