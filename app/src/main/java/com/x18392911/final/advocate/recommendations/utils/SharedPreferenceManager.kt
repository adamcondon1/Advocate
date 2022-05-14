package com.x18392911.final.advocate.recommendations.utils

import android.content.Context
import android.content.SharedPreferences

var context: Context? = null

//shared preferences acting as a db storing values

class SharedPreferenceManager(context: Context)
{
    val myPrif:String = "myPref"
//    var prefrenceManager : PreferenceManager ?= null
    val sharedPreferences : SharedPreferences = context!!.getSharedPreferences(myPrif,Context.MODE_PRIVATE)


    val editor: SharedPreferences.Editor = sharedPreferences.edit()


  fun addString(Key:String,value: String)
  {
      val editor: SharedPreferences.Editor = sharedPreferences.edit()
      editor.putString(Key,value)
      editor.commit()
  }


    fun getString(Key: String):String?
    {
        return sharedPreferences.getString(Key,null)
    }

    fun getLoginSession(): Boolean {
        return sharedPreferences.getBoolean("NUMBER", false)
    }

    fun setLoginSession(number: String) {
        editor.putBoolean("NUMBER", true)
        editor.commit()
    }


    fun clearSharedPreference() {


        //sharedPref = PreferenceManager.getDefaultSharedPreferences(context);

        editor.clear()
        editor.commit()
    }



}
