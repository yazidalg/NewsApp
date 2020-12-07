package com.example.detikcom

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import coil.api.load
import com.example.detikcom.R
import com.example.detikcom.databinding.ActivityDetailNewsBinding
import kotlinx.android.synthetic.main.activity_detail_news.*
import kotlinx.android.synthetic.main.cdv_news_headline.*

class DetailNews : AppCompatActivity() {

    private lateinit var binding: ActivityDetailNewsBinding
    companion object{
        const val date = "date"
        const val content = "content"
        const val image = "image"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_news)

        val tanggal = intent.getStringExtra(date)
        val contents = intent.getStringExtra(content)
        val detailImage = intent.getStringExtra(image)

        txtDate.text = tanggal
        txtContent.text = contents
        detailImageView.load(detailImage)
    }
}