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
include(":core:utils")
include(":core:widget")
include(":core:network")
include(":core:presentation")
include(":core:db")
include(":core:navigation")

include(":feature:home:api")
include(":feature:home:internal")

include(":feature:profile:api")
include(":feature:profile:internal")

include(":feature:auth:api")
include(":feature:auth:internal")

include(":feature:search:api")
include(":feature:search:internal")

include(":feature:anime:api")
include(":feature:anime:internal")

include(":feature:detail:api")
include(":feature:detail:internal")
