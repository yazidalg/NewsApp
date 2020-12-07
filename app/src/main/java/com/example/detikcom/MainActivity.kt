package com.example.detikcom

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.detikcom.adapter.RvNewsAdapter
import com.example.detikcom.databinding.ActivityMainBinding
import com.example.detikcom.model.Response
import retrofit2.Call
import com.example.detikcom.service.RetrofitBuilder
import retrofit2.Callback
import timber.log.Timber

class  MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val rvAdapter = RvNewsAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Timber.plant(Timber.DebugTree())
        binding = ActivityMainBinding.inflate(layoutInflater)
        with(binding){
            setContentView(root)
            recyclerView.adapter = rvAdapter
            recyclerView.layoutManager = LinearLayoutManager(baseContext)
            recyclerView.setHasFixedSize(true)
        }

        val call = RetrofitBuilder.getService().feachHeadLine()
        call.enqueue(object : Callback<Response> {
            override fun onFailure(call: Call<Response>, t: Throwable){
                Timber.e(t.localizedMessage)
            }
            override fun onResponse(call: Call<Response>, response: retrofit2.Response<Response>){
                Timber.d(response.body()?.totalResults.toString())
                val listArticlesItem = response.body()?.articles
                listArticlesItem.let { it?.let { it1 -> rvAdapter.addData(it1) } }
            }
        })


    }
}
