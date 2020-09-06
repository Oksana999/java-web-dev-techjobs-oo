package org.launchcode.techjobs_oo.Tests;

import org.junit.Before;
import org.junit.Test;
import org.launchcode.techjobs_oo.CoreCompetency;
import org.launchcode.techjobs_oo.Employer;
import org.launchcode.techjobs_oo.Job;
import org.launchcode.techjobs_oo.Location;
import org.launchcode.techjobs_oo.PositionType;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

/**
 * @author Oksana
 */
public class JobTest {
   private static final String PRODUCT_TESTER = "Product tester";
   private static final String ACME = "ACME";
   private static final String DESERT = "Desert";
   private static final String QUALITY_CONTROL = "Quality control";
   private static final String PERSISTENCE = "Persistence";
   private static final String DATA_NOT_AVAILABLE = "Data not available";

   Job test_job1;
   Job test_job2;
   Job test_job;

   @Before
   public void createJobObject() {
      test_job1 = new Job();
      test_job2 = new Job();
      test_job = new Job(PRODUCT_TESTER, new Employer(ACME), new Location(DESERT),
              new PositionType(QUALITY_CONTROL), new CoreCompetency(PERSISTENCE));
   }

   @Test
   public void testSettingJobId() {
      assertNotEquals(test_job1, test_job2);
   }

   @Test
   public void testJobConstructorSetsAllFields() {
      assertTrue(test_job instanceof Job);
      assertEquals(PRODUCT_TESTER, test_job.getName());
      assertEquals(ACME, test_job.getEmployer().toString());
      assertEquals(DESERT, test_job.getLocation().toString());
      assertEquals(QUALITY_CONTROL, test_job.getPositionType().toString());
      assertEquals(PERSISTENCE, test_job.getCoreCompetency().toString());
   }

   @Test
   public void testJobsForEquality() {
      Job test_job3 = new Job(PRODUCT_TESTER, new Employer(ACME), new Location(DESERT),
              new PositionType(QUALITY_CONTROL), new CoreCompetency(PERSISTENCE));
      Job test_job4 = new Job(PRODUCT_TESTER, new Employer(ACME), new Location(DESERT),
              new PositionType(QUALITY_CONTROL), new CoreCompetency(PERSISTENCE));

      assertNotEquals(test_job3, test_job4);
   }

   @Test
   public void testToStringContainBlankLineBeforeAndAfter() {
      test_job = new Job("", new Employer(""), new Location(""),
              new PositionType(""), new CoreCompetency(""));
      char[] chars = test_job.toString().toCharArray();
      // char aChar = chars[chars.length-1];

      assertEquals(" ", String.valueOf(chars[0]));
      assertEquals(" ", String.valueOf(chars[chars.length - 1]));
   }

   @Test
   public void testToStringToContainLabelForEachField() {
      assertTrue(test_job.toString().contains("ID"));
      assertTrue(test_job.toString().contains("Name"));
      assertTrue(test_job.toString().contains("Location"));
      assertTrue(test_job.toString().contains("Position Type"));
      assertTrue(test_job.toString().contains("Core Competency"));
   }

   @Test
   public void testToStringFieldEmpty() {
      test_job = new Job("", new Employer(ACME), new Location(DESERT),
              new PositionType(QUALITY_CONTROL), new CoreCompetency(PERSISTENCE));
      assertTrue(test_job.toString().contains(DATA_NOT_AVAILABLE));

      test_job = new Job(PRODUCT_TESTER, new Employer(""), new Location(DESERT),
              new PositionType(QUALITY_CONTROL), new CoreCompetency(PERSISTENCE));
      assertTrue(test_job.toString().contains(DATA_NOT_AVAILABLE));

      test_job = new Job(PRODUCT_TESTER, new Employer(ACME), new Location(""),
              new PositionType(QUALITY_CONTROL), new CoreCompetency(PERSISTENCE));
      assertTrue(test_job.toString().contains(DATA_NOT_AVAILABLE));

      test_job = new Job(PRODUCT_TESTER, new Employer(ACME), new Location(DESERT),
              new PositionType(""), new CoreCompetency(PERSISTENCE));
      assertTrue(test_job.toString().contains(DATA_NOT_AVAILABLE));

      test_job = new Job(PRODUCT_TESTER, new Employer(ACME), new Location(DESERT),
              new PositionType(QUALITY_CONTROL), new CoreCompetency(""));
      assertTrue(test_job.toString().contains(DATA_NOT_AVAILABLE));
   }

   @Test
   public void testToStringAllFieldEmpty() {
      test_job = new Job("", new Employer(""), new Location(""),
              new PositionType(""), new CoreCompetency(""));
      assertEquals(" OOPS! This job does not seem to exist. ", test_job.toString());
   }

}
