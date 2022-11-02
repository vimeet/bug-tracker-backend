package org.bugtracker.crud.controller;

import org.bugtracker.crud.exception.ResourceNotFoundException;
import org.bugtracker.crud.model.Issue;
import org.bugtracker.crud.model.People;
import org.bugtracker.crud.model.Projects;
import org.bugtracker.crud.repositories.IssueRepository;
import org.bugtracker.crud.repositories.PeopleRepository;
import org.bugtracker.crud.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.ResourceAccessException;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/bugtracker/v1")
public class BugTrackerController {
    @Autowired
    ProjectRepository projectRepository;

    @Autowired
    PeopleRepository peopleRepository;

    @Autowired
    IssueRepository issueRepository;

    @GetMapping("/projects")
    public List<Projects> getProjects() {
        return projectRepository.findAll();
    }

    @PostMapping("/projects")
    public Projects createProject(@Valid @RequestBody Projects projects) {
        return projectRepository.save(projects);
    }

    @PostMapping("/create-employee")
    public People createEmployee(@Valid @RequestBody People employee) {
        return peopleRepository.save(employee);
    }

    @GetMapping("/employee/{id}")
    public ResponseEntity<People> getEmployeeById(@PathVariable(value = "id") int personId)
            throws ResourceNotFoundException {
        People employee = peopleRepository.findById((long) personId).orElseThrow(() ->
                new ResourceNotFoundException("Employee not found for id: " + personId));
        return ResponseEntity.ok().body(employee);
    }


    @GetMapping("/issues")
    public List<Issue> getIssues() {
        return issueRepository.findAll();
    }

    @GetMapping("/issues/{id}")
    public Issue getIssueById(@PathVariable(value = "id") Long issueId) {
        Issue issueById = issueRepository.findById(issueId)
                .orElseThrow(() -> new ResourceAccessException("Issue not found for this id: " + issueId));
        return issueById;
    }

    @PostMapping("/issues")
    public Issue createIssue(@Valid @RequestBody Issue issue)
            throws ResourceNotFoundException {
        return issueRepository.save(issue);
    }

}
