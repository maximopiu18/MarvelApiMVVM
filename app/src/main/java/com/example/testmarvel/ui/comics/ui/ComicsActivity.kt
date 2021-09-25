package com.example.testmarvel.ui.comics.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.core.mvvm.login.viewmodel.ComicsViewModel
import com.example.testmarvel.ui.comics.model.Comics
import com.example.testmarvel.R
import com.example.testmarvel.ui.comics.model.ResponseComics
import com.example.testmarvel.ui.comics.ui.adapter.AdapterComicsList

class ComicsActivity : AppCompatActivity() {
    lateinit var recyclerComics : RecyclerView
    lateinit var adapterComics : AdapterComicsList
    private var comicsViewModel: ComicsViewModel? = null
    private lateinit var responsComics : ResponseComics

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comics)
        recyclerComics = findViewById(R.id.activity_comics_rv_comics)
        getViewModelComics()
    }

    fun  getViewModelComics() {
        comicsViewModel = ViewModelProviders.of(this).get(ComicsViewModel::class.java)
        comicsViewModel!!.initRequest()
        comicsViewModel!!.newsRepository()!!.observe(this, Observer<Any?> {
           responsComics = comicsViewModel!!.getModelResponse()!!
            updateRecyclerView(responsComics!!.data!!.results!!)
        })
    }

    private fun updateRecyclerView(list: ArrayList<Comics>){
        adapterComics = AdapterComicsList(list, this)
        val mLayoutManager: RecyclerView.LayoutManager = GridLayoutManager(this, 1)
        recyclerComics.setLayoutManager(mLayoutManager)
        recyclerComics.setHasFixedSize(false)
        recyclerComics.setNestedScrollingEnabled(false)
        recyclerComics.setAdapter(adapterComics)
    }
}