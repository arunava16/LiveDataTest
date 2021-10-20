package com.arunava.example.livedatatest.fragmentjourney.fragmenta

import android.app.ProgressDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.arunava.example.livedatatest.R
import com.arunava.example.livedatatest.fragmentjourney.fragmentb.FragmentB

class FragmentA : Fragment() {

    private lateinit var fragmentAViewModel: FragmentAViewModel

    private lateinit var progressDialog: ProgressDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        fragmentAViewModel = ViewModelProvider(this).get(FragmentAViewModel::class.java)

        fragmentAViewModel.getSuccessLiveData().observe(this) {
            progressDialog.dismiss()
            val fragmentB = FragmentB()
            parentFragmentManager.beginTransaction()
                .replace(R.id.contentFrame, fragmentB)
                .addToBackStack("B added")
                .commit()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_a, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        progressDialog = ProgressDialog(requireContext())
        progressDialog.setMessage("Loading...")
        progressDialog.setCancelable(false)

        view.findViewById<Button>(R.id.fragment_a_btn).setOnClickListener {
            progressDialog.show()
            fragmentAViewModel.makeApiCall()
        }
    }

}