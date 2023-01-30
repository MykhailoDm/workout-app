package com.workoutapp.const

import com.workoutapp.R
import com.workoutapp.model.ExerciseModel

object Constants {

    fun defaultExerciseList(): ArrayList<ExerciseModel> {
        val exerciseList = ArrayList<ExerciseModel>()

        val jumpingJacks = ExerciseModel(
            1,
            "Jumping Jacks",
            R.drawable.ic_jumping_jacks,
            isCompleted = false,
            isSelected = false
        )
        exerciseList.add(jumpingJacks)

        val abdominalCrunch = ExerciseModel(
            2,
            "Abdominal Crunch",
            R.drawable.ic_abdominal_crunch,
            isCompleted = false,
            isSelected = false
        )
        exerciseList.add(abdominalCrunch)

        val highKnees = ExerciseModel(
            3,
            "High Knees running in place",
            R.drawable.ic_high_knees_running_in_place,
            isCompleted = false,
            isSelected = false
        )
        exerciseList.add(highKnees)

        val lunge = ExerciseModel(
            4,
            "Lunge",
            R.drawable.ic_lunge,
            isCompleted = false,
            isSelected = false
        )
        exerciseList.add(lunge)

        val plank = ExerciseModel(
            5,
            "Plank",
            R.drawable.ic_plank,
            isCompleted = false,
            isSelected = false
        )
        exerciseList.add(plank)

        val pushUp = ExerciseModel(
            6,
            "Push Up",
            R.drawable.ic_push_up,
            isCompleted = false,
            isSelected = false
        )
        exerciseList.add(pushUp)

        val pushUpAndRotation = ExerciseModel(
            7,
            "Push Up and Rotation",
            R.drawable.ic_push_up_and_rotation,
            isCompleted = false,
            isSelected = false
        )
        exerciseList.add(pushUpAndRotation)

        val sidePlank = ExerciseModel(
            8,
            "Side Plank",
            R.drawable.ic_side_plank,
            isCompleted = false,
            isSelected = false
        )
        exerciseList.add(sidePlank)

        val squat = ExerciseModel(
            9,
            "Squat",
            R.drawable.ic_squat,
            isCompleted = false,
            isSelected = false
        )
        exerciseList.add(squat)

        val stepUp = ExerciseModel(
            10,
            "Step Up onto Chair",
            R.drawable.ic_step_up_onto_chair,
            isCompleted = false,
            isSelected = false
        )
        exerciseList.add(stepUp)

        val tricepsDipOnChair = ExerciseModel(
            11,
            "Triceps Dip on Chair",
            R.drawable.ic_triceps_dip_on_chair,
            isCompleted = false,
            isSelected = false
        )
        exerciseList.add(tricepsDipOnChair)

        val wallSit = ExerciseModel(
            12,
            "Wall Sit",
            R.drawable.ic_wall_sit,
            isCompleted = false,
            isSelected = false
        )
        exerciseList.add(wallSit)

        return exerciseList
    }
}