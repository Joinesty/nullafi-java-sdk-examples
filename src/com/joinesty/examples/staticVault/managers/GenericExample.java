package com.joinesty.examples.staticVault.managers;

import com.joinesty.domains.staticVault.StaticVault;
import com.joinesty.domains.staticVault.managers.generic.GenericResponse;

public class GenericExample {

  private StaticVault staticVault;

  private GenericExample() {
  }

  public GenericExample(StaticVault staticVault) {
    this.staticVault = staticVault;
  }

  public void run() throws Exception {
    // Creating a new Generic
    GenericResponse created = this.create(this.staticVault);

    // Retrieving a existent Generic
    GenericResponse retrieved = this.retrieve(this.staticVault, created.getId());

    // Retrieving from a real data
    this.retrieveFromRealData(this.staticVault, retrieved.getData());

    // Deleting a existent Generic
    this.delete(this.staticVault, retrieved.getId());

  }

  private GenericResponse create(StaticVault vault) throws Exception {
    String name = "Generic Example";
    String template = "[A-Z]{4}";

    GenericResponse created = vault.getGenericManager().create(name, template);

    System.out.println("**** GenericExample.create:");
    System.out.println("-> Original: " + name);
    System.out.println("-> " + created.toString());
    System.out.println("\n");

    return created;
  }

  private GenericResponse retrieve(StaticVault vault, String id) throws Exception {
    GenericResponse retrieved = vault.getGenericManager().retrieve(id);

    System.out.println("**** GenericExample.retrieve:");
    System.out.println("-> " + retrieved.toString());
    System.out.println("\n");

    return retrieved;

  }

  private GenericResponse[] retrieveFromRealData(StaticVault vault, String generic) throws Exception {
    GenericResponse[] retrieved = vault.getGenericManager().retrieveFromRealData(generic);

    System.out.println("**** GenericExample.retrieve:");
    for (int i = 0; i < retrieved.length; i++) {
      System.out.println("[" + i + "] -> " + retrieved[i].toString());
    }

    System.out.println("\n");

    return retrieved;
  }

  private boolean delete(StaticVault vault, String id) throws Exception {
    boolean deleted = vault.getGenericManager().delete(id);

    System.out.println("**** GenericExample.delete:");
    System.out.println("-> Success: " + deleted);
    System.out.println("\n");

    if (!deleted) throw new RuntimeException("Error when delete Generic");

    return deleted;
  }
}
