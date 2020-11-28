package com.yangPentingLulus.DCEMS.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
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
    }

    fun getListMyDatas(): ArrayList<MyData> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val listMyData = ArrayList<MyData>()
        for (position in dataName.indices) {
            val myData = MyData(
                dataName[position],
                dataDescription[position]
            )
            listMyData.add(myData)
        }
        return listMyData
    }
}