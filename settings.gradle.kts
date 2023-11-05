pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "AnimeList"
include(":app")

include(":core")
include(":core:designsystem")

include(":feature:home")
include(":feature:home:api")
include(":feature:home:internal")
include(":core:utils")
include(":core:widget")
include(":core:network")
include(":core:presentation")
include(":core:db")
include(":core:navigation")
