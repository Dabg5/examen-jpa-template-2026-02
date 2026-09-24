package com.example.demo.controller;

import com.example.demo.model.PullRequest;
import com.example.demo.repository.IPullRequestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pull-requests")
@RequiredArgsConstructor
public class PullRequestController {

    private final IPullRequestRepository pullRequestRepository;

    @GetMapping("/prueba")
    public List<PullRequest> findAllPullRequests() {
        return pullRequestRepository.findAll();
    }

    @GetMapping("/exercise1")
    public List<PullRequest> exercise1(){
        return pullRequestRepository.findDistinctByRepository_Assignment_Classroom_NameAndStatusOrderByCreatedAtDesc("Computacion en Internet II - Grupo 1", "OPEN");
    }

    @GetMapping("/exercise3")
    public List<PullRequest> exercise3(){
        return pullRequestRepository.findDistinctByReviewer_RoleAndAuthor_UsernameAndAuthor_Classrooms_Semester("TA", "cjimenez", "2026-02");
    }
}
