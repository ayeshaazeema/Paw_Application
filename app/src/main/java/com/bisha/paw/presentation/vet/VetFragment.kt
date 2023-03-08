package com.bisha.paw.presentation.vet

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bisha.paw.R
import com.bisha.paw.data.model_ui.Food
import com.bisha.paw.data.model_ui.Vet
import com.bisha.paw.databinding.FragmentVetBinding
import com.bisha.paw.presentation.main.PawLoadingDialog
import com.bisha.paw.presentation.viewmodel.MainViewModel
import com.bisha.paw.utils.observeLiveData
import com.bisha.paw.utils.onSearchQueryChanged

class VetFragment : Fragment() {

    private var vets = arrayListOf<Vet>()

    private val viewModel: MainViewModel by viewModels()

    private val vetAdapter: VetAdapter by lazy {
        VetAdapter {
            VetDetailActivity.start(requireContext(), it)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_vet, container, false)

        val rvVet: RecyclerView = view.findViewById(R.id.rvVet)
        val searchView: SearchView = view.findViewById(R.id.svVet)

        val linearLayoutManager = object : LinearLayoutManager(requireContext()) {
            override fun canScrollVertically() = false
        }

        rvVet.apply {
            setHasFixedSize(true)
            layoutManager = linearLayoutManager
            adapter = vetAdapter
        }

        viewModel.getVets()
        initObservers()
        initSearchable(searchView)

        return view
    }

    private fun initObservers() {
        viewModel.vetsResult.observeLiveData(
            owner = viewLifecycleOwner,
            context = requireContext(),
            onSuccess = {
                PawLoadingDialog.hideLoading(childFragmentManager)
                loadVets(it)
            },
            onLoading = {
                PawLoadingDialog.showLoading(childFragmentManager)
            },
            onFailure = {
                PawLoadingDialog.hideLoading(childFragmentManager)
            }
        )
    }

    private fun initSearchable(searchView: SearchView) {
        searchView.queryHint = getString(R.string.search_vet)
        searchView.onSearchQueryChanged {
            if (it.isNotEmpty()) {
                vetAdapter.filter.filter(it)
            } else {
                viewModel.getVets()
            }
        }
    }

    private fun loadVets(data: List<Vet>) {
        vets.clear()
        vets.addAll(data)
        vetAdapter.setList(vets)
    }
}

fun List<Vet>.searchable(query: String): List<Vet> {
    val searchQuery = query.lowercase()
    val originalList = this
    return this.filter {
        it.vetName.lowercase().contains(searchQuery) ||
                it.vetClinic.lowercase().contains(searchQuery) ||
                it.vetInfo.lowercase().contains(searchQuery) ||
                it.vetLocation.lowercase().contains(searchQuery) ||
                it.vetPrice.lowercase().contains(searchQuery)
    }.ifEmpty { originalList }
}