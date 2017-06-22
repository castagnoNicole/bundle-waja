package com.bundle.waja

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.ViewGroup
import butterknife.bindView
import com.bluelinelabs.conductor.Conductor
import com.bluelinelabs.conductor.Router
import com.bluelinelabs.conductor.RouterTransaction
import com.bundle.waja.home.view.AccountsController

class MainActivity : AppCompatActivity() {
    private lateinit var router: Router
    val container : ViewGroup by bindView(R.id.layoutRoot)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        router = Conductor.attachRouter(this, container, savedInstanceState)
        if (!router.hasRootController()){
            router.setRoot(RouterTransaction.with(AccountsController()))
        }
    }
}