package com.algorithmers.android.algoapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.algorithmers.android.algoapp.R
import com.algorithmers.android.algoapp.model.Category

/**
 * Created by devfatani on 10/26/16.
 */
class CategoryAdapter(context: Context?, layout: Int, categories: Array<Category>) : ArrayAdapter<Category>(context, layout, categories) {


    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view = convertView
        val category = this.getItem(position)
        if (view == null) {
            view = LayoutInflater.from(this.context).inflate(R.layout.category_row, parent, false)
            val categoryViewHolder = CategoryViewHolder()
            categoryViewHolder.tvName = view.findViewById(R.id.tvName) as TextView
            categoryViewHolder.tvDesc = view.findViewById(R.id.tvDesc) as TextView
            categoryViewHolder.ivImg = view.findViewById(R.id.ivImg) as ImageView
            view!!.tag = categoryViewHolder
        }

        val categoryViewHolder = view.tag as CategoryViewHolder
        categoryViewHolder.tvName!!.text = category.name
        categoryViewHolder.tvDesc!!.text = category.desc

        return view
    }

    class CategoryViewHolder {
        var tvName: TextView? = null
        var tvDesc: TextView? = null
        var ivImg: ImageView? = null
    }

}