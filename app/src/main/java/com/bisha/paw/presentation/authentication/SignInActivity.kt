package com.bisha.paw.presentation.authentication

import android.app.ProgressDialog
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.bisha.paw.R
import com.bisha.paw.presentation.main.MainActivity
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_sign_in.*

class SignInActivity : AppCompatActivity(), View.OnClickListener {

    companion object {
        fun start(context: Context) {
            context.startActivity(Intent(context, SignInActivity::class.java).apply {
                addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
            })
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)
        supportActionBar?.hide()

        tvForgotPasswordSignIn.setOnClickListener(this)
        tvQuestionSignIn.setOnClickListener(this)
        btnSignIn.setOnClickListener(this)
    }

    override fun onClick(p0: View) {
        when (p0.id) {
            R.id.tvForgotPasswordSignIn -> ForgotPasswordActivity.start(this)
            R.id.tvQuestionSignIn -> SignUpActivity.start(this)
            R.id.btnSignIn -> signInEmailPassword()
        }
    }

    private fun signInEmailPassword() {
        val email = etEmailSignIn.text.toString()
        val password = etPasswordSignIn.text.toString()

        if (email.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, getString(R.string.error_sign_in), Toast.LENGTH_SHORT).show()
        }

        FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password)
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    Toast.makeText(this, getString(R.string.success_sign_in), Toast.LENGTH_SHORT)
                        .show()
                    MainActivity.start(this)
                    return@addOnCompleteListener
                } else {
                    Toast.makeText(this, getString(R.string.failed_sign_in), Toast.LENGTH_SHORT)
                        .show()
                }
            }.addOnFailureListener {
                val progress = ProgressDialog(this, R.style.Theme_Paw)
                progress.hide()
                Toast.makeText(this, getString(R.string.failed_sign_in), Toast.LENGTH_SHORT).show()
            }
    }
}