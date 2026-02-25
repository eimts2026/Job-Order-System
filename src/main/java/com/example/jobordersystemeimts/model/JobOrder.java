package com.example.jobordersystemeimts.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.LocalDate;
import java.time.LocalTime;
//import com.example.jobordersystemeimts.model.Admin;

@Entity // This tells spring to make a table for this class
public class JobOrder {
    @Id // This is the primary key
    private Long jobOrderId;

    private String jobOrderName;
    private String jobOrderDescription;
    private enum JobStatus {CREATED, IN_PROGRESS, COMPLETED, CANCELLED};
    private JobStatus jobStatus;
    private Boolean isViewed;
    //private Admin user;
    private String createTime;
    private String updateTime;
    private String deleteTime;
    private String completedTime;

    public JobOrder() { super(); } // Default constructor

    public JobOrder(String jobOrderName, String jobOrderDescription, Long jobOrderId) {
        super();
        setJobName(jobOrderName);
        setJobDescription(jobOrderDescription);
        setJobOrderID(jobOrderId);

        this.createTime = LocalDate.now() + " @ " + LocalTime.now();

        setJobStatus(JobStatus.CREATED);
    }

    // Setters
    public void setJobName(String jobName) {this.jobOrderName = jobName;}
    public void setJobDescription(String jobDescription) {this.jobOrderDescription = jobDescription;}
    public void setJobStatus (JobStatus jobStatus) { this.jobStatus = jobStatus; }
    public void setIsViewed() { this.isViewed = true; }
    public void setJobOrderID(Long jobOrderID) { this.jobOrderId = jobOrderID; }

    // Getters
    public String getJobName() { return this.jobOrderName; }
    public String getJobDescription() { return this.jobOrderDescription; }
    public Long getJobOrderID() { return this.jobOrderId; }
    public JobStatus getJobStatus() { return this.jobStatus; }
    public Boolean isViewed() { return this.isViewed; }
    public String getStartTime() { return createTime;}

    // Methods
    @Override
    public String toString() {
        return "Job Order Name: " + getJobName() + ", Job Order Des: " + getJobDescription() + ", Job Order ID: " + getJobOrderID() +
                "\n, Job Order Status: " + getJobStatus() + ", Is Viewed: " + isViewed() + ", Start Time: " + getStartTime();
    }

    //
}
