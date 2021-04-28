package example

import zio._
import zio.magic._
import zio.console._
import com.bot4s.zmatrix.MatrixConfiguration
import com.bot4s.zmatrix.client.MatrixClient
import com.bot4s.zmatrix.api.{ accounts, roomMembership }
import com.bot4s.zmatrix.services.{ Logger, Authentication }
import sttp.client3.asynchttpclient.zio.AsyncHttpClientZioBackend

object Hello extends zio.App {

  override def run(args: List[String]): URIO[ZEnv, ExitCode] = {
    val getToken = Authentication.refresh *> Authentication.accessToken.flatMap(token => putStrLn(s"Token: \${token.token}"))
    val getInfo = accounts.whoAmI <*> roomMembership.joinedRooms()
    (getToken *> getInfo)
      .tapError(e => putStrLn(e.toString()))
      .flatMap(x => putStrLn(x.toString()))
      .exitCode
    .inject(
      ZEnv.live,
      Logger.live("matrix-zio-main"),
      MatrixConfiguration.live().mapError(x => new Exception(s"Unable to read configuration \$x")).orDie,
      Authentication.live,
      AsyncHttpClientZioBackend.layer().orDie,
      MatrixClient.live
    )
  }
}
