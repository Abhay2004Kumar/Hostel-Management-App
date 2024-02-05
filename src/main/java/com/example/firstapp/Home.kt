package com.example.firstapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.example.firstapp.databinding.ActivityHome2Binding
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase

class Home : AppCompatActivity() {
    private val binding : ActivityHome2Binding by lazy {
        ActivityHome2Binding.inflate(layoutInflater)
    }

    private lateinit var databaserefrace : DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(binding.root)



        binding.login.setOnClickListener {

            val id = binding.editTextLoginId.text.toString()
            val pass = binding.editTextPassword.text.toString().trim()

            val auth = Firebase.auth.signInWithEmailAndPassword(id,pass).addOnCompleteListener{
                if(it.isSuccessful){
                    startActivity(Intent(this,feature_page_real :: class.java))

                }
                else{
//                    Toast.makeText(this, it.exception?.localizedMessage, Toast.LENGTH_SHORT).show()
                    Toast.makeText(this,"${it.exception?.localizedMessage}",Toast.LENGTH_SHORT).show()
                }
            }
        }




    }


}




//        binding.login.setOnClickListener {
//            databaserefrace = FirebaseDatabase.getInstance().getReference("Users")
//            val rollno = binding.editTextLoginId.text.toString()
//            val pass = binding.editTextPassword.text.toString()
//
//            databaserefrace.child(rollno).get().addOnSuccessListener {
//                val rollno1 : String= it.child("std_RollNo").value.toString()
//                val pass1 = it.child("stu_pass").value.toString()
//
//
//
//                if(rollno1 == rollno && pass1 == pass){
//                    startActivity(Intent(this, feature_page_real :: class.java))
//                }else{
//                    Toast.makeText(this, "credentials not matched", Toast.LENGTH_SHORT).show()
//                }
//            }.addOnFailureListener{
//                Toast.makeText(this, it.localizedMessage, Toast.LENGTH_LONG).show()
//            }





//val btn: Button = findViewById(R.id.login)
//
//btn.setOnClickListener {
//    val Intent= Intent(this,feature_page_real::class.java)
//    startActivity(Intent)
//}