Nullafi Java SDK Examples
===============

A Java Application with examples to use the Nullafi Java SDK.

- [Pre Requisites](#pre-requisites)
- [Installation](#installation)
- [Getting Started](#getting-started)
- [Copyright and License](#copyright-and-license)

<!-- END doctoc generated TOC please keep comment here to allow auto update -->

Pre Requisites
------------
- Java SE Development Kit >= 8 

Installation
------------
- Import JAR (`lib/nullafi-java-sdk-1.0-SNAPSHOT-jar-with-dependencies.jar`) to Application

Getting Started
---------------

- To get started with the Examples, get a API Key from the Configuration page
of your app in the [Settings Page - API Key][settings-api-key]. You can use this token to make calls for your own Nullafi account.

- All vaults and tokens examples are in `src\com\joinesty\examples` folder.

- Run `com.joinesty.Main` class to view all examples working.

```java
package com.joinesty;

import com.joinesty.examples.Examples;

public class Main {

    private static final String API_KEY = "YOUR_API_KEY";

    public static void main(String[] args) {
        Examples examples = new Examples(API_KEY);

        examples.run();
    }
}
```

[settings-api-key]: https://dashboard.nullafi.com/admin/settings/api


Copyright and License
---------------------

Copyright 2019 Joinesty, Inc. All rights reserved.
