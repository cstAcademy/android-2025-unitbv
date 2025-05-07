package com.cst.cstacademy2025unitbv.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cst.cstacademy2025unitbv.R
import com.cst.cstacademy2025unitbv.models.ImageModel
import com.cst.cstacademy2025unitbv.models.MediaModel
import com.cst.cstacademy2025unitbv.models.MediaType
import com.cst.cstacademy2025unitbv.models.PodcastModel
import com.cst.cstacademy2025unitbv.models.TextModel
import com.cst.cstacademy2025unitbv.models.VideoModel

class MediaListAdapter(
    private val mediaList: List<MediaModel>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        when (viewType) {
            MediaType.PODCAST.id -> {
                val view = inflater.inflate(R.layout.item_podcast, parent, false)
                return PodcastItemViewHolder(view)
            }

            MediaType.IMAGE.id -> {
                val view = inflater.inflate(R.layout.item_image, parent, false)
                return ImageItemViewHolder(view)
            }

            MediaType.VIDEO.id -> {
                val view = inflater.inflate(R.layout.item_video, parent, false)
                return VideoItemViewHolder(view)
            }

            MediaType.TEXT.id -> {
                val view = inflater.inflate(R.layout.item_text, parent, false)
                return TextItemViewHolder(view)
            }


            else -> throw IllegalArgumentException("Invalid view type")
        }
    }

    override fun getItemCount() = mediaList.count()

    override fun getItemViewType(position: Int) = mediaList[position].type.id

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = mediaList[position]

        when (item.type) {
            MediaType.PODCAST -> (holder as? PodcastItemViewHolder)?.bind(
                item as? PodcastModel ?: return
            )

            MediaType.IMAGE -> (holder as? ImageItemViewHolder)?.bind(
                item as? ImageModel ?: return
            )

            MediaType.VIDEO -> (holder as? VideoItemViewHolder)?.bind(
                item as? VideoModel ?: return
            )

            MediaType.TEXT -> (holder as? TextItemViewHolder)?.bind(
                item as? TextModel ?: return
            )
        }
    }

    inner class PodcastItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(model: PodcastModel) {

        }
    }

    inner class ImageItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(model: ImageModel) {

        }
    }

    inner class VideoItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(model: VideoModel) {

        }
    }

    inner class TextItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(model: TextModel) {

        }
    }

}