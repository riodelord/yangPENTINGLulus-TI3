package com.yangPentingLulus.DCEMS.ui.dashboard

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.yangPentingLulus.DCEMS.ConfigActivity
import com.yangPentingLulus.DCEMS.MyData
import com.yangPentingLulus.DCEMS.R
import com.yangPentingLulus.DCEMS.adapter.CardViewMyDataAdapter
import kotlinx.android.synthetic.main.fragment_dashboard.*


class DashboardFragment : Fragment() {

    private lateinit var dashboardViewModel: DashboardViewModel
    private val list = ArrayList<MyData>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dashboardViewModel =
            ViewModelProviders.of(this).get(DashboardViewModel::class.java)
        val rootView = inflater.inflate(R.layout.fragment_dashboard, container, false)
        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dashboard_recyclerview.layoutManager = LinearLayoutManager(activity)
        list.addAll(getListMyDatas())
        dashboard_recyclerview.adapter = CardViewMyDataAdapter(list)

        settingsBtn.setOnClickListener{
            moveToSettingsActivity()
        }
    }
    private fun moveToSettingsActivity() {
        val i = Intent(activity, ConfigActivity::class.java)
        startActivity(i)
        (activity as Activity?)!!.overridePendingTransition(0, 0)
    }

    fun getListMyDatas(): ArrayList<MyData> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataTemperature = resources.getStringArray(R.array.data_temperature)
        val dataHumidity = resources.getStringArray(R.array.data_humidity)
        val dataStatus = resources.getStringArray(R.array.data_status)
        val listMyData = ArrayList<MyData>()
        for (position in dataName.indices) {
            val myData = MyData(
                dataName[position],
                dataTemperature[position],
                dataHumidity[position],
                dataStatus[position]
            )
            listMyData.add(myData)
        }
        return listMyData
    }
}