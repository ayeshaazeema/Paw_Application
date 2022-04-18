package com.bisha.paw.activity.authentication

import android.app.ProgressDialog
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.bisha.paw.R
import com.bisha.paw.activity.MainActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUpActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var mAuth: FirebaseAuth
    private lateinit var refUsers: DatabaseReference
    private var firebaseUserId: String = ""

    companion object {
        fun getLaunchService(from: Context) = Intent(from, SignUpActivity::class.java).apply {
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        tvQuestionSignUp.setOnClickListener(this)
        btnSignUp.setOnClickListener(this)

        mAuth = FirebaseAuth.getInstance()
    }

    override fun onClick(p0: View) {
        when (p0.id) {
            R.id.tvQuestionSignUp -> startActivity(SignInActivity.getLaunchService(this))
            R.id.btnSignUp -> signUpUser()
        }
    }

    private fun signUpUser() {
        val name: String = etNameSignUp.text.toString()
        val email: String = etEmailSignUp.text.toString()
        val password: String = etPasswordSignUp.text.toString()
        val confirmPassword: String = etConfirmPasswordSignUp.text.toString()

        if (name == "") {
            Toast.makeText(this, getString(R.string.error_name), Toast.LENGTH_SHORT).show()
        } else if (email == "") {
            Toast.makeText(this, getString(R.string.error_email), Toast.LENGTH_SHORT).show()
        } else if (password == "") {
            Toast.makeText(this, getString(R.string.error_password_sign_up), Toast.LENGTH_SHORT)
                .show()
        } else if ((confirmPassword == "").equals(password)) {
            Toast.makeText(
                this,
                getString(R.string.error_confirm_password_sign_up),
                Toast.LENGTH_SHORT
            ).show()
        } else {
            mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener { it ->
                if (it.isSuccessful) {
                    firebaseUserId = mAuth.currentUser!!.uid
                    refUsers =
                        FirebaseDatabase.getInstance().reference.child(getString(R.string.user))
                            .child(firebaseUserId)

                    val userHashMap = HashMap<String, Any>()
                    userHashMap["uidi"] = firebaseUserId
                    userHashMap["name"] = name
                    userHashMap["email"] = email

                    refUsers.updateChildren(userHashMap).addOnCompleteListener {
                        if (it.isSuccessful) {
                            startActivity(Intent(MainActivity.getLaunchService(this)))
                            finish()
                        }
                    }
                } else {
                    val progress = ProgressDialog(this, R.style.Theme_Paw)
                    progress.hide()
                    Toast.makeText(
                        this, getString(R.string.error_sign_up) + it.exception!!
                            .message.toString(), Toast.LENGTH_SHORT
                    ).show()
                    finish()

                }
            }
        }
    }
}