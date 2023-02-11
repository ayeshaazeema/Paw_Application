package com.bisha.paw.fragment.food

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.bisha.paw.R


class FoodDetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_food_detail, container, false)

        val btnShop: Button = view.findViewById(R.id.btnShop)

        btnShop.setOnClickListener {
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data = Uri.parse("https://shopee.co.id/whiskas.id")

            startActivity(openURL)
        }

        return view
    }
}

//        btnShop.setOnclickListener {
//            val openURL = Intent(intent.ACTION_VIEW)
//            openURL.data = Uri.parse("https://shopee.co.id/whiskas.id")
//
//            startActivity(openURL)
//        }
//
//
