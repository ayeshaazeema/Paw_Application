package com.bisha.paw.fragment.dashboard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bisha.paw.R

class DashboardFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_dashboard, container, false)

        val rvArticleDashboard = view.findViewById<RecyclerView>(R.id.rvArticleDashboard)
        val rvFoodDashboard = view.findViewById<RecyclerView>(R.id.rvFoodDashboard)

        // TODO: Make your adapter

        return view
    }
}


//class DashboardFragment : Fragment() {
//
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_dashboard, container, false)
//    }
//}