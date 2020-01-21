package com.example.batch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created By ChengHao On 2020/1/21
 */
@RestController
public class HelloController {
    @Autowired
    JobLauncher jobLauncher;
    @Autowired
    Job job;
    @GetMapping("/hello")
    public void hello() {
        try {
            jobLauncher.run(job, new JobParametersBuilder().toJobParameters());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
