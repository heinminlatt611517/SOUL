package com.heinminlatt.soul_client_app.adapters

import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import com.heinminlatt.shared.adapter.BaseRecyclerAdapter
import com.heinminlatt.shared.views.viewHolders.BaseViewHolder
import com.heinminlatt.soul_client_app.R
import com.heinminlatt.soul_client_app.delegate.StartQuizScreenItemDelegate
import com.heinminlatt.soul_client_app.views.viewHolders.*
import kotlinx.android.synthetic.main.item_news_tiltle.view.*
import kotlinx.android.synthetic.main.item_quiz_question.view.*

class QuizQuestionAdapter(delegate : StartQuizScreenItemDelegate) : BaseRecyclerAdapter<BaseViewHolder<String>,String>() {
    private val mDelegate  = delegate
    var rowIndex = -1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<String> {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_quiz_question, parent, false)
        return QuizQuestionViewHolder(view)
    }


    override fun onBindViewHolder(holder: BaseViewHolder<String>, position: Int) {
        super.onBindViewHolder(holder, position)

        var questionLists = mData[position]
        holder.itemView.tv_quiz_question.text = questionLists
        holder.itemView.cv_quiz.setOnClickListener {
            rowIndex = position
            notifyDataSetChanged()
            mDelegate.onTapQuizQuestionItem(questionLists)
        }

        if(position==rowIndex) {
            holder.itemView.cv_quiz.setBackgroundResource(R.drawable.quiz_stroke_color)
            holder.itemView.tv_quiz_char.setTextColor(Color.parseColor("#2CB9C1"))
            holder.itemView.tv_quiz_question.setTextColor(Color.parseColor("#2CB9C1"))
            holder.itemView.iv_select_quick.setBackgroundResource(R.drawable.circle_bg)

        }
        else{
            holder.itemView.cv_quiz.setBackgroundResource(R.drawable.quiz_stroke_gray_color)
            holder.itemView.tv_quiz_char.setTextColor(Color.parseColor("#A1A6AD"))
            holder.itemView.tv_quiz_question.setTextColor(Color.parseColor("#A1A6AD"))
            holder.itemView.iv_select_quick.setBackgroundResource(R.drawable.circle_bg_gray)
        }

    }
}