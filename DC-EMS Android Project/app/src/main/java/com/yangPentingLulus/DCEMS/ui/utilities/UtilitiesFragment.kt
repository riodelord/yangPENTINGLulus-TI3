package com.yangPentingLulus.DCEMS.ui.utilities

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.yangPentingLulus.DCEMS.R

class UtilitiesFragment : Fragment() {

    private lateinit var utilitiesViewModel: UtilitiesViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        utilitiesViewModel =
            ViewModelProviders.of(this).get(UtilitiesViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_utilities, container, false)
        val textView: TextView = root.findViewById(R.id.text_utilities)
        utilitiesViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}