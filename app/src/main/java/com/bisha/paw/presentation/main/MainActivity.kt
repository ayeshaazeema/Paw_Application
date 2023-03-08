package com.bisha.paw.presentation.main

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.bisha.paw.R
import com.bisha.paw.utils.ArticleClickEvent
import com.bisha.paw.utils.FoodClickEvent
import com.google.android.material.bottomnavigation.BottomNavigationView
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

class MainActivity : AppCompatActivity() {

    private lateinit var bottomNavigationView: BottomNavigationView

    companion object {
        fun start(context: Context) {
            context.startActivity(Intent(context, MainActivity::class.java).apply {
                addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
            })
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        EventBus.getDefault().register(this)
        supportActionBar?.hide()

        // Bottom Navigation
        bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        val navController = findNavController(R.id.fragment)

        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.dashboardFragment,
                R.id.articleFragment,
                R.id.vetFragment,
                R.id.foodFragment,
                R.id.profileFragment
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)

        bottomNavigationView.setupWithNavController(navController)
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onArticleClickEvent(event: ArticleClickEvent) {
        moveToOtherTab(R.id.articleFragment)
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onFoodClickEvent(event: FoodClickEvent) {
        moveToOtherTab(R.id.foodFragment)
    }

    override fun onDestroy() {
        super.onDestroy()
        EventBus.getDefault().unregister(this)
    }

    private fun moveToOtherTab(tabId: Int) {
        val viewTab: View = bottomNavigationView.findViewById(tabId)
        viewTab.performClick()
    }
}