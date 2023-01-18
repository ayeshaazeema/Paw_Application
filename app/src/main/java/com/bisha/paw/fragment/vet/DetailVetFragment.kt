package com.bisha.paw.fragment.vet

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import com.bisha.paw.R
import com.bisha.paw.databinding.FragmentDetailVetBinding

class DetailVetFragment : Fragment(){

    private lateinit var binding: FragmentDetailVetBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentDetailVetBinding.inflate(layoutInflater)

        val items = listOf("Monday,April 25 2022", "Wednesday,April 27 2022", "Saturday,April 30 2022","Sunday,May 1 2022")
//        val adapter = activity?.let {
//            ArrayAdapter<String>(
//                it,
//                android.R.layout.dropdown_item, items,
//            )
        }
//        val adapter = ArrayAdapter(this, R.layout.dropdown_item, items)
//        binding.dropdownField.setAdapter(adapter)
    }
//}