package de.syntaxinstitut.myapplication.ui.quiz

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.recyclerview.widget.RecyclerView
import de.syntaxinstitut.myapplication.R
import de.syntaxinstitut.myapplication.data.model.Quiz

class QuizErgebnisAdapter(
    private val context: Context,
    private val dataset: List<Quiz>,
    private val checkAnswerUpdateUI: (Quiz, Int) ->Boolean

) : RecyclerView.Adapter<QuizErgebnisAdapter.ItemViewHolder>() {

    inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvQuestion: TextView = itemView.findViewById(R.id.tvTranslate)
        val answerA: AppCompatButton = itemView.findViewById(R.id.btAnswerA)
        val answerB: AppCompatButton = itemView.findViewById(R.id.btAnswerB)
        val answerC: AppCompatButton = itemView.findViewById(R.id.btAnswerC)
        val answerD: AppCompatButton = itemView.findViewById(R.id.btAnswerD)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val itemLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_quiz, parent, false)

        return ItemViewHolder(itemLayout)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {

        // Hole den Kontakt aus dem dataset
        val quiz = dataset[position]

        holder.tvQuestion.text = quiz.question
        holder.answerA.text = quiz.answerA
        holder.answerB.text = quiz.answerB
        holder.answerC.text = quiz.answerC
        holder.answerD.text = quiz.answerD

        //checkedAnswer()

        holder.answerA.isClickable = false
        holder.answerB.isClickable = false
        holder.answerC.isClickable = false
        holder.answerD.isClickable = false

    }

    fun checkedAnswer (quiz: Quiz, int: Int, button: AppCompatButton) {
        val success = checkAnswerUpdateUI(quiz, int)
        if (success == true) {
            button.foreground = context.getDrawable(R.drawable.answer_cards_correct)
            quiz.clicked = true
        } else {
            button.foreground = context.getDrawable(R.drawable.answer_cards_wrong)
        }
    }

    override fun getItemCount(): Int {
        return dataset.size
    }
}