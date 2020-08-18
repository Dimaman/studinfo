package com.scg.studinfo.models

import com.google.firebase.database.Exclude

data class User(val email: String = "", val name: String = "", val group: String = "",
                var roles: String? = null, val photo: String? = null,
                val unity: List<String>? = null, @Exclude val uid: String? = null)
