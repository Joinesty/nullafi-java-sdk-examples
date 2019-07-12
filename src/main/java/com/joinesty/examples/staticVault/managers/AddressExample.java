package com.joinesty.examples.staticVault.managers;

import com.joinesty.domains.staticVault.StaticVault;
import com.joinesty.domains.staticVault.managers.address.AddressResponse;

import java.util.ArrayList;
import java.util.List;

public class AddressExample {

  private StaticVault staticVault;

  private AddressExample() {
  }

  public AddressExample(StaticVault staticVault) {
    this.staticVault = staticVault;
  }

  public void run() throws Exception {

    /*
     * ADDRESS
     */

    // Creating Address
    AddressResponse created = this.create(this.staticVault);

    // Retrieving a existent Address
    AddressResponse retrieved = this.retrieve(this.staticVault, created.getId());

    // Retrieving from a real data
    this.retrieveFromRealData(this.staticVault, retrieved.getAddress());

    // Deleting a existent Address
    this.delete(this.staticVault, retrieved.getId());


    /*
     * ADDRESS WITH STATE
     */

    // Creating a new Address with State
    AddressResponse createdWithState = this.createWithState(this.staticVault);

    // Retrieving a existent Address
    AddressResponse retrievedWithState = this.retrieve(this.staticVault, createdWithState.getId());

    // Deleting a existent Address
    this.delete(this.staticVault, retrievedWithState.getId());

  }

  private AddressResponse create(StaticVault vault) throws Exception {
    String name = "Address Example";

    AddressResponse created = vault.getAddressManager().create(name);

    System.out.println("**** AddressExample.create:");
    System.out.println("-> Original: " + name);
    System.out.println("-> " + created.toString());
    System.out.println("\n");

    return created;
  }

  private AddressResponse createWithState(StaticVault vault) throws Exception {
    String name = "138 Congress St, Portland, ME 04101";
    String state = "ME";
    List<String> tags = new ArrayList<>();
    tags.add("my-address-tag1");
    tags.add("my-address-tag2");

    AddressResponse created = vault.getAddressManager().create(name, state, tags);

    System.out.println("**** AddressExample.createWithState:");
    System.out.println("-> Original: " + name);
    System.out.println("-> " + created.toString());
    System.out.println("\n");

    return created;
  }

  private AddressResponse retrieve(StaticVault vault, String id) throws Exception {
    AddressResponse retrieved = vault.getAddressManager().retrieve(id);

    System.out.println("**** AddressExample.retrieve:");
    System.out.println("-> " + retrieved.toString());
    System.out.println("\n");

    return retrieved;
  }

  private AddressResponse[] retrieveFromRealData(StaticVault vault, String address) throws Exception {
    AddressResponse[] retrieved = vault.getAddressManager().retrieveFromRealData(address);

    System.out.println("**** AddressExample.retrieve:");
    for (int i = 0; i < retrieved.length; i++) {
      System.out.println("[" + i + "] -> " + retrieved[i].toString());
    }

    System.out.println("\n");

    return retrieved;
  }

  private boolean delete(StaticVault vault, String id) throws Exception {
    boolean deleted = vault.getAddressManager().delete(id);

    System.out.println("**** AddressExample.delete:");
    System.out.println("-> Success: " + deleted);
    System.out.println("\n");

    return deleted;
  }
}
