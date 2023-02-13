package com.bisha.paw.presentation.onboarding

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.bisha.paw.R
import com.bisha.paw.presentation.authentication.SignInActivity
import com.bisha.paw.presentation.onboarding.FirstOnboardingFragment
import com.bisha.paw.presentation.onboarding.SecondOnboardingFragment
import com.bisha.paw.presentation.onboarding.ThirdOnboardingFragment
import com.bisha.paw.utils.SessionManager
import kotlinx.android.synthetic.main.activity_onboarding.*

class OnboardingActivity : AppCompatActivity() {

    private val fragmentList = ArrayList<Fragment>()

    private val sessionManager: SessionManager by lazy {
        return@lazy SessionManager(this)
    }

    companion object {
        fun start(context: Context) {
            context.startActivity(Intent(context, OnboardingActivity::class.java))
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboarding)

        supportActionBar?.hide()

        val adapter = OnboardingAdapter(this)
        onboardingViewPager.adapter = adapter

        fragmentList.addAll(
            listOf(
                FirstOnboardingFragment(), SecondOnboardingFragment(), ThirdOnboardingFragment()
            )
        )
        adapter.setFragmentList(fragmentList)

        indicatorLayout.setIndicatorCount(adapter.itemCount)
        indicatorLayout.selectCurrentPosition(0)

        registerListeners()
    }

    private fun registerListeners() {
        onboardingViewPager.registerOnPageChangeCallback(object :
            ViewPager2.OnPageChangeCallback() {

            override fun onPageSelected(position: Int) {
                indicatorLayout.selectCurrentPosition(position)

                if (position < fragmentList.lastIndex) {
                    onboardingSkip.visibility = View.VISIBLE
                    onboardingNext.text = getString(R.string.button_next)
                } else {
                    onboardingSkip.visibility = View.GONE
                    onboardingNext.text = getString(R.string.button_start)
                }
            }
        })

        onboardingSkip.setOnClickListener {
            doFinishOnboard()
        }

        onboardingNext.setOnClickListener {
            val position = onboardingViewPager.currentItem

            if (position < fragmentList.lastIndex) {
                onboardingViewPager.currentItem = position + 1
            } else {
                doFinishOnboard()
            }
        }
    }

    private fun doFinishOnboard() {
        SignInActivity.start(this)
        finish()
        sessionManager.saveHasOnBoard()
    }
}