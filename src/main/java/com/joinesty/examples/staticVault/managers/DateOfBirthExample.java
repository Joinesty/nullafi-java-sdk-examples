package com.joinesty.examples.staticVault.managers;

import com.joinesty.domains.staticVault.StaticVault;
import com.joinesty.domains.staticVault.managers.dateOfBirth.DateOfBirthResponse;

import java.util.ArrayList;
import java.util.List;

public class DateOfBirthExample {

  private StaticVault staticVault;

  private DateOfBirthExample() {
  }

  public DateOfBirthExample(StaticVault staticVault) {
    this.staticVault = staticVault;
  }

  public void run() throws Exception {

    /*
     * DATE OF BIRTH
     */

    // Creating a new DateOfBirth
    DateOfBirthResponse created = this.create(this.staticVault);

    // Retrieving a existent DateOfBirth
    DateOfBirthResponse retrieved = this.retrieve(this.staticVault, created.getId());

    // Retrieving from a real data
    this.retrieveFromRealData(this.staticVault, retrieved.getDateofbirth());

    // Deleting a existent DateOfBirth
    this.delete(this.staticVault, retrieved.getId());


    /*
     * DATE OF BIRTH WITH YEAR
     */

    // Creating a new DateOfBirth with Year
    DateOfBirthResponse createdWithYear = this.createWithYear(this.staticVault);

    // Retrieving a existent DateOfBirth
    DateOfBirthResponse retrievedWithYear = this.retrieve(this.staticVault, createdWithYear.getId());

    // Deleting a existent DateOfBirth
    this.delete(this.staticVault, retrievedWithYear.getId());


    /*
     * DATE OF BIRTH WITH MONTH
     */

    // Creating a new DateOfBirth with Month
    DateOfBirthResponse createdWithMonth = this.createWithMonth(this.staticVault);

    // Retrieving a existent DateOfBirth
    DateOfBirthResponse retrievedWithMonth = this.retrieve(this.staticVault, createdWithMonth.getId());

    // Deleting a existent DateOfBirth
    this.delete(this.staticVault, retrievedWithMonth.getId());


    /*
     * DATE OF BIRTH WITH YEAR AND MONTH
     */

    // Creating a new DateOfBirth with Year and Month
    DateOfBirthResponse createdWithYearMonth = this.createWithYearMonth(this.staticVault);

    // Retrieving a existent DateOfBirth
    DateOfBirthResponse retrievedWithYearMonth = this.retrieve(this.staticVault, createdWithYearMonth.getId());

    // Deleting a existent DateOfBirth
    this.delete(this.staticVault, retrievedWithYearMonth.getId());
  }

  private DateOfBirthResponse create(StaticVault vault) throws Exception {
    String name = "DateOfBirth Example";
    DateOfBirthResponse created = vault.getDateOfBirthManager().create(name);

    System.out.println("**** DateOfBirthExample.create:");
    System.out.println("-> Original: " + name);
    System.out.println("-> " + created.toString());
    System.out.println("\n");

    return created;
  }

  private DateOfBirthResponse createWithYear(StaticVault vault) throws Exception {
    String name = "DateOfBirth With Year Example";
    Integer year = 1990;

    DateOfBirthResponse created = vault.getDateOfBirthManager().create(name, year, null);

    System.out.println("**** DateOfBirthExample.createWithYear:");
    System.out.println("-> Original: " + name);
    System.out.println("-> " + created.toString());
    System.out.println("\n");

    return created;
  }

  private DateOfBirthResponse createWithMonth(StaticVault vault) throws Exception {
    String name = "DateOfBirth With Month Example";
    Integer month = 1;

    DateOfBirthResponse created = vault.getDateOfBirthManager().create(name, null, month);

    System.out.println("**** DateOfBirthExample.createWithMonth:");
    System.out.println("-> Original: " + name);
    System.out.println("-> " + created.toString());
    System.out.println("\n");

    return created;
  }

  private DateOfBirthResponse createWithYearMonth(StaticVault vault) throws Exception {
    String name = "1999-07-02";
    Integer year = 1999;
    Integer month = 7;
    List<String> tags = new ArrayList<>();
    tags.add("my-dob-tag1");
    tags.add("my-dob-tag2");

    DateOfBirthResponse created = vault.getDateOfBirthManager().create(name, year, month, tags);

    System.out.println("**** DateOfBirthExample.createWithYearMonth:");
    System.out.println("-> Original: " + name);
    System.out.println("-> " + created.toString());
    System.out.println("\n");

    return created;
  }

  private DateOfBirthResponse retrieve(StaticVault vault, String id) throws Exception {
    DateOfBirthResponse retrieved = vault.getDateOfBirthManager().retrieve(id);

    System.out.println("**** DateOfBirthExample.retrieve:");
    System.out.println("-> " + retrieved.toString());
    System.out.println("\n");

    return retrieved;

  }

  private DateOfBirthResponse[] retrieveFromRealData(StaticVault vault, String dateOfBirth) throws Exception {
    DateOfBirthResponse[] retrieved = vault.getDateOfBirthManager().retrieveFromRealData(dateOfBirth);

    System.out.println("**** DateOfBirthExample.retrieve:");
    for (int i = 0; i < retrieved.length; i++) {
      System.out.println("[" + i + "] -> " + retrieved[i].toString());
    }

    System.out.println("\n");

    return retrieved;
  }

  private boolean delete(StaticVault vault, String id) throws Exception {
    boolean deleted = vault.getDateOfBirthManager().delete(id);

    System.out.println("**** DateOfBirthExample.delete:");
    System.out.println("-> Success: " + deleted);
    System.out.println("\n");

    if (!deleted) throw new RuntimeException("Error when delete DateOfBirth");

    return deleted;
  }
}
