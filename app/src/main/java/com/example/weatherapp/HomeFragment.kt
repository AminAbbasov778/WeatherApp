package com.example.weatherapp

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.weatherapp.databinding.FragmentHomeBinding
import android.view.inputmethod.EditorInfo
import androidx.fragment.app.viewModels
import com.example.weatherapp.adapter.WeatherAdapter
import com.example.weatherapp.objects.Extension.gone
import com.example.weatherapp.viewModel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint
import com.example.weatherapp.objects.Extension.loadurl
import com.example.weatherapp.objects.Extension.visible
import com.example.weatherapp.responseModel.ForecastResponseForDay
import android.graphics.Color
import com.example.weatherapp.UseCases.UseCaseCollector
import com.example.weatherapp.adapter.FiveDaysForecastAdapter
import com.example.weatherapp.objects.mysharedpreferencekeys
import com.example.weatherapp.responseModel.AverageForecast
import javax.inject.Inject

@AndroidEntryPoint
class HomeFragment : Fragment() {
    lateinit var binding: FragmentHomeBinding
    private val viewmodel: HomeViewModel by viewModels<HomeViewModel>()
    lateinit var weatheradapter: WeatherAdapter
    lateinit var fiveDaysForecastAdapter: FiveDaysForecastAdapter


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        weatheradapter = WeatherAdapter()
        fiveDaysForecastAdapter = FiveDaysForecastAdapter()
        changesinrecview()
        observe()
        clickonevents()


    }

    fun observe() {
        viewmodel.immutableforecastresponseforday.observe(viewLifecycleOwner) {
            it?.let { forecastresponseforday ->
                binding.placeid.text = it.name
                binding.mainweatherdegree.text = it.main.tempInt.toString() + "°"
                binding.tempmin.text = "Min Temp " + it.main.tempMinInt.toString() + "°"
                binding.tempmax.text = "Max Temp " + it.main.tempMaxInt.toString() + "°"
                binding.feelslike.text = "Feels like " + it.main.feelsLikeInt + "°"
                binding.mainweathertext.text = forecastresponseforday.weather[0].main
                forecastresponseforday.weather[0].iconurl?.let { iconurl ->
                    binding.mainweatherimage.loadurl(iconurl)
                }
                createweatherrec(forecastresponseforday)


            }
        }


        viewmodel.immutabledate.observe(viewLifecycleOwner){ date ->
            binding.dateid.text = date
        }



        viewmodel.combinedtomorrowlivedata.observe(viewLifecycleOwner){values ->
            var tomorrowdate = values[1]
            binding.dateid.text = tomorrowdate.toString()
        }


        viewmodel.immutablehourlyForecast.observe(viewLifecycleOwner) {
            weatheradapter.updatehourlyforecast(it)
        }


        viewmodel.immutablefivedaysforecast.observe(viewLifecycleOwner) {
            createfivedaysforecastrec(it)
        }


    }

    fun clickonevents() {
        binding.searchicon.setOnClickListener() {
            binding.actbackicon.visible()
            binding.citynameedittextcardview.visible()
            binding.placeid.gone()
            binding.searchicon.gone()

        }

        binding.citynameedittext.setOnEditorActionListener { v, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                var cityname = binding.citynameedittext.text.toString()
                viewmodel.savecityname( mysharedpreferencekeys.cityname,cityname)
                viewmodel.getweatherdata(cityname)

                true
            } else {
                false
            }
        }
        binding.actbackicon.setOnClickListener() {
            binding.actbackicon.gone()
            binding.citynameedittextcardview.gone()
            binding.placeid.visible()
            binding.searchicon.visible()
        }

        binding.tomorrowbutton.setOnClickListener() {
            viewmodel.savebooleanvalue(mysharedpreferencekeys.tomorrowbutton, true)
            viewmodel.savebooleanvalue(mysharedpreferencekeys.todaybutton, false)
            viewmodel.savebooleanvalue(mysharedpreferencekeys.fivedaysbutton, false)
            viewmodel.getcityname(mysharedpreferencekeys.cityname,mysharedpreferencekeys.defaultcityname)


        }
        binding.todaybutton.setOnClickListener() {

            viewmodel.savebooleanvalue(mysharedpreferencekeys.tomorrowbutton, false)
            viewmodel.savebooleanvalue(mysharedpreferencekeys.todaybutton, true)
            viewmodel.savebooleanvalue(mysharedpreferencekeys.fivedaysbutton, false)



        }
        binding.fivedaysbutton.setOnClickListener() {

            viewmodel.savebooleanvalue(mysharedpreferencekeys.tomorrowbutton, false)
            viewmodel.savebooleanvalue(mysharedpreferencekeys.todaybutton, false)
            viewmodel.savebooleanvalue(mysharedpreferencekeys.fivedaysbutton, true)


        }


    }

    fun createweatherrec(element: ForecastResponseForDay) {
        binding.weatherrec.adapter = weatheradapter
        weatheradapter.updateforecast(element)


    }

    fun createfivedaysforecastrec(list: ArrayList<AverageForecast>) {
        binding.weatherrec.adapter = fiveDaysForecastAdapter
        fiveDaysForecastAdapter.updatelist(list)
    }

    fun changesinrecview() {
        viewmodel.getbooleanvalue(mysharedpreferencekeys.todaybutton)
        viewmodel.getbooleanvalue(mysharedpreferencekeys.tomorrowbutton)
        viewmodel.getbooleanvalue(mysharedpreferencekeys.fivedaysbutton)
        viewmodel.getcityname(mysharedpreferencekeys.cityname,mysharedpreferencekeys.defaultcityname)


        viewmodel.combinedlivedata.observe(viewLifecycleOwner) { values ->
            viewmodel.getdate()
            var today = values[0]
            var tomorrow = values[1]
            var fivedays = values[2]
            var cityname = values[3]
            if (today == true) {
                binding.todaybuttoncardview.setCardBackgroundColor(Color.parseColor("#EBDEFF"))
                binding.tomorrowbuttoncardview.setCardBackgroundColor(Color.WHITE)
                binding.fivedaysbuttoncardview.setCardBackgroundColor(Color.WHITE)
                viewmodel.getweatherdata(cityname.toString())
                viewmodel.gethourlyforecastdata(cityname.toString(), "9")

            } else if (tomorrow == true) {
                binding.tomorrowbuttoncardview.setCardBackgroundColor(Color.parseColor("#EBDEFF"))
                binding.todaybuttoncardview.setCardBackgroundColor(Color.WHITE)
                binding.fivedaysbuttoncardview.setCardBackgroundColor(Color.WHITE)
                viewmodel.getweatherdata(cityname.toString())
                viewmodel.gethourlyforecastdata(cityname.toString(), "19")


            } else if (fivedays == true) {
                binding.tomorrowbuttoncardview.setCardBackgroundColor(Color.WHITE)
                binding.fivedaysbuttoncardview.setCardBackgroundColor(Color.parseColor("#EBDEFF"))
                binding.todaybuttoncardview.setCardBackgroundColor(Color.WHITE)
                viewmodel.getweatherdata(cityname.toString())
                viewmodel.gethourlyforecastdata(cityname.toString(), "70")

            }
        }


    }


}