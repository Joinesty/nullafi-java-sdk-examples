package com.joinesty.examples.staticVault.managers;

import com.joinesty.domains.staticVault.StaticVault;
import com.joinesty.domains.staticVault.managers.gender.GenderResponse;

public class GenderExample {

  private StaticVault staticVault;

  private GenderExample() {
  }

  public GenderExample(StaticVault staticVault) {
    this.staticVault = staticVault;
  }

  public void run() throws Exception {

    // Creating a new Gender
    GenderResponse created = this.create(this.staticVault);

    // Retrieving a existent Gender
    GenderResponse retrieved = this.retrieve(this.staticVault, created.getId());

    // Retrieving from a real data
    this.retrieveFromRealData(this.staticVault, retrieved.getGender());

    // Deleting a existent Gender
    this.delete(this.staticVault, retrieved.getId());

  }

  private GenderResponse create(StaticVault vault) throws Exception {
    String name = "male";

    GenderResponse created = vault.getGenderManager().create(name);

    System.out.println("**** GenderExample.create:");
    System.out.println("-> Original: " + name);
    System.out.println("-> " + created.toString());
    System.out.println("\n");

    return created;
  }

  private GenderResponse retrieve(StaticVault vault, String id) throws Exception {
    GenderResponse retrieved = vault.getGenderManager().retrieve(id);

    System.out.println("**** GenderExample.retrieve:");
    System.out.println("-> " + retrieved.toString());
    System.out.println("\n");

    return retrieved;

  }

  private GenderResponse[] retrieveFromRealData(StaticVault vault, String gender) throws Exception {
    GenderResponse[] retrieved = vault.getGenderManager().retrieveFromRealData(gender);

    System.out.println("**** GenderExample.retrieve:");
    for (int i = 0; i < retrieved.length; i++) {
      System.out.println("[" + i + "] -> " + retrieved[i].toString());
    }

    System.out.println("\n");

    return retrieved;
  }

  private boolean delete(StaticVault vault, String id) throws Exception {
    boolean deleted = vault.getGenderManager().delete(id);

    System.out.println("**** GenderExample.delete:");
    System.out.println("-> Success: " + deleted);
    System.out.println("\n");

    if (!deleted) throw new RuntimeException("Error when delete Gender");

    return deleted;
  }
}
