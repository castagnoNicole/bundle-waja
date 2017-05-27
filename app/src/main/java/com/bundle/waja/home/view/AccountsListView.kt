package com.bundle.waja.home.view

import android.content.Context
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.AttributeSet
import com.bundle.waja.home.AccountModel

class AccountsListView : RecyclerView {
    var onAccountClicked: ((AccountModel)-> Unit)? = null
    private val accountAdapter = AccountAdapter(
            listOf(
                    AccountModel("Facebook", "pippi@gmail.it"),AccountModel("Facebook", "gino@caluso.com"),
                    AccountModel("Facebook", "pippi@gmail.it"),AccountModel("Facebook", "gino@caluso.com"),
                    AccountModel("Facebook", "pippi@gmail.it"),AccountModel("Facebook", "gino@caluso.com"),
                    AccountModel("Facebook", "pippi@gmail.it"),AccountModel("Facebook", "gino@caluso.com"),
                    AccountModel("Facebook", "pippi@gmail.it"),AccountModel("Facebook", "gino@caluso.com")
            )
    )

    constructor(context: Context) : super(context)
    constructor(context: Context, attributes: AttributeSet) : super(context, attributes)
    constructor(context: Context, attributes: AttributeSet, defStyle: Int) : super(context, attributes, defStyle)

    init {
        accountAdapter.onAccountClicked = {onAccountClicked?.invoke(it)}
        adapter = accountAdapter
        layoutManager = GridLayoutManager(context, 3)
        addItemDecoration(AccountItemDecoration())
    }
}