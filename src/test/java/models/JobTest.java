package models;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Guest on 8/8/17.
 */
public class JobTest {
    @Test
    public void NewJobObjectGetsCorrectlyCreated_true() throws Exception {
        Job job = new Job("Test Job");
        assertEquals(true, job instanceof Job);
    }

    @Test
    public void JobInstantiatesWithJobTitle_true() throws Exception {
        Job job = new Job("Test job");
        assertEquals("Test job", job.getJobTitle());
    }

    @Test
    public void AllJobsAreCorrectlyReturned_true() {
        Job job = new Job("Test Job");
        Job otherJob = new Job ("Other Test Job");
        assertEquals(2, Job.getAll().size());
    }

    @Test
    public void AllJobsContainsAllJobs_true() {
        Job job = new Job("Test Job");
        Job otherJob = new Job ("Other Test Job");
        assertTrue(Job.getAll().contains(job));
        assertTrue(Job.getAll().contains(otherJob));
    }

    @Test
    public void getAddedJob_isFalseAfterInstantiation_false() throws Exception {
        Job myJob = setupNewJob();
        assertEquals(false, myJob.getAddedJob());
    }


    public Job setupNewJob(){
        return new Job("Test Job");
    }




}