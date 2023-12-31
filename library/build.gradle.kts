plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("maven-publish")
}

group = "com.github.Gra-Dus"
version = "1.0.0"

android {
    namespace = "ru.gradus.library"
    compileSdk = 33

    defaultConfig {
        minSdk = 24
        targetSdk = 33

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    publishing{
        multipleVariants{
            withSourcesJar()
            withJavadocJar()
        }
    }
}

dependencies {

    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
}

afterEvaluate {
    publishing{
        publications{
            create<MavenPublication>("library"){
                from(components.getByName("release"))
                groupId = "com.github.Gra-Dus"
                artifactId = "moclibrary"
                version = "1.0.0"
            }
        }
    }
}
