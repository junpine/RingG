package com.example.ringg

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import android.widget.VideoView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val v: VideoView = findViewById(R.id.videoView)
        //경로 (영상 raw폴더내에 교체필요)
        v.setVideoPath("android.resource://com.example.RingG/" + R.raw.testvid)
        v.start()

        val btn = findViewById<Button>(R.id.skipBtn)
        btn.setOnClickListener {
            val myIntent = Intent(this, CamAccess::class.java)
            startActivity(myIntent)
        }
    }

    var mBackWait: Long = 0

    override fun onBackPressed() {
        if (System.currentTimeMillis() - mBackWait >= 2000) {
            mBackWait = System.currentTimeMillis()
            Toast.makeText(this, "뒤로가기 버튼을 한번 더 누르면 종료됩니다.", Toast.LENGTH_SHORT).show()
        } else {
            finish()
        }
    }
}
