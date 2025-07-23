package com.project.JobApp.repo;

import com.project.JobApp.model.JobPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public interface JobRepo extends JpaRepository<JobPost, Integer> {

   List<JobPost> findByPostProfileContainingOrPostDescContaining(String postProfile, String postDesc);

}

//public List<JobPost> getAllJobs(){
//    return jobs;
//}
//
//public void addJob(JobPost obj){
//    jobs.add(obj);
//    System.out.println(jobs);
//}
//
//public JobPost getJob(int postId) {
//    for(JobPost job:jobs){
//        if(job.getPostId()==postId)
//            return job;
//
//    }
//    return null;
//}
//
//public JobPost deleteJob(int postId) {
//    for(JobPost job: jobs){
//        if(job.getPostId()==postId)
//        {
//            jobs.remove(job);
//            return job;
//        }
//    }
//    return null;
//}
//
//
//public void updateJob(JobPost jobPost) {
//    for(JobPost job: jobs){
//        if(job.getPostId()==jobPost.getPostId())
//        {
//            job.setPostId(jobPost.getPostId());
//            job.setPostDesc(jobPost.getPostDesc());
//            job.setPostProfile(jobPost.getPostProfile());
//            job.setReqExperience(jobPost.getReqExperience());
//            job.setPostTechStack(jobPost.getPostTechStack());
//
//        }
//    }
//}
