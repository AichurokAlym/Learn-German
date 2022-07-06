package de.syntaxinstitut.myapplication.ui.quiz

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import de.syntaxinstitut.myapplication.R
import de.syntaxinstitut.myapplication.data.model.Quiz

class QuizAdapter(
    private val dataset: List<Quiz>,
    private val checkAnswerUpdateUI: (Quiz, Int) -> Unit
) : RecyclerView.Adapter<QuizAdapter.ItemViewHolder>() {

    inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
       // val tvQuizTitle: TextView = itemView.findViewById(R.id.tvVocable)
        val tvQuestion: TextView = itemView.findViewById(R.id.tvTranslate)
        val answerA: TextView = itemView.findViewById(R.id.btAnswerA)
        val answerB: TextView = itemView.findViewById(R.id.btAnswerB)
        val answerC: TextView = itemView.findViewById(R.id.btAnswerC)
        val answerD: TextView = itemView.findViewById(R.id.btAnswerD)

    }

    /**
     * hier werden neue ViewHolder erstellt
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val itemLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_quiz, parent, false)

        return ItemViewHolder(itemLayout)
    }

    /**
     * hier findet der Recyclingprozess statt
     * die vom ViewHolder bereitgestellten Parameter erhalten die Information des Listeneintrags
     */
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {

        // Hole den Kontakt aus dem dataset
        val quiz = dataset[position]

        holder.tvQuestion.text = quiz.question
        holder.answerA.text = quiz.answerA
        holder.answerB.text = quiz.answerB
        holder.answerC.text = quiz.answerC
        holder.answerD.text = quiz.answerD

        holder.answerA.setOnClickListener {
            val success = checkAnswerUpdateUI(quiz, 1)
            if (success == true) {
                holder.answerA.setBackgroundResource(R.drawable.answer_cards_correct)
            } else {
                holder.answerA.setBackgroundResource(R.drawable.answer_cards_wrong)
            }
        }

        holder.answerB.setOnClickListener {
            checkAnswerUpdateUI(quiz, 2)
        }

        holder.answerC.setOnClickListener {
            checkAnswerUpdateUI(quiz, 3)
        }

        holder.answerD.setOnClickListener {
            checkAnswerUpdateUI(quiz, 4)
        }


    }

    override fun getItemCount(): Int {
       return dataset.size
    }

}