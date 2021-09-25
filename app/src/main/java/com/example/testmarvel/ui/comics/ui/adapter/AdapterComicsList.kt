package com.example.testmarvel.ui.comics.ui.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.testmarvel.ui.comics.model.Comics
import com.example.testmarvel.R
import com.example.testmarvel.ui.descriptioncomic.DescriptionComicActivity
import java.util.*

class AdapterComicsList(private var listComics: ArrayList<Comics>, private var context: Context) : RecyclerView.Adapter<AdapterComicsList.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val listItem = layoutInflater.inflate(R.layout.item_comic, parent, false)
        return ViewHolder(listItem)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvTitle.text = listComics[position].title
        holder.tvIsbn.text = listComics[position].isbn
        holder.tvAuthor.text = listComics[position].upc
        var url =listComics[position].thumbnail!!.path+"."+listComics[position].thumbnail!!.extension!!
        url = url.replace("http","https")
        Glide.with(context).load(url).into(holder.imgComic)
        holder.btnShowMore.setOnClickListener {
            val intent = Intent(context, DescriptionComicActivity::class.java)
            var comics = Comics()
            comics = listComics.get(position)
            intent.putExtra("comic",comics)
            context.startActivity(intent)
        }
/*
        Picasso
            .with(context)
            .load(url)
            .resize(400, 200) // resizes the image to these dimensions (in pixel)
            .centerCrop()
            .into(holder.imgBook);*/
    }

    override fun getItemCount(): Int {
        return listComics.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgComic: ImageView
        var tvTitle: TextView
        var tvAuthor: TextView
        var tvIsbn: TextView
        var btnShowMore: Button

        init {
            imgComic = itemView.findViewById<View>(R.id.item_comics_img_comic) as ImageView
            tvTitle = itemView.findViewById<View>(R.id.item_comics_tv_title) as TextView
            tvAuthor = itemView.findViewById<View>(R.id.item_comics_tv_autor) as TextView
            tvIsbn = itemView.findViewById<View>(R.id.item_comics_tv_isbn) as TextView
            btnShowMore = itemView.findViewById<View>(R.id.item_btn_show_more) as Button
        }
    }
}