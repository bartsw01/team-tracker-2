package Models;

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
        assertEquals("Test job", job.getContent());
    }

}