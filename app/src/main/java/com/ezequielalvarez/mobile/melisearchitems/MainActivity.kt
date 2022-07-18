package com.ezequielalvarez.mobile.melisearchitems



import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONException


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        searchItems()
    }

   fun searchItems(){
       val version: String = "2.0.0"
       val queue = Volley.newRequestQueue(this)
       //val url = SendVersionServices.urlSendVersion
       val url = "http://ideassa.com.ar/ALLADIO/WS/Service1.asmx/CheckAppVersion?cadena={\"Version\":\"$version\"}"
       val stringRequest = StringRequest(
           Request.Method.GET, url,
           { response ->
               val status = response.contains("200")
               if (status) {
                   try {
                     Log.i("status", status.toString())
                   } catch (e: JSONException) {
                       e.printStackTrace()
                   }
               }else{
                   Log.i("status", "eeror")
               }

           }) {
           Log.i("status", "ups")
       }
       queue.add(stringRequest)

   }

}