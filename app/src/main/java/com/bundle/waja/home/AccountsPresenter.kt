package com.bundle.waja.home

import com.bundle.waja.R
import com.bundle.waja.common.MVP
import com.bundle.waja.home.view.AccountScreen

class AccountsPresenter : MVP.Presenter<AccountScreen>(){

    fun onViewReady(){
        view?.showAccounts()
    }
}

