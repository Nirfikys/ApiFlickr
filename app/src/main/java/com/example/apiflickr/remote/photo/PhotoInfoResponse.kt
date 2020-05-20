package com.example.apiflickr.remote.photo

import com.example.apiflickr.remote.core.BaseResponse
import com.google.gson.annotations.SerializedName


data class PhotoInfoResponse(
    @SerializedName("photo")
    val photo: PhotoInfo
) : BaseResponse()

data class PhotoInfo(
    @SerializedName("comments")
    val comments: Comments,
    @SerializedName("dates")
    val dates: Dates,
    @SerializedName("dateuploaded")
    val dateuploaded: String,
    @SerializedName("description")
    val description: Description,
    @SerializedName("editability")
    val editability: Editability,
    @SerializedName("farm")
    val farm: Int,
    @SerializedName("id")
    val id: String,
    @SerializedName("isfavorite")
    val isfavorite: Int,
    @SerializedName("license")
    val license: Int,
    @SerializedName("media")
    val media: String,
    @SerializedName("notes")
    val notes: Notes,
    @SerializedName("originalformat")
    val originalformat: String,
    @SerializedName("originalsecret")
    val originalsecret: String,
    @SerializedName("owner")
    val owner: Owner,
    @SerializedName("people")
    val people: People,
    @SerializedName("publiceditability")
    val publiceditability: Publiceditability,
    @SerializedName("rotation")
    val rotation: Int,
    @SerializedName("safety_level")
    val safetyLevel: Int,
    @SerializedName("secret")
    val secret: String,
    @SerializedName("server")
    val server: String,
    @SerializedName("tags")
    val tags: Tags,
    @SerializedName("title")
    val title: Title,
    @SerializedName("urls")
    val urls: Urls,
    @SerializedName("usage")
    val usage: Usage,
    @SerializedName("views")
    val views: Int,
    @SerializedName("visibility")
    val visibility: Visibility
)

data class Comments(
    @SerializedName("_content")
    val content: Int
)

data class Dates(
    @SerializedName("lastupdate")
    val lastupdate: String,
    @SerializedName("posted")
    val posted: String,
    @SerializedName("taken")
    val taken: String,
    @SerializedName("takengranularity")
    val takengranularity: Int,
    @SerializedName("takenunknown")
    val takenunknown: Int
)

data class Description(
    @SerializedName("_content")
    val content: String
)

data class Editability(
    @SerializedName("canaddmeta")
    val canaddmeta: Int,
    @SerializedName("cancomment")
    val cancomment: Int
)

data class Notes(
    @SerializedName("note")
    val note: List<Any>
)

data class Owner(
    @SerializedName("iconfarm")
    val iconfarm: Int,
    @SerializedName("iconserver")
    val iconserver: String,
    @SerializedName("location")
    val location: String,
    @SerializedName("nsid")
    val nsid: String,
    @SerializedName("path_alias")
    val pathAlias: String,
    @SerializedName("realname")
    val realname: String,
    @SerializedName("username")
    val username: String
)

data class People(
    @SerializedName("haspeople")
    val haspeople: Int
)

data class Publiceditability(
    @SerializedName("canaddmeta")
    val canaddmeta: Int,
    @SerializedName("cancomment")
    val cancomment: Int
)

data class Tags(
    @SerializedName("tag")
    val tag: List<Tag>
)

data class Title(
    @SerializedName("_content")
    val content: String
)

data class Urls(
    @SerializedName("url")
    val url: List<Url>
)

data class Usage(
    @SerializedName("canblog")
    val canblog: Int,
    @SerializedName("candownload")
    val candownload: Int,
    @SerializedName("canprint")
    val canprint: Int,
    @SerializedName("canshare")
    val canshare: Int
)

data class Visibility(
    @SerializedName("isfamily")
    val isfamily: Int,
    @SerializedName("isfriend")
    val isfriend: Int,
    @SerializedName("ispublic")
    val ispublic: Int
)

data class Tag(
    @SerializedName("author")
    val author: String,
    @SerializedName("authorname")
    val authorname: String,
    @SerializedName("_content")
    val content: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("machine_tag")
    val machineTag: Int,
    @SerializedName("raw")
    val raw: String
)

data class Url(
    @SerializedName("_content")
    val content: String,
    @SerializedName("type")
    val type: String
)