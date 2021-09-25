package com.example.testmarvel.ui.descriptioncomic

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.testmarvel.R
import com.example.testmarvel.ui.comics.model.Comics

class DescriptionComicActivity :AppCompatActivity(){
    lateinit var imgComic: ImageView;
    lateinit var tvTitle: TextView
    lateinit var tvAuthor: TextView
    lateinit var tvIsbn: TextView
    lateinit var tvDescription : TextView
    lateinit var tvUpc: TextView
    lateinit var tvId: TextView

    lateinit var comic : Comics
   lateinit var imgBack : ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_description_comic)
        tvIsbn = findViewById(R.id.activity_description_comic_tv_isbn)
        tvTitle= findViewById(R.id.activity_description_comic_tv_tittle)
        tvAuthor = findViewById(R.id.activity_description_comic_tv_author)
        tvDescription = findViewById(R.id.activity_description_comic_tv_description)
        tvUpc = findViewById(R.id.activity_description_comic_tv_upc)
        tvId = findViewById(R.id.activity_description_comic_tv_id)

        imgComic = findViewById(R.id.activity_description_comic_img_comic)
        imgBack = findViewById(R.id.activity_description_comic_img_back)
        imgBack.setOnClickListener {
            finish()
        }
        checkoutData()
    }

    fun checkoutData(){
        if(intent.hasExtra("comic")){
            comic = intent.extras!!.getSerializable("comic") as Comics
            tvIsbn.text = "ISBN: "+ comic.isbn
            tvTitle.text = "Tittle: "+ comic.title
            tvDescription.text ="Description: " + comic.description
            tvUpc.text = "UPC: " + comic.upc
            tvId.text = "ID:  " + comic.id
            tvAuthor.text = "Diamond Code: " + comic.diamondCode
            var url =comic.thumbnail!!.path+"."+comic.thumbnail!!.extension!!
            url = url.replace("http","https")
            Glide.with(this).load(url).into(imgComic)
        }
    }
}