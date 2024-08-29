package com.example.app.onboarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import androidx.viewpager2.widget.ViewPager2
import android.view.ViewGroup
import com.example.app.onboarding.screen.FirstScreen
import com.example.app.onboarding.screen.SecondScreen
import com.example.app.onboarding.screen.ThirdScreen
import com.example.app.R


class ViewPagerFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_view_pager, container, false)

        val fragmentList = arrayListOf<Fragment>(
            FirstScreen(),
            SecondScreen(),
            ThirdScreen()
        )

        val adapter = ViewPagerAdapter(
            fragmentList,
            requireActivity().supportFragmentManager,
            lifecycle
        )

        val viewPager = view.findViewById<ViewPager2>(R.id.viewPager)
        viewPager.adapter = adapter

        return view
    }
}