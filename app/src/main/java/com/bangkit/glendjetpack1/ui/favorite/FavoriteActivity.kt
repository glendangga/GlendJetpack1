package com.bangkit.glendjetpack1.ui.favorite

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bangkit.glendjetpack1.R
import com.bangkit.glendjetpack1.databinding.ActivityFavoriteBinding
import com.bangkit.glendjetpack1.ui.home.HomeActivity
import dagger.android.support.DaggerAppCompatActivity

class   FavoriteActivity : DaggerAppCompatActivity() {
    private var activityFavoriteBinding: ActivityFavoriteBinding? = null
    private val binding get() = activityFavoriteBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favorite)


        activityFavoriteBinding = ActivityFavoriteBinding.inflate(layoutInflater)
        val activityHomeBinding = ActivityFavoriteBinding.inflate(layoutInflater)
        setContentView(binding?.root)


        val sectionsPagerAdapter = SectionsPagerAdapter(this, supportFragmentManager)
        binding?.viewPager?.adapter = sectionsPagerAdapter
        binding?.tabs?.setupWithViewPager(binding?.viewPager)

        supportActionBar?.elevation = 0f

        activityHomeBinding.btnFavorite.setOnClickListener {
            val i = Intent(this, HomeActivity::class.java)
            startActivity(i)
            finish()
        }

    }
}