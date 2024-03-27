package com.example.projectforlistview

import android.os.Bundle
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.projectforlistview.R.*
import com.example.projectforlistview.R.layout.*

class MainActivity : AppCompatActivity() {

    private lateinit var arrayForListView : ArrayList<UserData>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val arrayOfName = arrayOf("Doraemon" , "Nobita" , "Shizuka" , "Gian")
        val arrayOfDescription = arrayOf("Going outside" , "In the school" , "In the Guitar classes" , "Working in Shop")
        val arrayOfPN = arrayOf("Phone : 57736879" , "Phone : 95898949" , "Phone : 9497979846" , "Phone : 947979769876")
        val arrayOfImgID = arrayOf(R.drawable.pic0 , R.drawable.pic1, R.drawable.pic2 , R.drawable.pic3 )

        arrayForListView = arrayListOf()


        for (length in arrayOfName.indices){
            val userData = UserData(arrayOfName[length] , arrayOfDescription[length] , arrayOfPN[length] , arrayOfImgID[length] )

            arrayForListView.add(userData)

        }

        val listView = findViewById<ListView>(R.id.mainListView)
        listView.isClickable = true

        listView.adapter = MyAdapter(this , arrayForListView)

    }
}