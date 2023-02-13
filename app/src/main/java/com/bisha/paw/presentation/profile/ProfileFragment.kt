package com.bisha.paw.presentation.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bisha.paw.R
import com.bisha.paw.presentation.authentication.SignInActivity
import com.bisha.paw.databinding.FragmentProfileBinding
import com.bumptech.glide.Glide
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.*

class ProfileFragment : Fragment(), View.OnClickListener {

    var refUser: DatabaseReference? = null
    var firebaseUser: FirebaseUser? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val bind = FragmentProfileBinding.inflate(layoutInflater)

        profile(bind)
        return bind.root
    }

    private fun profile(binding: FragmentProfileBinding) {
        firebaseUser = FirebaseAuth.getInstance().currentUser
        refUser = FirebaseDatabase.getInstance().getReference("User").child(firebaseUser!!.uid)
        refUser!!.addValueEventListener(object : ValueEventListener {
            override fun onCancelled(error: DatabaseError) {

            }

            override fun onDataChange(snapshot: DataSnapshot) {
                snapshot.children.forEach { _ ->
                    val name = snapshot.child("name").value.toString()
                    val email = snapshot.child("email").value.toString()
                    val profileImage = snapshot.child("profile_image").value.toString()

                    binding.tvNameProfile.text = name
                    binding.tvEmailProfile.text = email

//                    Glide.with(requireActivity()).load(profileImage).into(binding.ivProfile)
                }
            }
        })
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<View>(R.id.tvSignOut).setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            SignInActivity.start(this@ProfileFragment.requireContext())
        }
    }

    override fun onClick(v: View?) {
        TODO("Not yet implemented")
    }
}

