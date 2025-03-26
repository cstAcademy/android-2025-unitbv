package com.cst.cstacademy2025unitbv.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cst.cstacademy2025unitbv.R
import com.cst.cstacademy2025unitbv.models.MediaModel
import com.cst.cstacademy2025unitbv.models.PodcastModel

class MediaListAdapter(
    private val mediaList: List<MediaModel>
) : RecyclerView.Adapter<MediaListAdapter.MediaItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MediaItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_podcast, parent, false)
        return MediaItemViewHolder(view)
    }

    override fun getItemCount() = mediaList.count()

    override fun onBindViewHolder(holder: MediaItemViewHolder, position: Int) {
        val podcast = (mediaList.getOrNull(position) as? PodcastModel) ?: return
        holder.bind(podcast)
    }


    inner class MediaItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(podcast: PodcastModel) {

        }
    }


}