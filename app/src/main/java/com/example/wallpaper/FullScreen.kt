package com.example.wallpaper

import android.app.DownloadManager
import android.app.WallpaperManager
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.transition.Transition
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.CustomTarget

class FullScreen : AppCompatActivity() {
    private lateinit var imageView: ImageView
    private lateinit var downloadButton: Button
    private lateinit var setWallpaperButton: Button
    private lateinit var imageUrl: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_full_screen)

        imageView = findViewById(R.id.fullImageView)
        downloadButton = findViewById(R.id.downloadButton)
        setWallpaperButton = findViewById(R.id.setWallpaperButton)

        imageUrl = intent.getStringExtra("url") ?: ""
        Glide.with(this).load(imageUrl).into(imageView)

        downloadButton.setOnClickListener {
            downloadImage()
        }

        /*setWallpaperButton.setOnClickListener {
            setWallpaper()
        }*/
    }

    private fun downloadImage() {
        val request = DownloadManager.Request(Uri.parse(imageUrl))
            .setTitle("Wallpaper")
            .setDescription("Downloading wallpaper")
            .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)
            .setDestinationInExternalPublicDir(Environment.DIRECTORY_PICTURES, "wallpaper_${System.currentTimeMillis()}.jpg")

        val manager = getSystemService(DOWNLOAD_SERVICE) as DownloadManager
        manager.enqueue(request)

        Toast.makeText(this, "Download started...", Toast.LENGTH_SHORT).show()
    }

   /* private fun setWallpaper() {
        Glide.with(this)
            .asBitmap()
            .load(imageUrl)
            .into(object : CustomTarget<Bitmap>() {
                override fun onResourceReady(resource: Bitmap, transition: Transition<in Bitmap>?) {
                    val wallpaperManager = WallpaperManager.getInstance(applicationContext)
                    wallpaperManager.setBitmap(resource)
                    Toast.makeText(applicationContext, "Wallpaper set!", Toast.LENGTH_SHORT).show()
                }

                override fun onLoadCleared(placeholder: Drawable?) {}
            })*/
    //}
}
