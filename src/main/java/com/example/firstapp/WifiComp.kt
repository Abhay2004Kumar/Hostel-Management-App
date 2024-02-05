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

class WifiComp : AppCompatActivity() {

    private lateinit var ID_wifi: TextInputEditText
    private lateinit var Wifi_des: TextInputEditText
    private lateinit var Wifi_place: TextInputEditText
    private lateinit var Wifi_date: TextInputEditText
    private lateinit var Wifi_time: TextInputEditText
    private lateinit var Wifi_contact: TextInputEditText
    private lateinit var Wifi_upload: Button
    private lateinit var database: FirebaseFirestore
//    private lateinit var database: DatabaseReference


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wifi_comp)

        database = FirebaseFirestore.getInstance()
        ID_wifi = findViewById(R.id.wifi_ID)
        Wifi_des = findViewById(R.id.descript_wifi)
        Wifi_place = findViewById(R.id.place_wifi)
        Wifi_date = findViewById(R.id.date_wifi)
        Wifi_time = findViewById(R.id.tim_wifi)
        Wifi_contact = findViewById(R.id.contact_wifi)
        Wifi_upload = findViewById(R.id.uploadButton_wifi)

        Wifi_upload.setOnClickListener {


            val wifi = ID_wifi.text.toString()
            val wDesc = Wifi_des.text.toString()
            val wplace = Wifi_place.text.toString()
            val wdate = Wifi_date.text.toString()
            val wtime = Wifi_time.text.toString()
            val wcontact = Wifi_contact.text.toString()

            val user: MutableMap<String, Any> = HashMap()

            user["Roll number"]=wifi
            user["Description"]=wDesc
            user["Place"]=wplace
            user["Date of Complaint"]=wdate
            user["Time of complaint"]=wtime
            user["Contact"]=wcontact

            // Create a collection reference to "infrastructure/userId"
            val infrastructureCollection = database.collection("Wi-fi").document(wifi)

            infrastructureCollection.collection(wifi)
                .add(user)
                .addOnSuccessListener(OnSuccessListener<DocumentReference> { documentReference ->

                    ID_wifi.text?.clear()
                    Wifi_des.text?.clear()
                    Wifi_place.text?.clear()
                    Wifi_date.text?.clear()
                    Wifi_time.text?.clear()
                    Wifi_contact.text?.clear()


                    Toast.makeText(this@WifiComp, "Successful", Toast.LENGTH_SHORT).show()



                })
                .addOnFailureListener(OnFailureListener { e ->
                    Toast.makeText(this@WifiComp, "Failed", Toast.LENGTH_SHORT).show()
                })
        }

//

    }
}
