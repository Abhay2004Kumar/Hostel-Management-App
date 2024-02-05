package com.example.firstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.google.android.gms.tasks.OnFailureListener
import com.google.android.gms.tasks.OnSuccessListener
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase

class MessComp : AppCompatActivity() {

    private lateinit var ID_mess: TextInputEditText
    private lateinit var Mess_des: TextInputEditText
    private lateinit var Mess_place: TextInputEditText
    private lateinit var Mess_date: TextInputEditText
    private lateinit var Mess_time: TextInputEditText
    private lateinit var Mess_contact: TextInputEditText
    private lateinit var Mess_upload: Button
    private lateinit var database: FirebaseFirestore
//    private lateinit var database: DatabaseReference


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mess_comp)

        database = FirebaseFirestore.getInstance()
        ID_mess = findViewById(R.id.mess_ID)
        Mess_des = findViewById(R.id.descript_mess)
        Mess_place = findViewById(R.id.place_mess)
        Mess_date = findViewById(R.id.date_mess)
        Mess_time = findViewById(R.id.tim_mess)
        Mess_contact = findViewById(R.id.contact_mess)
        Mess_upload = findViewById(R.id.uploadButton_mess)

        Mess_upload.setOnClickListener {


            val mess = ID_mess.text.toString()
            val mDesc = Mess_des.text.toString()
            val mplace = Mess_place.text.toString()
            val mdate = Mess_date.text.toString()
            val mtime = Mess_time.text.toString()
            val mcontact = Mess_contact.text.toString()

            val user: MutableMap<String, Any> = HashMap()

            user["Roll number"]=mess
            user["Description"]=mDesc
            user["Place"]=mplace
            user["Date of Complaint"]=mdate
            user["Time of complaint"]=mtime
            user["Contact"]=mcontact

            // Create a collection reference to "infrastructure/userId"
            val infrastructureCollection = database.collection("Mess").document(mess)

            infrastructureCollection.collection(mess)
                .add(user)
                .addOnSuccessListener(OnSuccessListener<DocumentReference> { documentReference ->

                    ID_mess.text?.clear()
                    Mess_des.text?.clear()
                    Mess_place.text?.clear()
                    Mess_date.text?.clear()
                    Mess_time.text?.clear()
                    Mess_contact.text?.clear()

                    Toast.makeText(this@MessComp, "Successful", Toast.LENGTH_SHORT).show()

                })
                .addOnFailureListener(OnFailureListener { e ->
                    Toast.makeText(this@MessComp, "Failed", Toast.LENGTH_SHORT).show()
                })
        }

//

    }
}
