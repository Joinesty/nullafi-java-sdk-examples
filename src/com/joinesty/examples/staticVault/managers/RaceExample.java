package com.joinesty.examples.staticVault.managers;

import com.joinesty.domains.staticVault.StaticVault;
import com.joinesty.domains.staticVault.managers.race.RaceResponse;

public class RaceExample {

  private StaticVault staticVault;

  private RaceExample() {
  }

  public RaceExample(StaticVault staticVault) {
    this.staticVault = staticVault;
  }

  public void run() throws Exception {

    // Creating a new Race
    RaceResponse created = this.create(this.staticVault);

    // Retrieving a existent Race
    RaceResponse retrieved = this.retrieve(this.staticVault, created.getId());

    // Retrieving from a real data
    this.retrieveFromRealData(this.staticVault, retrieved.getRace());

    // Deleting a existent Race
    this.delete(this.staticVault, retrieved.getId());

  }

  private RaceResponse create(StaticVault vault) throws Exception {
    String name = "Race Example";

    RaceResponse created = vault.getRaceManager().create(name);

    System.out.println("**** RaceExample.create:");
    System.out.println("-> Original: " + name);
    System.out.println("-> " + created.toString());
    System.out.println("\n");

    return created;
  }

  private RaceResponse retrieve(StaticVault vault, String id) throws Exception {
    RaceResponse retrieved = vault.getRaceManager().retrieve(id);

    System.out.println("**** RaceExample.retrieve:");
    System.out.println("-> " + retrieved.toString());
    System.out.println("\n");

    return retrieved;
  }

  private RaceResponse[] retrieveFromRealData(StaticVault vault, String race) throws Exception {
    RaceResponse[] retrieved = vault.getRaceManager().retrieveFromRealData(race);

    System.out.println("**** RaceExample.retrieve:");
    for (int i = 0; i < retrieved.length; i++) {
      System.out.println("[" + i + "] -> " + retrieved[i].toString());
    }

    System.out.println("\n");

    return retrieved;
  }

  private boolean delete(StaticVault vault, String id) throws Exception {
    boolean deleted = vault.getRaceManager().delete(id);

    System.out.println("**** RaceExample.delete:");
    System.out.println("-> Success: " + deleted);
    System.out.println("\n");

//        if (!deleted) throw new RuntimeException("Error when delete Race");

    return deleted;
  }
}
