package com.bundle.waja.details.view

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.bluelinelabs.conductor.Controller
import com.bundle.waja.R
import com.bundle.waja.common.MVP
import com.bundle.waja.details.presenter.AccountDetailsPresenter
import com.bundle.waja.home.AccountModel


interface AccountDetailsScreen :MVP.View {
    fun showEditAccount()
    fun showCopySuccess()
}

class AccountDetailsController(bundle: Bundle) : Controller(bundle), AccountDetailsScreen{
    companion object PassingAccount{
        const val BUNDLE_ACCOUNT_NAME : String = "name"
        const val BUNDLE_ACCOUNT_EMAIL : String = "email"

        fun create(accountModel: AccountModel): AccountDetailsController {
            val bundle = Bundle()
            bundle.putString(BUNDLE_ACCOUNT_NAME, accountModel.name)
            bundle.putString(BUNDLE_ACCOUNT_EMAIL, accountModel.email)
            return AccountDetailsController(bundle)
        }

    }
    private var presenter = AccountDetailsPresenter()
    private lateinit var copyButton : Button

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View {
        presenter.view = this
        val view = inflater.inflate(R.layout.account_details, container, false)
        val accountType = view.findViewById(R.id.user_name) as TextView
        val email = view.findViewById(R.id.email_address) as TextView
        val passwordTxt = view.findViewById(R.id.password) as TextView
        copyButton = view.findViewById(R.id.copy_password_btn) as Button
        copyButton.setOnClickListener { copyPassword(passwordTxt.text.toString()) }

        accountType.text = args.getString(BUNDLE_ACCOUNT_NAME)
        email.text = args.getString(BUNDLE_ACCOUNT_EMAIL)

        return view
    }

    private fun copyPassword(password: String){
        val clipboard = activity?.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        val clip = ClipData.newPlainText("password",password)
        clipboard.primaryClip = clip
        showCopySuccess()
    }

    override fun showCopySuccess() {
        val toast = Toast.makeText(activity!!, "La password è stata copiata", Toast.LENGTH_SHORT).show()
    }

    override fun showEditAccount() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}