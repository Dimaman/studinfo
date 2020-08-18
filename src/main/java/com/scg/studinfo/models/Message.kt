package com.scg.studinfo.models

import com.google.firebase.database.ServerValue
import java.sql.Date

data class Message(val text: String? = null, val user: String? = null,
                   val type: Int? = null,
                   val timestamp: Any? = ServerValue.TIMESTAMP) {
    fun timestampDate(): Date = Date(timestamp as Long)
}