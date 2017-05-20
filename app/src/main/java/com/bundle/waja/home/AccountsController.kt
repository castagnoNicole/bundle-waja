package com.bundle.waja.home

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.bluelinelabs.conductor.Controller
import com.bundle.waja.R
import com.bundle.waja.common.MVP

interface AccountScreen : MVP.View{
    fun showAccounts(){}
}

class AccountsController : Controller(), AccountScreen{
    private val presenter= AccountsPresenter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View {
        presenter.view = this
        val view = inflater.inflate(R.layout.accounts_recyclerview, container, false) as LinearLayout

        return  view
    }

}

