import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

group = "net.lab0.dailycoding"
version = "0.0.0"


plugins {
  val kotlinVersion = "1.3.21"

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
  compile("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
  compile("org.jetbrains.kotlin:kotlin-reflect")
  compile("com.google.guava:guava:27.0.1-jre")

  // TEST

  val junitJupiterVersion = "5.4.0"
  testCompile("org.assertj","assertj-core","3.12.0")
  testImplementation("org.junit.jupiter:junit-jupiter-api:$junitJupiterVersion")
  testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:$junitJupiterVersion")
}

buildscript {
  repositories {
    mavenCentral()
    jcenter()
  }
}

tasks.withType<Test> {
  useJUnitPlatform()
}

