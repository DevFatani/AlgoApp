package com.algorithmers.android.algoapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView

class TestActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)

        val view = findViewById(R.id.web_test) as WebView


        var html =
                "<html>" +
                        "<head>" +
                        "<style type=\"text/css\">" +
                        "@font-face{" +
                        "font-family: MyFont;" +
                        "src: url(\"file:///android_asset/fonts/Midan.ttf\")}" +
                        "body{" +
                        "font-family: MyFont;" +
                        "font-size: 26px;" +
                        "text-align: justify;}</style>" +
                        "</head>" +
                        "<body dir=\"rtl\">" +
                        "اهلا وسهلا بكم في عالم اندرويد، حيث نتعلم سويا بناء تطبيقات اندرويد بإحترافية" +
                        "</body>" +
                        "</html>"

        view.loadDataWithBaseURL(null, html, "text/html; charset=UTF-8", "utf-8", null)
    }
}
