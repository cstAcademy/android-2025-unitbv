package com.cst.cstacademy2025unitbv.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cst.cstacademy2025unitbv.R
import com.cst.cstacademy2025unitbv.adapters.UsersListAdapter
import com.cst.cstacademy2025unitbv.data.repositories.UserAddressRepository
import com.cst.cstacademy2025unitbv.data.repositories.UserIdentityCardRepository
import com.cst.cstacademy2025unitbv.data.repositories.UsersRepository as DatabaseUsersRepository
import com.cst.cstacademy2025unitbv.models.UserModel
import com.cst.cstacademy2025unitbv.models.dummyData.getRandomUserAddress
import com.cst.cstacademy2025unitbv.models.one_to_many.UserAddressModel
import com.cst.cstacademy2025unitbv.models.one_to_one.UserIdentityCardModel
import com.cst.cstacademy2025unitbv.networking.repositories.UsersRepository as NetworkingUserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.UUID

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

        view.findViewById<Button>(R.id.btn_get_id_cards).setOnClickListener {
            getUsersWithIDCards()
        }

        view.findViewById<Button>(R.id.btn_get_address).setOnClickListener {
            getAddressesWithUsers()
        }
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
                val users = result.data

                val idCards = users.map { user ->
                    UserIdentityCardModel(
                        id = UUID.randomUUID().toString(),
                        ownerId = user.id,
                        cnp = UUID.randomUUID().toString()
                    )
                }
                UserIdentityCardRepository.insertIdCards(idCards)

                val addresses = mutableListOf<UserAddressModel>()
                users.forEach { user ->
                    val address = getRandomUserAddress()
                    addresses.add(address)

                    user.addressId = address.id
                }
                UserAddressRepository.insert(addresses)

                DatabaseUsersRepository.insertUsers(users)
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

    private fun getUsersWithIDCards() {
        viewLifecycleOwner.lifecycleScope.launch {
            val result = withContext(Dispatchers.IO) {
                DatabaseUsersRepository.getUsersWithIDCards()
            }

            view?.findViewById<TextView>(R.id.tv_log)?.text = result.toString()
        }
    }

    private fun getAddressesWithUsers() {
        viewLifecycleOwner.lifecycleScope.launch {
            val result = withContext(Dispatchers.IO) {
                UserAddressRepository.getAddressWithUsers(getRandomUserAddress().id)
            }

            view?.findViewById<TextView>(R.id.tv_log)?.text = result.toString()
        }
    }
}