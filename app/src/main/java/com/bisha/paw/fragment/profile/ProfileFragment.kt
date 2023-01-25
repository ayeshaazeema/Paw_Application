//package com.bisha.paw.fragment.profile
//
//import android.content.Context
//import android.content.Intent
//import android.os.Bundle
//import androidx.fragment.app.Fragment
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import com.bisha.paw.R
//import com.bisha.paw.activity.authentication.SignInActivity
//import com.google.firebase.auth.FirebaseAuth
//import com.google.firebase.auth.FirebaseUser
//import com.google.firebase.database.*
//import kotlinx.android.synthetic.main.fragment_profile.*
//
//
//class ProfileFragment : Fragment(), View.OnClickListener {
//
//    var refUser: DatabaseReference? = null
//    var firebaseUser: FirebaseUser? = null
//    lateinit var auth: FirebaseAuth
//
//    companion object {
//        fun getLaunchService(from: Context) = Intent(from, ProfileFragment::class.java).apply {
//            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
//        }
//    }
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//
//        tvSignOut.setOnClickListener(this)
//
//        firebaseUser = FirebaseAuth.getInstance().currentUser
//        refUser = FirebaseDatabase.getInstance().getReference("User").child(firebaseUser!!.uid)
//        refUser!!.addValueEventListener(object : ValueEventListener {
//            override fun onDataChange(snapshot: DataSnapshot) {
//                for (p0 in snapshot.children) {
//                    val name = snapshot.child("fullName").value.toString()
//                    val email = snapshot.child("email").value.toString()
//                    tvNameProfile.text = name
//                    tvEmailProfile.text = email
//                }
//            }
//
//            override fun onCancelled(error: DatabaseError) {
//                TODO("Not yet implemented")
//            }
//        })
//    }
//
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_profile, container, false)
//    }
//
////    override fun onClick(p0: View) {
////        when (p0.id) {
////            R.id.tvSignOut -> signOut()
////        }
////    }
//
////    private fun signOut() {
////        startActivity(Intent(SignInActivity.getLaunchService(this)))
////        FirebaseAuth.getInstance().signOut()
////    }
//}