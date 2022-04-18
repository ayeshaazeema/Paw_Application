package com.bisha.paw.activity.onboarding

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.bisha.paw.R
import com.bisha.paw.activity.authentication.SignInActivity
import com.bisha.paw.fragment.onboarding.FirstOnboardingFragment
import com.bisha.paw.fragment.onboarding.SecondOnboardingFragment
import com.bisha.paw.fragment.onboarding.ThirdOnboardingFragment
import kotlinx.android.synthetic.main.activity_onboarding.*

class OnboardingActivity : AppCompatActivity() {

    private val fragmentList = ArrayList<Fragment>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboarding)

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
                    onboardingNext.text = "Next"
                } else {
                    onboardingSkip.visibility = View.GONE
                    onboardingNext.text = "Start"
                }
            }
        })

        onboardingSkip.setOnClickListener {
            startActivity(Intent(this, SignInActivity::class.java))
            finish()
        }

        onboardingNext.setOnClickListener {
            val position = onboardingViewPager.currentItem

            if (position < fragmentList.lastIndex) {
                onboardingViewPager.currentItem = position + 1
            } else {
                startActivity(Intent(this, SignInActivity::class.java))
                finish()
            }
        }
    }
}