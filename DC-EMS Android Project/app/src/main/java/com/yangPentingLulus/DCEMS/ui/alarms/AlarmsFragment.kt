package com.yangPentingLulus.DCEMS.ui.alarms

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.yangPentingLulus.DCEMS.R
import kotlinx.android.synthetic.main.fragment_alarms.*
import kotlinx.android.synthetic.main.fragment_utilities.*

class AlarmsFragment : Fragment() {

    private lateinit var alarmsViewModel: AlarmsViewModel
    private lateinit var materialAlertDialogBuilder: MaterialAlertDialogBuilder
    private lateinit var customAlertDialogView : View

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        alarmsViewModel =
            ViewModelProviders.of(this).get(AlarmsViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_alarms, container, false)
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        materialAlertDialogBuilder = MaterialAlertDialogBuilder(requireContext())
        alarms_export_button.setOnClickListener(View.OnClickListener {
            customAlertDialogView = LayoutInflater.from(activity)
                .inflate(R.layout.export_dialogue, null, false)

            launchExportAlertDialog()
        })
    }

    private fun launchExportAlertDialog() {
        materialAlertDialogBuilder.setView(customAlertDialogView)
            .setTitle("Export")
            .setMessage("Select Date Range for The Data")
            .setPositiveButton("Export") {
                    dialog, _ ->
                displayMessage("Success!")
                dialog.dismiss()
            }
            .setNegativeButton("Cancel") {
                    dialog, _ ->
                displayMessage("Cancelled")
                dialog.dismiss()
            }
            .show()
    }

    private fun displayMessage(message : String) {
        Toast.makeText(activity, message, Toast.LENGTH_SHORT).show()
    }

}
