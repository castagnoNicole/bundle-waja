package com.bundle.waja.common

interface MVP {
    interface View
    abstract class Presenter<V : View> {
        var view: V? = null
    }
}

