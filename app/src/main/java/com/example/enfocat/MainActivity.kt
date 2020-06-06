package com.example.enfocat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var saveData: SaveData


    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item->
        when(item.itemId){
            R.id.home->{
            println("Home Pressed")
                replaceFragment(HomeFragment())
            return@OnNavigationItemSelectedListener  true

        }
            R.id.remind->{
                println("Remind Pressed")
                replaceFragment(RemindFragment())
                return@OnNavigationItemSelectedListener  true

            }
            R.id.search->{
                println("Search Pressed")
                replaceFragment(SearchFragment())
                return@OnNavigationItemSelectedListener  true

            }
            R.id.profile->{
                println("Profile Pressed")
                replaceFragment(ProfileFragment())
                return@OnNavigationItemSelectedListener  true

            }
        }
        false

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        //Share preference states look
        saveData = SaveData(this)
        if(saveData.loadDarkModeState()==true){
            setTheme(R.style.darkTheme)
        }else
            setTheme(R.style.AppTheme)





        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNavigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        replaceFragment(HomeFragment())
    }
    private fun replaceFragment(fragment: Fragment){
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentContainer,fragment)
        fragmentTransaction.commit()
    }
}