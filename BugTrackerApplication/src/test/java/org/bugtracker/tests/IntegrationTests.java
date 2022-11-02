package org.bugtracker.tests;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.bugtracker.Main;
import org.bugtracker.crud.model.Issue;
import org.bugtracker.crud.model.People;
import org.bugtracker.crud.model.Projects;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Date;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Main.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class IntegrationTests {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    private String getRootUrl() {
        return "http://localhost:" + port;
    }

    @Test
    public void contextLoads() {

    }

    @Test
    public void testProjects() {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);

        ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/bugtracker/v1/projects/",
                HttpMethod.GET, entity, String.class);

        assertNotNull(response.getBody());
    }

    @Test
    public void testCreateProject() {
        Projects projectOrg = new Projects();
        projectOrg.setProjectName("testProject");
        projectOrg.setCreatedBy("testUser");
        projectOrg.setCreatedOn(Date.valueOf("2022-11-01"));
        projectOrg.setModifiedBy("testUser");
        projectOrg.setModifiedOn(Date.valueOf("2022-11-03"));
        projectOrg.setActualEndDate(Date.valueOf("2022-11-15"));
        projectOrg.setStartDate(Date.valueOf("2022-11-16"));
        projectOrg.setTargetEndDate(Date.valueOf("2022-11-31"));

        ResponseEntity<Projects> postResponse = restTemplate.postForEntity(getRootUrl() + "/bugtracker/v1/projects/", projectOrg,
                Projects.class);

        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());

    }

    @Test
    public void testIssue() {
        Issue issueTrack = new Issue();
        issueTrack.setTargetResolutionDate(Date.valueOf("2022-11-30"));
        Projects projectsIssue = new Projects();
        projectsIssue.setProjectId(1);
        issueTrack.setRelatedProject(projectsIssue);
        issueTrack.setActualResolutionDate(Date.valueOf("2022-11-28"));
        People assignedTo = new People();
        assignedTo.setPersonId(1);
        issueTrack.setAssignedTo(assignedTo);
        issueTrack.setCreatedOn(Date.valueOf("2022-11-28"));
        People identifiedByPersonId = new People();
        identifiedByPersonId.setPersonId(13);
        issueTrack.setIdentifiedByPersonId(identifiedByPersonId);
        issueTrack.setModifiedOn(Date.valueOf("2022-11-06"));
        issueTrack.setIdentifiedDate(Date.valueOf("2022-11-01"));
        issueTrack.setModifiedBy("testUser");
        issueTrack.setIssueSummary("This is a test issue");
        issueTrack.setIssueDescription("Test issue description");
        issueTrack.setStatus("open");
        issueTrack.setPriority("high");
        issueTrack.setProgress("completion of test results");
        issueTrack.setResolutionSummary("resolved");
        issueTrack.setCreatedBy("testUser");


        ResponseEntity<Issue> postResponse = restTemplate.postForEntity(getRootUrl() + "/bugtracker/v1/issues/", issueTrack,
                Issue.class);

        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());

    }
}
