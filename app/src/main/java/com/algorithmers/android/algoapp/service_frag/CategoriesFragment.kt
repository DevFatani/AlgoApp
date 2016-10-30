package com.algorithmers.android.algoapp.service_frag

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.GridView
import com.algorithmers.android.algoapp.AlgoMainServicesActivity
import com.algorithmers.android.algoapp.FakeData
import com.algorithmers.android.algoapp.R
import com.algorithmers.android.algoapp.adapter.CategoryAdapter
import com.algorithmers.android.algoapp.model.Category
import com.orangegangsters.github.swipyrefreshlayout.library.SwipyRefreshLayout
import com.orangegangsters.github.swipyrefreshlayout.library.SwipyRefreshLayoutDirection

/**
 * Created by devfatani on 10/26/16.
 */


class CategoriesFragment : Fragment(), SwipyRefreshLayout.OnRefreshListener, AdapterView.OnItemClickListener {

    interface CategorySelect {
        fun onSelected(id: Int)
    }

    var categorySelect: CategorySelect? = null
    var swipyRefresh: SwipyRefreshLayout? = null
    var categories = mutableListOf<Category>()
    var categoryAdapter: CategoryAdapter? = null

    override fun onRefresh(direction: SwipyRefreshLayoutDirection?) {

    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        try {
            this.categorySelect = context as AlgoMainServicesActivity
        } catch (e: ClassCastException) {
            e.printStackTrace()
        }
    }


    private fun downloadCategories() {
        this.categories.addAll(FakeData().fakeCategories())
        this.categoryAdapter = CategoryAdapter(this.context, 0, this.categories.toTypedArray())
    }

    object Holder {
        val instance: CategoriesFragment = CategoriesFragment()
    }

    companion object {
        val instance: CategoriesFragment by lazy { Holder.instance }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.downloadCategories()
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.fragment_categories, container, false)
    }

    override fun onItemClick(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long){
        this.categorySelect!!.onSelected((p0!!.getItemAtPosition(p2) as Category).id)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val gv = (view!!.findViewById(R.id.gvFrgCategories) as GridView)
        gv.adapter = this.categoryAdapter
        gv.onItemClickListener = this
        this.swipyRefresh = view.findViewById(R.id.swipyrefreshlayout) as SwipyRefreshLayout
    }
}