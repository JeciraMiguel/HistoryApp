package com.rafaelpilartes.historyapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private val famousPeople = mapOf(
        "Nelson Mandela" to Pair(95, "South African anti-apartheid revolutionary."),
        "William Shakespeare" to Pair(52, "Renowned English playwright and poet."),
        "Albert Einstein" to Pair(76, "German theoretical physicist."),
        "Leonardo da Vinci" to Pair(67, "Italian Renaissance polymath."),
        "Marie Curie" to Pair(66, "Polish-French physicist and chemist."),
        "Mahatma Gandhi" to Pair(78, "Indian pacifist leader."),
        "Ludwig van Beethoven" to Pair(56, "German composer and pianist."),
        "Steve Jobs" to Pair(56, "Co-founder of Apple Inc."),
        "Cleopatra" to Pair(39, "Last ruler of the Ptolemaic Kingdom of Egypt."),
        "Wolfgang Amadeus Mozart" to Pair(35, "Austrian composer."),
        "Leon Trotsky" to Pair(60, "Russian revolutionary."),
        "Mother Teresa" to Pair(87, "Albanian-Indian Roman Catholic nun and missionary."),
        "Pablo Picasso" to Pair(91, "Spanish painter, sculptor, and printmaker."),
        "Thomas Edison" to Pair(84, "American inventor."),
        "Martin Luther King Jr." to Pair(39, "American civil rights leader."),
        "Galileo Galilei" to Pair(77, "Italian astronomer, physicist, and engineer."),
        "Issac Newton" to Pair(84, "English mathematician, physicist, and astronomer."),
        "Vincent van Gogh" to Pair(37, "Dutch Post-Impressionist painter."),
        "Abraham Lincoln" to Pair(56, "16th President of the United States."),
        "Charles Darwin" to Pair(73, "English naturalist, geologist, and biologist."),
        "John F. Kennedy" to Pair(46, "35th President of the United States."),
        "Winston Churchill" to Pair(90, "British statesman, army officer, and writer."),
        "Alexander the Great" to Pair(32, "King of Macedonia."),
        "Mark Twain" to Pair(74, "American writer and humorist."),
        "Michelangelo" to Pair(88, "Italian sculptor, painter, and architect."),
        "Karl Marx" to Pair(64, "German philosopher, economist, and political theorist."),
        "Frida Kahlo" to Pair(47, "Mexican painter."),
        "Albert Camus" to Pair(46, "French philosopher, author, and journalist."),
        "Emily Dickinson" to Pair(55, "American poet."),
        "Elvis Presley" to Pair(42, "American singer and actor."),
        "Fyodor Dostoevsky" to Pair(59, "Russian novelist."),
        "Marlon Brando" to Pair(80, "American actor and film director."),
        "Stephen Hawking" to Pair(76, "English theoretical physicist, cosmologist, and author."),
        "Jane Austen" to Pair(41, "English novelist."),
        "Walt Disney" to Pair(65, "American entrepreneur and animator."),
        "Johannes Gutenberg" to Pair(70, "German inventor of the printing press."),
        "Rosa Parks" to Pair(92, "American civil rights activist."),
        "Marilyn Monroe" to Pair(36, "American actress, model, and singer."),
        "Emily Brontë" to Pair(30, "English novelist and poet."),
        "Mao Zedong" to Pair(82, "Chinese communist revolutionary and founding father of the People's Republic of China."),
        "Johann Sebastian Bach" to Pair(65, "German composer and musician."),
        "Helen Keller" to Pair(87, "American author, political activist, and lecturer."),
        "Franklin D. Roosevelt" to Pair(63, "32nd President of the United States."),
        "Pierre Curie" to Pair(46, "French physicist, husband of Marie Curie."),
        "Neil Armstrong" to Pair(82, "American astronaut and the first person to walk on the Moon."),
        "Margaret Thatcher" to Pair(87, "British stateswoman and former Prime Minister of the United Kingdom."),
        "Sigmund Freud" to Pair(83, "Austrian neurologist and the founder of psychoanalysis."),
        "George Orwell" to Pair(46, "English novelist, essayist, journalist, and critic."),
        "Homer" to Pair(20, "Legendary Greek author of the epic poems the 'Iliad' and the 'Odyssey'.")
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val editTextAge = findViewById<EditText>(R.id.editTextAge)
        val buttonFind = findViewById<Button>(R.id.buttonFind)
        val buttonClear = findViewById<Button>(R.id.buttonClear)
        val textViewResult = findViewById<TextView>(R.id.textViewResult) // Declaração correta do textViewResult

        buttonFind.setOnClickListener {
            val ageText = editTextAge.text.toString().toIntOrNull()
            if (ageText != null && ageText in 20..100) {
                val famousPerson = findFamousPerson(ageText)
                textViewResult.text = famousPerson ?: "No matches."
                Log.d("FindFamousPerson", famousPerson ?: "No matches.") // Log
            } else {
                textViewResult.text = "The age is invalid or out of range (20-100)."
                Log.d("FindFamousPerson", "The age is invalid or out of range (20-100).") // Log
            }
        }

        buttonClear.setOnClickListener {
            editTextAge.text.clear()
            textViewResult.text = ""
        }
    }

    private fun findFamousPerson(age: Int): String? {
        for ((famousName, pair) in famousPeople) {
            val deathAge = pair.first
            val famousOccupation = pair.second
            if (age == deathAge) {
                return "You are $age years old, which is the same age as $famousName. $famousName was a $famousOccupation."
            }
        }
        return null
    }
}