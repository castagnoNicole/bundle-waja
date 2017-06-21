package com.bundle.waja.home.view

import android.content.Context
import android.util.AttributeSet
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import butterknife.bindView
import com.bundle.waja.R
import com.bundle.waja.home.AccountModel

class AccountView: LinearLayout {
    var onClicked: (()-> Unit)? = null
    private val accountType: ImageView by bindView(R.id.acount_name)
    private val accountEmail: TextView by bindView(R.id.acount_mail)

    constructor(context: Context) : super(context)
    constructor(context: Context, attributes: AttributeSet) : super(context, attributes)
    constructor(context: Context, attributes: AttributeSet, defStyle: Int) : super(context, attributes, defStyle)

    init {
        inflate(context, R.layout.view_account, this)
    }

    fun showAccount(account: AccountModel) {
        accountType.setImageResource(account.type)
        accountEmail.text = account.email

        setOnClickListener { onClicked?.invoke() }
    }
}