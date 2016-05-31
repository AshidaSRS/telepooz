package com.github.nikdon.telepooz.raw

import com.github.nikdon.telepooz.model.{Message, Response, Update, User}
import io.circe.Json


sealed trait RawRequest[Result] extends Product with Serializable {
  def name: String = this.productPrefix
  def payload: Json
}

object RawRequest {

  def apply[A](implicit ev: RawRequest[A]): RawRequest[A] = ev

  case object GetMe extends RawRequest[Response[User]] {override val payload = Json.Null}
  case class SendMessage(payload: Json) extends RawRequest[Response[Message]]
  case class ForwardMessage(payload: Json) extends RawRequest[Response[Message]]
  case class GetUpdates(payload: Json) extends RawRequest[Response[Vector[Update]]]

}