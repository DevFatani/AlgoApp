package com.algorithmers.android.algoapp.model

/**
 * Created by devfatani on 10/23/16.
 */
class Category {
    var name: String = ""
    var id: Int = 0
    var img: String = ""
    var desc: String = ""
    var subCategories = mutableListOf<SubCategory>()
}