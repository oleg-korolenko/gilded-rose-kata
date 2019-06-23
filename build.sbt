name := "gilded-rose-kata"
version := "0.1"
scalaVersion := "2.12.8"
organization := "com.gildedrose"
scalafmtOnCompile := true
scalacOptions ++= commonScalacOptions
fork in Test := true
parallelExecution in Test := true
testOptions in Test += Tests.Argument(TestFrameworks.ScalaTest,"-oDF")
libraryDependencies ++= Seq(D.scalaTest % "test")

///////////////////////////////////////////////////////////////////////////////////////////////////
// Compiler settings
///////////////////////////////////////////////////////////////////////////////////////////////////
lazy val commonScalacOptions = Seq(
  "-deprecation",
  "-encoding",
  "UTF-8",
  "-feature",
  "-language:existentials",
  "-language:higherKinds",
  "-language:implicitConversions",
  "-unchecked",
  "-Xfatal-warnings",
  "-Xlint",
  "-Ywarn-dead-code",
  "-Ywarn-value-discard",
  "-Ywarn-unused-import",
  "-Ywarn-inaccessible"
)



///////////////////////////////////////////////////////////////////////////////////////////////////
// Dependencies
///////////////////////////////////////////////////////////////////////////////////////////////////
lazy val D = new {
  val Versions = new {
    val scalaTest = "3.0.7"
  }

  // Test
  val scalaTest = "org.scalatest" %% "scalatest" % Versions.scalaTest
}




