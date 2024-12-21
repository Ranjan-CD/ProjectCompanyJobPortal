package com.example.demo.service;

import com.example.demo.model.JobPost;
import com.example.demo.repo.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {

    @Autowired
    public JobRepo repo;

    //method to return all JobPosts
    public List<JobPost> returnAllJobPosts() {
        return repo.returnAllJobPosts();

    }

    // ***************************************************************************

    // method to add a jobPost
    public void addJobPost(JobPost jobPost) {
        repo.addJobPost(jobPost);

    }

}
