# KCL Java SDK

[![CI](https://github.com/kcl-lang/kcl-java/workflows/CI/badge.svg)](https://github.com/kcl-lang/kcl-java/actions)
[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://github.com/kcl-lang/kcl-java/blob/main/LICENSE)

KCL Java SDK

## Requirements

+ Python3+
+ Cargo
+ Java 8+
+ Maven

## Build and Test

```shell
make
```

## Add the Dependency

### Maven

Generally, you can first add the os-maven-plugin to automatically detect the classifier based on your platform:

```xml
<build>
<extensions>
  <extension>
    <groupId>kr.motd.maven</groupId>
    <artifactId>os-maven-plugin</artifactId>
    <version>1.7.0</version>
  </extension>
</extensions>
</build>
```

Add the JitPack repository to your build file

```xml
<repositories>
	<repository>
	    <id>jitpack.io</id>
	    <url>https://jitpack.io</url>
	</repository>
</repositories>
```

Add the dependency

```xml
<dependency>
    <groupId>com.github.kcl-lang</groupId>
    <artifactId>kcl-java</artifactId>
    <version>-SNAPSHOT</version>
</dependency>
```

### Gradle

For Gradle, you can first add the `com.google.osdetector` to automatically detect the classifier based on your platform:

```
plugins {
    id "com.google.osdetector" version "1.7.3"
}
```

Add it in your root build.gradle at the end of repositories:

```shell
dependencyResolutionManagement {
	repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
	repositories {
		mavenCentral()
		maven { url 'https://jitpack.io' }
	}
}
```

Add the dependency

```shell
dependencies {
        implementation 'com.github.kcl-lang:kcl-java:-SNAPSHOT'
}
```

## Quick Case

```java
import com.kcl.api.API;
import com.kcl.api.Spec.*;
import com.kcl.ast.Program;
import com.kcl.util.JsonUtil;

public class Main {
    public void testProgramSymbols() throws Exception {
        API api = new API();
        LoadPackage_Result result = api.loadPackage(
                LoadPackage_Args.newBuilder().setResolveAst(true).setParseArgs(
                        ParseProgram_Args.newBuilder().addPaths("./src/test_data/schema.k").build())
                        .build());
        String programString = result.getProgram();
        Program program = JsonUtil.deserializeProgram(programString);
        result.getSymbolsMap().values().forEach(s -> System.out.println(s));
    }
}
```
