package com.github.nikdon.model


import com.github.nikdon.ToDTO.syntax._
import com.github.nikdon.tags.FileId
import com.github.nikdon.{ToDTO, dto, model}
import shapeless.tag.@@
import java.time.Duration


case class Video(fileId: String @@ FileId,
                 width: Int,
                 height: Int,
                 duration: Duration,
                 thumb: Option[model.PhotoSize],
                 mimeType: Option[String],
                 fileSize: Option[Int])

object Video {
  implicit val toDTO: ToDTO[Video, dto.Video] =
    ToDTO(v ⇒ dto.Video(v.fileId, v.width, v.height, v.duration.getSeconds.toInt, v.thumb.map(_.toDTO), v.mimeType, v.fileSize))
}