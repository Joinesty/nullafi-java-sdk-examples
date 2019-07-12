package com.joinesty.examples.communicationVault.managers;

import com.joinesty.domains.communicationVault.CommunicationVault;
import com.joinesty.domains.communicationVault.managers.email.EmailResponse;

public class EmailExample {

  private CommunicationVault communicationVault;

  private EmailExample() {

  }

  public EmailExample(CommunicationVault communicationVault) {
    this.communicationVault = communicationVault;
  }

  public void run() throws Exception {

    // Creating a new Email
    EmailResponse created = this.create(this.communicationVault);

    // Retrieving a existent Email
    EmailResponse retrieved = this.retrieve(this.communicationVault, created.getId());

    // Retrieving from a real data
    this.retrieveFromRealData(this.communicationVault, retrieved.getEmail());

    // Deleting a existent Email
    this.delete(this.communicationVault, retrieved.getId());

  }

  private EmailResponse create(CommunicationVault vault) throws Exception {

    String name = "email@domain.com";
    EmailResponse created = vault.getEmailManager().create(name);

    System.out.println("//// EmailExample.create:");
    System.out.println("/// Name: " + name);
    System.out.println(created.toString());

    return created;
  }

  private EmailResponse retrieve(CommunicationVault vault, String id) throws Exception {
    EmailResponse retrieved = vault.getEmailManager().retrieve(id);

    System.out.println("//// EmailExample.retrieve:");
    System.out.println(retrieved.toString());

    return retrieved;

  }

  private EmailResponse[] retrieveFromRealData(CommunicationVault vault, String email) throws Exception {
    EmailResponse[] retrieved = vault.getEmailManager().retrieveFromRealData(email);

    System.out.println("**** EmailExample.retrieve:");
    for (int i = 0; i < retrieved.length; i++) {
      System.out.println("[" + i + "] -> " + retrieved[i].toString());
    }

    System.out.println("\n");

    return retrieved;
  }

  private boolean delete(CommunicationVault vault, String id) throws Exception {
    boolean deleted = vault.getEmailManager().delete(id);

    System.out.println("//// EmailExample.delete:");
    System.out.println(deleted);

    return deleted;
  }
}
