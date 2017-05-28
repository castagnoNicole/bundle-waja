package com.bundle.waja.details.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.bluelinelabs.conductor.Controller
import com.bundle.waja.R
import com.bundle.waja.common.MVP
import com.bundle.waja.details.presenter.AccountDetailsPresenter
import com.bundle.waja.home.AccountModel

interface AccountDetailsScreen :MVP.View {
    fun showEditAccount()
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

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View {
        presenter.view = this
        val view = inflater.inflate(R.layout.account_details, container, false)
        val accountType = view.findViewById(R.id.user_name) as TextView
        val email = view.findViewById(R.id.email_address) as TextView

        accountType.text = args.getString(BUNDLE_ACCOUNT_NAME)
        email.text = args.getString(BUNDLE_ACCOUNT_EMAIL)


        return view
    }

    override fun showEditAccount() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}