package com.bangkit.glendjetpack1.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.bangkit.glendjetpack1.R
import com.bangkit.glendjetpack1.data.ShowEntity
import com.bangkit.glendjetpack1.databinding.ActivityDetailShowBinding
import com.bangkit.glendjetpack1.databinding.ContentDetailShowBinding
import com.bangkit.glendjetpack1.viewmodel.ViewModelFactory
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.google.android.material.snackbar.Snackbar
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class DetailShowActivity : DaggerAppCompatActivity() {

    private lateinit var detailContentBinding: ContentDetailShowBinding
    private var activityDetailShowBinding: ActivityDetailShowBinding? = null
    private  val binding get() =  activityDetailShowBinding

    private lateinit var viewModel: DetailShowViewModel

    @Inject
    lateinit var factory: ViewModelFactory

    companion object {
        const val EXTRA_COURSE = "extra_course"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityDetailShowBinding = ActivityDetailShowBinding.inflate(layoutInflater)
        detailContentBinding = activityDetailShowBinding!!.detailContent

        setContentView(activityDetailShowBinding!!.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
//        setSupportActionBar(activityDetailShowBinding.toolbar)


        viewModel = ViewModelProvider(this, factory)[DetailShowViewModel::class.java]

        val extras = intent.extras
        if (extras != null) {
            val id = intent.getIntExtra(EXTRA_COURSE, 0)
            viewModel.setSelectedCourse(id)
            viewModel.getCourse(id).observe(this, { show -> populateCourse(show)})
        }
    }

    private fun populateCourse(showEntity: ShowEntity?) {

        detailContentBinding.textTitle.text = showEntity?.title
        detailContentBinding.textDesc.text = showEntity?.description
        detailContentBinding.textDate.text = resources.getString(R.string.deadline_date, showEntity?.date)
        val statusFavorite = showEntity?.isFavorite

        statusFavorite?.let { status ->
            setFavoriteState(status)
        }

        Glide.with(this)
            .load("https://image.tmdb.org/t/p/"+ "w200" + showEntity?.imagePath)
            .apply(RequestOptions.placeholderOf(R.drawable.ic_loading)
                .error(R.drawable.ic_error))
            .into(detailContentBinding.imagePoster)

        binding?.fabFavorite?.setOnClickListener {
            if (showEntity != null) {
                setFavorite(showEntity)
            }
        }

    }

    private fun setFavoriteState(status: Boolean){
        if (status) {
            binding?.fabFavorite?.setImageResource(R.drawable.ic_favorite_true)
        } else {
            binding?.fabFavorite?.setImageResource(R.drawable.ic_favorite_false)
        }
    }

    private fun setFavorite(showEntity: ShowEntity?) {
        if (showEntity != null) {
            if (showEntity.isFavorite){
                snackBar("${showEntity.title} Removed from favorite")
            }else {
                snackBar("${showEntity.title} Added to favorite")
            }
            viewModel.setFavoriteShow(showEntity)

        }

    }

    private fun snackBar(msg: String) {
        Snackbar.make(findViewById(android.R.id.content), msg, Snackbar.LENGTH_SHORT).show()
    }


}