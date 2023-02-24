package com.bisha.paw.presentation.vet

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.bisha.paw.R
import com.bisha.paw.data.model_ui.Vet
import com.bisha.paw.utils.setImageUrl
import com.bisha.paw.utils.toFormatRupiah

class VetDetailActivity : AppCompatActivity() {

    companion object {
        const val VET_ITEM = "vet_item"

        fun start(context: Context, vet: Vet) {
            context.startActivity(Intent(context, VetDetailActivity::class.java).apply {
                putExtra(VET_ITEM, vet)
            })
        }
    }

    private var vet: Vet? = null
    private var selectedAppoinmentTime: String = ""
    private var schedules = listOf(
        "Monday, April 25 2022",
        "Wednesday, April 27 2022",
        "Saturday, April 30 2022",
        "Sunday, May 1 2022"
    )

    private fun initIntent() {
        vet = intent.getParcelableExtra(VET_ITEM)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vet_detail)
        supportActionBar?.hide()
        initIntent()

        vet?.let { setDetailData(it) }

        val adapter: ArrayAdapter<String> = ArrayAdapter<String>(
            this,
            R.layout.support_simple_spinner_dropdown_item,
            schedules
        )

        val schSpinner: AutoCompleteTextView = findViewById(R.id.schSpinner)
        schSpinner.apply {
            setAdapter(adapter)
            setOnClickListener {
                showDropDown()
            }
            setOnItemClickListener { parent, _, position, _ ->
                val selectedItem = parent.getItemAtPosition(position) as String
                selectedAppoinmentTime = selectedItem
            }
        }

        val btnAppointment: Button = findViewById(R.id.btnAppointment)
        btnAppointment.setOnClickListener {
            VetAppointmentDialog {
                finish()
            }.show(supportFragmentManager, VetAppointmentDialog.VET_DIALOG)
        }
    }

    private fun setDetailData(model: Vet) {
        val ivDetailVet: ImageView = findViewById(R.id.ivVetDetail)
        val tvVetName: TextView = findViewById(R.id.detailVetName)
        val tvVetPlacename: TextView = findViewById(R.id.tvVetLocation)
        val tvVetLocation: TextView = findViewById(R.id.detailVetLocation)
        val tvVetPrice: TextView = findViewById(R.id.tvVetRange)
        val tvVetInfo: TextView = findViewById(R.id.InfoContent)
        val ivBackVet: ImageView = findViewById(R.id.ivBackVet)

        ivBackVet.setOnClickListener {
            finish()
        }

        ivDetailVet.setImageUrl(this, model.urlImage)
        tvVetName.text = model.vetName
        tvVetPlacename.text = model.vetClinic
        tvVetLocation.text = model.vetLocation
        tvVetPrice.text = model.vetPrice.toInt().toFormatRupiah()
        tvVetInfo.text = model.vetInfo
    }
}