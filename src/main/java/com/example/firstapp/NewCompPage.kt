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

class NewCompPage : AppCompatActivity() {

    private lateinit var ID_elec: TextInputEditText
    private lateinit var Elec_des: TextInputEditText
    private lateinit var Elec_place: TextInputEditText
    private lateinit var Elec_date: TextInputEditText
    private lateinit var Elec_time: TextInputEditText
    private lateinit var Elec_contact: TextInputEditText
    private lateinit var Elec_upload: Button
    private lateinit var database: FirebaseFirestore
//    private lateinit var database: DatabaseReference


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_comp_page)

        database = FirebaseFirestore.getInstance()
        ID_elec = findViewById(R.id.elec_ID)
        Elec_des = findViewById(R.id.descript_elec)
        Elec_place = findViewById(R.id.place_elec)
        Elec_date = findViewById(R.id.date_elec)
        Elec_time = findViewById(R.id.tim_elec)
        Elec_contact = findViewById(R.id.contact_elec)
        Elec_upload = findViewById(R.id.uploadButton_elec)

        Elec_upload.setOnClickListener {


            val elec = ID_elec.text.toString()
            val eDesc = Elec_des.text.toString()
            val eplace = Elec_place.text.toString()
            val edate = Elec_date.text.toString()
            val etime = Elec_time.text.toString()
            val econtact = Elec_contact.text.toString()

            val user: MutableMap<String, String> = HashMap()

            user["Roll number"]=elec
            user["Description"]=eDesc
            user["Place"]=eplace
            user["Date of Complaint"]=edate
            user["Time of complaint"]=etime
            user["Contact"]=econtact

            // Create a collection reference to "infrastructure/userId"
            val infrastructureCollection = database.collection("Electricity").document(elec)

            infrastructureCollection.collection(elec)
                .add(user)
                .addOnSuccessListener(OnSuccessListener<DocumentReference> {

                    ID_elec.text?.clear()
                    Elec_des.text?.clear()
                    Elec_place.text?.clear()
                    Elec_date.text?.clear()
                    Elec_time.text?.clear()
                    Elec_contact.text?.clear()


                    Toast.makeText(this@NewCompPage, "Successful", Toast.LENGTH_SHORT).show()



                })
                .addOnFailureListener(OnFailureListener { e ->
                    Toast.makeText(this@NewCompPage, "Failed", Toast.LENGTH_SHORT).show()
                })
        }

//

    }
}
