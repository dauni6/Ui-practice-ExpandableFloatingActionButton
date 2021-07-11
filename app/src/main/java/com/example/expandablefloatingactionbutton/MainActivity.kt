package com.example.expandablefloatingactionbutton

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Toast
import androidx.core.view.isVisible
import com.example.expandablefloatingactionbutton.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val rotateOpen: Animation by lazy { AnimationUtils.loadAnimation(this, R.anim.rotate_open_anim) }
    private val rotateClose: Animation by lazy { AnimationUtils.loadAnimation(this, R.anim.rotate_close_anim) }
    private val fromBottom: Animation by lazy { AnimationUtils.loadAnimation(this, R.anim.from_bottom_anim) }
    private val toBottom: Animation by lazy { AnimationUtils.loadAnimation(this, R.anim.to_bottom_anim) }

    private var clicked = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.addFAB.setOnClickListener {
            onAddButtonClicked()
        }

        binding.editFAB.setOnClickListener {
            Toast.makeText(this, "Edit button Clicked.", Toast.LENGTH_SHORT).show()
        }

        binding.imageFAB.setOnClickListener {
            Toast.makeText(this, "Image button Clicked.", Toast.LENGTH_SHORT).show()

        }

    }

    private fun onAddButtonClicked() {
        setVisibility(clicked)
        setAnimation(clicked)
        setClickable(clicked)
        clicked = clicked.not()
    }

    private fun setVisibility(clicked: Boolean) = with(binding) {
        if (clicked.not()) {
            editFAB.isVisible = true
            imageFAB.isVisible = true
        } else {
            editFAB.isVisible = false
            imageFAB.isVisible = false
        }
    }

    private fun setAnimation(clicked: Boolean) = with(binding) {
        if (clicked.not()) {
            editFAB.startAnimation(fromBottom)
            imageFAB.startAnimation(fromBottom)
            addFAB.startAnimation(rotateOpen)
        } else {
            editFAB.startAnimation(toBottom)
            imageFAB.startAnimation(toBottom)
            addFAB.startAnimation(rotateClose)
        }
    }

    private fun setClickable(clicked: Boolean) = with(binding) {
        if (clicked.not()) {
            editFAB.isClickable = true
            imageFAB.isClickable = true
        } else {
            editFAB.isClickable = false
            imageFAB.isClickable = false
        }
    }

}