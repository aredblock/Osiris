<div align="center">
    
# Osiris

***

</div>

Osiris is a simple API to easily create commands and other features of a PaperMC plugin. The API is inspired by the [PolygonMC](https://aredblock.github.io/PolygonMC/) Minestom fork. 

<br>

<div align="center">

## Installation
***

</div>

### Maven ➔
```xml
<repositories>
    <!-- ... -->
    <repository>
        <id>jitpack</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>
```
```xml
<dependencies>
    <!-- ... -->
    <dependency>
        <groupId>com.github.aredblock</groupId>
        <artifactId>Osiris</artifactId>
        <version>VERSION</version>
    </dependency>
</dependencies>
```

### Gradle ➔
```kotlin
repositories {
    // ...
    mavenCentral()
    maven(url = "https://jitpack.io")
}
```

```kotlin
dependencies {
    //...
    implementation("com.github.aredblock:Osiris:VERSION")
}
```

<br>

> [!NOTE]
> #### You can get the latest version [here](https://jitpack.io/#aredblock/Osiris). <br>


<div align="center">

## Usage
***

</div>

<br>

```java
import de.aredblock.osiris.OsirisBuilder;
import de.aredblock.osiris.OsirisPlugin;
import de.aredblock.osiris.feature.Feature;
import de.aredblock.osiris.test.commands.DemoCommands;

public final class DemoPlugin extends OsirisPlugin {

    public DemoPlugin() {
        super(OsirisBuilder.builder()
                .disable(Feature.FALL_DAMAGE, Feature.BLOCK_PLACING, Feature.BLOCK_BREAKING, Feature.HUNGER));
    }

    @Override
    public void onInitialize() {
        registerCommandRegistry(new DemoCommands());

        getLogger().info("OsirisPlugin loaded!");
    }

    @Override
    public void onShutdown() {

    }

}
```

[> DemoPlugin.class](https://github.com/aredblock/Osiris/blob/master/src/test/java/de/aredblock/osiris/test/DemoPlugin.java)

<br>

```java
import de.aredblock.osiris.command.CommandInput;
import de.aredblock.osiris.command.CommandRegistry;
import de.aredblock.osiris.command.RegisterCommand;

public final class DemoCommands implements CommandRegistry {

    @RegisterCommand(name = "demo")
    public void demoCommand(CommandInput input){
        if(input.isFromPlayer()){
            var player = input.getPlayer();

            player.sendMessage("Hello World! From Osiris!");
        }
    }

}
```

[> DemoCommands.class](https://github.com/aredblock/Osiris/blob/master/src/test/java/de/aredblock/osiris/test/commands/DemoCommands.java)

<br>

<div align="center">

#### From users for users ❤️

</div>
