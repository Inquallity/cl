package com.inq.cleanexample.presentation.main

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.inq.cleanexample.core.domain.MainPresentationBoundary
import com.inq.cleanexample.presentation.R

class MainActivity : AppCompatActivity(R.layout.ac_main) {

    private lateinit var presenter: MainPresenter

    private lateinit var loading: View
    private lateinit var button: View
    private lateinit var token: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        presenter = MainPresenter(
            this,
            MainPresentationBoundary.Factory().create(this)
        )
        super.onCreate(savedInstanceState)
        loading = findViewById(R.id.progress_indicator)
        button = findViewById(R.id.generate_user_token)
        token = findViewById(R.id.user_token)

        button.setOnClickListener { presenter.performAcquireUserToken() }
    }

    fun showLoading() {
        loading.visibility = View.VISIBLE
        button.visibility = View.GONE
        token.visibility = View.GONE
    }

    fun showToken(token: String) {
        loading.visibility = View.GONE
        button.visibility = View.GONE
        this.token.visibility = View.VISIBLE
        this.token.text = token
    }

    fun showButton() {
        loading.visibility = View.GONE
        button.visibility = View.VISIBLE
        token.visibility = View.GONE
        token.text = ""
    }

}