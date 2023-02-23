package com.bisha.paw.presentation.food

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.bisha.paw.R
import com.bisha.paw.data.ArticleModel
import com.bisha.paw.data.Food
import com.bisha.paw.presentation.article.ArticleDetailActivity
import com.bisha.paw.presentation.authentication.SignInActivity
import com.bisha.paw.utils.toFormatRupiah

class FoodDetailActivity : AppCompatActivity() {

    companion object {
        const val FOOD_ITEM = "food_item"

        fun start(context: Context, food: Food) {
            context.startActivity(Intent(context, FoodDetailActivity::class.java).apply {
                putExtra(FOOD_ITEM, food)
            })
        }
    }

    private var food: Food? = null

    private fun initIntent() {
        food = intent.getParcelableExtra(FOOD_ITEM)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food_detail)
        supportActionBar?.hide()
        initIntent()

        food?.let {
            setDetailData(it)
        }

        val btnShop: Button = findViewById(R.id.btnShop)
        btnShop.setOnClickListener {
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data = Uri.parse("https://shopee.co.id/whiskas.id")

            startActivity(openURL)
        }
    }

    private fun setDetailData(model: Food) {
        val ivFoodDetail: ImageView = findViewById(R.id.ivFoodDetail)
        val tvFoodTitle: TextView = findViewById(R.id.detailFoodTitle)
        val tvFoodPrice: TextView = findViewById(R.id.tvFoodPrice)
        val tvFoodSub: TextView = findViewById(R.id.detailFoodSub)
        val tvFoodDesc: TextView = findViewById(R.id.DescContent)
        val ivBackFood: ImageView = findViewById(R.id.ivBackFood)

        ivBackFood.setOnClickListener {
            finish()
        }


        tvFoodTitle.text = model.foodName
        tvFoodPrice.text = model.foodPrice.toFormatRupiah()
        tvFoodSub.text = model.foodBrand
    }
}