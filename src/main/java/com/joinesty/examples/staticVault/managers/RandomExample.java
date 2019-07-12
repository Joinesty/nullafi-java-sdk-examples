package com.joinesty.examples.staticVault.managers;

import com.joinesty.domains.staticVault.StaticVault;
import com.joinesty.domains.staticVault.managers.random.RandomResponse;

public class RandomExample {

  private StaticVault staticVault;

  private RandomExample() {
  }

  public RandomExample(StaticVault staticVault) {
    this.staticVault = staticVault;
  }

  public void run() throws Exception {

    // Creating a new Random
    RandomResponse created = this.create(this.staticVault);

    // Retrieving a existent Random
    RandomResponse retrieved = this.retrieve(this.staticVault, created.getId());
    String retrievedId = retrieved.getId();

    // Retrieving from a real data
    this.retrieveFromRealData(this.staticVault, retrieved.getData());

    // Deleting a existent Random
    this.delete(this.staticVault, retrievedId);

  }

  private RandomResponse create(StaticVault vault) throws Exception {
    String name = "Random Example";

    RandomResponse created = vault.getRandomManager().create(name);

    System.out.println("**** RandomExample.create:");
    System.out.println("-> Original: " + name);
    System.out.println("-> " + created.toString());
    System.out.println("\n");

    return created;
  }

  private RandomResponse retrieve(StaticVault vault, String id) throws Exception {
    RandomResponse retrieved = vault.getRandomManager().retrieve(id);

    System.out.println("**** RandomExample.retrieve:");
    System.out.println("-> " + retrieved.toString());
    System.out.println("\n");

    return retrieved;

  }

  private RandomResponse[] retrieveFromRealData(StaticVault vault, String random) throws Exception {
    RandomResponse[] retrieved = vault.getRandomManager().retrieveFromRealData(random);

    System.out.println("**** RandomExample.retrieve:");
    for (int i = 0; i < retrieved.length; i++) {
      System.out.println("[" + i + "] -> " + retrieved[i].toString());
    }

    System.out.println("\n");

    return retrieved;
  }

  private boolean delete(StaticVault vault, String id) throws Exception {
    boolean deleted = vault.getRandomManager().delete(id);

    System.out.println("**** RandomExample.delete:");
    System.out.println("-> Success: " + deleted);
    System.out.println("\n");

    if (!deleted) throw new RuntimeException("Error when delete Random");

    return deleted;
  }
}
