package com.example.notes

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import com.example.notes.database.NotesDatabase
import com.example.notes.entities.Notes
import com.example.notes.util.NoteBottomSheetFragment
import kotlinx.android.synthetic.main.create_note_fragment.*
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*

class CreateNoteFragment : BaseFragment() {
    var selectedColor = "#171C26"
    var currentDate:String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //Inflate the layout for this fragment
        return inflater.inflate(R.layout.create_note_fragment, container, false)
    }

    companion object{
        @JvmStatic
        fun newInstance() =
            CreateNoteFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        LocalBroadcastManager.getInstance(requireContext()).registerReceiver(
            BroadcastReceiver, IntentFilter("bottom_sheet_action")
        )

        val sdf = SimpleDateFormat("dd/M/yyyy hh:mm:ss")
        currentDate = sdf.format(Date())

        dateTime.text = currentDate

        imgDone.setOnClickListener {
            //saveNote
            saveNote()
        }
        imgBack.setOnClickListener {
            requireActivity().supportFragmentManager.popBackStack()
        }

        imgMore.setOnClickListener {
            var noteBottomSheetFragment = NoteBottomSheetFragment.newInstance()
            noteBottomSheetFragment.show(requireActivity().supportFragmentManager, "Note Button Sheet Fragment")
        }
    }

    private fun saveNote(){

        if (notesTitle.text.isNullOrEmpty()){
            Toast.makeText(context, "Title Required", Toast.LENGTH_SHORT).show()
        }

        if (notesSubTitle.text.isNullOrEmpty()){
            Toast.makeText(context, "Notes Sub Title Required", Toast.LENGTH_SHORT).show()
        }

        if (notesDesc.text.isNullOrEmpty()){
            Toast.makeText(context,"Notes Description is Required", Toast.LENGTH_SHORT).show()
        }

        launch {
            var notes = Notes()
            notes.title = notesTitle.text.toString()
            notes.subTitle = notesSubTitle.text.toString()
            notes.noteText = notesDesc.text.toString()
            notes.dateTime = currentDate
            notes.color = selectedColor

            context?.let {
                NotesDatabase.getDatabase(it).noteDao().insertNotes(notes)
                notesTitle.setText("")
                notesSubTitle.setText("")
                notesDesc.setText("")

            }
        }

    }

    fun replaceFragment(fragment: Fragment, istransition: Boolean){
        val fragmentTransition = activity!!.supportFragmentManager.beginTransaction()

        if (istransition){
            fragmentTransition.setCustomAnimations(android.R.anim.slide_out_right, android.R.anim.slide_in_left)
        }
        fragmentTransition.replace(R.id.frameLayout, fragment).addToBackStack(fragment.javaClass.simpleName)
        fragmentTransition.commit()
    }

    private val BroadcastReceiver : BroadcastReceiver = object  : BroadcastReceiver(){
        override fun onReceive(context: Context?, intent: Intent?) {

            var actionColor = intent!!.getStringExtra("actionColor")

            when(actionColor!!){

                "Blue" ->{
                    selectedColor = intent.getStringExtra("selectedColor")!!
                    colorView.setBackgroundColor(Color.parseColor(selectedColor))
                }

                "Yellow" ->{
                    selectedColor = intent.getStringExtra("selectedColor")!!
                    colorView.setBackgroundColor(Color.parseColor(selectedColor))

                }

                "Orange" ->{
                    selectedColor = intent.getStringExtra("selectedColor")!!
                    colorView.setBackgroundColor(Color.parseColor(selectedColor))

                }

                "Purple" ->{
                    selectedColor = intent.getStringExtra("selectedColor")!!
                    colorView.setBackgroundColor(Color.parseColor(selectedColor))

                }

                "Green" ->{
                    selectedColor = intent.getStringExtra("selectedColor")!!
                    colorView.setBackgroundColor(Color.parseColor(selectedColor))

                }

                "Black" ->{
                    selectedColor = intent.getStringExtra("selectedColor")!!
                    colorView.setBackgroundColor(Color.parseColor(selectedColor))

                }

                else ->{
                    selectedColor = intent.getStringExtra("selectedColor")!!
                    colorView.setBackgroundColor(Color.parseColor(selectedColor))

                }

            }
        }

    }

    override fun onDestroy() {
        LocalBroadcastManager.getInstance(requireContext()).unregisterReceiver(BroadcastReceiver)
        super.onDestroy()

    }

}