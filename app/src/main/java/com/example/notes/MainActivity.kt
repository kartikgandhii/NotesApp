package com.example.notes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.notes.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        replaceFragment(HomeFragment.newInstance(), true)

    }

    fun replaceFragment(fragment: Fragment, istransition: Boolean){
        val fragmentTransition = supportFragmentManager.beginTransaction()

        if (istransition){
            fragmentTransition.setCustomAnimations(android.R.anim.slide_out_right, android.R.anim.slide_in_left)
        }
        fragmentTransition.replace(R.id.frameLayout, fragment).addToBackStack(fragment.javaClass.simpleName)
        fragmentTransition.commit()
    }

}