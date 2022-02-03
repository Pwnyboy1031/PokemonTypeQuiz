package com.example.pokemontypequiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.pokemontypequiz.R.id
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Find buttons

        val grassButton: Button = findViewById(R.id.grassButton)
        val fireButton: Button = findViewById(R.id.fireButton)
        val waterButton: Button = findViewById(R.id.waterButton)
        // Set Click listeners for each button to check quiz answer

        grassButton.setOnClickListener { checkAnswer("Grass") }
        fireButton.setOnClickListener { checkAnswer("Fire") }
        waterButton.setOnClickListener { checkAnswer("Water") }

        checkAnswer("begin")
    }

    // Create Type Triangle Objects
    private val fire = Type("Grass", "Water", "Fire")
     private val water = Type("Fire", "Grass", "Water")
     private val grass = Type("Water", "Fire", "Grass")
    var testQuestion = ""

    // Create list of types
     private val typeList = setOf(fire, water, grass)
    // Set the type being quizzed and display it

    private fun setQuestion() {
        val quizType = typeList.random()
        val textView: TextView = findViewById(id.textView)
        textView.text = quizType.name
        testQuestion = quizType.weakness
    }
    // check the answer
    private fun checkAnswer(answer: String) {
        // Toast the user with correct or incorrect answer
        when (answer) {
            testQuestion -> Toast.makeText(this@MainActivity, "Correct!", Toast.LENGTH_SHORT).show()
            "begin" -> Toast.makeText(this@MainActivity, "Let's Begin", Toast.LENGTH_SHORT).show()
                else -> Toast.makeText(this@MainActivity, "Nope!", Toast.LENGTH_SHORT).show()
        }
        setQuestion()
    }

}



class Type(private val strongAgainst: String, private val weakTo: String, private val typeName: String) {

    val strength = strongAgainst
    val weakness = weakTo
    val name = typeName
}
