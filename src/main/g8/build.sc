import mill._, scalalib._
import coursier.MavenRepository

object $moduleName$ extends ScalaModule {
  def scalaVersion = "$scala_version$"

  def ivyDeps = Agg(
    ivy"com.bot4s::zmatrix:0.1.0",
    ivy"dev.zio::zio:1.0.7"
  )
}
