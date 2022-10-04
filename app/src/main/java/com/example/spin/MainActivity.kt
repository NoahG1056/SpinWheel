package com.example.spin

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.webkit.WebView
import android.widget.Button
import androidx.core.view.isVisible

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val webView=findViewById<WebView>(R.id.webview)
        val url=""
        val startButton=findViewById<Button>(R.id.Start)
        val sharedPreferences=getSharedPreferences("sharedPrefs",Context.MODE_PRIVATE)
        fun saveUrlInCache(url:String){
            val sharedPreferences:SharedPreferences=getSharedPreferences("sharedPrefs",Context.MODE_PRIVATE)
            val editor: SharedPreferences.Editor=sharedPreferences.edit()
            editor.apply {
             putString("URL_KEY", url)
            }.apply()
        }
        fun getCachedUrl():String{
            val sharedPreferences=getSharedPreferences("sharedPrefs",Context.MODE_PRIVATE)
            val savedUrl=sharedPreferences.getString("URL_KEY","").toString()
            return savedUrl
        }
        fun IsSameUrls():Boolean{
            return getCachedUrl()==url
        }
        fun loadUrl(url:String){
                webView.loadUrl(url)
        }
             if (sharedPreferences.getBoolean("firstRun",false)==false){
                startButton.isVisible=true
                sharedPreferences.edit().putBoolean("firstRun",true).apply()
                saveUrlInCache(url = url)
            }else{
                when(getCachedUrl()){
                    ""->startButton.isVisible=true

                    else->loadUrl(getCachedUrl())

                }
                 saveUrlInCache(url = url)
            }




        startButton.setOnClickListener{val intent = Intent(this, Spin::class.java)
            startActivity(intent)}






    }
}