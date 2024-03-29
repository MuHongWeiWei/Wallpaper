package com.example.wallpaper.fragment.search

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.wallpaper.databinding.FragmentSearchBinding

/**
 * Author: FlyWei
 * E-mail: tony91097@gmail.com
 * Date: 2023/1/6
 */
class SearchFragment : Fragment() {

    private var mBinding: FragmentSearchBinding? = null
    private val binding get() = requireNotNull(mBinding)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {

        if (mBinding == null) {
            mBinding = FragmentSearchBinding.inflate(inflater, container, false)
            init()
        }

        return binding.root
    }

    private fun init() {
        binding.imageBack.setOnClickListener {
            hideKeyboard()
            findNavController().popBackStack()
        }
    }

    private fun hideKeyboard() {
        val inputMethodManager =
            requireContext().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(binding.inputSearch.windowToken, 0)
    }

    override fun onDestroy() {
        super.onDestroy()
        mBinding = null
    }
}