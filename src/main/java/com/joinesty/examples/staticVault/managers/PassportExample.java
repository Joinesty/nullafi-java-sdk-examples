package com.joinesty.examples.staticVault.managers;

import com.joinesty.domains.staticVault.StaticVault;
import com.joinesty.domains.staticVault.managers.passport.PassportResponse;

public class PassportExample {

  private StaticVault staticVault;

  private PassportExample() {
  }

  public PassportExample(StaticVault staticVault) {
    this.staticVault = staticVault;
  }

  public void run() throws Exception {

    // Creating a new Passport
    PassportResponse created = this.create(this.staticVault);

    // Retrieving a existent Passport
    PassportResponse retrieved = this.retrieve(this.staticVault, created.getId());

    // Retrieving from a real data
    this.retrieveFromRealData(this.staticVault, retrieved.getPassport());

    // Deleting a existent Passport
    this.delete(this.staticVault, retrieved.getId());

  }

  private PassportResponse create(StaticVault vault) throws Exception {
    String name = "Passport Example";

    PassportResponse created = vault.getPassportManager().create(name);

    System.out.println("**** PassportExample.create:");
    System.out.println("-> Original: " + name);
    System.out.println("-> " + created.toString());
    System.out.println("\n");

    return created;
  }

  private PassportResponse retrieve(StaticVault vault, String id) throws Exception {
    PassportResponse retrieved = vault.getPassportManager().retrieve(id);

    System.out.println("**** PassportExample.retrieve:");
    System.out.println("-> " + retrieved.toString());
    System.out.println("\n");

    return retrieved;

  }

  private PassportResponse[] retrieveFromRealData(StaticVault vault, String passport) throws Exception {
    PassportResponse[] retrieved = vault.getPassportManager().retrieveFromRealData(passport);

    System.out.println("**** PassportExample.retrieve:");
    for (int i = 0; i < retrieved.length; i++) {
      System.out.println("[" + i + "] -> " + retrieved[i].toString());
    }

    System.out.println("\n");

    return retrieved;
  }

  private boolean delete(StaticVault vault, String id) throws Exception {
    boolean deleted = vault.getPassportManager().delete(id);

    System.out.println("**** PassportExample.delete:");
    System.out.println("-> Success: " + deleted);
    System.out.println("\n");

    if (!deleted) throw new RuntimeException("Error when delete Passport");

    return deleted;
  }
}
