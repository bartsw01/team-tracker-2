package models;

import org.junit.After;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Guest on 8/8/17.
 */
public class JobTest {
    @After
    public void tearDown() throws Exception {
        Job.clearAllJobs(); //I clear out allll the posts before each test.
    }

    @Test
    public void NewJobObjectGetsCorrectlyCreated_true() throws Exception {
        Job job = setupNewJob();
        assertEquals(true, job instanceof Job);
    }

    @Test
    public void JobInstantiatesWithJobTitle_true() throws Exception {
        Job job = setupNewJob();
        assertEquals("Test Job", job.getJobTitle());
    }

    @Test
    public void AllJobsAreCorrectlyReturned_true() {
        Job job = setupNewJob();
        Job otherJob = setupNewJob();
        assertEquals(2, Job.getAll().size());
    }

    @Test
    public void AllJobsContainsAllJobs_true() {
        Job job = setupNewJob();
        Job otherJob = setupNewJob();
        assertTrue(Job.getAll().contains(job));
        assertTrue(Job.getAll().contains(otherJob));
    }

    @Test
    public void getAddedJob_isFalseAfterInstantiation_false() throws Exception {
        Job myJob = setupNewJob();
        assertEquals(false, myJob.getAddedJob());
    }


    public Job setupNewJob(){
        return new Job("Test Job", "Test Company", "Test Job Description", "Test Job Location", "Test Start", "Test End");
    }




}