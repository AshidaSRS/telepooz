package com.github.nikdon.telepooz.model.methods

import com.github.nikdon.telepooz.helpers.Arbitraries._
import com.github.nikdon.telepooz.raw.CirceEncoders
import io.circe.Json
import io.circe.syntax._
import org.scalatest.prop.GeneratorDrivenPropertyChecks
import org.scalatest.{FlatSpec, Matchers}


class GetChatAdministratorsTest extends FlatSpec
                                        with Matchers
                                        with GeneratorDrivenPropertyChecks
                                        with CirceEncoders {

  "GetChatAdministrators" should "convert to json" in {
    forAll { getChatAdministrators: GetChatAdministrators[Long] ⇒
      getChatAdministrators.asJson should not be Json.Null
    }
  }
}
