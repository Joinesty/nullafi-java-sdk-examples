package com.joinesty.examples.staticVault.managers;

import com.joinesty.domains.staticVault.StaticVault;
import com.joinesty.domains.staticVault.managers.taxpayer.TaxpayerResponse;

public class TaxpayerExample {

  private StaticVault staticVault;

  private TaxpayerExample() {
  }

  public TaxpayerExample(StaticVault staticVault) {
    this.staticVault = staticVault;
  }

  public void run() throws Exception {
    // Creating a new Taxpayer
    TaxpayerResponse created = this.create(this.staticVault);

    // Retrieving a existent Taxpayer
    TaxpayerResponse retrieved = this.retrieve(this.staticVault, created.getId());

    // Retrieving from a real data
    this.retrieveFromRealData(this.staticVault, retrieved.getTaxpayer());

    // Deleting a existent Taxpayer
    this.delete(this.staticVault, retrieved.getId());

  }

  private TaxpayerResponse create(StaticVault vault) throws Exception {
    String name = "Taxpayer Example";

    TaxpayerResponse created = vault.getTaxpayerManager().create(name);

    System.out.println("**** TaxpayerExample.create:");
    System.out.println("-> Original: " + name);
    System.out.println("-> " + created.toString());
    System.out.println("\n");

    return created;
  }

  private TaxpayerResponse retrieve(StaticVault vault, String id) throws Exception {
    TaxpayerResponse retrieved = vault.getTaxpayerManager().retrieve(id);

    System.out.println("**** TaxpayerExample.retrieve:");
    System.out.println("-> " + retrieved.toString());
    System.out.println("\n");

    return retrieved;

  }

  private TaxpayerResponse[] retrieveFromRealData(StaticVault vault, String taxpayer) throws Exception {
    TaxpayerResponse[] retrieved = vault.getTaxpayerManager().retrieveFromRealData(taxpayer);

    System.out.println("**** TaxpayerExample.retrieve:");
    for (int i = 0; i < retrieved.length; i++) {
      System.out.println("[" + i + "] -> " + retrieved[i].toString());
    }

    System.out.println("\n");

    return retrieved;
  }

  private boolean delete(StaticVault vault, String id) throws Exception {
    boolean deleted = vault.getTaxpayerManager().delete(id);

    System.out.println("**** TaxpayerExample.delete:");
    System.out.println("-> Success: " + deleted);
    System.out.println("\n");

    if (!deleted) throw new RuntimeException("Error when delete Taxpayer");

    return deleted;
  }
}
