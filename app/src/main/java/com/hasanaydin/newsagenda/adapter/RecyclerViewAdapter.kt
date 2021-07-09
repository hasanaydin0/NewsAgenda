package com.hasanaydin.newsagenda.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Adapter
import androidx.core.os.bundleOf
import androidx.core.os.persistableBundleOf
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.hasanaydin.newsagenda.R
import com.hasanaydin.newsagenda.data.ArticlesData
import com.hasanaydin.newsagenda.databinding.RowLayoutBinding
import com.hasanaydin.newsagenda.view.MainFragment
import com.hasanaydin.newsagenda.view.MainFragmentDirections

class RecyclerViewAdapter (var dataList : List<ArticlesData>) : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    class ViewHolder (val itemBinding : RowLayoutBinding) : RecyclerView.ViewHolder(itemBinding.root){

        fun bind (articlesData: ArticlesData){

            itemBinding.titleView.text = articlesData.title
            itemBinding.textView.text = articlesData.description
            itemBinding.source.text = "Source: " +articlesData.source.name

            Glide.with(itemBinding.imageView.context)
                .load(articlesData.urlToImage)
                .into(itemBinding.imageView)


            itemBinding.readMoreButton.setOnClickListener {

                val action = MainFragmentDirections.actionMainFragmentToDetailFragment()
                val bundle = bundleOf("article" to articlesData)
                Navigation.findNavController(it).navigate(R.id.action_mainFragment_to_detailFragment,bundle)

            }

        }

    }

    lateinit var adapterLayout : RowLayoutBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        adapterLayout = RowLayoutBinding.inflate(LayoutInflater.from(parent.context))
        return (ViewHolder(adapterLayout))

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(dataList[position])
    }

    override fun getItemCount(): Int {
        return(dataList.size)
    }


}