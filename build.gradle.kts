import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.7.20"
    id("com.diffplug.spotless") version "6.12.0"
    application
}

group = "dev.yashgarg"

version = "1.0-SNAPSHOT"

repositories { mavenCentral() }

dependencies { testImplementation(kotlin("test")) }

tasks.test { useJUnitPlatform() }

tasks.withType<KotlinCompile> { kotlinOptions.jvmTarget = "1.8" }

application { mainClass.set("MainKt") }

spotless {
    kotlin {
        ktfmt().kotlinlangStyle()
        target("**/*.kt")
        targetExclude("**/build/")
        trimTrailingWhitespace()
        endWithNewline()
    }

    kotlinGradle {
        ktfmt().kotlinlangStyle()
        target("**/*.gradle.kts")
        targetExclude("**/build/")
    }
}
