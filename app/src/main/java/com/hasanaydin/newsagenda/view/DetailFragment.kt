package com.hasanaydin.newsagenda.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.hasanaydin.newsagenda.data.ArticlesData
import com.hasanaydin.newsagenda.model.DetailViewModel
import com.hasanaydin.newsagenda.databinding.FragmentDetailBinding
import com.hasanaydin.newsagenda.service.NewsAPIService

class DetailFragment : Fragment() {

    private var _binding : FragmentDetailBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: DetailViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {





        viewModel = ViewModelProvider(this).get(DetailViewModel::class.java)

        _binding = FragmentDetailBinding.inflate(inflater,container,false)
        val view = binding.root

        arguments?.let {

            if (it.containsKey("article")){

                val x =  it.get("article") as ArticlesData
               /* binding.detailTitle.text = x.title
                Glide.with(binding.detailImage.context)
                    .load(x.urlToImage)
                    .into(binding.detailImage)

                binding.textView.text = x.content*/

                val myWebView: WebView = binding.webWiew
                myWebView.loadUrl(x.url)


            }

        }

        return view

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}