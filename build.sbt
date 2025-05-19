
inThisBuild(
  Seq(
    version := "0.1.0",
    scalaVersion := "3.6.4",
    organization := "com.github.tmtsoftware.keycloak-adapters",
    homepage := Some(url("https://github.com/tmtsoftware/keycloak-adapters")),
    resolvers += "jitpack" at "https://jitpack.io",
    licenses := List(
      "Apache-2.0" -> url("http://www.apache.org/licenses/LICENSE-2.0")
    ),
    developers := List(
      Developer("tmtsoftware", "TMT", "", url("https://github.com/tmtsoftware"))
    )
  )
)

/* ================= Root Project ============== */
lazy val `csw-keycloak-adapters` = project
  .in(file("."))
  .aggregate(`csw-keycloak-adapter-core`, `csw-keycloak-installed`)

lazy val `csw-keycloak-adapter-core` = project
  .in(file("csw-keycloak-adapter-core"))
  .settings(
    libraryDependencies ++= Dependencies.CswAasKeycloakAdapterCore.value
  )

lazy val `csw-keycloak-installed` = project
  .in(file("csw-keycloak-installed"))
  .dependsOn(`csw-keycloak-adapter-core`)
  .settings(
    libraryDependencies ++= Dependencies.CswAasKeycloakInstalled.value
  )

