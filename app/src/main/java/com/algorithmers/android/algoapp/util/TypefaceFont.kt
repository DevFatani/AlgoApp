package com.algorithmers.android.algoapp.util

import android.content.Context
import android.graphics.Typeface

/**
 * Created by devfatani on 10/26/16.
 */
object TypefaceFont {
    fun set(context: Context): Typeface {
        return Typeface.createFromAsset(context.assets, "fonts/Midan.ttf")
    }
}
