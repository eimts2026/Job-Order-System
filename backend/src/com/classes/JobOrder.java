package com.classes;

import java.time.*;

public class JobOrder {
    private String jobName;
    private String jobDescription;
    private enum JobStatus {CREATED, IN_PROGRESS, COMPLETED, CANCELLED;}
    private String jobOrderID;
    private JobStatus jobStatus;
    private Boolean isViewed;
    private Admin userAdmin;
    private String createDateTime;
    private String updateDateTime;
    private String deleteDateTime;
    private String completedDateTime;


    public JobOrder() {super();}

    public JobOrder(String jobName, String jobDescription, Admin usersAdmin) {
        super();
        setJobName(jobName);
        setJobDescription(jobDescription);

        createDateTime = LocalDate.now() + " @ " + LocalTime.now();

        setJobStatus(JobStatus.CREATED);
    }

    public JobOrder(String jobName, String jobDescription, String jobOrderID) {
        super();
        setJobName(jobName);
        setJobDescription(jobDescription);
        setJobOrderID(jobOrderID);

        createDateTime = LocalDate.now() + " @ " + LocalTime.now();

        setJobStatus(JobStatus.CREATED);
    }

    // Setters
    public void setJobName(String jobName) {this.jobName = jobName;}
    public void setJobDescription(String jobDescription) {this.jobDescription = jobDescription;}
    public void setJobStatus (JobStatus jobStatus) { this.jobStatus = jobStatus; }
    public void setUserAdmin(Admin userAdmin) { this.userAdmin = userAdmin; }
    public void setIsViewed() { this.isViewed = true; }
    public void setJobOrderID(String jobOrderID) { this.jobOrderID = jobOrderID; }

    // Getters
    public String getJobName() { return this.jobName; }
    public String getJobDescription() { return this.jobDescription; }
    public String getJobOrderID() { return this.jobOrderID; }
    public JobStatus getJobStatus() { return this.jobStatus; }
    public Admin getUserAdmin() { return this.userAdmin; }
    public Boolean isViewed() { return this.isViewed; }
    public String getStartTime() { return createDateTime;}

    // Methods
    @Override
    public String toString() {
        return "Job Order Name: " + getJobName() + ", Job Order Des: " + getJobDescription() + ", Job Order ID: " + getJobOrderID() +
                "\n, Job Order Status: " + getJobStatus() + ", Is Viewed: " + isViewed() + ", Start Time: " + getStartTime() +
                "\n, User: " + getUserAdmin();
    }

}
