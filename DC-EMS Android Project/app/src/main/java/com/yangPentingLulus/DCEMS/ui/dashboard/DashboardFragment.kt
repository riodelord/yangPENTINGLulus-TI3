package com.yangPentingLulus.DCEMS.ui.dashboard

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.yangPentingLulus.DCEMS.ConfigActivity
import com.yangPentingLulus.DCEMS.MyData
import com.yangPentingLulus.DCEMS.R
import com.yangPentingLulus.DCEMS.adapter.CardViewMyDataAdapter
import com.yangPentingLulus.DCEMS.model.Rack
import kotlinx.android.synthetic.main.fragment_dashboard.*


class DashboardFragment : Fragment() {

    private lateinit var dashboardViewModel: DashboardViewModel
    private val list = ArrayList<MyData>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_dashboard, container, false)
        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val thIds = createThIds()
        val racks = ArrayList<Rack>()
        var temp = ArrayList<Rack>()
        dashboardViewModel = ViewModelProvider(this)[DashboardViewModel::class.java]
        for ((index, value) in thIds.withIndex()) {
            println("value $value with index $index")
            dashboardViewModel.fetchRackData(value)
            dashboardViewModel.rackListLiveData?.observe(viewLifecycleOwner, Observer {
                if (it!=null){
                    temp = it as ArrayList<Rack>
                    racks.add(temp[0])
                }else{
                    Toast.makeText(context, "Terjadi Kesalahan!",Toast.LENGTH_SHORT).show()
                }
            })
        }
        dashboard_recyclerview.layoutManager = LinearLayoutManager(activity)
        list.addAll(getListMyDatas(racks))
        dashboard_recyclerview.adapter = CardViewMyDataAdapter(list)

        settingsBtn.setOnClickListener {
            moveToSettingsActivity()
        }
    }

    private fun moveToSettingsActivity() {
        val i = Intent(activity, ConfigActivity::class.java)
        startActivity(i)
        (activity as Activity?)!!.overridePendingTransition(0, 0)
    }

    fun getListMyDatas(racks: ArrayList<Rack>): ArrayList<MyData> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataTemperature = resources.getStringArray(R.array.data_temperature)
        val dataHumidity = resources.getStringArray(R.array.data_humidity)
        val dataStatus = resources.getStringArray(R.array.data_status)
        val listMyData = ArrayList<MyData>()
        for (position in dataName.indices) {
            val myData = MyData(
                dataName[position],
                racks[position].value_temp!!,
                racks[position].value_hum!!,
                dataStatus[position]
            )
            listMyData.add(myData)
        }
        return listMyData
    }

    fun createThIds(): ArrayList<Int> {
        val thIds = ArrayList<Int>()
        thIds.add(24)
        thIds.add(27)
        thIds.add(30)
        thIds.add(33)

        return thIds
    }


}