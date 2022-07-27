package com.example.trendingrepos.ui

import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ProgressBar
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.data.RepoItem
import com.example.trendingrepos.R
import com.example.trendingrepos.SelectListener

/**
 * A simple [Fragment] subclass.
 * Use the [TrendingRepoFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class TrendingRepoFragment : Fragment(), SelectListener {

    private val viewModel: HomeActivityViewModel by activityViewModels()
    lateinit var recyclerView: RecyclerView
    lateinit var progressBar: ProgressBar
    lateinit var mProgressBar: ProgressBar
    lateinit var webView: WebView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_trending_repo, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        progressBar = view.findViewById(R.id.progressBar)
        mProgressBar = view.findViewById(R.id.mProgressBar)
        webView = view.findViewById(R.id.webView)
        viewModel.trendingRepos.value?.toString()?.let { Log.d("demo", it) }
        viewModel.trendingRepos.observe(requireActivity()){
            if (it.isNotEmpty()) {
                progressBar.visibility = View.GONE
                mProgressBar.visibility = View.GONE
                setUpUi(it)
            }
        }

        webView.setOnKeyListener { _, _, keyEvent ->
            if (keyEvent.keyCode == KeyEvent.KEYCODE_BACK && webView.canGoBack()) {
                webView.goBack()
                true
            }
            else {
                false
            }
        }
    }

    private fun setUpUi(trendingRepos: List<RepoItem>) {
        recyclerView.adapter = TrendingRepoAdapter(trendingRepos, this)
    }

    override fun onItemSelect(url: String?) {
        url?.let {
            webView.apply {
                webView.visibility = View.VISIBLE
                loadUrl(it)
                webViewClient = WebViewClient()
                settings.javaScriptEnabled = true
            }
        }
    }
}