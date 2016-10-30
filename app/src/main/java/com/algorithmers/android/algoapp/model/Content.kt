package com.algorithmers.android.algoapp.model

/**
 * Created by devfatani on 10/23/16.
 */
open class Content : kotlin.Any() {
    var id: Int = 0
    var name: String = ""
    var img: String = ""
    var desc: String = ""
    var like: Int = 0
    var category = Category()
}