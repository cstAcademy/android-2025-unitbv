package com.cst.cstacademy2025unitbv.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cst.cstacademy2025unitbv.R
import com.cst.cstacademy2025unitbv.adapters.UsersListAdapter
import com.cst.cstacademy2025unitbv.data.repositories.UsersRepository as DatabaseUsersRepository
import com.cst.cstacademy2025unitbv.models.UserModel
import com.cst.cstacademy2025unitbv.networking.repositories.UsersRepository as NetworkingUserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class UsersFragment : Fragment() {

    private val users = mutableListOf<UserModel>()
    private val adapter = UsersListAdapter(users)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_users, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupList()

        getFromDatabase()
        getFromServer()
    }

    private fun setupList() {
        val rvUsers = view?.findViewById<RecyclerView>(R.id.rv_users) ?: return

        rvUsers.adapter = adapter
        rvUsers.layoutManager = LinearLayoutManager(requireContext())
    }

    private fun getFromServer() {
        viewLifecycleOwner.lifecycleScope.launch {
            delay(3000)

            val result = withContext(Dispatchers.IO) {
                NetworkingUserRepository.getUsers(2)
            }

            withContext(Dispatchers.IO) {
                DatabaseUsersRepository.insertUsers(result.data)
            }

            getFromDatabase()
        }
    }

    private fun getFromDatabase() {
        viewLifecycleOwner.lifecycleScope.launch {
            val result = withContext(Dispatchers.IO) {
                DatabaseUsersRepository.getUsers()
            }

            users.clear()
            users.addAll(result)
//            adapter.notifyDataSetChanged()
            adapter.notifyItemRangeChanged(0, users.size)
        }
    }
}