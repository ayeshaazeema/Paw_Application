package com.bisha.paw.presentation.vet

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bisha.paw.R
import com.bisha.paw.data.VetModel
import com.bisha.paw.databinding.FragmentVetBinding

class VetFragment : Fragment() {

    private var binding: FragmentVetBinding? = null
    lateinit var rvVet: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_vet, container, false)

        rvVet = view.findViewById(R.id.rvVet)
        val linearLayoutManager = object : LinearLayoutManager(requireContext()) {
            override fun canScrollVertically() = false
        }

        rvVet.apply {
            setHasFixedSize(true)
            layoutManager = linearLayoutManager
            adapter = VetAdapter(VetModel.getVets()) {
                VetDetailActivity.start(requireContext(), it)
            }
        }

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}