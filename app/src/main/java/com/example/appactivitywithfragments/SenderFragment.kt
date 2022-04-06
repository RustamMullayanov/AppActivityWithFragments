package com.example.appactivitywithfragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider

class SenderFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.sender_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewModel = ViewModelProvider(requireActivity())[ReceiverViewModel::class.java]

        view.findViewById<Button>(R.id.send_message_button).setOnClickListener {
            replaceOnReceiverFragment()
            viewModel.setMessageText("Hello from SenderFragment")
        }
    }

    private fun replaceOnReceiverFragment() {
        requireActivity().supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container_view, ReceiverFragment())
            .addToBackStack(null)
            .commit()
    }
}