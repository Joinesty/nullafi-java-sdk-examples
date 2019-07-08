package com.joinesty.examples.staticVault.managers;

import com.joinesty.domains.staticVault.StaticVault;
import com.joinesty.domains.staticVault.managers.vehicleRegistration.VehicleRegistrationResponse;

public class VehicleRegistrationExample {

  private StaticVault staticVault;

  private VehicleRegistrationExample() {
  }

  public VehicleRegistrationExample(StaticVault staticVault) {
    this.staticVault = staticVault;
  }

  public void run() throws Exception {
    // Creating a new VehicleRegistration
    VehicleRegistrationResponse created = this.create(this.staticVault);

    // Retrieving a existent VehicleRegistration
    VehicleRegistrationResponse retrieved = this.retrieve(this.staticVault, created.getId());

    // Retrieving from a real data
    this.retrieveFromRealData(this.staticVault, retrieved.getVehicleregistration());

    // Deleting a existent VehicleRegistration
    this.delete(this.staticVault, retrieved.getId());

  }

  private VehicleRegistrationResponse create(StaticVault vault) throws Exception {
    String name = "VehicleRegistration Example";

    VehicleRegistrationResponse created = vault.getVehicleRegistrationManager().create(name);

    System.out.println("**** VehicleRegistrationExample.create:");
    System.out.println("-> Original: " + name);
    System.out.println("-> " + created.toString());
    System.out.println("\n");

    return created;
  }

  private VehicleRegistrationResponse retrieve(StaticVault vault, String id) throws Exception {
    VehicleRegistrationResponse retrieved = vault.getVehicleRegistrationManager().retrieve(id);

    System.out.println("**** VehicleRegistrationExample.retrieve:");
    System.out.println("-> " + retrieved.toString());
    System.out.println("\n");

    return retrieved;

  }

  private VehicleRegistrationResponse[] retrieveFromRealData(StaticVault vault, String vehicleRegistration) throws Exception {
    VehicleRegistrationResponse[] retrieved = vault.getVehicleRegistrationManager().retrieveFromRealData(vehicleRegistration);

    System.out.println("**** VehicleRegistrationExample.retrieve:");
    for (int i = 0; i < retrieved.length; i++) {
      System.out.println("[" + i + "] -> " + retrieved[i].toString());
    }

    System.out.println("\n");

    return retrieved;
  }

  private boolean delete(StaticVault vault, String id) throws Exception {
    boolean deleted = vault.getVehicleRegistrationManager().delete(id);

    System.out.println("**** VehicleRegistrationExample.delete:");
    System.out.println("-> Success: " + deleted);
    System.out.println("\n");

    if (!deleted) throw new RuntimeException("Error when delete VehicleRegistration");

    return deleted;
  }
}
