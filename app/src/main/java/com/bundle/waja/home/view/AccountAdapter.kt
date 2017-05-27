package com.bundle.waja.home.view

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import com.bundle.waja.home.AccountModel

class AccountAdapter(var accounts: List<AccountModel>): RecyclerView.Adapter<AccountAdapter.AccountViewHolder>() {
    var onAccountClicked: ((AccountModel) -> Unit)? = null

    class AccountViewHolder(private val view: AccountView, var onClick: (AccountModel)->Unit) : RecyclerView.ViewHolder(view){
        fun bindAccount(account: AccountModel){
            view.showAccount(account)
            view.onClicked = { onClick(account)}
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AccountViewHolder {
        val view = AccountView(parent.context).apply {
            layoutParams = ViewGroup.LayoutParams(WRAP_CONTENT, WRAP_CONTENT)
        }

        return AccountViewHolder(view) { onAccountClicked?.invoke(it)}
    }

    override fun onBindViewHolder(holder: AccountViewHolder, position: Int) {
            holder.bindAccount(accounts[position])
    }

    override fun getItemCount() = accounts.size
}