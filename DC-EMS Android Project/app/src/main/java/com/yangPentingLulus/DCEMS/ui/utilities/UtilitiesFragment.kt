package com.yangPentingLulus.DCEMS.ui.utilities

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.github.aachartmodel.aainfographics.aachartcreator.AAChartModel
import com.github.aachartmodel.aainfographics.aachartcreator.AAChartType
import com.github.aachartmodel.aainfographics.aachartcreator.AASeriesElement
import com.yangPentingLulus.DCEMS.R
import kotlinx.android.synthetic.main.fragment_utilities.*
import kotlinx.android.synthetic.main.fragment_utilities.view.*

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
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val todayKWHChartModel : AAChartModel = AAChartModel()
            .chartType(AAChartType.Area)
            .title("Electicity Usage")
            .subtitle("Current Month")
            .yAxisTitle("mW")
            .backgroundColor("#ffffff")
            .dataLabelsEnabled(true)
            .series(arrayOf(
                AASeriesElement()
                    .name("Siang")
                    .data(arrayOf(7.0, 6.9, 9.5, 14.5, 18.2, 21.5, 25.2, 26.5, 23.3, 18.3, 13.9, 9.6)),
                AASeriesElement()
                    .name("Malam")
                    .data(arrayOf(3.9, 4.2, 5.7, 8.5, 11.9, 15.2, 17.0, 16.6, 14.2, 10.3, 6.6, 4.8))
            )
            )
        today_kwh_chart.aa_drawChartWithChartModel(todayKWHChartModel)
    }
}