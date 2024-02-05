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

class InfraComp : AppCompatActivity() {

    private lateinit var ID_infra: TextInputEditText
    private lateinit var Infra_des: TextInputEditText
    private lateinit var Infra_place: TextInputEditText
    private lateinit var Infra_date: TextInputEditText
    private lateinit var Infra_time: TextInputEditText
    private lateinit var Infra_contact: TextInputEditText
    private lateinit var Infra_upload: Button
    private lateinit var database: FirebaseFirestore
//    private lateinit var database: DatabaseReference


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_infra_comp)

        database = FirebaseFirestore.getInstance()
        ID_infra = findViewById(R.id.infra_ID)
        Infra_des = findViewById(R.id.descript_infra)
        Infra_place = findViewById(R.id.place_infra)
        Infra_date = findViewById(R.id.date_infra)
        Infra_time = findViewById(R.id.tim_infra)
        Infra_contact = findViewById(R.id.contact_infra)
        Infra_upload = findViewById(R.id.uploadButton_infra)

        Infra_upload.setOnClickListener {


            val infra = ID_infra.text.toString()
            val iDesc = Infra_des.text.toString()
            val iplace = Infra_place.text.toString()
            val idate = Infra_date.text.toString()
            val itime = Infra_time.text.toString()
            val icontact = Infra_contact.text.toString()

            val user: MutableMap<String, Any> = HashMap()

            user["Roll number"]=infra
            user["Description"]=iDesc
            user["Place"]=iplace
            user["Date of Complaint"]=idate
            user["Time of complaint"]=itime
            user["Contact"]=icontact

            // Create a collection reference to "infrastructure/userId"
            val infrastructureCollection = database.collection("infrastructure").document(infra)

            infrastructureCollection.collection(infra)
                .add(user)
                .addOnSuccessListener(OnSuccessListener<DocumentReference> { documentReference ->

                   ID_infra.text?.clear()
                    Infra_des.text?.clear()
                    Infra_place.text?.clear()
                    Infra_date.text?.clear()
                    Infra_time.text?.clear()
                    Infra_contact.text?.clear()


                    Toast.makeText(this@InfraComp, "Successful", Toast.LENGTH_SHORT).show()



                })
                .addOnFailureListener(OnFailureListener { e ->
                    Toast.makeText(this@InfraComp, "Failed", Toast.LENGTH_SHORT).show()
                })
        }

//

        }
    }
