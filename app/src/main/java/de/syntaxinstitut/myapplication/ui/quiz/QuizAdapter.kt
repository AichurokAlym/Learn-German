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

class QuizAdapter(
    private val context: Context,
    private val dataset: List<Quiz>,
    private val checkAnswerUpdateUI: (Quiz, Int) -> Boolean
) : RecyclerView.Adapter<QuizAdapter.ItemViewHolder>() {

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

        // das itemLayout wird gebaut
        val itemLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_quiz, parent, false)

        // und in einem ViewHolder zurückgegeben
        return ItemViewHolder(itemLayout)
    }

    /**
     * hier findet der Recyclingprozess statt
     * die vom ViewHolder bereitgestellten Parameter erhalten die Information des Listeneintrags
     */
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {

        // hier wird Quiz Elemente aus dem dataset geholt
        val quiz = dataset[position]

        holder.tvQuestion.text = quiz.question
        holder.answerA.text = quiz.answerA
        holder.answerB.text = quiz.answerB
        holder.answerC.text = quiz.answerC
        holder.answerD.text = quiz.answerD

        //alle Antwort Varianten werden auf neutrale answer_cards_style neu gesetzt
        if (!quiz.clicked) {
            holder.answerA.foreground = context.getDrawable(R.drawable.answer_cards_style)
            holder.answerB.foreground = context.getDrawable(R.drawable.answer_cards_style)
            holder.answerC.foreground = context.getDrawable(R.drawable.answer_cards_style)
            holder.answerD.foreground = context.getDrawable(R.drawable.answer_cards_style)
        }


        // mit checkedAnswer wird geklickte AntwortVariant geprüft
        // und alle andere Atwort Varianten werden nicht clickbar gemacht
        holder.answerA.setOnClickListener {
            checkedAnswer(quiz, 1, it as AppCompatButton)
            holder.answerB.isClickable = false
            holder.answerC.isClickable = false
            holder.answerD.isClickable = false
        }

        // mit checkedAnswer wird geklickte AntwortVariant geprüft
        // und alle andere Atwort Varianten werden nicht clickbar gemacht
        holder.answerB.setOnClickListener {
            checkedAnswer(quiz, 2, it as AppCompatButton)
            holder.answerA.isClickable = false
            holder.answerC.isClickable = false
            holder.answerD.isClickable = false
        }

        // mit checkedAnswer wird geklickte AntwortVariant geprüft
        // und alle andere Atwort Varianten werden nicht clickbar gemacht
        holder.answerC.setOnClickListener {
            checkedAnswer(quiz, 3, it as AppCompatButton)
            holder.answerA.isClickable = false
            holder.answerB.isClickable = false
            holder.answerD.isClickable = false
        }

        // mit checkedAnswer wird geklickte AntwortVariant geprüft
        // und alle andere Atwort Varianten werden nicht clickbar gemacht
        holder.answerD.setOnClickListener {
           checkedAnswer(quiz, 4, it as AppCompatButton)
            holder.answerA.isClickable = false
            holder.answerB.isClickable = false
            holder.answerC.isClickable = false
        }
    }

    //diese Funktion prüft die Antwort Varianten
    //fals die Antwort richtig ist, dann wird Buttons Farbe auf grün geändert
    //und wenn die Antwort falsch ist, dann wird Buttons Farbe auf rot geändert
    fun checkedAnswer (quiz: Quiz, int: Int, button: AppCompatButton) {
        val success = checkAnswerUpdateUI(quiz, int)
        if (success == true) {
            button.foreground = context.getDrawable(R.drawable.answer_cards_correct)
            quiz.clicked = true
        } else {
            button.foreground = context.getDrawable(R.drawable.answer_cards_wrong)
        }
    }

    // damit der LayoutManager weiß wie lang die Liste ist
    override fun getItemCount(): Int {
       return dataset.size
    }



}