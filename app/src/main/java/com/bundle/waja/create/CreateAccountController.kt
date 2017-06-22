package com.bundle.waja.create

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.Toast
import com.bluelinelabs.conductor.Controller
import com.bundle.waja.R

class CreateAccountController: Controller() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View {
        val view = inflater.inflate(R.layout.view_create_account, container, false) as LinearLayout
        val accountType = view.findViewById(R.id.account_type) as EditText
        val email = view.findViewById(R.id.email) as EditText
        val password = view.findViewById(R.id.password) as EditText

        val doneBtn = view.findViewById(R.id.done_btn) as Button
        doneBtn.setOnClickListener { saveAccount(accountType.text.toString(), email.text.toString(), password.text.toString()) }

        return view
    }

    fun saveAccount(type: String, email: String, password: String){
        val toast = Toast.makeText(activity!!, "${type}, ${email}, $password", Toast.LENGTH_SHORT)
        toast.show()
    }

}

