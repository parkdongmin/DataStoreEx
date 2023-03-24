package com.example.datastoreex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.datastoreex.Application.SampleApplication
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        CoroutineScope(Dispatchers.Main).launch {
            val text = "Sample"
            SampleApplication.getInstance().getDataStore().setText(text)
        }

        CoroutineScope(Dispatchers.Main).launch {
            //계속
//            SampleApplication.getInstance().getDataStore().text.collect{ it ->
//                Log.d("text","$it")
//            }
            //한번만 불러오기
            val text = SampleApplication.getInstance().getDataStore().text.first()

                Log.d("text","$text")
        }


    }
}