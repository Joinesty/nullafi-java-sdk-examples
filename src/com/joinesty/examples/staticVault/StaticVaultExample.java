package com.joinesty.examples.staticVault;

import com.joinesty.Client;
import com.joinesty.domains.staticVault.StaticVault;
import com.joinesty.examples.staticVault.managers.*;

import java.util.ArrayList;
import java.util.List;

public class StaticVaultExample {

  private Client client;

  private StaticVaultExample() {

  }

  public StaticVaultExample(Client client) {
    this.client = client;
  }

  public void run() throws Exception {

    /* Creating a new Static Vault
     *
     * IMPORTANT: Store your Vault Id and MasterKey, it will be necessary to retrieve this one
     */
    StaticVault created = createStaticVault(this.client);
    String vaultId = created.getId();
    String vaultMasterKey = created.getMasterKey();


    /*
     * Retrieving an existent Static Vault
     *
     * IMPORTANT: You will need your Id and MasterKey
     */
    StaticVault retrievedStaticVault = retrieveStaticVault(this.client, vaultId, vaultMasterKey);

    /*
     *  Running Static Vault Managers Examples
     */
    new AddressExample(retrievedStaticVault).run();
    new DateOfBirthExample(retrievedStaticVault).run();
    new DriversLicenseExample(retrievedStaticVault).run();
    new FirstNameExample(retrievedStaticVault).run();
    new GenderExample(retrievedStaticVault).run();
    new GenericExample(retrievedStaticVault).run();
    new LastNameExample(retrievedStaticVault).run();
    new PassportExample(retrievedStaticVault).run();
    new PlaceOfBirthExample(retrievedStaticVault).run();
    new RaceExample(retrievedStaticVault).run();
    new RandomExample(retrievedStaticVault).run();
    new SsnExample(retrievedStaticVault).run();
    new TaxpayerExample(retrievedStaticVault).run();
    new VehicleRegistrationExample(retrievedStaticVault).run();

    /*
     * Deleting an existent Static Vault
     */
    deleteStaticVault(this.client, retrievedStaticVault.getId());

  }

  private StaticVault createStaticVault(Client client) throws Exception {
    String name = "Sample Static Vault Name";
    List tags = new ArrayList<String>();
    tags.add("tag-1");

    StaticVault staticVault = client.createStaticVault(name, tags);
    System.out.println("**** StaticVaultExample.createStaticVault:");
    System.out.println("-> Id: " + staticVault.getId());
    System.out.println("-> Name: " + staticVault.getName());
    System.out.println("-> MasterKey: " + staticVault.getMasterKey());
    System.out.println("\n");

    return staticVault;
  }

  private StaticVault retrieveStaticVault(Client client, String id, String masterKey) throws Exception {
    StaticVault staticVault = client.retrieveStaticVault(id, masterKey);
    System.out.println("**** StaticVaultExample.retrieveStaticVault:");
    System.out.println("-> Id: " + staticVault.getId());
    System.out.println("-> Name: " + staticVault.getName());
    System.out.println("-> MasterKey: " + staticVault.getMasterKey());
    System.out.println("\n");

    return staticVault;
  }

  private boolean deleteStaticVault(Client client, String id) throws Exception {
    boolean deleted =  client.deleteStaticVault(id);
    System.out.println("**** AddressExample.delete:");
    System.out.println("-> Success: " + deleted);
    System.out.println("\n");

    return deleted;
  }




}
