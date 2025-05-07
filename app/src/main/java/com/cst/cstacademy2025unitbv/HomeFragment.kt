package com.cst.cstacademy2025unitbv

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cst.cstacademy2025unitbv.adapters.MediaListAdapter
import com.cst.cstacademy2025unitbv.models.ImageModel
import com.cst.cstacademy2025unitbv.models.PodcastModel
import com.cst.cstacademy2025unitbv.models.TextModel
import com.cst.cstacademy2025unitbv.models.VideoModel

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
            VideoModel(),
            PodcastModel(),
            ImageModel(),
            TextModel(),
            VideoModel(),
            PodcastModel(),
            ImageModel(),
            TextModel(),
            VideoModel(),
            PodcastModel(),
            ImageModel(),
            TextModel(),
            VideoModel(),
            PodcastModel(),
            ImageModel(),
            TextModel(),
            VideoModel(),
            PodcastModel(),
            ImageModel(),
            TextModel(),
            VideoModel(),
            PodcastModel(),
            ImageModel(),
            TextModel(),
        ).shuffled()

        val adapter = MediaListAdapter(mediaList)

        val layoutManager = LinearLayoutManager(context)

        rvMedia.apply {
            this.layoutManager = layoutManager
            this.adapter = adapter
        }

        view.findViewById<Button>(R.id.btn_go_to_users).setOnClickListener {
            goToUsers()
        }
    }

    fun goToUsers() {
        val action = HomeFragmentDirections.actionHomeFragmentToNavigationUsers()
        findNavController().navigate(action)
    }
}