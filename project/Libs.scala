import sbt._

object Libs {
  val httpclient5              = "org.apache.httpcomponents.client5" % "httpclient5"              % "5.4.2"
  val `jboss-logging`          = "org.jboss.logging"                 % "jboss-logging"            % "3.6.1.Final"
  val `jboss-jaxrs-api`        = "org.jboss.spec.javax.ws.rs"        % "jboss-jaxrs-api_2.1_spec" % "2.0.2.Final"
  val `resteasy-client-api`    = "org.jboss.resteasy"                % "resteasy-client-api"      % "6.2.12.Final"
  val `quarkus-http-http-core` = "io.quarkus.http"                   % "quarkus-http-http-core"   % "5.3.4"
  val `undertow-core`          = "io.undertow"                       % "undertow-core"            % "2.3.18.Final"
  val hamcrest                 = "org.hamcrest"                      % "hamcrest"                 % "3.0"    % Test
  val `junit-jupiter-api`      = "org.junit.jupiter"                 % "junit-jupiter-api"        % "5.12.2" % Test
}

object Keycloak {
  val Version = "26.2.3"

  val `keycloak-core`            = "org.keycloak" % "keycloak-core"            % Version
  val `keycloak-test-helper`     = "org.keycloak" % "keycloak-test-helper"     % Version
  val `keycloak-policy-enforcer` = "org.keycloak" % "keycloak-policy-enforcer" % "26.0.5"
  val `keycloak-adapter-spi`     = "org.keycloak" % "keycloak-adapter-spi"     % Version
  val `keycloak-crypto-default`  = "org.keycloak" % "keycloak-crypto-default"  % Version
  val `keycloak-authz-client`    = "org.keycloak" % "keycloak-authz-client"    % "26.0.5"
}
