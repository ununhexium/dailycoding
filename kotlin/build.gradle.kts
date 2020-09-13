import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

group = "net.lab0.dailycoding"
version = "0.0.0"


plugins {
  val kotlinVersion = "1.4.10"

  id("org.jetbrains.kotlin.jvm") version kotlinVersion
  java
  idea
  maven
}

tasks.withType<KotlinCompile> {
  kotlinOptions.jvmTarget = "1.8"
}

idea {
  module {
    isDownloadSources = true
  }
}

repositories {
  mavenCentral()
}

dependencies {
  implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
  implementation("org.jetbrains.kotlin:kotlin-reflect")
  implementation("org.jgrapht:jgrapht-core:1.3.0")
  implementation("org.junit.jupiter:junit-jupiter:5.4.2")

  // TEST

  val junitJupiterVersion = "5.4.0"
  testImplementation("org.assertj", "assertj-core", "3.12.0")
  testImplementation("org.junit.jupiter:junit-jupiter-api:$junitJupiterVersion")
  testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:$junitJupiterVersion")
}

buildscript {
  repositories {
    mavenCentral()
    jcenter()
  }
}

tasks {
  withType<Test> {
    useJUnitPlatform()
  }
}

