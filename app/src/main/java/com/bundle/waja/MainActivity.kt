package com.bundle.waja

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.ViewGroup
import butterknife.bindView
import com.bluelinelabs.conductor.Conductor
import com.bluelinelabs.conductor.Router
import com.bluelinelabs.conductor.RouterTransaction
import com.bundle.waja.home.data.RealmAccount
import com.bundle.waja.home.view.AccountsController
import io.realm.Realm

class MainActivity : AppCompatActivity() {
    private lateinit var router: Router
    val container: ViewGroup by bindView(R.id.layoutRoot)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       /* val realm: Realm = Realm.getDefaultInstance()
        realm.beginTransaction()
        realm.deleteAll()
        realm.createObject(RealmAccount::class.java)

       /* realm.createObject(RealmAccount::class.java, "email@ggg.it")
        realm.createObject(RealmAccount::class.java, "email@kkk.it")
        realm.createObject(RealmAccount::class.java, "email@lll.it")
        realm.createObject(RealmAccount::class.java, "email@uuu.it")
        realm.createObject(RealmAccount::class.java, "email@mmm.it")
        realm.createObject(RealmAccount::class.java, "email@mmm.it")
        realm.createObject(RealmAccount::class.java, "email@mmm.it")
        realm.createObject(RealmAccount::class.java, "email@mmm.it")
        realm.createObject(RealmAccount::class.java, "email@nnn.it")*/
        realm.commitTransaction()
        realm.close()*/


        router = Conductor.attachRouter(this, container, savedInstanceState)
        if (!router.hasRootController()) {
            router.setRoot(RouterTransaction.with(AccountsController()))
        }
    }

    override fun onBackPressed() {
        if (!router.handleBack()) super.onBackPressed()
    }
}