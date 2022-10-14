package com.tech4dev.wta

import android.app.AlertDialog
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

    private var aScore = ""
    private var bScore = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addScoreButton = findViewById(R.id.addScoreButton)
        enterTeamA_Score = findViewById(R.id.enterTeamA_Score)
        enterTeamB_Score = findViewById(R.id.enterTeamB_Score)
        teamA_Score = findViewById(R.id.teamA_Score)
        teamB_Score = findViewById(R.id.teamB_Score)

        addScoreButton.setOnClickListener{
            Toast.makeText(this, "Add Score Button has been clicked", Toast.LENGTH_LONG).show()
            aScore = enterTeamA_Score.text.toString()
            bScore = enterTeamB_Score.text.toString()

            if (aScore.isNullOrEmpty()){
                Toast.makeText(this, "Enter a Valid Number", Toast.LENGTH_LONG).show()
            }else if (bScore.isNullOrEmpty()){
                Toast.makeText(this, "Enter a Valid Number", Toast.LENGTH_LONG).show()
            }else {
                updateScoreBoard()

                showWinnerPopup()
            }
        }
    }

    private fun updateScoreBoard() {
        teamA_Score.text = "Team A: $aScore"
        teamB_Score.text = "Team B: $bScore"
    }

    private fun showWinnerPopup() {
        var msg = if (aScore.toInt() > bScore.toInt()) {
            "Team A is the winner"
        } else {
            "Team B is the winner!"
        }

        var alertDialogue = AlertDialog.Builder(this)
        alertDialogue.setMessage(msg)
            .setTitle("Who is the winner?")
            .setPositiveButton("ok", null)
            .show()
    }
}