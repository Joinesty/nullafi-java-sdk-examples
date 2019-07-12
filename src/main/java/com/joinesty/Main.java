package com.joinesty;

import com.joinesty.examples.Examples;

public class Main {

  public static void main(String[] args) throws Exception {
    String apiKey = System.getenv("NULLAFI_API_KEY");
    if (apiKey == null) throw new RuntimeException("Environment API_KEY could not be null.");

    Examples examples = new Examples(apiKey);
    examples.run();
  }
}
