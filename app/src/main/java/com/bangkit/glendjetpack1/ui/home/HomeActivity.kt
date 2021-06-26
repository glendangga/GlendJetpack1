package com.bangkit.glendjetpack1.ui.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.Menu
import android.view.MenuItem
import com.bangkit.glendjetpack1.R
import com.bangkit.glendjetpack1.databinding.ActivityHomeBinding
import com.bangkit.glendjetpack1.ui.favorite.FavoriteActivity
import com.bangkit.glendjetpack1.ui.reminder.ReminderActivity
import dagger.android.support.DaggerAppCompatActivity

class HomeActivity : DaggerAppCompatActivity() {
    private var activityHomeBinding: ActivityHomeBinding? = null
    private val binding get() = activityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        activityHomeBinding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        val sectionsPagerAdapter = SectionsPagerAdapter(this, supportFragmentManager)
        binding?.viewPager?.adapter = sectionsPagerAdapter
        binding?.tabs?.setupWithViewPager(binding?.viewPager)

        supportActionBar?.elevation = 0f

        activityHomeBinding!!.btnFavor.setOnClickListener {
            val i = Intent(this, FavoriteActivity::class.java)
//            delay1()
            startActivity(i)
            finish()
        }

    }

//    private fun delay1() {
//        Handler(Looper.getMainLooper()).postDelayed({
//            activityHomeBinding.ImageButton.btnFavor = getString(R.string.delay1)
//        }, 2000)
//    }

    override fun onDestroy() {
        super.onDestroy()
        activityHomeBinding = null
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.reminder -> {
                val mIntent = Intent(this, ReminderActivity::class.java)
                startActivity(mIntent)
            }
            R.id.action_favorite -> {
                val mIntent = Intent(this, FavoriteActivity::class.java)
                startActivity(mIntent)

            }
        }
        return super.onOptionsItemSelected(item)
    }


}