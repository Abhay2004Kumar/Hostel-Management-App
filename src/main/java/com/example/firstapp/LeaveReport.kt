package com.example.firstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class LeaveReport : AppCompatActivity() {
    private lateinit var St_name: TextInputEditText
    private lateinit var St_roll: TextInputEditText
    private lateinit var St_purpo: TextInputEditText
    private lateinit var date_depa: TextInputEditText
    private lateinit var date_arri: TextInputEditText
    private lateinit var day_out_camp: TextInputEditText
    private lateinit var contact_st: TextInputEditText
    private lateinit var contact_par: TextInputEditText
    private lateinit var upload: Button

    private lateinit var database: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_leave_report)
St_name = findViewById(R.id.leav_name)
        St_roll = findViewById(R.id.leav_roll)
        St_purpo = findViewById(R.id.leav_purpose)
        date_depa = findViewById(R.id.date_dep)
        date_arri = findViewById(R.id.date_arr)
        day_out_camp = findViewById(R.id.day_out)
        contact_st = findViewById(R.id.contact_st)
        contact_par = findViewById(R.id.guardian_cont)
        upload = findViewById(R.id.upload_leave)

        upload.setOnClickListener {
val Sname = St_name.text.toString()
            val  Sroll = St_roll.text.toString()
            val Spurp = St_purpo.text.toString()
            val Date_dep = date_depa.text.toString()
            val Date_arr = date_arri.text.toString()
            val dAyout = day_out_camp.text.toString()
            val Stcont = contact_st.text.toString()
            val Parcont = contact_par.text.toString()


            database = FirebaseDatabase.getInstance().getReference("Leave_applications")
            val Leave_applications = leavfile(Sname,Sroll,Spurp,Date_dep,Date_arr,dAyout,Stcont,Parcont)
            database.child(Sroll).setValue(Leave_applications).addOnSuccessListener {
               St_name.text?.clear()
                St_roll.text?.clear()
                St_purpo.text?.clear()
                date_depa.text?.clear()
                date_arri.text?.clear()
                day_out_camp.text?.clear()
                contact_st.text?.clear()
                contact_par.text?.clear()


                Toast.makeText(this,"Successfully saved", Toast.LENGTH_SHORT).show()
            }.addOnFailureListener{
                Toast.makeText(this,"Invalid input", Toast.LENGTH_SHORT).show()
            }

        }


    }
}