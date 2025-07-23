package com.project.JobApp.controller;

import com.project.JobApp.JobAppApplication;
import com.project.JobApp.model.JobPost;
import com.project.JobApp.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.batch.BatchProperties;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@Controller
public class MainController {

    @Autowired
    public JobService jobService;

    @GetMapping({"/","home"})
    public String home(){
        return "home";
    }

    @GetMapping({"addjob"})
    public String addJob(){
        return "addJob";
    }

    @PostMapping({"handleForm"})
    public String handlerForm(JobPost jobPost){
        jobService.addJob(jobPost);
        return "success";
    }

    @GetMapping("viewalljobs")
    public String viewAllJobs(Model model){
        List<JobPost> jobs=jobService.getAllJobs();
        model.addAttribute("jobPosts", jobs);
        return "viewalljobs";
    }

    @GetMapping("jobPosts")
    @ResponseBody
    public List<JobPost> viewAllJobs(){
        return jobService.getAllJobs();
    }

    @GetMapping("jobPost/{postId}")
    @ResponseBody
    public JobPost getJob(@PathVariable("postId") int postId){
        return jobService.getJob(postId);
    }



    @PostMapping(value = "/jobPost/xml-to-json", consumes = "application/xml", produces = "application/json")
    public JobPost add(@RequestBody JobPost jobPost){
      jobService.addJob(jobPost);
      return jobService.getJob(jobPost.getPostId());
    }

    @PutMapping("jobPost")
    public JobPost update(@RequestBody JobPost jobPost){
        jobService.updateJob(jobPost);
        return jobService.getJob(jobPost.getPostId());
    }

    @GetMapping("deleteJob/{postId}")
    public void delete(@PathVariable("postId") int postId){
        jobService.deleteJob(postId);
    }

    @GetMapping("load")
    public String loadData(){
      jobService.load();
      return "success";
    }

    @GetMapping("search/{keyword}")
    public List<JobPost> search(@PathVariable("keyword") String keyword){
        return jobService.findBykeyword(keyword);
    }

}
