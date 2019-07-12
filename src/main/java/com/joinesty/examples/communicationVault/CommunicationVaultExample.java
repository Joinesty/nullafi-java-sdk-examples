package com.joinesty.examples.communicationVault;

import com.joinesty.Client;
import com.joinesty.domains.communicationVault.CommunicationVault;
import com.joinesty.examples.communicationVault.managers.EmailExample;

import java.util.ArrayList;
import java.util.List;

public class CommunicationVaultExample {

  private Client client;

  private CommunicationVaultExample() {

  }

  public CommunicationVaultExample(Client client) {
    this.client = client;
  }

  public void run() throws Exception {

    /* Creating a new Communication Vault
     *
     * IMPORTANT: Store your Vault Id and MasterKey, it will be necessary to retrieve this one
     */
    CommunicationVault created = createCommunicationVault(this.client);
    String vaultId = created.getId();
    String vaultMasterKey = created.getMasterKey();


    /*
     * Retrieving a existent Communication Vault
     *
     * IMPORTANT: You will need your Id and MasterKey
     */
    CommunicationVault retrievedCommunicationVault = retrieveCommunicationVault(this.client, vaultId, vaultMasterKey);

    /*
     *  Running Communication Vault Managers Examples
     */
    new EmailExample(retrievedCommunicationVault).run();

    /*
     * Deleting an existent Static Vault
     */
    deleteCommunicationVault(this.client, retrievedCommunicationVault.getId());
  }

  private CommunicationVault createCommunicationVault(Client client) throws Exception {
    String name = "Sample Communication Vault Name";
    List tags = new ArrayList<String>();
    tags.add("tag-1");
    tags.add("tag-2");

    CommunicationVault communicationVault = client.createCommunicationVault(name, tags);
    System.out.println("**** CommunicationVaultExample.createCommunicationVault:");
    System.out.println("-> Id: " + communicationVault.getId());
    System.out.println("-> Name: " + communicationVault.getName());
    System.out.println("-> MasterKey: " + communicationVault.getMasterKey());
    System.out.println("\n");

    return communicationVault;
  }

  private CommunicationVault retrieveCommunicationVault(Client client, String id, String masterKey) throws Exception {
    CommunicationVault communicationVault = client.retrieveCommunicationVault(id, masterKey);
    System.out.println("**** CommunicationVaultExample.retrieveCommunicationVault:");
    System.out.println("-> Id: " + communicationVault.getId());
    System.out.println("-> Name: " + communicationVault.getName());
    System.out.println("-> MasterKey: " + communicationVault.getMasterKey());
    System.out.println("\n");

    return communicationVault;
  }

  private boolean deleteCommunicationVault(Client client, String id) throws Exception {
    boolean deleted =  client.deleteCommunicationVault(id);
    System.out.println("**** AddressExample.delete:");
    System.out.println("-> Success: " + deleted);
    System.out.println("\n");

    return deleted;
  }


}
