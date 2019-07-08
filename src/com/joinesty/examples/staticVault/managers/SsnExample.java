package com.joinesty.examples.staticVault.managers;

import com.joinesty.domains.staticVault.StaticVault;
import com.joinesty.domains.staticVault.managers.ssn.SsnResponse;

public class SsnExample {

  private StaticVault staticVault;

  private SsnExample() {
  }

  public SsnExample(StaticVault staticVault) {
    this.staticVault = staticVault;
  }

  public void run() throws Exception {

    /*
     * SSN
     */

    // Creating Ssn
    SsnResponse created = this.create(this.staticVault);

    // Retrieving a existent Ssn
    SsnResponse retrieved = this.retrieve(this.staticVault, created.getId());

    // Retrieving from a real data
    this.retrieveFromRealData(this.staticVault, retrieved.getSsn());

    // Deleting a existent Ssn
    this.delete(this.staticVault, retrieved.getId());


    /*
     * SSN WITH STATE
     */

    // Creating a new Ssn with State
    SsnResponse createdWithState = this.createWithState(this.staticVault);

    // Retrieving a existent Ssn
    SsnResponse retrievedWithState = this.retrieve(this.staticVault, createdWithState.getId());

    // Deleting a existent Ssn
    this.delete(this.staticVault, retrievedWithState.getId());

  }

  private SsnResponse create(StaticVault vault) throws Exception {
    String name = "Ssn Example";

    SsnResponse created = vault.getSsnManager().create(name);

    System.out.println("**** SsnExample.create:");
    System.out.println("-> Original: " + name);
    System.out.println("-> " + created.toString());
    System.out.println("\n");

    return created;
  }

  private SsnResponse createWithState(StaticVault vault) throws Exception {
    String name = "Ssn With State Example";
    String state = "IL";

    SsnResponse created = vault.getSsnManager().create(name, state);

    System.out.println("**** SsnExample.createWithState:");
    System.out.println("-> Original: " + name);
    System.out.println("-> " + created.toString());
    System.out.println("\n");

    return created;
  }

  private SsnResponse retrieve(StaticVault vault, String id) throws Exception {
    SsnResponse retrieved = vault.getSsnManager().retrieve(id);

    System.out.println("**** SsnExample.retrieve:");
    System.out.println("-> " + retrieved.toString());
    System.out.println("\n");

    return retrieved;
  }

  private SsnResponse[] retrieveFromRealData(StaticVault vault, String ssn) throws Exception {
    SsnResponse[] retrieved = vault.getSsnManager().retrieveFromRealData(ssn);

    System.out.println("**** SsnExample.retrieve:");
    for (int i = 0; i < retrieved.length; i++) {
      System.out.println("[" + i + "] -> " + retrieved[i].toString());
    }

    System.out.println("\n");

    return retrieved;
  }

  private boolean delete(StaticVault vault, String id) throws Exception {
    boolean deleted = vault.getSsnManager().delete(id);

    System.out.println("**** SsnExample.delete:");
    System.out.println("-> Success: " + deleted);
    System.out.println("\n");

    if (!deleted) throw new RuntimeException("Error when delete SSN");

    return deleted;
  }
}
