package com.example.services

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder
import android.provider.Settings
import java.security.Provider


class MyService:Service() ,MediaPlayer.OnCompletionListener{

    private lateinit var mediaPlayer: MediaPlayer
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        mediaPlayer = MediaPlayer.create(this,Settings.System.DEFAULT_RINGTONE_URI)
        if (!mediaPlayer.isPlaying) {
            mediaPlayer.start()
        }
        mediaPlayer.isLooping = true
        mediaPlayer.start()
        return START_STICKY
    }

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer.stop()
    }
    override fun onCreate() {
        super.onCreate()
        mediaPlayer = MediaPlayer.create(this, Settings.System.DEFAULT_RINGTONE_URI)
        mediaPlayer.setOnCompletionListener(this)
    }

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onCompletion(mp: MediaPlayer?) {
        stopSelf()
    }

    override fun stopService(name: Intent?): Boolean {
        return super.stopService(name)
        mediaPlayer.stop()

    }



}