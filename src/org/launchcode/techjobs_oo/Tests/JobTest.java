package org.launchcode.techjobs_oo.Tests;

import org.junit.Before;
import org.junit.Test;
import org.launchcode.techjobs_oo.CoreCompetency;
import org.launchcode.techjobs_oo.Employer;
import org.launchcode.techjobs_oo.Job;
import org.launchcode.techjobs_oo.Location;
import org.launchcode.techjobs_oo.PositionType;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

/**
 * @author Oksana
 */
public class JobTest {
   Job test_job1;
   Job test_job2;
   Job test_job;
   @Before
   public void createJobObject(){
      test_job1 = new Job();
      test_job2 = new Job();
      test_job = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
              new PositionType("Quality control"), new CoreCompetency("Persistence"));
   }

   @Test
   public void testSettingJobId(){
      assertNotEquals(test_job1, test_job2);
   }

   @Test
   public void testJobConstructorSetsAllFields(){
      assertTrue(test_job instanceof Job );
      assertEquals("Product tester", test_job.getName());
      assertEquals("ACME", test_job.getEmployer().toString());
      assertEquals("Desert", test_job.getLocation().toString());
      assertEquals("Quality control", test_job.getPositionType().toString());
      assertEquals("Persistence", test_job.getCoreCompetency().toString());
   }

   @Test
   public void testJobsForEquality(){
      Job test_job3 = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
              new PositionType("Quality control"), new CoreCompetency("Persistence"));
      Job test_job4 = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
              new PositionType("Quality control"), new CoreCompetency("Persistence"));

      assertNotEquals(test_job3, test_job4);

   }

}
