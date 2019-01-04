

plugins {
    id("java")

    id("application")
    id("idea")

    id("com.gradle.build-scan").version("2.1")
    id("org.springframework.boot").version("2.1.1.RELEASE")
    id("io.spring.dependency-management").version("1.0.6.RELEASE")
    id("org.javamodularity.moduleplugin").version("1.4.0")
    id("org.openjfx.javafxplugin").version("0.0.5")
   // id("org.jetbrains.kotlin.jvm").version("1.3.11")
}


repositories {
    jcenter()
    mavenLocal()
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-dependencies:2.1.1.RELEASE")
    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.openjfx:javafx-fxml:11")
    implementation("org.openjfx:javafx-controls:11")

    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("junit:junit:4.12")
}

sourceSets {
    main {
        output.setResourcesDir(java.outputDir)
    }
}

javafx {
    version = "11.0+"
    modules = listOf("javafx.controls", "javafx.fxml")
}

application {
    mainClassName = "com.sflpro.budgeteer/com.sflpro.budgeteer.Budgeteer"
    applicationName = "budgeteer"
}
