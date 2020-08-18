package com.scg.studinfo.models

import com.google.firebase.database.Exclude
import com.google.firebase.database.ServerValue
import java.sql.Date

data class FeedPost(
    val uid: String? = null, val title: String? = null, val text: String? = null,
    val image: String? = null, val domColor: Int? = null, val img: String? = null,
    val startTime: Long? = null,
    val timestamp: Any? = ServerValue.TIMESTAMP, var isDelete: Boolean = false,
    val user: String? = null, val kategories: List<Boolean>? = null,
    @Exclude val uidNews: String? = null) {
    fun timestampDate(): Date = Date(timestamp as Long)
}