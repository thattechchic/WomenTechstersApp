package com.tech4dev.wta

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var teamA_Score: TextView
    private lateinit var teamB_Score: TextView
    private lateinit var enterTeamA_Score: EditText
    private lateinit var enterTeamB_Score: EditText
    private lateinit var addScoreButton: Button

    private var aScore = 0
    private var bScore = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addScoreButton = findViewById(R.id.addScoreButton)
        enterTeamA_Score = findViewById(R.id.enterTeamA_Score)
        enterTeamB_Score = findViewById(R.id.enterTeamB_Score)
        teamA_Score = findViewById(R.id.teamA_Score)
        teamB_Score = findViewById(R.id.teamB_Score)

        addScoreButton.setOnClickListener{
            aScore = enterTeamA_Score.text.toString().toInt()
            bScore = enterTeamB_Score.text.toString().toInt()

            Toast.makeText(this, "Team A Score is $aScore\n Team B score is $bScore", Toast.LENGTH_LONG).show()
            teamA_Score.text = "Team A: $aScore"
            teamB_Score.text = "Team B: $bScore"
        }
    }
}