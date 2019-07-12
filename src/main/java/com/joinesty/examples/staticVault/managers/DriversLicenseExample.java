package com.joinesty.examples.staticVault.managers;

import com.joinesty.domains.staticVault.StaticVault;
import com.joinesty.domains.staticVault.managers.driversLicense.DriversLicenseResponse;

import java.util.ArrayList;
import java.util.List;

public class DriversLicenseExample {

  private StaticVault staticVault;

  private DriversLicenseExample() {
  }

  public DriversLicenseExample(StaticVault staticVault) {
    this.staticVault = staticVault;
  }

  public void run() throws Exception {

    /*
     * DRIVERS LICENSE
     */

    // Creating a new DriversLicense
    DriversLicenseResponse created = this.create(this.staticVault);

    // Retrieving a existent DriversLicense
    DriversLicenseResponse retrieved = this.retrieve(this.staticVault, created.getId());

    // Retrieving from a real data
    this.retrieveFromRealData(this.staticVault, retrieved.getDriverslicense());

    // Deleting a existent DriversLicense
    this.delete(this.staticVault, retrieved.getId());


    /*
     * DRIVERS LICENSE WITH STATE
     */

    // Creating a new DriversLicense with State
    DriversLicenseResponse createdWithState = this.createWithState(this.staticVault);

    // Retrieving a existent DriversLicense
    DriversLicenseResponse retrievedWithState = this.retrieve(this.staticVault, createdWithState.getId());

    // Deleting a existent DriversLicense
    this.delete(this.staticVault, retrievedWithState.getId());

  }

  private DriversLicenseResponse create(StaticVault vault) throws Exception {
    String name = "DriversLicense Example";

    DriversLicenseResponse created = vault.getDriversLicenseManager().create(name);

    System.out.println("**** DriversLicenseExample.create:");
    System.out.println("-> Original: " + name);
    System.out.println("-> " + created.toString());
    System.out.println("\n");

    return created;
  }

  private DriversLicenseResponse createWithState(StaticVault vault) throws Exception {
    String name = "123456789";
    String state = "NY";
    List<String> tags = new ArrayList<>();
    tags.add("my-driversLicense-tag1");
    tags.add("my-driversLicense-tag2");

    DriversLicenseResponse created = vault.getDriversLicenseManager().create(name, state, tags);

    System.out.println("**** DriversLicenseExample.createWithState:");
    System.out.println("-> Original: " + name);
    System.out.println("-> " + created.toString());
    System.out.println("\n");

    return created;
  }

  private DriversLicenseResponse retrieve(StaticVault vault, String id) throws Exception {
    DriversLicenseResponse retrieved = vault.getDriversLicenseManager().retrieve(id);

    System.out.println("**** DriversLicenseExample.retrieve:");
    System.out.println("-> " + retrieved.toString());
    System.out.println("\n");

    return retrieved;

  }

  private DriversLicenseResponse[] retrieveFromRealData(StaticVault vault, String driversLicense) throws Exception {
    DriversLicenseResponse[] retrieved = vault.getDriversLicenseManager().retrieveFromRealData(driversLicense);

    System.out.println("**** DriversLicenseExample.retrieve:");
    for (int i = 0; i < retrieved.length; i++) {
      System.out.println("[" + i + "] -> " + retrieved[i].toString());
    }

    System.out.println("\n");

    return retrieved;
  }

  private boolean delete(StaticVault vault, String id) throws Exception {
    boolean deleted = vault.getDriversLicenseManager().delete(id);

    System.out.println("**** DriversLicenseExample.delete:");
    System.out.println("-> Success: " + deleted);
    System.out.println("\n");

    if (!deleted) throw new RuntimeException("Error when delete DriversLicense");

    return deleted;
  }
}
