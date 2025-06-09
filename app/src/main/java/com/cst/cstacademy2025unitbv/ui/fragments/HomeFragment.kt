package com.cst.cstacademy2025unitbv.ui.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cst.cstacademy2025unitbv.R
import com.cst.cstacademy2025unitbv.adapters.MediaListAdapter
import com.cst.cstacademy2025unitbv.managers.SharedPrefsManager
import com.cst.cstacademy2025unitbv.models.ImageModel
import com.cst.cstacademy2025unitbv.models.PodcastModel
import com.cst.cstacademy2025unitbv.models.TextModel
import com.cst.cstacademy2025unitbv.models.VideoModel
import com.cst.cstacademy2025unitbv.ui.ControllerActivity

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

        view.findViewById<Button>(R.id.btn_go_to_media).setOnClickListener {
            goToMedia()
        }

        view.findViewById<Button>(R.id.btn_go_to_users).setOnClickListener {
            goToUsers()
        }

        view.findViewById<Button>(R.id.btn_log_out).setOnClickListener {
            logOut()
        }
    }

    private fun goToUsers() {
        val action = HomeFragmentDirections.actionHomeFragmentToNavigationUsers()
        findNavController().navigate(action)
    }

    private fun goToMedia() {
        val action = HomeFragmentDirections.actionHomeFragmentToMediaNavigation()
        findNavController().navigate(action)
    }


    private fun logOut() {
        SharedPrefsManager.removeAuthToken()

        val intent = Intent(activity, ControllerActivity::class.java)
        startActivity(intent)

        activity?.finish()
    }
}