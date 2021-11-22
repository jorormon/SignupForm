package com.jordiortuno.signupform.framework.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.jordiortuno.signupform.databinding.HomeFragmentBinding
import com.jordiortuno.signupform.domain.ResultWrapper
import com.jordiortuno.signupform.framework.ui.common.showToast

class HomeFragment : Fragment() {
    private val viewModel by viewModels<HomeViewModel>()
    private var _binding: HomeFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = HomeFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getUser.observe(viewLifecycleOwner, Observer {
            when(it){
                is ResultWrapper.Success ->{
                    context?.showToast(it.value.email, Toast.LENGTH_LONG)
                }
                else -> {}
            }
        })
        binding.closeSession.setOnClickListener {
            viewModel.getUser()
        }
    }

    private fun closeSession() {
        (activity as MainActivity).closeSession()
    }
}