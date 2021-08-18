package com.example.activitylifecycle.model

import androidx.lifecycle.ViewModel

//viewmodel the () is call the parent constructor, and get what to pass in (x,x)
class QuestionModel : ViewModel() {
    var name : String = ""
    var no1 : Int = 0
    var no2 : Int = 0

    //when it is initialized
    init {
        generateQuestion()
    }

    fun generateQuestion():String{
        //var name : String = ""
        no1 = (Math.random()*100).toInt()
        no2 = (Math.random()*100).toInt()

        //${} refer to variable, if put no1 + no2, it will be just display
        //similar to no1 + " " + no2
        return "${no1} + ${no2} = ?"
    }

    //if java public int to determine return type
    //kotlin is : dataType
    fun getQuestion() : String{
        return "${no1} + ${no2} = ?"
    }

    fun getAnswer(): Int{
        return  (no1+no2)
    }

    companion object {
        private var instance : QuestionModel? = null

        fun getInstance() = instance ?: synchronized(QuestionModel::class.java){
            instance ?: QuestionModel().also { instance=it }
        }
    }
}