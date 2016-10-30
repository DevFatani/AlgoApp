package com.algorithmers.android.algoapp.service_frag

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.algorithmers.android.algoapp.*
import com.algorithmers.android.algoapp.adapter.ContentAdapter

/**
 * Created by devfatani on 10/25/16.
 */

class NewsfeedFragment : Fragment(), ChangeContent {


    var contents = mutableListOf<Any>()
    var contentAdapter: ContentAdapter = ContentAdapter()
    var contentType: Int = ALL

    override fun onChange(contentType: Int, categoryId: Int) {
        if (this.contentType != MIX) if (this.contentType == contentType) return

        this.contentType = contentType

        if (contentType == ALL) {
            this.downloadAllContent()
        } else if (contentType == TXT) {
            this.downloadAllTxts()
        } else if (contentType == VIDEO) {
            this.downloadAllVideos()
        } else if (contentType == MIX) {
            this.downloadByCategory(categoryId)
        } else if (contentType == AUDIO) {
            this.downloadAllAudios()
        } else if (contentType == IMAGE) {
            this.downloadAllImgs()
        }

        this.contentAdapter.notifyDataSetChanged()

    }


    override fun onAttach(context: Context?) {
        super.onAttach(context)

        this.contentAdapter.context = this.context
        this.contentAdapter.contents = this.contents
        this.downloadAllContent()

        try {
            (context as AlgoMainServicesActivity).changeContent = this
        } catch (e: ClassCastException) {
            e.printStackTrace()
        }
    }

    private fun downloadAllContent() {
        this.contents.clear()
        this.contents.addAll(FakeData().fakeAd())
        this.contents.addAll(FakeData().fakeAudioList())
        this.contents.addAll(FakeData().fakeTxtList())
        this.contents.addAll(FakeData().fakeVideoList())
        this.contents.addAll(FakeData().fakeImgList())
    }

    private fun downloadAllTxts() {
        this.contents.clear()
        this.contents.addAll(FakeData().fakeTxtList())
    }

    private fun downloadAllVideos() {
        this.contents.clear()
        this.contents.addAll(FakeData().fakeVideoList())
    }

    private fun downloadAllAudios() {
        this.contents.clear()
        this.contents.addAll(FakeData().fakeAudioList())
    }

    private fun downloadAllImgs() {
        this.contents.clear()
        this.contents.addAll(FakeData().fakeImgList())
    }

    private fun downloadByCategory(categoryId: Int) {
        this.contents.clear()
        this.contents.addAll(FakeData().getByCategory(categoryId))
    }


    object Holder {
        val instance: NewsfeedFragment = NewsfeedFragment()
    }

    companion object {
        val instance: NewsfeedFragment by lazy { Holder.instance }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.fragment_newsfeed, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val rvNewsFeed = view!!.findViewById(R.id.rv_newsfeed) as RecyclerView
        rvNewsFeed.layoutManager = LinearLayoutManager(this.context)
        rvNewsFeed.adapter = this.contentAdapter
    }
}