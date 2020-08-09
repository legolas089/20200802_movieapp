package com.example.a20200802_movieapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_movie_list.*
import kotlinx.android.synthetic.main.cell.*
import java.io.LineNumberReader


/*
Movie Data Class 만들기(ㅇ)
영화정보를 담은 Array List 만들기(O)
RecyclerView Adapter만들기
 */
class MovieListActivity : AppCompatActivity() {

    //영화정보를 담고있는 ArrayList만들기
    val movieList : ArrayList<Movie> = arrayListOf(
        Movie("테넷", 22.433,  "시간의 흐름은...",  "2020-08-26", R.drawable.m2),
        Movie ("소년시절의 너", 17.321, "넌 세상을 지켜...",  "2020-07-09", R.drawable.m4),
        Movie( "덩케르크 이스케이프", 15.842, "역사에 기록되지 않은...", "2020-08-03", R.drawable.m3),
        Movie("짱구는 못말려", 10.954, "짱구 the movie...", "2020-08-07", R.drawable.m1)

    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_list)

        val adapter = MovieAdapter(this, movieList)//Adapter선언
        movieRecycler.adapter = adapter//Recyclerview에 만든 MovieAdapter 세팅

        val lm = LinearLayoutManager(this)//LinearManager선언
        movieRecycler.layoutManager = lm

    }
}