package com.yangPentingLulus.DCEMS.ui.dashboard

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.*
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
    private var racksArray = ArrayList<Rack>()

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
        dashboard_recyclerview.layoutManager = LinearLayoutManager(activity)
        dashboardViewModel = ViewModelProvider(this)[DashboardViewModel::class.java]
        dashboardViewModel.fetchRackDataTest(21)
        dashboardViewModel.rackListLiveData?.observe(viewLifecycleOwner, Observer {
            list.addAll(getListMyDatas(it))
            dashboard_recyclerview.adapter = CardViewMyDataAdapter(list)
        })
//        dashboardViewModel.fetchRackDataTest(21)
//        dashboardViewModel.rackListLiveData?.observe(viewLifecycleOwner, Observer {
//            println("INI MUNCUL: $it")
////            list.addAll(getListMyDatas(it))
////            dashboard_recyclerview.adapter = CardViewMyDataAdapter(list)
//        })
        //racksArray.add(dashboardViewModel.rackListLiveData)
//        racksArray = fetchRacksData()
//        println("LANJUTANNYA : ${racksArray.get(0).observe(viewLifecycleOwner, Observer{
//            println(it)
//        })}")
//        fetchRackData(21)
        settingsBtn.setOnClickListener {
            moveToSettingsActivity()
        }
    }

    private fun moveToSettingsActivity() {
        val i = Intent(activity, ConfigActivity::class.java)
        startActivity(i)
        (activity as Activity?)!!.overridePendingTransition(0, 0)
    }

    fun getListMyDatas(list: List<Rack>): ArrayList<MyData> {
        val dataName = resources.getStringArray(R.array.data_name)
//        val dataTemperature = resources.getStringArray(R.array.data_temperature)
        var dataTemperature = ArrayList<String>()
        dataTemperature.add("%.1f°C".format(list[0].value_temp))
        dataTemperature.add("24.2°C")
        dataTemperature.add("25.3°C")
        dataTemperature.add("26.1°C")
        val dataHumidity = ArrayList<String>()
        dataHumidity.add("%.0f%%".format(list[0].value_hum))
        dataHumidity.add("47%")
        dataHumidity.add("42%")
        dataHumidity.add("46%")
        val dataStatus = resources.getStringArray(R.array.data_status)
        val listMyData = ArrayList<MyData>()
        println("BISMISLLAH ${list[0].value_temp}")
        for (position in dataName.indices) {
            val myData = MyData(
                dataName[position],
                dataTemperature[position],
//              "${list[0].value_hum}%",
                dataHumidity[position],
                dataStatus[position]
            )
            listMyData.add(myData)
        }
        return listMyData
    }

    fun fetchRackData(id: Int) {
        var temp = ArrayList<Rack>()
    }

    fun fetchRacksData(): ArrayList<Rack> {
        val thIds = createThIds()
        val racks = ArrayList<Rack>()
//        racks.add(fetchRackData(21).get(0))
//        racks.add(fetchRackData(24).get(0))
//        racks.add(fetchRackData(27).get(0))
//        racks.add(fetchRackData(30).get(0))
        return  racks
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