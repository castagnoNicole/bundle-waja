package com.bundle.waja

import android.app.Application
import io.realm.Realm

open class MyApplication : Application(){

    override  fun  onCreate() {
        super.onCreate()
        Realm.init(this)
    }

}