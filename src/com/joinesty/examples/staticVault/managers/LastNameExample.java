package com.joinesty.examples.staticVault.managers;

import com.joinesty.domains.staticVault.StaticVault;
import com.joinesty.domains.staticVault.managers.lastName.LastNameResponse;

public class LastNameExample {

  private StaticVault staticVault;

  private LastNameExample() {
  }

  public LastNameExample(StaticVault staticVault) {
    this.staticVault = staticVault;
  }

  public void run() throws Exception {

    /*
     * LAST NAME
     */

    // Creating a new LastName
    LastNameResponse created = this.create(this.staticVault);

    // Retrieving a existent LastName
    LastNameResponse retrieved = this.retrieve(this.staticVault, created.getId());

    // Retrieving from a real data
    this.retrieveFromRealData(this.staticVault, retrieved.getLastname());

    // Deleting a existent LastName
    this.delete(this.staticVault, retrieved.getId());


    /*
     * LAST NAME WITH GENDER
     */

    // Creating a new LastName with Gender
    LastNameResponse createdWithGender = this.createWithGender(this.staticVault);

    // Retrieving a existent LastName
    LastNameResponse retrievedWithGender = this.retrieve(this.staticVault, createdWithGender.getId());

    // Deleting a existent LastName
    this.delete(this.staticVault, retrievedWithGender.getId());

  }

  private LastNameResponse create(StaticVault vault) throws Exception {
    String name = "LastName Example";

    LastNameResponse created = vault.getLastNameManager().create(name);

    System.out.println("**** LastNameExample.create:");
    System.out.println("-> Original: " + name);
    System.out.println("-> " + created.toString());
    System.out.println("\n");

    return created;
  }

  private LastNameResponse createWithGender(StaticVault vault) throws Exception {
    String name = "LastName With Gender Example";
    String gender = "female";

    LastNameResponse created = vault.getLastNameManager().create(name, gender);

    System.out.println("**** LastNameExample.createWithGender:");
    System.out.println("-> Original: " + name);
    System.out.println("-> " + created.toString());
    System.out.println("\n");

    return created;
  }

  private LastNameResponse[] retrieveFromRealData(StaticVault vault, String lastName) throws Exception {
    LastNameResponse[] retrieved = vault.getLastNameManager().retrieveFromRealData(lastName);

    System.out.println("**** LastNameExample.retrieve:");
    for (int i = 0; i < retrieved.length; i++) {
      System.out.println("[" + i + "] -> " + retrieved[i].toString());
    }

    System.out.println("\n");

    return retrieved;
  }

  private LastNameResponse retrieve(StaticVault vault, String id) throws Exception {
    LastNameResponse retrieved = vault.getLastNameManager().retrieve(id);

    System.out.println("**** LastNameExample.retrieve:");
    System.out.println("-> " + retrieved.toString());
    System.out.println("\n");

    return retrieved;

  }

  private boolean delete(StaticVault vault, String id) throws Exception {
    boolean deleted = vault.getLastNameManager().delete(id);

    System.out.println("**** LastNameExample.delete:");
    System.out.println("-> Success: " + deleted);
    System.out.println("\n");

    if (!deleted) throw new RuntimeException("Error when delete LastName");

    return deleted;
  }
}
