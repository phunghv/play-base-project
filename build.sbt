organization := "com.phunghv"

name := "play-base-project"

scalaVersion := "2.12.6"

version := "1.0-SNAPSHOT"

val appDependencies = Seq(
  "be.objectify" %% "deadbolt-java" % "2.6.4",
  "be.objectify" %% "deadbolt-java-gs" % "2.6.0",
  // Comment the next line for local development of the Play Authentication core:
  // Use the latest release version when copying this code, e.g. "0.9.0"
  "com.feth" %% "play-authenticate" % "0.9.0-SNAPSHOT",
  "org.postgresql" % "postgresql" % "9.4-1206-jdbc42",
  cacheApi,
  ehcache,
  evolutions,
  javaWs,
  javaJdbc,
  "org.webjars" % "bootstrap" % "3.2.0",
  "org.easytesting" % "fest-assert" % "1.4" % "test",
  "org.fluentlenium" % "fluentlenium-core" % "3.6.1" % "test",
  "org.seleniumhq.selenium" % "selenium-java" % "3.14.0" % "test",
  "org.seleniumhq.selenium" % "selenium-api" % "3.14.0" % "test",
  "org.seleniumhq.selenium" % "selenium-firefox-driver" % "3.14.0" % "test",
  "org.seleniumhq.selenium" % "selenium-support" % "3.14.0" % "test",
  "org.webjars" % "swagger-ui" % "2.2.0" //play-swagger ui integration
)

// add resolver for deadbolt and easymail snapshots
resolvers += Resolver.sonatypeRepo("snapshots")
resolvers += Resolver.jcenterRepo
resolvers += "mvnrepository" at "http://mvnrepository.com/artifact/"

// display deprecated or poorly formed Java
javacOptions ++= Seq("-Xlint:unchecked")
javacOptions ++= Seq("-Xlint:deprecation")
javacOptions ++= Seq("-Xdiags:verbose")

//  Uncomment the next line for local development of the Play Authenticate core:
//lazy val playAuthenticate = project.in(file("modules/play-authenticate")).enablePlugins(PlayJava)

lazy val root = project.in(file("."))
  .enablePlugins(PlayJava, PlayEbean, SwaggerPlugin)
  .settings(
    libraryDependencies ++= appDependencies
  )
/* Uncomment the next lines for local development of the Play Authenticate core: */
//.dependsOn(playAuthenticate)
//.aggregate(playAuthenticate)

swaggerDomainNameSpaces := Seq("models")