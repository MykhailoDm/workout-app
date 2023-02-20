package com.workoutapp.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.workoutapp.R
import com.workoutapp.databinding.ItemExerciseStatusBinding
import com.workoutapp.model.ExerciseModel

class ExerciseStatusAdapter(val items: ArrayList<ExerciseModel>) :
    RecyclerView.Adapter<ExerciseStatusAdapter.ExerciseStatusViewHolder>() {

    class ExerciseStatusViewHolder(binding: ItemExerciseStatusBinding): RecyclerView.ViewHolder(binding.root) {
        val tvItem = binding.tvItem
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExerciseStatusViewHolder {
        return ExerciseStatusViewHolder(ItemExerciseStatusBinding.inflate(
            LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ExerciseStatusViewHolder, position: Int) {
        val model: ExerciseModel = items[position]
        holder.tvItem.text = model.id.toString()

        when {
            model.isSelected -> {
                holder.tvItem.background = ContextCompat.getDrawable(
                    holder.itemView.context,
                    R.drawable.item_circular_thin_color_accent_border
                )
                holder.tvItem.setTextColor(
                    ContextCompat.getColor(holder.itemView.context, R.color.text_exercise_item))
            }
            model.isCompleted -> {
                holder.tvItem.background = ContextCompat.getDrawable(
                    holder.itemView.context,
                    R.drawable.item_circular_color_accent_background
                )
                holder.tvItem.setTextColor(
                    ContextCompat.getColor(holder.itemView.context, R.color.text_exercise_item_completed))
            }
            else -> {
                holder.tvItem.background = ContextCompat.getDrawable(
                    holder.itemView.context,
                    R.drawable.item_circular_color_gray_background
                )
                holder.tvItem.setTextColor(
                    ContextCompat.getColor(holder.itemView.context, R.color.text_exercise_item))
            }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }
}