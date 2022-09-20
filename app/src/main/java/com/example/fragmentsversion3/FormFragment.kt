package com.example.fragmentsversion3

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.fragmentsversion3.databinding.DataFragmentBinding
import com.example.fragmentsversion3.databinding.FormFragmentBinding

class FormFragment : Fragment() {

    private lateinit var binding: FormFragmentBinding

    var updatedData : String = ""
    set(value) {
        field = value
        binding.edtData.setText(field)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FormFragmentBinding.inflate(inflater)

        //way 1
        /* binding.btnSendData.setOnClickListener {
            (activity as MainActivity).sendDataToDataFragment(binding.edtData.text.toString())
        }

        */
       //way 2
       binding.btnSendData.setOnClickListener {
           (parentFragmentManager.findFragmentById(R.id.dataFragment) as DataFragment).data = binding.edtData.text.toString()
       }
        return binding.root
    }
}