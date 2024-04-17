plugins {
    id("org.jetbrains.kotlin.jvm") version "1.7.10"
    id("com.github.johnrengelman.shadow") version "7.0.0"
    `java-library`
}

group = "noahasu.pnx.pve"
version = "1.0"

repositories {
    mavenCentral()
    maven { setUrl("https://jitpack.io") }
    maven { setUrl("https://repo.opencollab.dev/maven-releases") }
    maven { setUrl("https://repo.opencollab.dev/maven-snapshots") }
}

dependencies {
    implementation("com.github.PowerNukkitX:PowerNukkitX:master-SNAPSHOT")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.10.2")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.10.2")
}

tasks.test {
    // テストの設定
    useJUnitPlatform()
    testLogging {
        events("passed", "skipped", "failed")
    }
}