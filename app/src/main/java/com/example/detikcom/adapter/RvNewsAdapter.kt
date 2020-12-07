package com.example.detikcom.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.api.load
import coil.size.Scale
import com.example.detikcom.DetailNews
import com.example.detikcom.databinding.CdvNewsHeadlineBinding
import com.example.detikcom.model.ArticlesItem

class RvNewsAdapter : RecyclerView.Adapter<RvNewsAdapter.CdvNewsHeadline>(){

    private val listNews: ArrayList<ArticlesItem> = arrayListOf<ArticlesItem>()

    fun addData(rpla: List<ArticlesItem>){
        listNews.clear()
        listNews.addAll(rpla)
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CdvNewsHeadline {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = CdvNewsHeadlineBinding.inflate(layoutInflater, parent, false)
        return CdvNewsHeadline(binding)
    }

    override fun onBindViewHolder(holder: CdvNewsHeadline, position: Int) {
        val data = listNews[position]
        holder.bind(data)
        holder.itemView.setOnClickListener{
            val intent = Intent(it.context, DetailNews::class.java)
            intent.putExtra(DetailNews.date, data.publishedAt)
            intent.putExtra(DetailNews.image, data.urlToImage)
            intent.putExtra(DetailNews.content, data.content)
            it.context.startActivity(intent)

        }

    }


    override fun getItemCount(): Int {
        return listNews.size
    }
    class CdvNewsHeadline(private val binding: CdvNewsHeadlineBinding)
        :RecyclerView.ViewHolder(binding.root){
        fun bind(item: ArticlesItem){
            with(binding){
                txtTitle.text = item.title
                txtSubtitle.text = item.description
                imageView.load(item.urlToImage){
                    scale(Scale.FILL)
                }
            }
        }
    }



}