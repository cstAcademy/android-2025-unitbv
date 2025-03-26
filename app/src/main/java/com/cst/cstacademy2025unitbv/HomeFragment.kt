package com.cst.cstacademy2025unitbv

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cst.cstacademy2025unitbv.adapters.MediaListAdapter
import com.cst.cstacademy2025unitbv.models.PodcastModel

class HomeFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val rvMedia = view.findViewById<RecyclerView>(R.id.rv_media)

        val mediaList = listOf(
            PodcastModel(),
            PodcastModel(),
            PodcastModel(),
            PodcastModel(),
            PodcastModel(),
            PodcastModel(),
            PodcastModel(),
            PodcastModel(),
            PodcastModel(),
            PodcastModel(),
            PodcastModel(),
            PodcastModel(),
            PodcastModel(),
            PodcastModel(),
            PodcastModel(),
            PodcastModel(),
            PodcastModel(),
            PodcastModel(),
            PodcastModel(),
            PodcastModel(),
            PodcastModel(),
            PodcastModel(),
            PodcastModel(),
            PodcastModel(),
        )

        val adapter = MediaListAdapter(mediaList)


        val layoutManager = LinearLayoutManager(context)

        rvMedia.apply {
            this.layoutManager = layoutManager
            this.adapter = adapter
        }

    }
}