package com.bangkit.glendjetpack1.ui.home

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.swipeUp
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.bangkit.glendjetpack1.R
import com.bangkit.glendjetpack1.utils.DataDummy
import com.bangkit.glendjetpack1.utils.EspressoIdlingResource
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class HomeActivityTest{
    private val dummyShow = DataDummy.generateDummyShow()
    private val dummyFilm = DataDummy.generateDummyFilm()

    @get:Rule
    var activityRule =  ActivityScenarioRule(HomeActivity::class.java)

    @Before
    fun setUp() {
        IdlingRegistry.getInstance().register(EspressoIdlingResource.espressoTestIdlingResource)
    }

    @After
    fun tearDown() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.espressoTestIdlingResource)
    }

    @Test
    fun loadShows(){
        Espresso.onView(withText("TV Show")).perform(ViewActions.click())
        Espresso.onView(withId(R.id.rv_show))
            .check(matches(isDisplayed()))
        Espresso.onView(withId(R.id.rv_show))
            .perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyShow.size))
    }

    @Test
    fun loadMovies(){
        Espresso.onView(withId(R.id.rv_movie))
                .check(matches(isDisplayed()))
        Espresso.onView(withId(R.id.rv_movie))
                .perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyFilm.size))
    }

    @Test
    fun loadDetailShow() {
        Espresso.onView(withText("TV Show")).perform(ViewActions.click())
        Espresso.onView(withId(R.id.rv_show)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0,
            ViewActions.click()
        ))
        Espresso.onView(withId(R.id.text_title))
            .check(matches(isDisplayed()))
        Espresso.onView(withId(R.id.text_date))
            .check(matches(isDisplayed()))
        Espresso.onView(withId(R.id.image_poster)).check(matches(isDisplayed()))
        Espresso.onView(withId(R.id.text_desc)).check(matches(isDisplayed()))
    }

    @Test
    fun loadDetailMovie() {
        Espresso.onView(withId(R.id.rv_movie)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0,
                ViewActions.click()
        ))
        Espresso.onView(withId(R.id.text_title))
                .check(matches(isDisplayed()))
        Espresso.onView(withId(R.id.text_date))
                .check(matches(isDisplayed()))
        Espresso.onView(withId(R.id.image_poster)).check(matches(isDisplayed()))
        Espresso.onView(withId(R.id.text_desc))
                .check(matches(isDisplayed()))
    }

    @Test
    fun addFavoriteMovie() {
        Espresso.onView(withId(R.id.rv_movie)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0,
            ViewActions.click()
        ))
        Espresso.onView(withId(R.id.fab_favorite)).perform(ViewActions.click())
    }

    @Test
    fun addFavoriteShow() {
        Espresso.onView(withText("TV Show")).perform(ViewActions.click())
        Espresso.onView(withId(R.id.rv_show)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0,
                ViewActions.click()
        ))

        Espresso.onView(withId(R.id.fab_favorite)).perform(ViewActions.click())
    }

    @Test
    fun loadFavoriteMovie(){
        delayFiveSecond()
        Espresso.onView(withId(R.id.btnFavor)).check(matches(isDisplayed())).perform(click())
        Espresso.onView(withText("Favorite Movie")).perform(click())
        Espresso.onView(withId(R.id.rv_movie)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0,
                ViewActions.click()
        ))
        Espresso.onView(withId(R.id.text_title)).check(matches(isDisplayed()))
        Espresso.onView(withId(R.id.text_date))
                .check(matches(isDisplayed()))
        Espresso.onView(withId(R.id.text_desc))
                .check(matches(isDisplayed()))
        Espresso.onView(withId(R.id.image_poster)).check(matches(isDisplayed()))
        Espresso.onView(isRoot()).perform(ViewActions.pressBack())
    }

    @Test
    fun loadFavoriteShow(){
        delayFiveSecond()
        Espresso.onView(withId(R.id.btnFavor)).check(matches(isDisplayed())).perform(click())
        Espresso.onView(withText("Favorite TV Show")).perform(click())
        Espresso.onView(withId(R.id.rv_show)).perform(
                RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0,
                        ViewActions.click()
                ))
        Espresso.onView(withId(R.id.text_title)).check(matches(isDisplayed()))
        Espresso.onView(withId(R.id.text_date))
                .check(matches(isDisplayed()))
        Espresso.onView(withId(R.id.text_desc))
                .check(matches(isDisplayed()))
        Espresso.onView(withId(R.id.image_poster)).check(matches(isDisplayed()))
    }

    private fun delayFiveSecond() {
        try {
            Thread.sleep(5000)
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }
    }
}