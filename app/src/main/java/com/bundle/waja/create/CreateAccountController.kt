package com.bundle.waja.create

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.Toast
import com.bluelinelabs.conductor.Controller
import com.bluelinelabs.conductor.RouterTransaction
import com.bundle.waja.R
import com.bundle.waja.home.data.RealmAccount
import com.bundle.waja.home.view.AccountsController
import io.realm.Realm
import io.realm.RealmObject

class CreateAccountController : Controller() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View {
        val view = inflater.inflate(R.layout.view_create_account, container, false) as LinearLayout
        val accountType = view.findViewById(R.id.account_type) as EditText
        val email = view.findViewById(R.id.email) as EditText
        val password = view.findViewById(R.id.password) as EditText

        val doneBtn = view.findViewById(R.id.done_btn) as Button
        doneBtn.setOnClickListener { checkFields(accountType.text.toString(), email.text.toString(), password.text.toString()) }

        return view
    }

    private fun checkFields(type: String, email: String, password: String) {
        if (type.isNotBlank() && email.isNotBlank() && password.isNotBlank()) {
            saveNewAccount(type, email, password)
            gobackHome()
        } else {
            val toast = Toast.makeText(activity!!, "Devi inserire tutti i campi", Toast.LENGTH_SHORT)
            toast.show()
        }
    }

    private fun saveNewAccount(type: String, email: String, password: String){
        val newAccount = createAccount(type, email, password)
        saveToRealm(newAccount)
    }

    private fun createAccount(type: String, email: String, password: String): RealmObject {
        val newAccount: RealmObject = RealmAccount(email, type, password, R.drawable.ic_mood_fancy_inverted_5)
        val toast = Toast.makeText(activity!!, "$newAccount", Toast.LENGTH_SHORT)
        toast.show()
        return newAccount
    }

    private fun saveToRealm(newAccount: RealmObject) {
        val realm: Realm = Realm.getDefaultInstance()
        realm.beginTransaction()
        realm.copyToRealm(newAccount)
        realm.commitTransaction()
        realm.close()
    }

    private fun gobackHome(){
        router.pushController(RouterTransaction.with(AccountsController()))
    }

}