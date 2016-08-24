package com.github.nikdon.telepooz.model

import com.github.nikdon.telepooz.helpers.Arbitraries._
import com.github.nikdon.telepooz.raw.{CirceDecoders, CirceEncoders}
import io.circe.syntax._
import org.scalatest.prop.GeneratorDrivenPropertyChecks
import org.scalatest.{FlatSpec, Matchers, OptionValues}


class ForceReplyTest extends FlatSpec
                             with OptionValues
                             with Matchers
                             with GeneratorDrivenPropertyChecks
                             with CirceEncoders
                             with CirceDecoders {

  "ForceReply" should "convert to a json and back to a model" in {
    forAll { forceReply: ForceReply ⇒
      val json = forceReply.asJson.noSpaces
      io.circe.parser.decode[ForceReply](json).toOption.value shouldEqual forceReply
    }
  }
}
