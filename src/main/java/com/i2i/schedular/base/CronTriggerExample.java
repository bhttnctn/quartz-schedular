package com.i2i.schedular.base;

import org.apache.log4j.Logger;
import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

import com.i2i.schedular.jobs.TestJob;

public class CronTriggerExample {

    public static Logger log = Logger.getLogger(CronTriggerExample.class);

    public static void main(String[] args) throws Exception {

	log.info("TEST STARTED");

	JobDetail job = JobBuilder.newJob(TestJob.class)
		.withIdentity("testJob").build();

	CronTrigger cronTrigger = TriggerBuilder.newTrigger()
		.withIdentity("crontrigger", "crontriggergroup1")
//		.withSchedule(CronScheduleBuilder.dailyAtHourAndMinute(7, 58))
		.withSchedule(CronScheduleBuilder.cronSchedule("10 * * * * ?"))
		.build();

	// schedule it
	Scheduler scheduler = new StdSchedulerFactory().getScheduler();
	// Start the schedule
	scheduler.start();
	// Tell quartz to schedule the job using the trigger
	scheduler.scheduleJob(job, cronTrigger);

	log.info("TEST FINISHED");
    }
}
