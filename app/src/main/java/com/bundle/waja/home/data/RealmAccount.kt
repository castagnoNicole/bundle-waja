package com.bundle.waja.home.data

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class RealmAccount(var email: String = "@", accountType: String = "", password: String? = null, image: Int? = null ): RealmObject()
