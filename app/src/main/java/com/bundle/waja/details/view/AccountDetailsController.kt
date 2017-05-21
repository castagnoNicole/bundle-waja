package com.bundle.waja.details.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bluelinelabs.conductor.Controller
import com.bundle.waja.common.MVP

interface AccountDetailsScreen :MVP.View {
    fun showEditAccount()
}

class AccountDetailsController : Controller(), AccountDetailsScreen{
    override fun showEditAccount() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}

