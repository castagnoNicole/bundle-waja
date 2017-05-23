package com.bundle.waja.details.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.bluelinelabs.conductor.Controller
import com.bundle.waja.R
import com.bundle.waja.common.MVP
import com.bundle.waja.details.presenter.AccountDetailsPresenter

interface AccountDetailsScreen :MVP.View {
    fun showEditAccount()
}

class AccountDetailsController : Controller(), AccountDetailsScreen{
    private var presenter = AccountDetailsPresenter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View {
        presenter.view = this
        val view = inflater.inflate(R.layout.account_details, container, false)

        return view
    }

    override fun showEditAccount() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}

