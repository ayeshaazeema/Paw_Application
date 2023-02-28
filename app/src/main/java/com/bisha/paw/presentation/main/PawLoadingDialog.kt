package com.bisha.paw.presentation.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager
import com.bisha.paw.R

class PawLoadingDialog : DialogFragment() {

    companion object {
        const val LOADING_DIALOG = "loading_dialog"

        fun showLoading(fragmentManager: FragmentManager) {
            PawLoadingDialog().show(fragmentManager, LOADING_DIALOG)
        }

        fun hideLoading(fragmentManager: FragmentManager) {
            (fragmentManager.findFragmentByTag(LOADING_DIALOG) as? DialogFragment)?.dismiss()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dialog?.window?.setBackgroundDrawableResource(R.drawable.dialog_round_corner)
        return inflater.inflate(R.layout.loading_dialog_layout, container, false)
    }

    override fun onStart() {
        super.onStart()
        val width = ((resources.displayMetrics.widthPixels * 0.85) - 37).toInt()
        val height = (resources.displayMetrics.heightPixels * 0.40).toInt()
        dialog?.window?.setLayout(width, ViewGroup.LayoutParams.WRAP_CONTENT)
    }

}