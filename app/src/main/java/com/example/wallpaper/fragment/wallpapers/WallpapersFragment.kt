package com.example.wallpaper.fragment.wallpapers

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.wallpaper.R
import com.example.wallpaper.databinding.FragmentSearchBinding
import com.example.wallpaper.databinding.FragmentWallpapersBinding

/**
 * Author: FlyWei
 * E-mail: tony91097@gmail.com
 * Date: 2023/1/6
 */
class WallpapersFragment : Fragment(R.layout.fragment_wallpapers) {

    private var mBinding: FragmentWallpapersBinding? = null
    private val binding get() = requireNotNull(mBinding)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {

        if (mBinding == null) {
            mBinding = FragmentWallpapersBinding.inflate(inflater, container, false)
            init()
        }

        return binding.root
    }

    private fun init() {
        setListeners()
    }

    private fun setListeners() {
        binding.imageSearch.setOnClickListener {
            findNavController().navigate(WallpapersFragmentDirections.actionWallpapersFragmentToSearchFragment())
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        mBinding = null
    }
}