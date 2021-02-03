package com.example.notes.util

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import com.example.notes.R
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.fragment_notes_bottom_sheets.*

class NoteBottomSheetFragment : BottomSheetDialogFragment() {
    var selectedColor = "#171C26"

    companion object{
        fun newInstance(): NoteBottomSheetFragment{
            val args = Bundle()
            val fragment = NoteBottomSheetFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun setupDialog(dialog: Dialog, style: Int) {
        super.setupDialog(dialog, style)

        val view = LayoutInflater.from(context).inflate(R.layout.fragment_notes_bottom_sheets, null)
        dialog.setContentView(view)

        val param = (view.parent as View).layoutParams as CoordinatorLayout.LayoutParams

        val behavior = param.behavior

        if (behavior is BottomSheetBehavior<*>) {
            behavior.setBottomSheetCallback(object : BottomSheetBehavior.BottomSheetCallback(){
                override fun onStateChanged(bottomSheet: View, newState: Int) {
                    var state = ""
                    when(newState){
                        BottomSheetBehavior.STATE_DRAGGING -> {
                            state = "DRAGGING"
                        }

                        BottomSheetBehavior.STATE_SETTLING -> {
                            state = "SETTING"
                        }

                        BottomSheetBehavior.STATE_EXPANDED -> {
                            state = "EXPANDED"
                        }

                        BottomSheetBehavior.STATE_COLLAPSED -> {
                            state = "COLLAPSED"
                        }

                        BottomSheetBehavior.STATE_HIDDEN -> {
                            state = "HIDDEN"
                            dismiss()
                            behavior.state = BottomSheetBehavior.STATE_COLLAPSED
                        }
                    }
                }

                override fun onSlide(bottomSheet: View, slideOffset: Float) {

                }

            })
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    private fun setListener(){
        fNote1.setOnClickListener{

            imgNote1.setImageResource(R.drawable.ic_tick)
            imgNote2.setImageResource(0)
            imgNote3.setImageResource(0)
            imgNote4.setImageResource(0)
            imgNote5.setImageResource(0)
            imgNote6.setImageResource(0)

            selectedColor = "#4e33ff"

            val intent = Intent("bottom_sheet_action")
            intent.putExtra("actionBlue", "Blue")
            intent.putExtra("selectedColor", selectedColor)
            LocalBroadcastManager.getInstance(requireContext()).sendBroadcast(intent)

        }

        fNote2.setOnClickListener{
            imgNote1.setImageResource(0)
            imgNote2.setImageResource(R.drawable.ic_tick)
            imgNote3.setImageResource(0)
            imgNote4.setImageResource(0)
            imgNote5.setImageResource(0)
            imgNote6.setImageResource(0)

            selectedColor = "#ffd633"

            val intent = Intent("bottom_sheet_action")
            intent.putExtra("actionYellow", "Yellow")
            intent.putExtra("selectedColor", selectedColor)
            LocalBroadcastManager.getInstance(requireContext()).sendBroadcast(intent)

        }

        fNote3.setOnClickListener{
            imgNote1.setImageResource(0)
            imgNote2.setImageResource(0)
            imgNote3.setImageResource(R.drawable.ic_tick)
            imgNote4.setImageResource(0)
            imgNote5.setImageResource(0)
            imgNote6.setImageResource(0)

            selectedColor = "#ff7746"

            val intent = Intent("bottom_sheet_action")
            intent.putExtra("actionOrange", "Orange")
            intent.putExtra("selectedColor", selectedColor)
            LocalBroadcastManager.getInstance(requireContext()).sendBroadcast(intent)

        }

        fNote4.setOnClickListener{
            imgNote1.setImageResource(0)
            imgNote2.setImageResource(0)
            imgNote3.setImageResource(0)
            imgNote4.setImageResource(R.drawable.ic_tick)
            imgNote5.setImageResource(0)
            imgNote6.setImageResource(0)

            selectedColor = "#ae3b76"

            val intent = Intent("bottom_sheet_action")
            intent.putExtra("actionPurple", "Purple")
            intent.putExtra("selectedColor", selectedColor)
            LocalBroadcastManager.getInstance(requireContext()).sendBroadcast(intent)

        }

        fNote5.setOnClickListener{
            imgNote1.setImageResource(0)
            imgNote2.setImageResource(0)
            imgNote3.setImageResource(0)
            imgNote4.setImageResource(0)
            imgNote5.setImageResource(R.drawable.ic_tick)
            imgNote6.setImageResource(0)

            selectedColor = "#0aebaf"

            val intent = Intent("bottom_sheet_action")
            intent.putExtra("actionGreen", "Green")
            intent.putExtra("selectedColor", selectedColor)
            LocalBroadcastManager.getInstance(requireContext()).sendBroadcast(intent)

        }

        fNote6.setOnClickListener{
            imgNote1.setImageResource(0)
            imgNote2.setImageResource(0)
            imgNote3.setImageResource(0)
            imgNote4.setImageResource(0)
            imgNote5.setImageResource(0)
            imgNote6.setImageResource(R.drawable.ic_tick)

            selectedColor = "#202734"

            val intent = Intent("bottom_sheet_action")
            intent.putExtra("actionBlack", "Black")
            intent.putExtra("selectedColor", selectedColor)
            LocalBroadcastManager.getInstance(requireContext()).sendBroadcast(intent)

        }
    }
}