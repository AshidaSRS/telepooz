enablePlugins(AutomateHeaderPlugin)
headerLicense := Some(HeaderLicense.ALv2("2016", "Nikolay Donets"))

lazy val buildSettings = Seq(
  organization := "com.github.nikdon",
  name := "telepooz",
  version := "0.5.6-SNAPSHOT",
  scalaVersion := "2.12.3",
  licenses += ("Apache-2.0", url("http://www.apache.org/licenses/LICENSE-2.0"))
)

lazy val compilerOptions = Seq(
  "-deprecation",
  "-encoding",
  "UTF-8",
  "-feature",
  "-language:existentials",
  "-language:higherKinds",
  "-unchecked",
  "-Xfatal-warnings",
  "-Yno-adapted-args",
  "-Ywarn-dead-code",
  "-Ywarn-numeric-widen",
  "-Xfuture"
)

lazy val baseSettings = Seq(
  scalacOptions ++= compilerOptions ++ Seq(
    "-Ywarn-unused-import"
  ),
  testOptions in Test += Tests.Argument("-oF"),
  scalacOptions in (Compile, console) := compilerOptions,
  scalacOptions in (Compile, test) := compilerOptions,
  resolvers ++= Seq(
    Resolver.sonatypeRepo("releases"),
    Resolver.sonatypeRepo("snapshots")
  ),
  mappings.in(Compile, packageBin) += baseDirectory.in(ThisBuild).value / "LICENSE" -> "LICENSE"
)

buildSettings ++ baseSettings

lazy val akkaHttpV        = "10.0.10"
lazy val akkaHttpJsonV    = "1.18.0"
lazy val catsV            = "0.9.0"
lazy val circeVersion     = "0.8.0"

lazy val scalaTestV  = "3.0.4"
lazy val scalaCheckV = "1.13.5"

libraryDependencies ++= Seq(
  "org.typelevel"     %% "cats"                 % catsV,
  "com.typesafe.akka" %% "akka-http-core"       % akkaHttpV,
  "com.typesafe.akka" %% "akka-http"            % akkaHttpV,
  "com.typesafe.akka" %% "akka-http-testkit"    % akkaHttpV,
  "io.circe"          %% "circe-core"           % circeVersion,
  "io.circe"          %% "circe-generic"        % circeVersion,
  "io.circe"          %% "circe-generic-extras" % circeVersion,
  "io.circe"          %% "circe-parser"         % circeVersion,
  "io.circe"          %% "circe-testing"        % circeVersion,
  "de.heikoseeberger" %% "akka-http-circe"      % akkaHttpJsonV,
  "org.scalatest"     %% "scalatest"            % scalaTestV  % Test,
  "org.scalacheck"    %% "scalacheck"           % scalaCheckV % Test
)
