package com.scg.studinfo.models

import com.google.firebase.database.Exclude

data class Unity(
    val shortname: String? = null,
    val name: String? = null, val text: String? = null, val users: List<String>? = null,
    val vk: String? = null, val img: String? = null, val imgmain: String? = null,
    val sortword: String? = null, @Exclude val uid: String? = null)