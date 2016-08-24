package com.github.nikdon.telepooz.model

import com.github.nikdon.telepooz.helpers.Arbitraries._
import com.github.nikdon.telepooz.raw.{CirceDecoders, CirceEncoders}
import io.circe.syntax._
import org.scalatest.prop.GeneratorDrivenPropertyChecks
import org.scalatest.{FlatSpec, Matchers, OptionValues}


class InlineKeyboardMarkupTest extends FlatSpec
                                       with OptionValues
                                       with Matchers
                                       with GeneratorDrivenPropertyChecks
                                       with CirceEncoders
                                       with CirceDecoders {

  "InlineKeyboardMarkup" should "convert to a json and back to a model" in {
    forAll { inlineKeyboardMarkup: InlineKeyboardMarkup ⇒
      val json = inlineKeyboardMarkup.asJson.noSpaces
      io.circe.parser.decode[InlineKeyboardMarkup](json).toOption.value shouldEqual inlineKeyboardMarkup
    }
  }
}
