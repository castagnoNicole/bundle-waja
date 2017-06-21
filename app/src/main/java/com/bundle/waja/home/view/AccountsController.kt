package com.bundle.waja.home.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.bluelinelabs.conductor.Controller
import com.bluelinelabs.conductor.RouterTransaction
import com.bundle.waja.R
import com.bundle.waja.common.MVP
import com.bundle.waja.details.view.AccountDetailsController
import com.bundle.waja.home.AccountModel
import com.bundle.waja.home.AccountsPresenter

interface AccountScreen : MVP.View {
    fun showAccounts(){}
}

class AccountsController : Controller(), AccountScreen {
    private val presenter = AccountsPresenter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View {
        presenter.view = this
        val view = inflater.inflate(R.layout.accounts_controller, container, false) as LinearLayout
        val accountListView = view.findViewById(R.id.accounts_list) as AccountsListView
        accountListView.onAccountClicked = { showAccountDetails(it)}

        presenter.onViewReady()

        return  view
    }

    override fun showAccounts() {
        super.showAccounts()
    }

    private fun showAccountDetails(account: AccountModel){
        val controller = AccountDetailsController.create(account)
        router.pushController(RouterTransaction.with(controller))
    }
}