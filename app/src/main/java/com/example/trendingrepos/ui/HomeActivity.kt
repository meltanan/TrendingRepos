package com.example.trendingrepos.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.activity.viewModels
import androidx.lifecycle.viewModelScope
import com.example.trendingrepos.R
import com.example.trendingrepos.addFragment
import com.example.trendingrepos.showToast
import kotlinx.coroutines.launch

class HomeActivity() : AppCompatActivity() {
    private val viewModel: HomeActivityViewModel by viewModels()
    lateinit var searchEditText: EditText
    lateinit var submitButton: Button
    lateinit var fragmentContainer: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupUi()
    }

    private fun setupUi() {
        searchEditText = findViewById(R.id.search_editText)
        submitButton = findViewById(R.id.submit_button)
        fragmentContainer = findViewById(R.id.fragmentContainerView)

        submitButton.setOnClickListener() {
            if (searchEditText.text.isNullOrEmpty())
                showToast("Input is required")
            else{
                viewModel.viewModelScope.launch {
                    viewModel.testing(searchEditText.text.toString())
                    addFragment<TrendingRepoFragment>(true)
                }
            }
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        addFragment<TrendingRepoFragment>(true)
    }
}