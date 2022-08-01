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
        val rockButton: Button = findViewById(R.id.rockButton)
        val iceButton: Button = findViewById(R.id.iceButton)
        val normalButton: Button = findViewById(R.id.normalButton)
        val electricButton: Button = findViewById(R.id.electricButton)
        val fightingButton: Button = findViewById(R.id.fightingButton)
        val poisonButton: Button = findViewById(R.id.poisonButton)
        val groundButton: Button = findViewById(R.id.groundButton)
        val flyingButton: Button = findViewById(R.id.flyingButton)
        val psychicButton: Button = findViewById(R.id.psychicButton)
        val bugButton: Button = findViewById(R.id.bugButton)
        val ghostButton: Button = findViewById(R.id.ghostButton)
        val dragonButton: Button = findViewById(R.id.dragonButton)
        val darkButton: Button = findViewById(R.id.darkButton)
        val steelButton: Button = findViewById(R.id.steelButton)
        val fairyButton: Button = findViewById(R.id.fairyButton)
        // Set Click listeners for each button to check quiz answer

        grassButton.setOnClickListener { checkAnswer("Grass") }
        fireButton.setOnClickListener { checkAnswer("Fire") }
        waterButton.setOnClickListener { checkAnswer("Water") }
        rockButton.setOnClickListener { checkAnswer("Rock") }
        iceButton.setOnClickListener { checkAnswer("Ice") }
        normalButton.setOnClickListener { checkAnswer("Normal") }
        electricButton.setOnClickListener { checkAnswer("Electric") }
        fightingButton.setOnClickListener { checkAnswer("Fighting")}
        poisonButton.setOnClickListener { checkAnswer("Poison")}
        groundButton.setOnClickListener { checkAnswer("Ground")}
        flyingButton.setOnClickListener { checkAnswer("Flying")}
        psychicButton.setOnClickListener { checkAnswer("Psychic")}
        bugButton.setOnClickListener { checkAnswer("Bug")}
        ghostButton.setOnClickListener { checkAnswer("Ghost")}
        dragonButton.setOnClickListener { checkAnswer("Dragon")}
        darkButton.setOnClickListener { checkAnswer("Dark")}
        steelButton.setOnClickListener { checkAnswer("Steel")}
        fairyButton.setOnClickListener { checkAnswer("Fairy")}



        checkAnswer("begin")
    }

    var score = 0


    // Create Type Triangle Objects
    private val fire = Type((listOf("Grass","Ice","Bug","Steel")), listOf("Water","Ground","Rock"), "Fire")
    private val water = Type((listOf("Fire","Ground","Rock")), listOf("Grass","Electric",), "Water")
    private val grass = Type((listOf("Water","Ground","Rock")), listOf("Fire","Flying","Ice","Bug","Poison"),"Grass")
    private val rock = Type((listOf("Fire","Ice","Flying","Bug")), listOf("Water","Grass","Fighting","Ground","Steel"), "Rock")
    private val ice = Type((listOf("Grass","Flying","Dragon","Ground")), listOf("Fire","Fighting","Rock","Steel"), "Ice")
    private val normal = Type((listOf("")), listOf("Fighting"), "Normal")
    private val electric = Type((listOf("Water","Flying",)), listOf("Ground"), "Electric")
    private val fighting = Type((listOf("Normal","Ice","Rock")), listOf("Flying","Psychic","Fairy"), "Fighting")
    private val poison = Type((listOf("Grass","Fairy")), listOf("Ground","Psychic"), "Poison")
    private val ground = Type((listOf("Electric","Fire","Poison","Rock","Steel")), listOf("Water","Grass","Ice"), "Ground")
    private val flying = Type((listOf("Grass","Fighting","Bug")), listOf("Electric","Ice","Rock"), "Flying")
    private val psychic = Type((listOf("Fighting","Poison")), listOf("Dark","Ghost","Bug"), "Psychic")
    private val bug = Type((listOf("Grass","Psychic","Dark")), listOf("Fire","Flying","Rock"), "Bug")
    private val ghost = Type((listOf("Psychic","Ghost")), listOf("Ghost","Dark"), "Ghost")
    private val dragon = Type((listOf("Dragon")), listOf("Ice","Dragon","Fairy"), "Dragon")
    private val dark = Type((listOf("Psychic","Ghost")), listOf("Fighting","Bug","Fairy"), "Dark")
    private val steel = Type((listOf("Ice","Rock","Fairy")), listOf("Fire","Fighting","Ground"), "Steel")
    private val fairy = Type((listOf("Fighting","Dragon","Dark")), listOf("Poison","Steel"), "Fairy")



    private var testQuestion = listOf("")

    // Create list of types
     private val typeList = listOf(fire, water, grass, rock, ice, normal, electric,
                                    fighting, poison, ground, flying, psychic, bug,
                                    ghost, dragon, dark, steel, fairy)
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
        if (testQuestion.contains(answer)) {
            Toast.makeText(this@MainActivity, "Correct!", Toast.LENGTH_SHORT).show()
            val scoreLabel: TextView = findViewById(R.id.labelScore)
            score += 100
            scoreLabel.text = score.toString()
        } else if (answer == "begin") {
            Toast.makeText(this@MainActivity, "Let's Begin", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this@MainActivity, "Nope!", Toast.LENGTH_SHORT).show()
        }
        /*when (answer) {
            "True" -> Toast.makeText(this@MainActivity, "Correct!", Toast.LENGTH_SHORT).show()
            "begin" -> Toast.makeText(this@MainActivity, "Let's Begin", Toast.LENGTH_SHORT).show()
            else -> Toast.makeText(this@MainActivity, "Nope!", Toast.LENGTH_SHORT).show()
        }*/
        setQuestion()
    }

}



class Type(private val strongAgainst: List<String>, private val weakTo: List<String>, private val typeName: String) {

    val strength = strongAgainst
    val weakness = weakTo
    val name = typeName
}
