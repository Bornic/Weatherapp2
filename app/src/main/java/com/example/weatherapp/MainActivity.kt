package com.example.weatherapp

import android.app.DownloadManager.Request
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.weatherapp.databinding.ActivityMainBinding
import com.example.weatherapp.fragment.mainFragment
import org.json.JSONObject
/*
использовалось для отладки сейчас он не нужен
не стал удалять


 */
const val API_KEY = "1ad5b8e48b3a3dc7c36f50be50ae7e0b"

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportFragmentManager.beginTransaction().replace(R.id.PlaceHolder, mainFragment.newInstance()).commit()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.bGet.setOnClickListener {
            getResult("Moscow")
        }
    }

    private fun getResult(name: String){
        val url = "https://api.openweathermap.org/data/2.5/weather?" +
                "q=$name&appid=$API_KEY&units=metric"

        val queue = Volley.newRequestQueue(this)
        val stringRequest = StringRequest(com.android.volley.Request.Method.GET,
            url,
            {
                    response->
                val obj = JSONObject(response)
                val temp = obj.getJSONObject("main")
                Log.d("MyLog","Volley response: ${temp.getString("temp")}")

            },
            {
                Log.d("MyLog","Volley error: $it")
            }

            )
        queue.add(stringRequest)

    }
}