package com.JobApplication.JobApplication;

import com.JobApplication.JobApplication.model.JobPost;
import com.JobApplication.JobApplication.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class JobController {
    @Autowired
    private JobService service;

    @GetMapping("/")
    public String home(){
        System.out.println("Home called");
        return "home";
    }
    @GetMapping("addjob")
    public String addJob(){
        System.out.println("Add Job called");
        return "addjob";
    }
    @PostMapping("handleForm")
    public String handleForm(JobPost jobpost ){
        System.out.println("Form Handle triggered");
        service.addJob(jobpost);
        return "success";
    }
    @GetMapping("viewalljobs")
    public String viewJobs(Model m){
        List<JobPost> jobs = service.getAllJobs();
        m.addAttribute("jobPosts",jobs);
        return "viewalljobs";
    }

}
