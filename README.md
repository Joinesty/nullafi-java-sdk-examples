Nullafi Java SDK Examples
===============

A Java Application with examples to use the Nullafi Java SDK.

- [Pre Requisites](#pre-requisites)
- [How to install the SDK at your project](#how-to-install-the-sdk-at-your-project)  
- [Importing the Examples at IDE (ItelliJ IDEA CE)](#importing-the-examples-at-ide-itellij-idea-ce)
- [Importing the Examples at IDE (Eclipse or Similar)](#importing-the-examples-at-ide-eclipse-or-similar)
- [Running without IDE](#running-without-ide)
- [Getting Started](#getting-started)
- [Copyright and License](#copyright-and-license)

<!-- END doctoc generated TOC please keep comment here to allow auto update -->

Pre Requisites
---
- Java SE Development Kit >= 8 
- Maven >= 3.6.0

How to install the SDK at your project
---
- Import the Maven Plugin Dependency from [Central Repository](https://search.maven.org/artifact/com.joinesty/nullafi-java-sdk). Example:
```xml
<dependencies>
  <dependency>
    <groupId>com.joinesty</groupId>
    <artifactId>nullafi-java-sdk</artifactId>
    <version>...</version>
  </dependency>
</dependencies>
``` 

Importing the Examples at IDE (ItelliJ IDEA CE)
---

#### Importing
1. Clone the repository: `git clone https://github.com/Joinesty/nullafi-csharp-sdk-examples.git`
2. Open `ItelliJ IDEA CE` and click on `File > New > Project from Existing Sources...`
3. Select the folder `nullafi-csharp-sdk-examples` and click on `Open`
4. Select the option `Import project from external model`, choose `Maven` and click on `Next`
5. Check if the `Root directory` is the right folder and click on `Next`
6. Make sure if the `com.joinesty.nullafi-java-sdk-examples:…` is selected and click on `Next`
7. Select the Java SDK Version (make sure if the version is >= 1.8) and click on `Next`
8. Check the `Project name` and `Project file location` and click on `Finish`

#### Running
- Setup an Environment Variable called `NULLAFI_API_KEY` with yours and run `mvn clean install` at your terminal

Importing the Examples at IDE (Eclipse or Similar)
---

#### Importing
1. Clone the repository: `git clone https://github.com/Joinesty/nullafi-csharp-sdk-examples.git`
2. Open `Eclipse IDE` and click on `File > Import...`
3. Select the option `Maven > Existing Maven Project` and click on `Next`
4. Click on `Browse` and select the folder `nullafi-csharp-sdk-examples`
5. Make sure if the option `/pom.xml  com.joinesty:nullafi-sdk-examples:...jar` is selected and click on `Finish`

#### Running
- Setup an Environment Variable called `NULLAFI_API_KEY` with yours and run `mvn clean install` at your terminal

Running without IDE
---
- Setup an Environment Variable called `NULLAFI_API_KEY` with yours and run `mvn clean install` at your terminal
 
---

Getting Started
---

- To get started with the Examples, get a API Key from the Configuration page
of your app in the [Settings Page - API Key][settings-api-key]. You can use this token to make calls for your own Nullafi account.

- All vaults and tokens examples are in `src\main\java\com\joinesty` folder.

- View `com.joinesty.Main` class to view all examples working.

```java
package com.joinesty;

import com.joinesty.examples.Examples;

public class Main {

  public static void main(String[] args) throws Exception {
    String apiKey = System.getenv("NULLAFI_API_KEY");
    if (apiKey == null) throw new RuntimeException("Environment NULLAFI_API_KEY could not be null.");

    Examples examples = new Examples(apiKey);
    examples.run();
  }
}
```

[settings-api-key]: https://dashboard.nullafi.com/admin/settings/api

Copyright and License
---------------------

Copyright 2019 Joinesty, Inc. All rights reserved.
