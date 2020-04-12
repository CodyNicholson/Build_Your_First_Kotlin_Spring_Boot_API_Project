import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "2.1.7.RELEASE"
    id("io.spring.dependency-management") version "1.0.7.RELEASE"
    id("maven-publish")
    id("jacoco")
    kotlin("plugin.jpa") version "1.3.11"
    kotlin("jvm")  version "1.3.11"
    kotlin("plugin.spring")  version "1.3.11"
}

group = "org.clairvoyantcoding"
version = "1.0"
java.sourceCompatibility = JavaVersion.VERSION_1_8

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.retry:spring-retry:1.2.4.RELEASE")
    implementation("org.springframework.boot:spring-boot-starter-aop:1.5.22.RELEASE")
    implementation("org.springframework.boot:spring-boot-starter-actuator")
    implementation("org.springframework.boot:spring-boot-starter-data-rest")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework:spring-web:5.1.13.RELEASE")
    implementation("org.jetbrains.kotlin:kotlin-reflect:1.3.50")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.3.50")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk7:1.3.50")
    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.3.50")
    implementation("org.apache.poi:poi:3.17")
    implementation("org.apache.poi:poi-ooxml:3.17")
    implementation("com.google.code.gson:gson:2.8.5")
    implementation("com.google.guava:guava:28.0-jre")
    implementation("io.micrometer:micrometer-registry-prometheus:1.0.4")
    implementation("com.nimbusds:nimbus-jose-jwt:7.9")
    implementation("joda-time:joda-time:2.9.9")
    implementation("org.json:json:20140107")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.10.0")
    implementation("com.fasterxml.jackson.core:jackson-core:2.10.0")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.10.0") {
        isForce = true
    }

    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.springframework.security:spring-security-test")
    testImplementation("org.springframework.boot:spring-boot-starter-test:2.1.7.RELEASE")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.5.1")
    testImplementation("org.junit.platform:junit-platform-runner:1.5.1")
    testImplementation("org.junit.platform:junit-platform-commons:1.5.1")
    testImplementation("org.mockito:mockito-junit-jupiter:3.0.0")
    testImplementation("com.nhaarman:mockito-kotlin:1.5.0")
    testImplementation("org.mockito:mockito-core:3.0.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.4.0")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher:1.4.2")
    testRuntimeOnly("org.junit.vintage:junit-vintage-engine:5.4.0")
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }
}

tasks.test {
    useJUnitPlatform()
    testLogging {
        events("PASSED", "STARTED", "FAILED", "SKIPPED")
    }
}
