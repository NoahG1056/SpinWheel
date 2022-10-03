package com.example.spin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val webView=findViewById<WebView>(R.id.webview)
//        webView.loadUrl("http://www.script-tutorials.com/demos/199/index.html")
        val startButton=findViewById<Button>(R.id.Start)
        startButton.setOnClickListener{val intent = Intent(this, Spin::class.java)
            startActivity(intent)}
    }
}