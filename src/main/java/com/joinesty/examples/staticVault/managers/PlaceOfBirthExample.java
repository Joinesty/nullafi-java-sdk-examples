package com.joinesty.examples.staticVault.managers;

import com.joinesty.domains.staticVault.StaticVault;
import com.joinesty.domains.staticVault.managers.placeOfBirth.PlaceOfBirthResponse;

public class PlaceOfBirthExample {

  private StaticVault staticVault;

  private PlaceOfBirthExample() {
  }

  public PlaceOfBirthExample(StaticVault staticVault) {
    this.staticVault = staticVault;
  }

  public void run() throws Exception {

    /*
     * PLACE OF BIRTH
     */

    // Creating a new PlaceOfBirth
    PlaceOfBirthResponse created = this.create(this.staticVault);

    // Retrieving a existent PlaceOfBirth
    PlaceOfBirthResponse retrieved = this.retrieve(this.staticVault, created.getId());

    // Retrieving from a real data
    this.retrieveFromRealData(this.staticVault, retrieved.getPlaceofbirth());

    // Deleting a existent PlaceOfBirth
    this.delete(this.staticVault, retrieved.getId());


    /*
     * PLACE OF BIRTH WITH STATE
     */

    // Creating a new PlaceOfBirth with State
    PlaceOfBirthResponse createdWithState = this.createWithState(this.staticVault);

    // Retrieving a existent PlaceOfBirth
    PlaceOfBirthResponse retrievedWithState = this.retrieve(this.staticVault, createdWithState.getId());

    // Deleting a existent PlaceOfBirth
    this.delete(this.staticVault, retrievedWithState.getId());

  }

  private PlaceOfBirthResponse create(StaticVault vault) throws Exception {
    String name = "PlaceOfBirth Example";

    PlaceOfBirthResponse created = vault.getPlaceOfBirthManager().create(name);

    System.out.println("**** PlaceOfBirthExample.create:");
    System.out.println("-> Original: " + name);
    System.out.println("-> " + created.toString());
    System.out.println("\n");

    return created;
  }

  private PlaceOfBirthResponse createWithState(StaticVault vault) throws Exception {
    String name = "PlaceOfBirth With State Example";
    String state = "IL";

    PlaceOfBirthResponse created = vault.getPlaceOfBirthManager().create(name, state);

    System.out.println("**** PlaceOfBirthExample.createWithState:");
    System.out.println("-> Original: " + name);
    System.out.println("-> " + created.toString());
    System.out.println("\n");

    return created;
  }

  private PlaceOfBirthResponse retrieve(StaticVault vault, String id) throws Exception {
    PlaceOfBirthResponse retrieved = vault.getPlaceOfBirthManager().retrieve(id);

    System.out.println("**** PlaceOfBirthExample.retrieve:");
    System.out.println("-> " + retrieved.toString());
    System.out.println("\n");

    return retrieved;

  }

  private PlaceOfBirthResponse[] retrieveFromRealData(StaticVault vault, String placeOfBirth) throws Exception {
    PlaceOfBirthResponse[] retrieved = vault.getPlaceOfBirthManager().retrieveFromRealData(placeOfBirth);

    System.out.println("**** PlaceOfBirthExample.retrieve:");
    for (int i = 0; i < retrieved.length; i++) {
      System.out.println("[" + i + "] -> " + retrieved[i].toString());
    }

    System.out.println("\n");

    return retrieved;
  }

  private boolean delete(StaticVault vault, String id) throws Exception {
    boolean deleted = vault.getPlaceOfBirthManager().delete(id);

    System.out.println("**** PlaceOfBirthExample.delete:");
    System.out.println("-> Success: " + deleted);
    System.out.println("\n");

//        if (!deleted) throw new RuntimeException("Error when delete PlaceOfBirth");

    return deleted;
  }
}
