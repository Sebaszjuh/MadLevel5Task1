package com.example.madlevel5task1.UI

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.madlevel5task1.Model.NoteViewModel
import com.example.madlevel5task1.R
import kotlinx.android.synthetic.main.fragment_add_note.*

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class AddNoteFragment : Fragment() {

    private val viewModel: NoteViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_add_note, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnSave.setOnClickListener {
            saveNote()
        }

        observeNote()
    }

    private fun observeNote() {

        viewModel.note.observe(viewLifecycleOwner, Observer { note ->
            if (note != null) {
                tilNoteTitle.editText?.setText(note.title)
                tilNoteText.editText?.setText(note.text)
            }
        })

        viewModel.error.observe(viewLifecycleOwner, Observer { message ->
            Toast.makeText(activity, message, Toast.LENGTH_SHORT).show()
        })

        viewModel.success.observe(viewLifecycleOwner, Observer { success ->
            //"pop" the backstack, this means we destroy this fragment and go back to the RemindersFragment
            findNavController().popBackStack()
        })
    }

    private fun saveNote() {
        viewModel.updateNote(
            tilNoteTitle.editText?.text.toString(),
            tilNoteText.editText?.text.toString()
        )
    }
}