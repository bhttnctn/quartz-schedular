package com.i2i.schedular.jobs;

import org.apache.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class TestJob implements Job {

    public static Logger log = Logger.getLogger(TestJob.class);

    public void execute(JobExecutionContext jExeCtx)
	    throws JobExecutionException {
	log.info("TestJob run successfully...");
    }
}