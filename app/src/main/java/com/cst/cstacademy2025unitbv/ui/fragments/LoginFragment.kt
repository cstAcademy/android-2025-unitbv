package com.cst.cstacademy2025unitbv.ui.fragments

import androidx.lifecycle.lifecycleScope

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.cst.cstacademy2025unitbv.BuildConfig
import com.cst.cstacademy2025unitbv.R
import com.cst.cstacademy2025unitbv.helpers.extensions.isEmailValid
import com.cst.cstacademy2025unitbv.helpers.extensions.isPasswordValid
import com.cst.cstacademy2025unitbv.helpers.extensions.showToast
import com.cst.cstacademy2025unitbv.managers.SharedPrefsManager
import com.cst.cstacademy2025unitbv.networking.repositories.AuthRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.io.IOException

class LoginFragment : Fragment() {
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
        view.findViewById<TextView>(R.id.btn_register).setOnClickListener {
            val email = view.findViewById<EditText>(R.id.et_email).text.toString()
            goToRegister(email)
        }

        if(BuildConfig.DEBUG) {
            view.findViewById<EditText>(R.id.et_email).setText("eve.holt@reqres.in")
            view.findViewById<EditText>(R.id.et_password).setText("cityslicka")
        }
    }

    private fun doLogin() {
        val email = view?.findViewById<EditText>(R.id.et_email)?.text.toString()
        val password = view?.findViewById<EditText>(R.id.et_password)?.text.toString()

        if(!email.isEmailValid()) {
            context?.showToast(getString(R.string.error_invalid_email))
            return
        }

        if(!password.isPasswordValid()) {
            context?.showToast(getString(R.string.error_invalid_password))
            return
        }

        viewLifecycleOwner.lifecycleScope.launch {
            try {
                val result = withContext(Dispatchers.IO) {
                    AuthRepository.login(email, password)
                }

                result.body()?.token?.let { token ->
                    SharedPrefsManager.saveAuthToken(token = token)
                }

                goToHome()
            } catch (e: IOException) {
                ("Please check your internet connection").showToast(requireContext())
            } catch (e: HttpException) {
                ("Server error: ${e.code()}").showToast(requireContext())
            } catch (e: Exception) {
                ("Unexpected error: ${e.localizedMessage}").showToast(requireContext())
            }

        }
    }

    fun goToHome() {
        val action = LoginFragmentDirections.actionLoginFragmentToAuthenticationNavigation()
        findNavController().navigate(action)
    }

    fun goToRegister(email: String) {
        val action = LoginFragmentDirections.actionLoginFragmentToRegisterFragment(email)
        findNavController().navigate(action)
    }
}