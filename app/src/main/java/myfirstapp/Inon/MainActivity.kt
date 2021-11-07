package myfirstapp.Inon

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.database.DatabaseReference

import com.google.firebase.database.FirebaseDatabase
import kotlin.system.exitProcess
import android.media.MediaPlayer

import android.media.MediaPlayer.OnCompletionListener


class MainActivity : AppCompatActivity() {

    lateinit var plusBtn:Button
    lateinit var minusBtn:Button
    lateinit var resetBtn:Button
    lateinit var calcText:TextView
    lateinit var updateDataBtn:Button
    lateinit var userInputTxt:EditText
    var counter: Int = 0
    var idCounter: Int = 0
    var myRef = FirebaseDatabase.getInstance().getReference()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        plusBtn = findViewById<Button>(R.id.btnPlus)
        minusBtn = findViewById<Button>(R.id.btnMinus)
        resetBtn = findViewById<Button>(R.id.btnReset)
        calcText = findViewById<TextView>(R.id.textCalc)
        updateDataBtn = findViewById<Button>(R.id.updateData)
        userInputTxt = findViewById<EditText>(R.id.userInput)

        plusBtn.setOnClickListener{
            calcText.text = (++counter).toString()
        }
        minusBtn.setOnClickListener{
            calcText.text = (--counter).toString()
        }
        resetBtn.setOnClickListener{
            counter=0
            calcText.text = (counter).toString()
        }
        updateDataBtn.setOnClickListener {
            if(userInputTxt.text.isEmpty()){return@setOnClickListener}
            myRef.child("Inon")
                .child("${++idCounter}")
                .setValue(userInputTxt.text.toString())
            userInputTxt.text.clear()
            /*val mediaplayer: MediaPlayer = MediaPlayer.create(
                this@MainActivity,R.raw.a770
            ) //You Can Put Your File Name Instead Of abc

            mediaplayer.start()*/
        }


    }





}