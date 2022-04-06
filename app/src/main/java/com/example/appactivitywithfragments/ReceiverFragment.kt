package com.example.appactivitywithfragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView

class ReceiverFragment : Fragment() {
    private lateinit var messageView: TextView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.receiver_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        messageView = view.findViewById(R.id.messages_text)
        val viewModel = ViewModelProvider(requireActivity())[ReceiverViewModel::class.java]

        viewModel.textMessageLiveData.observe(requireActivity()) { messageText ->
            messageView.text = messageText.toString()
        }

        view.findViewById<Button>(R.id.read_button).setOnClickListener {
            viewModel.setMessageText(resources.getText(R.string.messages_text) as String)
        }
    }
}