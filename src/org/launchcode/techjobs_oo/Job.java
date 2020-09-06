package org.launchcode.techjobs_oo;

import java.util.Objects;

public class Job {

   private static final String DATA_NOT_AVAILABLE = "Data not available";
   private static final String EMPTY = "";
   private int id;
   private static int nextId = 1;

   private String name;
   private Employer employer;
   private Location location;
   private PositionType positionType;
   private CoreCompetency coreCompetency;

   public Job() {
      id = nextId;
      nextId++;
   }

   public Job(String name, Employer employer, Location location, PositionType positionType,
              CoreCompetency coreCompetency) {
      this();
      this.name = name;
      this.employer = employer;
      this.location = location;
      this.positionType = positionType;
      this.coreCompetency = coreCompetency;
   }


   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      Job job = (Job) o;
      return id == job.id;
   }

   @Override
   public int hashCode() {
      return Objects.hash(id);
   }


   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public Employer getEmployer() {
      return employer;
   }

   public void setEmployer(Employer employer) {
      this.employer = employer;
   }

   public Location getLocation() {
      return location;
   }

   public void setLocation(Location location) {
      this.location = location;
   }

   public PositionType getPositionType() {
      return positionType;
   }

   public void setPositionType(PositionType positionType) {
      this.positionType = positionType;
   }

   public CoreCompetency getCoreCompetency() {
      return coreCompetency;
   }

   public void setCoreCompetency(CoreCompetency coreCompetency) {
      this.coreCompetency = coreCompetency;
   }

   public int getId() {
      return id;
   }

   @Override
   public String toString() {
      String employerValue = employer.getValue();
      String locationValue = location.getValue();
      String positionTypeValue = positionType.getValue();
      String coreCompetencyValue = coreCompetency.getValue();

      if (EMPTY.equals(name)) {
         name = " " + DATA_NOT_AVAILABLE;
      }
      if (EMPTY.equals(employerValue)) {
         employerValue = DATA_NOT_AVAILABLE;
      }
      if (EMPTY.equals(locationValue)) {
         locationValue = DATA_NOT_AVAILABLE;
      }
      if (EMPTY.equals(positionTypeValue)) {
         positionTypeValue = DATA_NOT_AVAILABLE;
      }

      if (EMPTY.equals(coreCompetencyValue)) {
         coreCompetencyValue = DATA_NOT_AVAILABLE + " ";
      }
      if (DATA_NOT_AVAILABLE.equals(employerValue) &&
              DATA_NOT_AVAILABLE.equals(locationValue) &&
              DATA_NOT_AVAILABLE.equals(positionTypeValue) &&
              (DATA_NOT_AVAILABLE + " ").equals(coreCompetencyValue)) {
         return " OOPS! This job does not seem to exist. ";
      } else {
         return " ID: " + id + "\n" +
                 " Name: " + name + '\n' +
                 " Employer: " + employerValue + '\n' +
                 " Location: " + locationValue + '\n' +
                 " Position Type: " + positionTypeValue + '\n' +
                 " Core Competency: " + coreCompetencyValue;
      }
   }
}

