package com.bisha.paw.presentation.vet

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bisha.paw.R
import com.bisha.paw.data.model_ui.Vet
import com.bisha.paw.databinding.FragmentVetBinding
import com.bisha.paw.presentation.viewmodel.MainViewModel
import com.bisha.paw.utils.observeLiveData

class VetFragment : Fragment() {

    private var binding: FragmentVetBinding? = null
    private lateinit var vetAdapter: VetAdapter
    private var vets = arrayListOf<Vet>()

    private val viewModel: MainViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_vet, container, false)

        val rvVet: RecyclerView = view.findViewById(R.id.rvVet)
        val linearLayoutManager = object : LinearLayoutManager(requireContext()) {
            override fun canScrollVertically() = false
        }

        vetAdapter = VetAdapter {
            VetDetailActivity.start(requireContext(), it)
        }

        rvVet.apply {
            setHasFixedSize(true)
            layoutManager = linearLayoutManager
            adapter = vetAdapter
        }

        initProcess()
        initObservers()

        return view
    }

    private fun initProcess() {
        viewModel.getVets()
    }

    private fun initObservers() {
        viewModel.vetsResult.observeLiveData(
            owner = viewLifecycleOwner,
            context = requireContext(),
            onSuccess = {
                vets.addAll(it)
                vetAdapter.setList(vets)
            }
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}