pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
    resolutionStrategy {
        eachPlugin {
            if (requested.id.id.startsWith("com.android")) {
                useModule("com.android.tools.build:gradle:8.0.0")
            }

            if (requested.id.id.startsWith("org.jetbrains.kotlin")) {
                useVersion("1.8.10")
            }
        }
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven { setUrl( "https://jitpack.io") }
    }
}

rootProject.name = "moclibrary"
include(":library")
