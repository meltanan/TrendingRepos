package com.example.trendingrepos.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplication.data.RepoItem
import com.example.trendingrepos.R
import com.example.trendingrepos.SelectListener

class TrendingRepoAdapter(private val trendingRepos: List<RepoItem>, private val listener: SelectListener): RecyclerView.Adapter<TrendingRepoAdapter.ViewHolder>()  {
    private val topReposLimit = 3
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.trending_repo_row, parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Glide.with(holder.imageView).load(trendingRepos[position].owner?.image).into(holder.imageView)
        holder.name.text = "Name: ${trendingRepos[position].name}"
        holder.watchers.text = "Watchers: ${trendingRepos[position].watchers.toString()}"
        holder.language.text = "Language: ${trendingRepos[position].language}"
        holder.privacy.text = "Visibility: ${trendingRepos[position].visibility}"
        holder.openIssue.text = "Open issue: ${trendingRepos[position].openIssues.toString()}"
        holder.defaultBranch.text = "Branch: ${trendingRepos[position].defaultBranch}"
        holder.cardView.setOnClickListener{
            listener.onItemSelect(trendingRepos[position].owner?.url)
        }
    }

    override fun getItemCount(): Int = topReposLimit

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val cardView: CardView = itemView.findViewById(R.id.cardView)
        val imageView: ImageView = itemView.findViewById(R.id.repo_image_view)
        val name: TextView = itemView.findViewById(R.id.repo_name_text_view)
        val watchers: TextView = itemView.findViewById(R.id.repo_watchers_text_view)
        val language: TextView = itemView.findViewById(R.id.repo_language_text_view)
        val privacy: TextView = itemView.findViewById(R.id.repo_visibility_text_view)
        val openIssue: TextView = itemView.findViewById(R.id.repo_open_issues_text_view)
        val defaultBranch: TextView = itemView.findViewById(R.id.repo_default_branch_text_view)
    }
}