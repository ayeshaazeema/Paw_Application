package com.bisha.paw.fragment.vet

import android.content.Context
import android.os.Bundle
import android.os.Parcelable
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.databinding.DataBindingUtil.setContentView
import androidx.fragment.app.Fragment
import com.bisha.paw.R
import com.bisha.paw.databinding.FragmentDetailVetBinding
import kotlinx.android.synthetic.main.fragment_detail_vet.*

class DetailVetFragment() : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_detail_vet, container, false)
    }
}

