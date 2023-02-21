package com.bisha.paw.presentation.authentication

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Toast
import com.bisha.paw.R
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_forgot_password.*

class ForgotPasswordActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var mAuth: FirebaseAuth

    companion object {
        fun start(context: Context) {
            context.startActivity(Intent(context, ForgotPasswordActivity::class.java).apply {
                addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
            })
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)

        supportActionBar?.hide()

        tvQuestionForgotPassword.setOnClickListener(this)
        btnForgotPassword.setOnClickListener(this)

        mAuth = FirebaseAuth.getInstance()
    }

    override fun onClick(p0: View) {
        when (p0.id) {
            R.id.tvQuestionForgotPassword -> SignInActivity.start(this)
            R.id.btnForgotPassword -> forgotPassword()
        }
    }

    private fun forgotPassword() {
        val email = etEmailForgotPassword.text.toString()
        if (TextUtils.isEmpty(email)) {
            Toast.makeText(this, getString(R.string.error_email), Toast.LENGTH_SHORT).show()
        } else {
            mAuth.sendPasswordResetEmail(email).addOnCompleteListener {
                if (it.isSuccessful) {
                    Toast.makeText(
                        this,
                        getString(R.string.reset_forgot_password),
                        Toast.LENGTH_SHORT
                    ).show()
                    SignInActivity.start(this)
                } else {
                    Toast.makeText(
                        this,
                        getString(R.string.failed_forgot_password),
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }
}
