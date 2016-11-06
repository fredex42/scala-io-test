import _root_.sbt.Keys._

name := "processtest"

version := "1.0"

scalaVersion := "2.12.0"

libraryDependencies += "org.apache.logging.log4j" % "log4j-core" % "2.7"

libraryDependencies += "org.apache.logging.log4j" % "log4j-api" % "2.7"

libraryDependencies += "com.fasterxml.jackson.dataformat" % "jackson-dataformat-yaml" % "2.8.2"

libraryDependencies += "com.fasterxml.jackson.core" % "jackson-databind" % "2.8.2"

libraryDependencies += "com.fasterxml.jackson.module" % "jackson-module-scala_2.11" % "2.8.2"