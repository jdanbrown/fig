class Fig(info: sbt.ProjectInfo) extends sbt.DefaultProject(info) with posterous.Publish with rsync.RsyncPublishing {
  /**
   * Publish the source as well as the class files.
   */
  override def packageSrcJar= defaultJarPath("-sources.jar")
  val sourceArtifact = sbt.Artifact(artifactID, "src", "jar", Some("sources"), Nil, None)
  override def packageToPublishActions = super.packageToPublishActions ++ Seq(packageSrc)

  /**
   * Publish via rsync.
   */
  def rsyncRepo = "codahale.com:/home/codahale/repo.codahale.com"
  
  /**
   * Dependencies
   */
  val liftJson = "net.liftweb" %% "lift-json" % "2.1" withSources() intransitive()
  val paranamer = "com.thoughtworks.paranamer" % "paranamer" % "2.0" withSources() intransitive()
  val scalaTest = "org.scalatest" % "scalatest" % "1.2" % "test" withSources() intransitive()
}
