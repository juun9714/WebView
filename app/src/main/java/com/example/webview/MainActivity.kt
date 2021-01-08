package com.example.webview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebChromeClient
import android.webkit.WebViewClient
import com.example.webview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        var view = binding.root
        setContentView(view)

        binding.webView.settings.javaScriptEnabled = true
        //web에서 js로 구현되어있는 것도 app에서 돌아가게 할거니 ? true !

        /*
          webview에서 새 창이 뜨지 않도록 방지하는 구문
          이걸 하지 않으면 webView 내에서 창이 뜨는게 아니라
          각 폰의 인터넷 앱이 실행되면서 web이 실행되게 된다.
        */
        binding.webView.webViewClient= WebViewClient()
        binding.webView.webChromeClient= WebChromeClient()

        binding.webView.loadUrl("https://www.naver.com")
        //링크 주소를 Load 함

        //근데 지금 backButton 누르면 app이 그냥 꺼짐
    }

    override fun onBackPressed() {
        if(binding.webView.canGoBack()){
            //웹 사이트에서 뒤로갈 페이지가 존재한다면?
            binding.webView.goBack()//웹사이트 뒤로가기 액션 수행
        }else{
            //본래 안드로이드의 back button 기능 수행 (app 종료)
            super.onBackPressed()
        }

    }
}