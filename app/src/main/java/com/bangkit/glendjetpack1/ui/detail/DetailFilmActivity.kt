package com.bangkit.glendjetpack1.ui.detail

import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import com.bangkit.glendjetpack1.R
import com.bangkit.glendjetpack1.data.FilmEntity
import com.bangkit.glendjetpack1.databinding.ActivityDetailFilmBinding
import com.bangkit.glendjetpack1.databinding.ContentDetailFilmBinding
import com.bangkit.glendjetpack1.viewmodel.ViewModelFactory
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.google.android.material.snackbar.Snackbar
import dagger.android.support.DaggerAppCompatActivity
import okhttp3.internal.platform.android.BouncyCastleSocketAdapter.Companion.factory
import javax.inject.Inject

class DetailFilmActivity : DaggerAppCompatActivity() {

    private lateinit var detailContentBinding: ContentDetailFilmBinding
    private var activityDetailFilmBinding: ActivityDetailFilmBinding? = null
    private  val binding get() =  activityDetailFilmBinding

    private lateinit var viewModel: DetailFilmViewModel
    private var menu: Menu? = null

    @Inject
    lateinit var factory: ViewModelFactory


    companion object {
        const val EXTRA_COURSE = "extra_course"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityDetailFilmBinding = ActivityDetailFilmBinding.inflate(layoutInflater)
        detailContentBinding = activityDetailFilmBinding!!.detailContent

        setContentView(activityDetailFilmBinding!!.root)

//        setSupportActionBar(activityDetailFilmBinding?.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)






        viewModel = ViewModelProvider(this@DetailFilmActivity,factory)[DetailFilmViewModel::class.java]

        val extras = intent.extras
        if (extras != null) {
            val id = intent.getIntExtra(EXTRA_COURSE, 0)
            viewModel.setSelectedCourse(id)
            viewModel.getCourse(id).observe(this, { film -> populateCourse(film)})


        }


    }



    private fun populateCourse(filmEntity: FilmEntity?) {

        detailContentBinding.textTitle.text = filmEntity?.title
        detailContentBinding.textDesc.text = filmEntity?.description
        detailContentBinding.textDate.text = resources.getString(R.string.deadline_date, filmEntity?.date)
        val statusFavorite = filmEntity?.isFavorite

        statusFavorite?.let { setFavoriteState(it) }




        Glide.with(this)
            .load("https://image.tmdb.org/t/p/" + "w200" + filmEntity?.imagePath)
            .apply(RequestOptions.placeholderOf(R.drawable.ic_loading)
                .error(R.drawable.ic_error))
            .into(detailContentBinding.imagePoster)

        binding?.fabFavorite?.setOnClickListener {
            setFavorite(filmEntity)
        }

    }

    private fun setFavoriteState(status: Boolean){

        if (status) {
            binding?.fabFavorite?.setImageResource(R.drawable.ic_favorite_true)
        } else {
            binding?.fabFavorite?.setImageResource(R.drawable.ic_favorite_false)
        }

    }

    private fun setFavorite(filmEntity: FilmEntity?) {

        if (filmEntity != null) {
            if (filmEntity.isFavorite){
                snackBar("${filmEntity.title} Removed from favorite")
            }else {
                snackBar("${filmEntity.title} Added to favorite")
            }
            viewModel.setFavoriteFilm(filmEntity)

        }

    }

    private fun snackBar(msg: String) {
        Snackbar.make(findViewById(android.R.id.content), msg, Snackbar.LENGTH_SHORT).show()
    }



    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.favorite, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.action_bookmark) {
            viewModel.setFavoriteFilm(film = FilmEntity())
            snackBar("added to favorite")
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    private fun setBookmarkState(state: Boolean) {
        if (menu == null) return
        val menuItem = menu?.findItem(R.id.action_bookmark)
        if (state) {
            menuItem?.icon = ContextCompat.getDrawable(this, R.drawable.ic_bookmarked_white)
        } else {
            menuItem?.icon = ContextCompat.getDrawable(this, R.drawable.ic_bookmark_white)
        }
    }


}