name := "linreg-domainonly-ddd-cake-scala"

version := "1.0"

scalaVersion := "2.9.1"

scalacOptions += "-deprecation"

libraryDependencies ++= Seq(
  "junit" % "junit" % "4.7",
  "org.specs2" %% "specs2" % "1.8.2" % "test"
)

resolvers ++= Seq("snapshots" at "http://oss.sonatype.org/content/repositories/snapshots",
                  "releases"  at "http://oss.sonatype.org/content/repositories/releases")