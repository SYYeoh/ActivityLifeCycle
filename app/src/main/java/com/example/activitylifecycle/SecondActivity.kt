package com.example.activitylifecycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.example.activitylifecycle.model.QuestionModel
import org.w3c.dom.Text

//class extends from AppCompatActivity
class SecondActivity : AppCompatActivity() {
    private  lateinit var myModel : QuestionModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)


        Log.i("LifeCycle", "onCreate")

        val btn: Button = findViewById(R.id.btnAdd)
        val tv: TextView = findViewById(R.id.tvQuestion)
        val tvName : TextView = findViewById(R.id.tvName)
        //? is for nullable data type
        /*if (savedInstanceState != null)
        tv.text = savedInstanceState?.getString("question")*/

        //create a new instance
        //myModel = QuestionModel()

        //save data from model to viewmodelprovider
        myModel = QuestionModel.getInstance()
        tv.text = myModel.getQuestion()
        tvName.text = myModel.name

        btn.setOnClickListener() {
            tv.text = myModel.generateQuestion()
        }

    }

        override fun onStart() {
            super.onStart()
            Log.i("LifeCycle", "onStart")
        }

        override fun onResume() {
            super.onResume()
            Log.i("LifeCycle", "onResume")
        }

        override fun onPause() {
            super.onPause()
            Log.i("LifeCycle", "onPause")
        }

        override fun onStop() {
            super.onStop()
            Log.i("LifeCycle", "onStop")
        }

        override fun onDestroy() {
            super.onDestroy()
            Log.i("LifeCycle", "onDestroy")
        }

        //save data from bundle
        //the bundle in savedInstanceState at oncreate will get back the question through variable savedInstance
        /*override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        val tvQ:TextView = findViewById(R.id.tvQuestion)
        outState.putString("question", tvQ.text.toString())

    }*/
}