// More about the setup here: https://github.com/DevSrSouza/KotlinBukkitAPI/wiki/Getting-Started
plugins {
    kotlin("jvm") version "1.4.0"
    kotlin("plugin.serialization") version "1.4.0"
    id("net.minecrell.plugin-yml.bukkit") version "0.3.0"
    id("com.github.johnrengelman.shadow") version "6.0.0"
}

group = "com.mshmelev"
version = "0.0.1"

repositories {
    jcenter()
    // minecraft
    maven("https://papermc.io/repo/repository/maven-public/")
    maven("https://oss.sonatype.org/content/repositories/snapshots/")

    //kotlinbukkitapi with backup repo
    maven("http://nexus.devsrsouza.com.br/repository/maven-public/")
    
    //plugins
    
}

dependencies {
    compileOnly(kotlin("stdlib-jdk8"))

    //minecraft
    compileOnly("org.github.paperspigot:paperspigot-api:1.8.8-R0.1-SNAPSHOT")

    //kotlinbukkitapi
    val changing = Action<ExternalModuleDependency> { isChanging = true }
    compileOnly("br.com.devsrsouza.kotlinbukkitapi:core:0.2.0-SNAPSHOT", changing)
    compileOnly("br.com.devsrsouza.kotlinbukkitapi:serialization:0.2.0-SNAPSHOT", changing)
    compileOnly("br.com.devsrsouza.kotlinbukkitapi:plugins:0.2.0-SNAPSHOT", changing)
    compileOnly("br.com.devsrsouza.kotlinbukkitapi:exposed:0.2.0-SNAPSHOT", changing)

    //plugins
    val transitive = Action<ExternalModuleDependency> { isTransitive = false }
    
}

bukkit {
    main = "com.mshmelev.bridgen.Main"
    depend = listOf("KotlinBukkitAPI")
    description = "A plugin to prictice pridging in minecraft."
    author = "mshmelev"
    website = ""
}

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "1.8"
        kotlinOptions.freeCompilerArgs += "-Xopt-in=kotlin.time.ExperimentalTime,kotlin.ExperimentalStdlibApi"
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = "1.8"
        kotlinOptions.freeCompilerArgs += "-Xopt-in=kotlin.time.ExperimentalTime,kotlin.ExperimentalStdlibApi"
    }
    shadowJar {
        classifier = null
    }
}

configurations.all {
    resolutionStrategy.cacheChangingModulesFor(120, "seconds")
}