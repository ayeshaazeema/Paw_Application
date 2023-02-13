package com.bisha.paw.presentation.vet

import android.content.Context
import android.os.Bundle
import android.os.Parcelable
import android.view.Gravity
import android.view.View
import android.widget.*
import androidx.databinding.DataBindingUtil.setContentView
import androidx.fragment.app.Fragment
import com.bisha.paw.R
import com.bisha.paw.databinding.FragmentDetailVetBinding
import kotlinx.android.synthetic.main.fragment_detail_vet.*

class DetailVetFragment() : Fragment()
//AdapterView.OnItemSelectedListener, Parcelable {
//
//    private lateinit var binding: FragmentDetailVetBinding
//    var schedule = arrayOf("Monday,April 25 2022", "Wednesday,April 27 2022", "Saturday,April 30 2022", "Sunday,May 1 2022")
//    val NEW_SPINNER_ID = 1
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.fragment_detail_vet)
//        binding = FragmentDetailVetBinding.inflate(layoutInflater)
//
//        var schAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, schedule)
//        schAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
//
//        with(sch_spinner)
//        {
//            adapter = schAdapter
//            setSelection(0, false)
//            onItemSelectedListener = this@DetailVetFragment
//            prompt = "Select Schedule"
//            gravity = Gravity.CENTER
//
//        }
//        val spinner = Spinner(this)
//        spinner.id = NEW_SPINNER_ID
//
//        val rl = RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT)
//
//        rl.setMargins(10, 40, 10, 10)
//        relativelayout.addView(spinner)
//
//        schAdapter = ArrayAdapter(this, R.layout.fragment_detail_vet, schedule)
//        schAdapter.setDropDownViewResource(R.layout.dropdown_item)
//
//        with(spinner)
//        {
//            adapter = schAdapter
//            setSelection(0, false)
//            onItemSelectedListener = this@DetailVetFragment
//            layoutParams = rl
//            prompt = "Select Schedule"
//            setPopupBackgroundResource(R.color.material_grey_600)
//
//        }
//    }
//
//    override fun onNothingSelected(parent: AdapterView<*>?) {
//        showToast(message = "Nothing selected")
//    }
//    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
//
//        when (view?.id) {
//            1 -> showToast(message = "Spinner 2 Position:${position} and schedule: ${schedule[position]}")
//            else -> {
//                showToast(message = "Spinner 1 Position:${position} and schedule: ${schedule[position]}")
//            }
//        }
//    }
//
//    private fun showToast(context: Context = applicationContext, message: String, duration: Int = Toast.LENGTH_LONG) {
//        Toast.makeText(context, message, duration).show()
//    }
//
//
//
//
//}

//    lateinit var option : Spinner
//    lateinit var result : TextView
//
//    constructor(parcel: Parcel) : this() {
//
//    }
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//        option = findViewById(R.id.spinner)
//        result = findViewById(R.id.textView)
//
//        val options = arrayOf("Option 1", "Option 2", "Option 3")
//
//        option.adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, options)
//
//        option.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
//            override fun onNothingSelected(parent: AdapterView<*>?) {
//                result.text = "Please select an Option"
//            }
//
//            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
//                result.text = options.get(position)
//            }
//        }
//
//    }
//
//    override fun writeToParcel(parcel: Parcel, flags: Int) {
//
//    }
//
//    override fun describeContents(): Int {
//        return 0
//    }
//
//    companion object CREATOR : Parcelable.Creator<DetailVetFragment> {
//        override fun createFromParcel(parcel: Parcel): DetailVetFragment {
//            return DetailVetFragment(parcel)
//        }
//
//        override fun newArray(size: Int): Array<DetailVetFragment?> {
//            return arrayOfNulls(size)
//        }
//    }

