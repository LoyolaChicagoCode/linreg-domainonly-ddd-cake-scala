name := "linreg-domainonly-ddd-cake-scala"

version := "1.0"

scalaVersion := "2.9.1"

scalacOptions += "-deprecation"

libraryDependencies ++= Seq(
  "junit" % "junit" % "4.7",
  "org.specs2" %% "specs2" % "1.11",
  "org.mockito" % "mockito-all" % "1.9.0",
  "org.hamcrest" % "hamcrest-all" % "1.1"
)

resolvers ++= Seq("snapshots" at "http://oss.sonatype.org/content/repositories/snapshots",
                  "releases"  at "http://oss.sonatype.org/content/repositories/releases")