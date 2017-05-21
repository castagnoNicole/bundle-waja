package com.bundle.waja.home.view

import android.graphics.Color
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import com.bundle.waja.home.AccountModel

class AccountAdapter(var accounts: List<AccountModel>): RecyclerView.Adapter<AccountAdapter.ViewHolder>() {
    open class ViewHolder(view: View) : RecyclerView.ViewHolder(view)

    class AccountViewHolder(private val view: AccountView) : ViewHolder(view){
        fun bindAccount(account: AccountModel){
            view.showAccount(account)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = AccountView(parent.context).apply {
            layoutParams = ViewGroup.LayoutParams(WRAP_CONTENT, WRAP_CONTENT)
            setBackgroundColor(Color.LTGRAY)
        }

        return AccountViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val account = accounts[position]
        if (holder is AccountViewHolder)
            holder.bindAccount(account)
    }

    override fun getItemCount() = accounts.size
}

