package com.cst.cstacademy2025unitbv.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.cst.cstacademy2025unitbv.R

class LoginFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_login, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<Button>(R.id.btn_login).setOnClickListener {
            doLogin()
        }
        view.findViewById<Button>(R.id.btn_register).setOnClickListener {
            val email = view.findViewById<EditText>(R.id.et_email).text.toString()
            goToRegister(email)
        }

    }

    fun doLogin() {
        val action = LoginFragmentDirections.actionLoginFragmentToAuthenticationNavigation()
        findNavController().navigate(action)
    }

    fun goToRegister(email : String) {
        val action = LoginFragmentDirections.actionLoginFragmentToRegisterFragment(email)
        findNavController().navigate(action)
    }
}