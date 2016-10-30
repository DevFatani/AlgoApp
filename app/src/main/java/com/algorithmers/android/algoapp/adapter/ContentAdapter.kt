package com.algorithmers.android.algoapp.adapter

/**
 * Created by devfatani on 10/23/16.
 */

import android.content.Context
import android.graphics.Color
import android.graphics.PorterDuff
import android.graphics.PorterDuffColorFilter
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.algorithmers.android.algoapp.*
import com.algorithmers.android.algoapp.model.*
import com.algorithmers.android.algoapp.util.TypefaceFont
import com.github.mugku.activehashtag.ActiveHashTag
import com.hugomatilla.audioplayerview.AudioPlayerView
import com.pierfrancescosoffritti.youtubeplayer.AbstractYouTubeListener
import com.pierfrancescosoffritti.youtubeplayer.YouTubePlayerView
import com.squareup.picasso.Picasso
import java.util.*

class ContentAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var contents = mutableListOf<Any>()
    var context: Context? = null

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder {

        Log.v(toString(), "view type $viewType")
        if (viewType == VIDEO) {
            return VideoViewHolder(LayoutInflater.from(parent!!.context).inflate(R.layout.content_video_row, parent, false))
        } else if (viewType == AD) {
            return AdViewHolder(LayoutInflater.from(parent!!.context).inflate(R.layout.content_ad_row, parent, false))
        } else if (viewType == IMAGE) {
            return ImageViewHolder(LayoutInflater.from(parent!!.context).inflate(R.layout.content_image_row, parent, false))
        } else if (viewType == AUDIO) {
            return AudioViewHolder(LayoutInflater.from(parent!!.context).inflate(R.layout.content_audio_row, parent, false), context = context!!)
        } else {
            return MainViewHolder(LayoutInflater.from(parent!!.context).inflate(R.layout.content_generic_row, parent, false))
        }

    }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {

        val viewType = this.getItemViewType(position)
        if (viewType == AD) {
            this.displayAd(adViewHolder = holder as AdViewHolder, position = position)
        } else if (viewType == VIDEO) {
            this.displayVideo(videoViewHolder = holder as VideoViewHolder, position = position)
        } else if (viewType == AUDIO) {
            this.displayAudio(audioViewHolder = holder as AudioViewHolder, position = position)
        } else if (viewType == IMAGE) {
            this.displayImg(imageViewHolder = holder as ImageViewHolder, position = position)
        } else if (viewType == TXT) {
            this.displayTxt(mainViewHolder = holder as MainViewHolder, position = position)
        }
    }

    private fun displayVideo(videoViewHolder: VideoViewHolder, position: Int) {
        val video = this.contents[position] as Video
        videoViewHolder.contentBody!!.text = video.txt
        videoViewHolder.contentName!!.text = video.name
        videoViewHolder.contentMainCategory!!.text = video.category.name
        videoViewHolder.contentTagBox!!.text = this.setTags(video.category.subCategories)
        videoViewHolder.contentLike!!.text = String.format(Locale.getDefault(), "%d", video.like)

        this.setContentIcon(contentImg = videoViewHolder.contentImg, viewType = VIDEO)
        this.initYouTubePlayer(youTubePlayer = videoViewHolder.youTube, videoId = video.videoId, videoDuration = video.duration)
    }

    private fun displayAudio(audioViewHolder: AudioViewHolder, position: Int) {
        val audio = this.contents[position] as Audio
        audioViewHolder.contentBody!!.text = audio.txt
        audioViewHolder.contentName!!.text = audio.name
        audioViewHolder.contentMainCategory!!.text = audio.category.name
        audioViewHolder.contentTagBox!!.text = this.setTags(audio.category.subCategories)
        audioViewHolder.contentLike!!.text = String.format(Locale.getDefault(), "%d", audio.like)

        this.setContentIcon(contentImg = audioViewHolder.contentImg, viewType = AUDIO)
        this.downloadAudio(audioPlayerView = audioViewHolder.audioPlayer, url = audio.audioSrc)
    }

    private fun displayImg(imageViewHolder: ImageViewHolder, position: Int) {
        val image = this.contents[position] as Image
        imageViewHolder.contentBody!!.text = image.txt
        imageViewHolder.contentName!!.text = image.name
        imageViewHolder.contentMainCategory!!.text = image.category.name
        imageViewHolder.contentTagBox!!.text = this.setTags(image.category.subCategories)
        imageViewHolder.contentLike!!.text = String.format(Locale.getDefault(), "%d", image.like)

        this.setContentIcon(contentImg = imageViewHolder.contentImg, viewType = IMAGE)
        this.downloadImage(url = image.src, ivContentImgSrc = imageViewHolder.ivContentImgSrc)

    }

    private fun displayTxt(mainViewHolder: MainViewHolder, position: Int) {
        val txt = this.contents[position] as Txt
        mainViewHolder.contentBody!!.text = txt.txt
        mainViewHolder.contentName!!.text = txt.name
        mainViewHolder.contentMainCategory!!.text = txt.category.name
        mainViewHolder.contentTagBox!!.text = this.setTags(txt.category.subCategories)
        mainViewHolder.contentLike!!.text = String.format(Locale.getDefault(), "%d", txt.like)

        this.setContentIcon(contentImg = mainViewHolder.contentImg, viewType = TXT)
    }

    private fun displayAd(adViewHolder: AdViewHolder, position: Int) {
        val ad = this.contents[position] as Ad
        this.setContentIcon(adViewHolder.ivAdImg, AD)
        adViewHolder.tvAdBody!!.text = ad.desc
    }

    private fun downloadAudio(audioPlayerView: AudioPlayerView?, url: String) {
        audioPlayerView!!.withUrl(url)
    }

    private fun downloadImage(url: String, ivContentImgSrc: ImageView?) {
        Picasso.with(this.context).load(url).into(ivContentImgSrc);
    }


    override fun getItemViewType(position: Int): Int {

        if (this.contents[position] is Video) {
            Log.v(toString(), "VIDEO")
            return VIDEO
        } else if (this.contents[position] is Ad) {
            Log.v(toString(), "Ad")
            return AD
        } else if (this.contents[position] is Image) {
            Log.v(toString(), "Image")
            return IMAGE
        } else if (this.contents[position] is Audio) {
            Log.v(toString(), "Audio")
            return AUDIO
        } else {
            return TXT
        }
    }

    override fun getItemCount(): Int {
        return this.contents.count()
    }


    private fun setTags(subCategories: List<SubCategory>): String {
        var tags: String = ""
        for (subCategory in subCategories) {
            tags = String.format(Locale.getDefault(), "%s \t #%s", tags, subCategory.name)
        }
        return tags
    }

    private fun initYouTubePlayer(youTubePlayer: YouTubePlayerView?, videoId: String, videoDuration: Float) {
        youTubePlayer!!.initialize(object : AbstractYouTubeListener() {
            override fun onReady() {
                youTubePlayer.loadVideo(videoId, videoDuration)
                youTubePlayer.pauseVideo()
            }
        }, true)
    }

    private fun setContentIcon(contentImg: ImageView?, viewType: Int) {

        var colorHex = ""
        var imgResource = 0

        if (viewType == VIDEO) {
            colorHex = ""
            imgResource = R.drawable.ic_play_circle_filled_black_24dp
        } else if (viewType == TXT) {
            colorHex = ""
            imgResource = R.drawable.ic_import_contacts_black_24dp
        } else if (viewType == AD) {
            colorHex = ""
            imgResource = R.drawable.ic_assistant_photo_black_24dp
        } else if (viewType == IMAGE) {
            imgResource = R.drawable.ic_photo_library_black_24dp
        } else if (viewType == AUDIO) {
            imgResource = R.drawable.ic_headset_black_24dp
        }

        this.setIcon(contentImg = contentImg, imgResource = imgResource)
//        this.changeIconColor(contentImg = contentImg, colorHex = colorHex)

    }

    private fun changeIconColor(contentImg: ImageView?, colorHex: String) {
        if (contentImg != null) {
            contentImg.colorFilter = PorterDuffColorFilter(Color.parseColor(colorHex), PorterDuff.Mode.SRC_ATOP)
        }
    }

    private fun setIcon(contentImg: ImageView?, imgResource: Int) {
        contentImg!!.setImageResource(imgResource)
    }


    class AdViewHolder constructor(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        var tvAdBody: TextView? = null
        var ivAdImg: ImageView? = null

        init {
            this.ivAdImg = this.itemView.findViewById(R.id.ivAd) as ImageView
            this.tvAdBody = this.itemView.findViewById(R.id.tvAdBody) as TextView
        }
    }


    class AudioViewHolder(itemView: View?, context: Context) : MainViewHolder(itemView) {
        var audioPlayer: AudioPlayerView? = null

        init {
            this.audioPlayer = this.itemView.findViewById(R.id.audioPlayer) as AudioPlayerView?

            this.audioPlayer!!.typeface = TypefaceFont.set(context = context)
        }
    }


    class ImageViewHolder(itemView: View?) : MainViewHolder(itemView) {
        var ivContentImgSrc: ImageView? = null

        init {
            this.ivContentImgSrc = this.itemView.findViewById(R.id.ivContentImgSrc) as ImageView?
        }
    }


    class VideoViewHolder(itemView: View?) : MainViewHolder(itemView) {
        var youTube: YouTubePlayerView? = null

        init {
            this.youTube = this.itemView.findViewById(R.id.youtube_player_view) as YouTubePlayerView?
            this.contentName!!.setTextColor(R.color.red)
        }
    }

    open class MainViewHolder constructor(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        var contentImg: ImageView? = null
        var contentName: TextView? = null
        var contentLike: TextView? = null
        var contentBody: TextView? = null
        var contentTagBox: TextView? = null
        var contentMainCategory: TextView? = null
        val TV_HASH_TAG: ActiveHashTag = ActiveHashTag.Factory.create(Color.parseColor("#51e1cb"), null)

        init {
            this.contentImg = this.itemView.findViewById(R.id.ivContentImg) as ImageView?
            this.contentName = this.itemView.findViewById(R.id.tvContentName) as TextView?
            this.contentLike = this.itemView.findViewById(R.id.tvContentLike) as TextView?
            this.contentBody = this.itemView.findViewById(R.id.tvContentBody) as TextView?
            this.contentTagBox = this.itemView.findViewById(R.id.tvContentBoxTag) as TextView?
            this.contentMainCategory = this.itemView.findViewById(R.id.tvMainCategory) as TextView?
            TV_HASH_TAG.operate(this.contentTagBox)
        }
    }
}