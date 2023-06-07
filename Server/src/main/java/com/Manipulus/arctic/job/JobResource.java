package com.Manipulus.arctic.job;

import com.Manipulus.arctic.job.model.Job;
import com.Manipulus.arctic.job.service.JobService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/job")
public class JobResource {
    private final JobService jobService;

    public JobResource(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Job>> getAllJob() {
        // Get all jobs using the jobService
        List<Job> jobs = jobService.findAllJobs();
        // Return the list of jobs and the status code 200 (OK)
        return new ResponseEntity<>(jobs, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Job> addCustomer(@RequestBody Job job) {
        // Add a new job using the jobService
        Job newJob = jobService.addJob(job);
        // Return the newly added job and the status code 201 (CREATED)
        return new ResponseEntity<>(newJob, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Job> updateJob(@RequestBody Job job) {
        // Update an existing job using the jobService
        Job updateJob = jobService.updateJob(job);
        // Return the updated job and the status code 201 (CREATED)
        return new ResponseEntity<>(updateJob, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteJobById(@PathVariable("id") Long id) {
        // Delete a job by its id using the jobService
        jobService.deleteJobById(id);
    }
}
