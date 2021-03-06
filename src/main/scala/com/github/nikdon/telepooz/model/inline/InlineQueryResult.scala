/*
 * Copyright 2016 Nikolay Donets
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.github.nikdon.telepooz.model.inline

import com.github.nikdon.telepooz.model.InlineKeyboardMarkup

/** This object represents one result of an inline query */
sealed trait InlineQueryResult extends Product with Serializable

/**
  * Represents a link to an article or web page.
  *
  * @param id                     Unique identifier for this result, 1-64 Bytes
  * @param title                  Title of the result
  * @param input_message_content  Content of the message to be sent
  * @param reply_markup           Inline keyboard attached to the message
  * @param url                    URL of the result
  * @param hide_url               Pass True, if you don't want the URL to be shown in the message
  * @param description            Short description of the result
  * @param thumb_url              Url of the thumbnail for the result
  * @param thumb_width            Thumbnail width
  * @param thumb_height           Thumbnail height
  */
case class InlineQueryResultArticle(id: String,
                                    title: String,
                                    input_message_content: InputMessageContent,
                                    reply_markup: Option[InlineKeyboardMarkup] = None,
                                    url: Option[String] = None,
                                    hide_url: Option[Boolean] = None,
                                    description: Option[String] = None,
                                    thumb_url: Option[String] = None,
                                    thumb_width: Option[Int] = None,
                                    thumb_height: Option[Int] = None)
    extends InlineQueryResult
object InlineQueryResultArticle {
  final val `type` = Map("type" → "article")
}

/**
  * Represents a link to a photo. By default, this photo will be sent by the user with optional caption. Alternatively,
  * you can use input_message_content to send a message with the specified content instead of the photo.
  *
  * @param id                     Unique identifier for this result, 1-64 bytes
  * @param photo_url              A valid URL of the photo. Photo must be in jpeg format. Photo size must not exceed 5MB
  * @param thumb_url              URL of the thumbnail for the photo
  * @param photo_width            Width of the photo
  * @param photo_height           Height of the photo
  * @param title                  Title for the result
  * @param description            Short description of the result
  * @param caption                Caption of the photo to be sent, 0-200 characters
  * @param reply_markup           Inline keyboard attached to the message
  * @param input_message_content  Content of the message to be sent instead of the photo
  */
case class InlineQueryResultPhoto(id: String,
                                  photo_url: String,
                                  thumb_url: String,
                                  photo_width: Option[Int] = None,
                                  photo_height: Option[Int] = None,
                                  title: Option[String] = None,
                                  description: Option[String] = None,
                                  caption: Option[String] = None,
                                  reply_markup: Option[InlineKeyboardMarkup] = None,
                                  input_message_content: Option[InputMessageContent] = None)
    extends InlineQueryResult
object InlineQueryResultPhoto {
  final val `type` = Map("type" → "photo")
}

/**
  * Represents a link to an animated GIF file. By default, this animated GIF file will be sent by the user with optional
  * caption. Alternatively, you can use input_message_content to send a message with the specified content instead of
  * the animation.
  *
  * @param id                     Unique identifier for this result, 1-64 bytes
  * @param gif_url                A valid URL for the GIF file. File size must not exceed 1MB
  * @param gif_width              Width of the GIF
  * @param gif_height             Height of the GIF
  * @param gif_duration           Duration of the GIF
  * @param thumb_url              URL of the static thumbnail for the result (jpeg or gif)
  * @param title                  Title for the result
  * @param caption                Caption of the GIF file to be sent, 0-200 characters
  * @param reply_markup           Inline keyboard attached to the message
  * @param input_message_content  Content of the message to be sent instead of the GIF animation
  */
case class InlineQueryResultGif(id: String,
                                gif_url: String,
                                gif_width: Option[Int] = None,
                                gif_height: Option[Int] = None,
                                gif_duration: Option[Int],
                                thumb_url: String,
                                title: Option[String] = None,
                                caption: Option[String] = None,
                                reply_markup: Option[InlineKeyboardMarkup] = None,
                                input_message_content: Option[InputMessageContent] = None)
    extends InlineQueryResult
object InlineQueryResultGif {
  final val `type` = Map("type" → "gif")
}

/**
  * Represents a link to a video animation (H.264/MPEG-4 AVC video without sound). By default, this animated MPEG-4 file
  * will be sent by the user with optional caption. Alternatively, you can use input_message_content to send a message
  * with the specified content instead of the animation.
  *
  * @param id                     Unique identifier for this result, 1-64 bytes
  * @param mpeg4_url              A valid URL for the MP4 file. File size must not exceed 1MB
  * @param mpeg4_width            Video width
  * @param mpeg4_height           Video height
  * @param mpeg4_duration         Video duration
  * @param thumb_url              URL of the static thumbnail (jpeg or gif) for the result
  * @param title                  Title for the result
  * @param caption                Caption of the MPEG-4 file to be sent, 0-200 characters
  * @param reply_markup           Inline keyboard attached to the message
  * @param input_message_content  Content of the message to be sent instead of the video animation
  */
case class InlineQueryResultMpeg4Gif(id: String,
                                     mpeg4_url: String,
                                     mpeg4_width: Option[Int] = None,
                                     mpeg4_height: Option[Int] = None,
                                     mpeg4_duration: Option[Int],
                                     thumb_url: String,
                                     title: Option[String] = None,
                                     caption: Option[String] = None,
                                     reply_markup: Option[InlineKeyboardMarkup] = None,
                                     input_message_content: Option[InputMessageContent] = None)
    extends InlineQueryResult
object InlineQueryResultMpeg4Gif {
  final val `type` = Map("type" → "mpeg4_gif")
}

/**
  * Represents a link to a page containing an embedded video player or a video file. By default, this video file will be
  * sent by the user with an optional caption. Alternatively, you can use input_message_content to send a message with
  * the specified content instead of the video.
  *
  * @param id                     Unique identifier for this result, 1-64 bytes
  * @param video_url              A valid URL for the embedded video player or video file
  * @param mime_type              Mime type of the content of video url, “text/html” or “video/mp4”
  * @param thumb_url              URL of the thumbnail (jpeg only) for the video
  * @param title                  Title for the result
  * @param caption                Caption of the video to be sent, 0-200 characters
  * @param video_width            Video width
  * @param video_height           Video height
  * @param video_duration         Video duration in seconds
  * @param description            Short description of the result
  * @param reply_markup           Inline keyboard attached to the message
  * @param input_message_content  Content of the message to be sent instead of the video
  */
case class InlineQueryResultVideo(id: String,
                                  video_url: String,
                                  mime_type: String,
                                  thumb_url: String,
                                  title: String,
                                  caption: Option[String] = None,
                                  video_width: Option[Int] = None,
                                  video_height: Option[Int] = None,
                                  video_duration: Option[Int] = None,
                                  description: Option[String] = None,
                                  reply_markup: Option[InlineKeyboardMarkup] = None,
                                  input_message_content: Option[InputMessageContent] = None)
    extends InlineQueryResult
object InlineQueryResultVideo {
  final val `type` = Map("type" → "video")
}

/**
  * Represents a link to an mp3 audio file. By default, this audio file will be sent by the user. Alternatively, you can
  * use input_message_content to send a message with the specified content instead of the audio.
  *
  * @param id                     Unique identifier for this result, 1-64 bytes
  * @param audio_url              A valid URL for the audio file
  * @param title                  Title
  * @param performer              Performer
  * @param audio_duration         Audio duration in seconds
  * @param reply_markup           Inline keyboard attached to the message
  * @param input_message_content  Content of the message to be sent instead of the audio
  */
case class InlineQueryResultAudio(id: String,
                                  audio_url: String,
                                  title: String,
                                  caption: Option[String] = None,
                                  performer: Option[String] = None,
                                  audio_duration: Option[Int] = None,
                                  reply_markup: Option[InlineKeyboardMarkup] = None,
                                  input_message_content: Option[InputMessageContent] = None)
    extends InlineQueryResult
object InlineQueryResultAudio {
  final val `type` = Map("type" → "audio")
}

/**
  * Represents a link to a voice recording in an .ogg container encoded with OPUS. By default, this voice recording will
  * be sent by the user. Alternatively, you can use input_message_content to send a message with the specified content
  * instead of the the voice message.
  *
  * @param id                     Unique identifier for this result, 1-64 bytes
  * @param voice_url              A valid URL for the voice recording
  * @param title                  Recording title
  * @param voice_duration         Recording duration in seconds
  * @param reply_markup           Inline keyboard attached to the message
  * @param input_message_content  Content of the message to be sent instead of the voice recording
  */
case class InlineQueryResultVoice(id: String,
                                  voice_url: String,
                                  title: String,
                                  caption: Option[String] = None,
                                  voice_duration: Option[Int] = None,
                                  reply_markup: Option[InlineKeyboardMarkup] = None,
                                  input_message_content: Option[InputMessageContent] = None)
    extends InlineQueryResult
object InlineQueryResultVoice {
  final val `type` = Map("type" → "voice")
}

/**
  * Represents a link to a file. By default, this file will be sent by the user with an optional caption. Alternatively,
  * you can use input_message_content to send a message with the specified content instead of the file. Currently, only
  * .PDF and .ZIP files can be sent using this method.
  *
  * @param id                     Unique identifier for this result, 1-64 bytes
  * @param title                  Title for the result
  * @param caption                Caption of the document to be sent, 0-200 characters
  * @param document_url           A valid URL for the file
  * @param mime_type              Mime type of the content of the file, either “application/pdf” or “application/zip”
  * @param description            Short description of the result
  * @param thumb_url              URL of the thumbnail (jpeg only) for the file
  * @param thumb_width            Thumbnail width
  * @param thumb_height           Thumbnail height
  * @param reply_markup           Inline keyboard attached to the message
  * @param input_message_content  Content of the message to be sent instead of the file
  */
case class InlineQueryResultDocument(id: String,
                                     title: String,
                                     caption: Option[String] = None,
                                     document_url: String,
                                     mime_type: String,
                                     description: Option[String] = None,
                                     thumb_url: Option[String] = None,
                                     thumb_width: Option[Int] = None,
                                     thumb_height: Option[Int] = None,
                                     reply_markup: Option[InlineKeyboardMarkup] = None,
                                     input_message_content: Option[InputMessageContent] = None)
    extends InlineQueryResult
object InlineQueryResultDocument {
  final val `type` = Map("type" → "document")
}

/**
  * Represents a location on a map. By default, the location will be sent by the user. Alternatively, you can use
  * input_message_content to send a message with the specified content instead of the location.
  *
  * @param id                     Unique identifier for this result, 1-64 Bytes
  * @param title                  Location title
  * @param latitude               Location latitude in degrees
  * @param longitude              Location longitude in degrees
  * @param thumb_url              URL of the thumbnail (jpeg only) for the file
  * @param thumb_width            Thumbnail width
  * @param thumb_height           Thumbnail height
  * @param reply_markup           Inline keyboard attached to the message
  * @param input_message_content  Content of the message to be sent instead of the file
  */
case class InlineQueryResultLocation(id: String,
                                     title: String,
                                     latitude: Double,
                                     longitude: Double,
                                     thumb_url: Option[String] = None,
                                     thumb_width: Option[Int] = None,
                                     thumb_height: Option[Int] = None,
                                     reply_markup: Option[InlineKeyboardMarkup] = None,
                                     input_message_content: Option[InputMessageContent] = None)
    extends InlineQueryResult
object InlineQueryResultLocation {
  final val `type` = Map("type" → "location")
}

/**
  * Represents a venue. By default, the venue will be sent by the user. Alternatively, you can use input_message_content
  * to send a message with the specified content instead of the venue.
  *
  * @param id                     Unique identifier for this result, 1-64 Bytes
  * @param title                  Title of the venue
  * @param latitude               Latitude of the venue location in degrees
  * @param longitude              Longitude of the venue location in degrees
  * @param address                Address of the venue
  * @param foursquare_id          Foursquare identifier of the venue if known
  * @param thumb_url              URL of the thumbnail (jpeg only) for the file
  * @param thumb_width            Thumbnail width
  * @param thumb_height           Thumbnail height
  * @param reply_markup           Inline keyboard attached to the message
  * @param input_message_content  Content of the message to be sent instead of the file
  */
case class InlineQueryResultVenue(id: String,
                                  title: String,
                                  latitude: Double,
                                  longitude: Double,
                                  address: String,
                                  foursquare_id: Option[String] = None,
                                  thumb_url: Option[String] = None,
                                  thumb_width: Option[Int] = None,
                                  thumb_height: Option[Int] = None,
                                  reply_markup: Option[InlineKeyboardMarkup] = None,
                                  input_message_content: Option[InputMessageContent] = None)
    extends InlineQueryResult
object InlineQueryResultVenue {
  final val `type` = Map("type" → "venue")
}

/**
  * Represents a contact with a phone number. By default, this contact will be sent by the user. Alternatively, you can
  * use input_message_content to send a message with the specified content instead of the contact.
  *
  * @param `type`                 Type of the result, must be contact
  * @param id                     Unique identifier for this result, 1-64 Bytes
  * @param phone_number           Contact's phone number
  * @param first_name             Contact's first name
  * @param last_name              Contact's last name
  * @param thumb_url              URL of the thumbnail (jpeg only) for the file
  * @param thumb_width            Thumbnail width
  * @param thumb_height           Thumbnail height
  * @param reply_markup           Inline keyboard attached to the message
  * @param input_message_content  Content of the message to be sent instead of the file
  */
case class InlineQueryResultContact(id: String,
                                    phone_number: String,
                                    first_name: String,
                                    last_name: Option[String] = None,
                                    thumb_url: Option[String] = None,
                                    thumb_width: Option[Int] = None,
                                    thumb_height: Option[Int] = None,
                                    reply_markup: Option[InlineKeyboardMarkup] = None,
                                    input_message_content: Option[InputMessageContent] = None)
    extends InlineQueryResult
object InlineQueryResultContact {
  final val `type` = Map("type" → "contact")
}

/**
  * Represents a link to a photo stored on the Telegram servers. By default, this photo will be sent by the user with an
  * optional caption. Alternatively, you can use input_message_content to send a message with the specified content
  * instead of the photo.
  *
  * @param id                     Unique identifier for this result, 1-64 bytes
  * @param photo_file_id          A valid file identifier of the photo
  * @param title                  Title for the result
  * @param description            Short description of the result
  * @param caption                Caption of the photo to be sent, 0-200 characters
  * @param reply_markup           Inline keyboard attached to the message
  * @param input_message_content  Content of the message to be sent instead of the photo
  */
case class InlineQueryResultCachedPhoto(id: String,
                                        photo_file_id: String,
                                        title: Option[String] = None,
                                        description: Option[String] = None,
                                        caption: Option[String] = None,
                                        reply_markup: Option[InlineKeyboardMarkup] = None,
                                        input_message_content: Option[InputMessageContent] = None)
    extends InlineQueryResult
object InlineQueryResultCachedPhoto {
  final val `type` = Map("type" → "photo")
}

/**
  * Represents a link to an animated GIF file stored on the Telegram servers. By default, this animated GIF file will be
  * sent by the user with an optional caption. Alternatively, you can use input_message_content to send a message with
  * specified content instead of the animation.
  *
  * @param id                     Unique identifier for this result, 1-64 bytes
  * @param gif_file_id            A valid file identifier for the GIF file
  * @param title                  Title for the result
  * @param caption                Caption of the GIF file to be sent, 0-200 characters
  * @param reply_markup           An Inline keyboard attached to the message
  * @param input_message_content  Content of the message to be sent instead of the GIF animation
  */
case class InlineQueryResultCachedGif(id: String,
                                      gif_file_id: String,
                                      title: Option[String] = None,
                                      caption: Option[String] = None,
                                      reply_markup: Option[InlineKeyboardMarkup] = None,
                                      input_message_content: Option[InputMessageContent] = None)
    extends InlineQueryResult
object InlineQueryResultCachedGif {
  final val `type` = Map("type" → "gif")
}

/**
  * Represents a link to a video animation (H.264/MPEG-4 AVC video without sound) stored on the Telegram servers. By
  * default, this animated MPEG-4 file will be sent by the user with an optional caption. Alternatively, you can use
  * input_message_content to send a message with the specified content instead of the animation.
  *
  * @param id                     Unique identifier for this result, 1-64 bytes
  * @param mpeg4_file_id          A valid file identifier for the MP4 file
  * @param title                  Title for the result
  * @param caption                Caption of the MPEG-4 file to be sent, 0-200 characters
  * @param reply_markup           An Inline keyboard attached to the message
  * @param input_message_content  Content of the message to be sent instead of the video animation
  */
case class InlineQueryResultCachedMpeg4Gif(id: String,
                                           mpeg4_file_id: String,
                                           title: Option[String] = None,
                                           caption: Option[String] = None,
                                           reply_markup: Option[InlineKeyboardMarkup] = None,
                                           input_message_content: Option[InputMessageContent] = None)
    extends InlineQueryResult
object InlineQueryResultCachedMpeg4Gif {
  final val `type` = Map("type" → "mpeg4_gif")
}

/**
  * Represents a link to a sticker stored on the Telegram servers. By default, this sticker will be sent by the user.
  * Alternatively, you can use input_message_content to send a message with the specified content instead of the sticker.
  *
  * @param id                     Unique identifier for this result, 1-64 bytes
  * @param sticker_file_id        A valid file identifier of the sticker
  * @param reply_markup           An Inline keyboard attached to the message
  * @param input_message_content  Content of the message to be sent instead of the sticker
  */
case class InlineQueryResultCachedSticker(id: String,
                                          sticker_file_id: String,
                                          reply_markup: Option[InlineKeyboardMarkup] = None,
                                          input_message_content: Option[InputMessageContent] = None)
    extends InlineQueryResult
object InlineQueryResultCachedSticker {
  final val `type` = Map("type" → "sticker")
}

/**
  * Represents a link to a file stored on the Telegram servers. By default, this file will be sent by the user with an
  * optional caption. Alternatively, you can use input_message_content to send a message with the specified content
  * instead of the file. Currently, only pdf-files and zip archives can be sent using this method.
  *
  * @param id                     Title for the result
  * @param title                  A valid file identifier for the file
  * @param document_file_id       Short description of the result
  * @param description            Caption of the document to be sent, 0-200 characters
  * @param caption                An Inline keyboard attached to the message
  * @param input_message_content  Content of the message to be sent instead of the file
  */
case class InlineQueryResultCachedDocument(id: String,
                                           title: String,
                                           document_file_id: String,
                                           description: Option[String] = None,
                                           caption: Option[String] = None,
                                           input_message_content: Option[InputMessageContent] = None)
    extends InlineQueryResult
object InlineQueryResultCachedDocument {
  final val `type` = Map("type" → "document")
}

/**
  * Represents a link to a video file stored on the Telegram servers. By default, this video file will be sent by the
  * user with an optional caption. Alternatively, you can use input_message_content to send a message with the specified
  * content instead of the video.
  *
  * @param id                     Unique identifier for this result, 1-64 bytes
  * @param video_file_id          A valid file identifier for the video file
  * @param title                  Title for the result
  * @param description            Short description of the result
  * @param caption                Caption of the video to be sent, 0-200 characters
  * @param reply_markup           An Inline keyboard attached to the message
  * @param input_message_content  Content of the message to be sent instead of the video
  */
case class InlineQueryResultCachedVideo(id: String,
                                        video_file_id: String,
                                        title: String,
                                        description: Option[String] = None,
                                        caption: Option[String] = None,
                                        reply_markup: Option[InlineKeyboardMarkup] = None,
                                        input_message_content: Option[InputMessageContent] = None)
    extends InlineQueryResult
object InlineQueryResultCachedVideo {
  final val `type` = Map("type" → "video")
}

/**
  * Represents a link to a voice message stored on the Telegram servers. By default, this voice message will be sent by
  * the user. Alternatively, you can use input_message_content to send a message with the specified content instead of
  * the voice message.
  *
  * @param id                     Unique identifier for this result, 1-64 bytes
  * @param voice_file_id          A valid file identifier for the voice message
  * @param title                  Voice message title
  * @param caption                Audio caption, 0-200 characters
  * @param reply_markup           An Inline keyboard attached to the message
  * @param input_message_content  Content of the message to be sent instead of the voice message
  */
case class InlineQueryResultCachedVoice(id: String,
                                        voice_file_id: String,
                                        title: String,
                                        caption: Option[String] = None,
                                        reply_markup: Option[InlineKeyboardMarkup] = None,
                                        input_message_content: Option[InputMessageContent] = None)
    extends InlineQueryResult
object InlineQueryResultCachedVoice {
  final val `type` = Map("type" → "voice")
}

/**
  * Represents a link to an mp3 audio file stored on the Telegram servers. By default, this audio file will be sent by
  * the user. Alternatively, you can use input_message_content to send a message with the specified content instead of
  * the audio.
  *
  * @param id                     Unique identifier for this result, 1-64 bytes
  * @param audio_file_id          A valid file identifier for the audio file
  * @param reply_markup           An Inline keyboard attached to the message
  * @param input_message_content  Content of the message to be sent instead of the audio
  */
case class InlineQueryResultCachedAudio(id: String,
                                        audio_file_id: String,
                                        caption: Option[String] = None,
                                        reply_markup: Option[InlineKeyboardMarkup] = None,
                                        input_message_content: Option[InputMessageContent] = None)
    extends InlineQueryResult
object InlineQueryResultCachedAudio {
  final val `type` = Map("type" → "audio")
}

case class InlineQueryResultGame(id: String,
                                 game_short_name: String,
                                 reply_markup: Option[InlineKeyboardMarkup] = None)
    extends InlineQueryResult
object InlineQueryResultGame {
  final val `type` = Map("type" → "game")
}
