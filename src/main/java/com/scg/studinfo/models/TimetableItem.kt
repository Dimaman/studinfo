package com.scg.studinfo.models

import com.google.firebase.database.Exclude

data class TimetableItem(val item: String? = null, val cabinet: String? = null,
                         val teacher: String? = null, @Exclude val para: String? = null)