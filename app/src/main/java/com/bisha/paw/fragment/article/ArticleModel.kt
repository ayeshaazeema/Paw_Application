package com.bisha.paw.fragment.article

import android.os.Parcelable
import com.bisha.paw.R
import kotlinx.android.parcel.Parcelize

@Parcelize
class ArticleModel(
    var articleTitle: String? = null,
    var articleCategory: String? = null,
    var articleImg: Int = 0
) : Parcelable {
    companion object {
        fun getArticles(): ArrayList<ArticleModel> {

            //1
            val article1 = ArticleModel()
            article1.articleTitle = "How to Take Care of Bird"
            article1.articleCategory = "Bird"
            article1.articleImg = R.drawable.bird

            //2
            val article2 = ArticleModel()
            article2.articleTitle = "How to Take Care of Cat"
            article2.articleCategory = "Cat"
            article2.articleImg = R.drawable.cat

            //3
            val article3 = ArticleModel()
            article3.articleTitle = "How to Take Care of Dog"
            article3.articleCategory = "Dog"
            article3.articleImg = R.drawable.dog

            //4
            val article4 = ArticleModel()
            article4.articleTitle = "How to Take Care of Fish"
            article4.articleCategory = "Fish"
            article4.articleImg = R.drawable.fish

            return arrayListOf(article1, article2, article3, article4)
        }
    }
}