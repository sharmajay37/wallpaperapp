package com.example.wallpaper

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.SearchView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.wallpaper.Api.RetrofitInstance
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var searchView: SearchView
    private lateinit var nextPageButton: Button
    private var currentPage = 1
    private var currentQuery: String? = null
    private val apiKey = "259hOn80MdLSaH5uvj8xkd0PmeNgQHK8PrNLvJ908mQ5bOaWLFgkIrO0"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        searchView = findViewById(R.id.searchView)
        nextPageButton = findViewById(R.id.nextPageButton)

        recyclerView.layoutManager = LinearLayoutManager(this)

        loadWallpapers()

        nextPageButton.setOnClickListener {
            currentPage++
            loadWallpapers()
        }

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                currentQuery = query
                currentPage = 1
                loadWallpapers()
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean = false
        })
    }

    private fun loadWallpapers() {
        lifecycleScope.launch {
            try {
                val response = if (currentQuery.isNullOrEmpty()) {
                    RetrofitInstance.api.getWallpapers(currentPage, apiKey = apiKey)
                } else {
                    RetrofitInstance.api.searchWallpapers(currentQuery!!, currentPage, apiKey = apiKey)
                }

                recyclerView.adapter = WallpaperAdapter(response.photos) {
                    val intent = Intent(this@MainActivity, FullScreen::class.java)
                    intent.putExtra("url", it.src.original)
                    startActivity(intent)
                }

            } catch (e: Exception) {
                Toast.makeText(this@MainActivity, "Error: ${e.message}", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
