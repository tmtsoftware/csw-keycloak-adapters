import sbt._

object Dependencies {
  val CswAasKeycloakAdapterCore = Def.setting(
    Seq(
      Libs.`jboss-logging`,
      Keycloak.`keycloak-adapter-spi`,
      Keycloak.`keycloak-core`,
      Keycloak.`keycloak-crypto-default`,
      Keycloak.`keycloak-authz-client`,
      Keycloak.`keycloak-policy-enforcer`,
      Libs.httpclient5,
      Libs.hamcrest,
      Libs.`junit-jupiter-api`
    )
  )

  val CswAasKeycloakInstalled = Def.setting(
    Seq(
      Keycloak.`keycloak-core`,
      Keycloak.`keycloak-adapter-spi`,
      Libs.`jboss-logging`,
      Libs.`jboss-jaxrs-api`,
      Libs.httpclient5,
      Libs.`resteasy-client-api`,
      Libs.`quarkus-http-http-core`,
      Libs.`undertow-core`
    )
  )
}