package com.bisha.paw.presentation.vet

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.DialogFragment
import com.bisha.paw.R

class VetAppointmentDialog(
    private val onClick: () -> Unit
) : DialogFragment() {

    companion object {
        const val VET_DIALOG = "vet_dialog"
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dialog?.window?.setBackgroundDrawableResource(R.drawable.dialog_round_corner)
        val view = inflater.inflate(R.layout.dialog_appointment_layout, container, false)

        val btnAppointment = view.findViewById<Button>(R.id.btn_appointment)
        btnAppointment.setOnClickListener {
            onClick()
            dismiss()
        }

        return view
    }

    override fun onStart() {
        super.onStart()
        val width = ((resources.displayMetrics.widthPixels * 0.85) - 37).toInt()
        val height = (resources.displayMetrics.heightPixels * 0.40).toInt()
        dialog?.window?.setLayout(width, ViewGroup.LayoutParams.WRAP_CONTENT)
    }

}