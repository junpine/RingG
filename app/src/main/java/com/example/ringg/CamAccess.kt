package com.example.ringg

import android.content.ContextParams
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.core.content.ContextCompat
import android.content.pm.PackageManager
import android.util.Log
import android.widget.Toast
import androidx.core.app.ActivityCompat
import java.util.jar.Manifest


class CamAccess : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cam_access)



        var button = findViewById(R.id.snackbar_button) as Button
        button.setOnClickListener {
            checkPermission()
        }
    }

    fun checkPermission() {
        val cameraPermission =
            ContextCompat.checkSelfPermission(this, android.Manifest.permission.CAMERA)

        if (cameraPermission == PackageManager.PERMISSION_GRANTED) {
            startProcess()
        } else {
            requestPermissions()
        }
    }

    val FLAG_CAMERA = 99
    fun requestPermissions() {
        ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.CAMERA), FLAG_CAMERA)
    }

    fun startProcess() {
        Toast.makeText(this,"카메라 실행",Toast.LENGTH_SHORT).show()
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        when(requestCode) {
            FLAG_CAMERA -> {
                if(grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    startProcess()
                } else {
                    finish()
                }
            }
        }
    }
}