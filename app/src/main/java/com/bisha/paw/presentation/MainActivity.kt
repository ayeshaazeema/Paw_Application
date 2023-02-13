package com.bisha.paw.presentation

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.bisha.paw.R
import com.bisha.paw.utils.ArticleClickEvent
import com.bisha.paw.utils.FoodClickEvent
import com.bisha.paw.utils.RxEventBus
import com.google.android.material.bottomnavigation.BottomNavigationView
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers

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
        initRxBusEvent()
    }


    private fun initRxBusEvent() {
        RxEventBus.subscribe<ArticleClickEvent>()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                Log.d("ArticleClickEvent", "SUBCRIBED")
                moveToOtherTab(R.id.articleFragment)
            }.dispose()

        RxEventBus.subscribe<FoodClickEvent>()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                Log.d("FoodClickEvent", "SUBCRIBED")
                moveToOtherTab(R.id.foodFragment)
            }.dispose()
    }

    private fun moveToOtherTab(tabId: Int) {
        val viewTab: View = bottomNavigationView.findViewById(tabId)
        viewTab.performClick()
    }

}