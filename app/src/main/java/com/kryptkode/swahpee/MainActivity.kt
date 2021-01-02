package com.kryptkode.swahpee

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.kryptkode.commonandroid.viewbinding.viewBinding
import com.kryptkode.swahpee.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by viewBinding(ActivityMainBinding::inflate)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }

}