package com.example.fragmentsversion3

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.fragmentsversion3.databinding.DataFragmentBinding

class DataFragment : Fragment() {

    private lateinit var binding: DataFragmentBinding

    var data : String = ""
    set(value) {
        field = value
        binding.txtData.text = field
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataFragmentBinding.inflate(inflater)

        //way 1
        /*binding.btnUpdateData.setOnClickListener {
            (activity as MainActivity).sendDataToFormFragment("$data -- Updated Data")
        }

         */

        //way 2
        binding.btnUpdateData.setOnClickListener {
            (parentFragmentManager.findFragmentById(R.id.formFragment) as FormFragment).updatedData = "$data--updated"
        }

        return binding.root
    }
}