package org.bugtracker.crud.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Table(name = "people")
public class People {

    private long personId;
    private long assignedProject;
    private Date createdOn;
    private Date modifiedOn;
    private String username;
    private String createdBy;
    private String modifiedBy;
    private String personName;
    private String personEmail;
    private String personRole;

    public People(long personId, long assignedProject, Date createdOn, Date modifiedOn, String username, String createdBy, String modifiedBy, String personName, String personEmail, String personRole) {
        this.personId = personId;
        this.assignedProject = assignedProject;
        this.createdOn = createdOn;
        this.modifiedOn = modifiedOn;
        this.username = username;
        this.createdBy = createdBy;
        this.modifiedBy = modifiedBy;
        this.personName = personName;
        this.personEmail = personEmail;
        this.personRole = personRole;
    }


    @Id
    @Column(name = "person_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public long getPersonId() {
        return personId;
    }

    public void setPersonId(long personId) {
        this.personId = personId;
    }

    @Column(name = "assigned_project", nullable = false)
    public long getAssignedProject() {
        return assignedProject;
    }

    public void setAssignedProject(long assignedProject) {
        this.assignedProject = assignedProject;
    }

    @Column(name = "created_on", nullable = false)
    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    @Column(name = "modified_on", nullable = false)
    public Date getModifiedOn() {
        return modifiedOn;
    }

    public void setModifiedOn(Date modifiedOn) {
        this.modifiedOn = modifiedOn;
    }

    @Column(name = "username", nullable = false)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Column(name = "created_by", nullable = false)
    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    @Column(name = "modified_by", nullable = false)
    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    @Column(name = "person_name", nullable = false)
    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    @Column(name = "person_email", nullable = false)
    public String getPersonEmail() {
        return personEmail;
    }

    public void setPersonEmail(String personEmail) {
        this.personEmail = personEmail;
    }

    @Column(name = "person_role", nullable = false)
    public String getPersonRole() {
        return personRole;
    }

    public void setPersonRole(String personRole) {
        this.personRole = personRole;
    }

    public People() {
    }
}
