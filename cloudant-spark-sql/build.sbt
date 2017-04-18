organization  := "com.cloudant.spark"

name := "spark-sql"

version       := "0.1-SNAPSHOT"

scalaVersion  := "2.11.6"

fork in run := true

resolvers ++= Seq(
  "spray repo" at "http://repo.spray.io/",
  "typesafe repo" at "http://repo.typesafe.com/typesafe/releases/"
)

libraryDependencies ++= {
  val sparkV =  "2.1.0"
  val sprayV = "1.3.4"
  val playJsonV = "2.5.14"
  val akkaV = "2.3.9"
  Seq(
    "org.apache.spark"    %%  "spark-core"	  %  sparkV % "provided",
    "org.apache.spark"    %%  "spark-sql"	  %  sparkV % "provided",
    "io.spray"            %%  "spray-client"  %  sprayV,
    "io.spray"            %%  "spray-can"     %  sprayV,
    "com.typesafe.play"   %%  "play-json"     %  playJsonV,
    "com.typesafe.akka"   %%  "akka-actor"    % akkaV
  )
}

assemblyOption in assembly := (assemblyOption in assembly).value.copy(includeScala = false)

assemblyMergeStrategy in assembly := {
  case PathList("scala", xs @ _*) => MergeStrategy.discard
  case x =>
    val oldStrategy = (assemblyMergeStrategy in assembly).value
    oldStrategy(x)
}

assemblyJarName in assembly := "cloudant-spark-2.1.jar"
