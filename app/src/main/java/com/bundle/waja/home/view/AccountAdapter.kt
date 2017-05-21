package com.bundle.waja.home.view

import android.graphics.Color
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import com.bundle.waja.home.AccountModel

class AccountAdapter(var accounts: List<AccountModel>): RecyclerView.Adapter<AccountAdapter.AccountViewHolder>() {

    class AccountViewHolder(private val view: AccountView) : RecyclerView.ViewHolder(view){
        fun bindAccount(account: AccountModel){
            view.showAccount(account)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AccountViewHolder {
        val view = AccountView(parent.context).apply {
            layoutParams = ViewGroup.LayoutParams(WRAP_CONTENT, WRAP_CONTENT)
            setBackgroundColor(Color.LTGRAY)
        }

        return AccountViewHolder(view)
    }

    override fun onBindViewHolder(holder: AccountViewHolder, position: Int) {
            holder.bindAccount(accounts[position])
    }

    override fun getItemCount() = accounts.size
}

