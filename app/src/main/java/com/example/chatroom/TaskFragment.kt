package com.example.chatroom

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.chatroom.databinding.FragmentChatBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class TaskFragment : Fragment(R.layout.fragment_chat) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding: FragmentChatBinding = FragmentChatBinding.bind(view)
        binding.apply {

        }
    }

    companion object {
        private const val TAG = "TaskFragment"
    }
}