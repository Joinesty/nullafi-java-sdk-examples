package com.joinesty.examples;

import com.joinesty.Client;
import com.joinesty.NullafiSDK;
import com.joinesty.examples.communicationVault.CommunicationVaultExample;
import com.joinesty.examples.staticVault.StaticVaultExample;

public class Examples {

  private String apiKey;

  private Examples() {
  }

  public Examples(String apiKey) {
    this.apiKey = apiKey;
  }

  public void run() throws Exception {
    NullafiSDK nullafiSDK = new NullafiSDK(this.apiKey);
    Client client = nullafiSDK.createClient();

    /*
     * Running StaticVault Examples
     */
    new StaticVaultExample(client).run();

    /*
     * Running CommunicationVault Examples
     */
    new CommunicationVaultExample(client).run();
  }
}
