package com.cst.cstacademy2025unitbv.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cst.cstacademy2025unitbv.R
import com.cst.cstacademy2025unitbv.adapters.UsersListAdapter
import com.cst.cstacademy2025unitbv.data.repositories.UsersRepository
import com.cst.cstacademy2025unitbv.models.UserModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class UsersFragment: Fragment() {

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

        view.findViewById<Button>(R.id.add_user).setOnClickListener {
            insertIntoDatabase(getRandomUsersList())
        }
    }

    fun getRandomUsersList(): List<UserModel> {
        val users = mutableListOf<UserModel>()

        users.add(
            UserModel(
                firstName = "Gabriel",
                lastName = "Alexandru",
                email = "gabriel.alexandru@cst.ro",
                avatar = "https://letsenhance.io/static/73136da51c245e80edc6ccfe44888a99/1015f/MainBefore.jpg"
            )
        )
        users.add(
            UserModel(
                firstName = "Gabriel",
                lastName = "Alexandru",
                email = "gabriel.alexandru@cst.ro",
                avatar = "https://letsenhance.io/static/73136da51c245e80edc6ccfe44888a99/1015f/MainBefore.jpg"
            )
        )
        users.add(
            UserModel(
                firstName = "Gabriel",
                lastName = "Alexandru",
                email = "gabriel.alexandru@cst.ro",
                avatar = "https://letsenhance.io/static/73136da51c245e80edc6ccfe44888a99/1015f/MainBefore.jpg"
            )
        )
        users.add(
            UserModel(
                firstName = "Gabriel",
                lastName = "Alexandru",
                email = "gabriel.alexandru@cst.ro",
                avatar = "https://letsenhance.io/static/73136da51c245e80edc6ccfe44888a99/1015f/MainBefore.jpg"
            )
        )
        users.add(
            UserModel(
                firstName = "Gabriel",
                lastName = "Alexandru",
                email = "gabriel.alexandru@cst.ro",
                avatar = "https://letsenhance.io/static/73136da51c245e80edc6ccfe44888a99/1015f/MainBefore.jpg"
            )
        )
        users.add(
            UserModel(
                firstName = "Gabriel",
                lastName = "Alexandru",
                email = "gabriel.alexandru@cst.ro",
                avatar = "https://letsenhance.io/static/73136da51c245e80edc6ccfe44888a99/1015f/MainBefore.jpg"
            )
        )

        val endIndex = (1..5).random()
        return users.subList(0, endIndex)
    }

    private fun setupList() {
        val rvUsers = view?.findViewById<RecyclerView>(R.id.rv_users) ?: return

        rvUsers.adapter = adapter
        rvUsers.layoutManager = LinearLayoutManager(requireContext())
    }

//    UserModel(
//    firstName = "Gabriel",
//    lastName = "Alexandru",
//    email = "gabriel.alexandru@cst.ro",
//    avatar = "https://letsenhance.io/static/73136da51c245e80edc6ccfe44888a99/1015f/MainBefore.jpg"
//    )

    fun insertIntoDatabase(users: List<UserModel>) {
        viewLifecycleOwner.lifecycleScope.launch {
            withContext(Dispatchers.IO) {
                UsersRepository.insertUsers(users)
            }

            getFromDatabase()
        }
    }

    private fun getFromDatabase() {
        viewLifecycleOwner.lifecycleScope.launch {
            val result = withContext(Dispatchers.IO) {
                UsersRepository.getUsers()
            }

            users.clear()
            users.addAll(result)
//            adapter.notifyDataSetChanged()
            adapter.notifyItemRangeChanged(0, users.size)
        }
    }
}