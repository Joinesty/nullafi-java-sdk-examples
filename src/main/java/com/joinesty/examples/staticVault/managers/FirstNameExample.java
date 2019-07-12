package com.joinesty.examples.staticVault.managers;

import com.joinesty.domains.staticVault.StaticVault;
import com.joinesty.domains.staticVault.managers.firstName.FirstNameResponse;

import java.util.ArrayList;
import java.util.List;

public class FirstNameExample {

  private StaticVault staticVault;

  private FirstNameExample() {
  }

  public FirstNameExample(StaticVault staticVault) {
    this.staticVault = staticVault;
  }

  public void run() throws Exception {

    /*
     * FIRST NAME
     */

    // Creating a new FirstName
    FirstNameResponse created = this.create(this.staticVault);

    // Retrieving a existent FirstName
    FirstNameResponse retrieved = this.retrieve(this.staticVault, created.getId());

    // Retrieving from a real data
    this.retrieveFromRealData(this.staticVault, retrieved.getFirstname());

    // Deleting a existent FirstName
    this.delete(this.staticVault, retrieved.getId());


    /*
     * FIRST NAME WITH GENDER
     */
    // Creating a new FirstName with Gender
    FirstNameResponse createdWithGender = this.createWithGender(this.staticVault);

    // Retrieving a existent FirstName
    FirstNameResponse retrievedWithGender = this.retrieve(this.staticVault, createdWithGender.getId());

    // Deleting a existent FirstName
    this.delete(this.staticVault, retrievedWithGender.getId());

  }

  private FirstNameResponse create(StaticVault vault) throws Exception {
    String name = "FirstName Example";

    FirstNameResponse created = vault.getFirstNameManager().create(name);

    System.out.println("**** FirstNameExample.create:");
    System.out.println("-> Original: " + name);
    System.out.println("-> " + created.toString());
    System.out.println("\n");

    return created;
  }

  private FirstNameResponse createWithGender(StaticVault vault) throws Exception {
    String name = "John";
    String gender = "male";
    List<String> tags = new ArrayList<>();
    tags.add("my-fName-tag1");
    tags.add("my-fName-tag2");

    FirstNameResponse created = vault.getFirstNameManager().create(name, gender, tags);

    System.out.println("**** FirstNameExample.createWithGender:");
    System.out.println("-> Original: " + name);
    System.out.println("-> " + created.toString());
    System.out.println("\n");

    return created;
  }

  private FirstNameResponse retrieve(StaticVault vault, String id) throws Exception {
    FirstNameResponse retrieved = vault.getFirstNameManager().retrieve(id);

    System.out.println("**** FirstNameExample.retrieve:");
    System.out.println("-> " + retrieved.toString());
    System.out.println("\n");

    return retrieved;

  }

  private FirstNameResponse[] retrieveFromRealData(StaticVault vault, String firstName) throws Exception {
    FirstNameResponse[] retrieved = vault.getFirstNameManager().retrieveFromRealData(firstName);

    System.out.println("**** FirstNameExample.retrieve:");
    for (int i = 0; i < retrieved.length; i++) {
      System.out.println("[" + i + "] -> " + retrieved[i].toString());
    }

    System.out.println("\n");

    return retrieved;
  }

  private boolean delete(StaticVault vault, String id) throws Exception {
    boolean deleted = vault.getFirstNameManager().delete(id);

    System.out.println("**** FirstNameExample.delete:");
    System.out.println("-> Success: " + deleted);
    System.out.println("\n");

    if (!deleted) throw new RuntimeException("Error when delete FirstName");

    return deleted;
  }
}
