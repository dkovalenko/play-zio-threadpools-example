package controllers

import javax.inject._
import play.api._
import play.api.mvc._
import zio._
import scala.concurrent.Future

@Singleton
class HomeController @Inject()(cc: ControllerComponents) extends AbstractController(cc) {

  def async() = Action.async {
    Future.successful(Ok("Running future on " + Thread.currentThread().getName()))
  }
  
  def asyncZIO() = Action.async {
    val zioLogic = for {
      res <- IO(Ok("Running zio on " + Thread.currentThread().getName()))
    } yield res
    Runtime.default.unsafeRunToFuture(zioLogic)
  }
  
  def asyncZIOProper() = Action.async {
    val zioLogic = for {
      res <- IO(Ok("Running zio on " + Thread.currentThread().getName()))
    } yield res
    Runtime.default.unsafeRunToFuture(ZIO.yieldNow *> zioLogic)
  }
  
}
