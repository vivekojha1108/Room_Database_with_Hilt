package com.example.chatroom

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.chatroom.databinding.ActivityMainBinding
import com.example.chatroom.viewmodel.TaskFragmentViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    private val taskFragmentViewModel: TaskFragmentViewModel by lazy {
        ViewModelProvider(this).get(TaskFragmentViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        taskFragmentViewModel.getAllList.observe(this) {
            Log.d(TAG, "onCreate: $it")
            it?.let {
                binding.listItemLl.removeAllViews()
                it.forEach { task ->
                    val textView: TextView = TextView(this)
                    textView.text = task.title
                    binding.listItemLl.addView(textView)
                }
            }
        }

        binding.button.setOnClickListener {
            val text = binding.editText.text.toString().trim()
            if (text.isNotBlank() && text.isNotEmpty()) {
                lifecycleScope.launchWhenCreated {
                    taskFragmentViewModel.insertData(text)
                }
            } else {
                Toast.makeText(this, "enter data first", Toast.LENGTH_SHORT).show()
            }
        }


    }

    companion object {
        private const val TAG = "MainActivity"
    }
}