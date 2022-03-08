package com.example.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //replace setContent view with data binding
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        //we can now access done button using binding
        binding.doneButton.setOnClickListener{
            addNickname(it)
        }
    }

    //The current issue with calling editText is that it creates a lot of overhead for our mainactivity class
    //We will fix this by using something called data binding
    private fun addNickname(view: View) {

        //make code easier to read using binding.apply
        binding.apply {
            nicknameText.text = binding.nicknameEdit.text
            //invalidates all binding expressions so they get recreated with correct data
            invalidateAll()
            nicknameEdit.visibility = View.GONE
            doneButton.visibility = View.GONE
            nicknameText.visibility = View.VISIBLE
        }


        //hide keyboard after done typing
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)

    }
}

/* Why use data binding?
-generates binding objects at compile times for all views in the layout
-accessing views through binding object is more efficient than findViewById
-for complex hierarchies, data binding can be significant performance gain
-findViewbyId traverses the view hierarchy at runntime to find a find everytime it's called
 */
