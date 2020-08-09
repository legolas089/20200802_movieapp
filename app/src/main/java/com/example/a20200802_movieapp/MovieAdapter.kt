package com.example.a20200802_movieapp

import android.content.Context
import android.view.LayoutInflater
import android.view.SurfaceHolder
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView

/*
Movie Data Class 만들기(여기!!)
영화정보를 담은 Array List 만들기
RecyclerView Adapter만들기
 */

data class Movie(
    //영화제목, 인기도, 설명, 개봉일, 포스터 url
    val title : String,//영화제목
    val popularity : Double,//인기도
    val description : String,//설명
    val openDate : String,//개봉일
    val posterUrl : Int//포스터url
)

class MovieAdapter ( val context : Context, val movieList: ArrayList<Movie>) : RecyclerView.Adapter<MovieAdapter.Holder>(){
    override fun onCreateViewHolder(parent : ViewGroup, viwType : Int) : Holder {
        //셀 레이아웃 불러오기
        val view = LayoutInflater.from(context).inflate(R.layout.cell , parent, false)
        return Holder(view)
    }
    override fun getItemCount(): Int {
        //셀 갯수 설정(셀 갯수 반환)
        return movieList.size
    }
    override fun onBindViewHolder(holder: Holder, position: Int){
        //각 셀에 맞는 정보 넣기
        holder.bind(movieList[position])
    }

    //Holder: 셀 그 자체.
    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView){
        //셀의 구성요소 불러옴
        val container = itemView.findViewById<ConstraintLayout>(R.id.container)

        val imgPoster = itemView.findViewById<ImageView>(R.id.imgPoster)
        val tvTitle = itemView.findViewById<TextView>(R.id.tvTitle)
        val tvPopularity = itemView.findViewById<TextView>(R.id.tvPopularity)
        val tvDescription = itemView.findViewById<TextView>(R.id.tvDescription)
        val tvOpenDate = itemView.findViewById<TextView>(R.id.tvOpenDate)


        //ArrayList의 데이터를 셀의 레이아웃에 넣어주는 역할]
        fun bind(movie: Movie){
            imgPoster.setImageResource(movie.posterUrl)
            tvTitle.text = movie.title
            tvPopularity.text = "인기도 : "+ movie.popularity
            tvDescription.text = "설명 : "+ movie.description
            tvOpenDate.text = "개봉일 : " + movie.openDate

            container.setOnClickListener{//셀을 클릭했을 때
                Toast.makeText(context, movie.title, Toast.LENGTH_SHORT).show()//영화제목을 toast message로 띄움
            }

        }
    }

}