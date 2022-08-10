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

    //der ItemViewHolder weiß welche Teile des Layouts beim Recycling angepasst werden
    inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvQuestion: TextView = itemView.findViewById(R.id.tvTranslate)
        val answerA: AppCompatButton = itemView.findViewById(R.id.btAnswerA)
        val answerB: AppCompatButton = itemView.findViewById(R.id.btAnswerB)
        val answerC: AppCompatButton = itemView.findViewById(R.id.btAnswerC)
        val answerD: AppCompatButton = itemView.findViewById(R.id.btAnswerD)

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


        // hier wird alle Atwort Varianten auf nicht clickbar gesetzt
        holder.answerA.isClickable = false
        holder.answerB.isClickable = false
        holder.answerC.isClickable = false
        holder.answerD.isClickable = false

        //um richtige Antworten anzuzeigen werden alle Antwort Varianten auf entsprechende styles gesetzt
        when (quiz.rightAnswer) {
            1 -> {
                holder.answerA.foreground =context.getDrawable(R.drawable.answer_cards_correct)
                holder.answerB.foreground =context.getDrawable(R.drawable.answer_cards_style)
                holder.answerC.foreground =context.getDrawable(R.drawable.answer_cards_style)
                holder.answerD.foreground =context.getDrawable(R.drawable.answer_cards_style)
            }
            2 -> {
                holder.answerB.foreground =context.getDrawable(R.drawable.answer_cards_correct)
                holder.answerA.foreground =context.getDrawable(R.drawable.answer_cards_style)
                holder.answerC.foreground =context.getDrawable(R.drawable.answer_cards_style)
                holder.answerD.foreground =context.getDrawable(R.drawable.answer_cards_style)
            }

            3 -> {
                holder.answerC.foreground =context.getDrawable(R.drawable.answer_cards_correct)
                holder.answerA.foreground =context.getDrawable(R.drawable.answer_cards_style)
                holder.answerB.foreground =context.getDrawable(R.drawable.answer_cards_style)
                holder.answerD.foreground =context.getDrawable(R.drawable.answer_cards_style)
            }
            4 -> {
                holder.answerD.foreground =context.getDrawable(R.drawable.answer_cards_correct)
                holder.answerA.foreground =context.getDrawable(R.drawable.answer_cards_style)
                holder.answerC.foreground =context.getDrawable(R.drawable.answer_cards_style)
                holder.answerB.foreground =context.getDrawable(R.drawable.answer_cards_style)
            }
        }

    }

    // damit der LayoutManager weiß wie lang die Liste ist
    override fun getItemCount(): Int {
        return dataset.size
    }
}