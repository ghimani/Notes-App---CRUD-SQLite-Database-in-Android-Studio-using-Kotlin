package com.example.sqlliteproject

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.sqlliteproject.databinding.ActivityAddNoteBinding

class AddNoteActivity : AppCompatActivity() {

    private  lateinit var binding: ActivityAddNoteBinding
    private lateinit var db:NotesDatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityAddNoteBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //setContentView(R.layout.activity_add_note)

        db= NotesDatabaseHelper(this)
        binding.saveButton.setOnClickListener {
            val title=binding.tittleEditText.text.toString()
            val context = binding.contentEditText.text.toString()
            val note=Note(0,title,context)
            db.insertNote(note)
            finish()
            Toast.makeText(this,"Note Saved",Toast.LENGTH_SHORT).show()
        }
    }
}