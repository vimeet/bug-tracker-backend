package org.bugtracker.crud.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Table(name = "issue")
public class Issue {
    private long issueId;
    private Date targetResolutionDate;
    private Projects relatedProject;
    private Date actualResolutionDate;
    private People assignedTo;
    private Date createdOn;
    private People identifiedByPersonId;
    private Date modifiedOn;
    private Date identifiedDate;
    private String modifiedBy;
    private String issueSummary;
    private String issueDescription;
    private String status;
    private String priority;
    private String progress;
    private String resolutionSummary;
    private String createdBy;



    public Issue() {
    }

    @Id
    @Column(name = "issue_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public long getIssueId() {
        return issueId;
    }

    public void setIssueId(long issueId) {
        this.issueId = issueId;
    }

    @Column(name = "target_resolution_date")
    public Date getTargetResolutionDate() {
        return targetResolutionDate;
    }

    public void setTargetResolutionDate(Date targetResolutionDate) {
        this.targetResolutionDate = targetResolutionDate;
    }

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "related_project", referencedColumnName = "project_id")
    public Projects getRelatedProject() {
        return relatedProject;
    }

    public void setRelatedProject(Projects relatedProject) {
        this.relatedProject = relatedProject;
    }

    @Column(name = "actual_resolution_date")
    public Date getActualResolutionDate() {
        return actualResolutionDate;
    }

    public void setActualResolutionDate(Date actualResolutionDate) {
        this.actualResolutionDate = actualResolutionDate;
    }

    @OneToOne(cascade =  CascadeType.ALL)
    @JoinColumn(name = "assigned_to", referencedColumnName = "person_id")
    public People getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(People assignedTo) {
        this.assignedTo = assignedTo;
    }

    @Column(name = "created_on")
    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "identified_by_person_id", referencedColumnName = "person_id")
    public People getIdentifiedByPersonId() {
        return identifiedByPersonId;
    }

    public void setIdentifiedByPersonId(People identifiedByPersonId) {
        this.identifiedByPersonId = identifiedByPersonId;
    }

    @Column(name = "modified_on")
    public Date getModifiedOn() {
        return modifiedOn;
    }

    public void setModifiedOn(Date modifiedOn) {
        this.modifiedOn = modifiedOn;
    }

    @Column(name = "identified_date")
    public Date getIdentifiedDate() {
        return identifiedDate;
    }

    public void setIdentifiedDate(Date identifiedDate) {
        this.identifiedDate = identifiedDate;
    }

    @Column(name = "modified_by")
    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    @Column(name = "issue_summary")
    public String getIssueSummary() {
        return issueSummary;
    }

    public void setIssueSummary(String issueSummary) {
        this.issueSummary = issueSummary;
    }

    @Column(name = "issue_description")
    public String getIssueDescription() {
        return issueDescription;
    }

    public void setIssueDescription(String issueDescription) {
        this.issueDescription = issueDescription;
    }

    @Column(name = "status")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Column(name = "priority")
    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    @Column(name = "progress")
    public String getProgress() {
        return progress;
    }

    public void setProgress(String progress) {
        this.progress = progress;
    }

    @Column(name = "resolution_summary")
    public String getResolutionSummary() {
        return resolutionSummary;
    }

    public void setResolutionSummary(String resolutionSummary) {
        this.resolutionSummary = resolutionSummary;
    }

    @Column(name = "created_by")
    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

}
