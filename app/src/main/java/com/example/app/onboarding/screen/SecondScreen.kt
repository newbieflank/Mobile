package com.example.app.onboarding.screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.viewpager2.widget.ViewPager2
import com.example.app.R

class SecondScreen : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_second_screen, container, false)

        val NextButton: TextView = view.findViewById(R.id.next2)
        val viewPager = activity?.findViewById<ViewPager2>(R.id.viewPager)

        NextButton.setOnClickListener {
            viewPager?.currentItem = 2
        }

        return view
    }
}