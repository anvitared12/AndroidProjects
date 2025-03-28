package com.example.bottomnavigation

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.bottomnavigation.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var bottomNav:BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        bottomNav=findViewById(R.id.myBottomView)

        val defaultTone=supportFragmentManager.beginTransaction()
        defaultTone.replace(R.id.myFragment,Call()).commit()
        bottomNav.setOnItemSelectedListener {
            val next=supportFragmentManager.beginTransaction()
            val fragment=when(it.itemId){
                R.id.myCall->next.replace(R.id.myFragment,Call())
                R.id.myInfo->next.replace(R.id.myFragment,Info())
                else->null

            }
            if(fragment!=null){
                supportFragmentManager.beginTransaction()
                    .replace(R.id.myFragment,Call())
                    .commit()
            }
            next.commit()
            true
        }

    }
}