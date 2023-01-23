package com.workoutapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.Toast
import com.workoutapp.databinding.ActivityExerciseBinding

class ExerciseActivity : AppCompatActivity() {

    private var binding: ActivityExerciseBinding? = null

    private var restTimer: CountDownTimer? = null
    private var restProgress = 0

    private var exerciseTimer: CountDownTimer? = null
    private var exerciseProgress = 0

    companion object {
        private const val REST_MAX_TIME = 10000L
        private const val REST_COUNT_DOWN_INTERVAL = 1000L
        private const val EXERCISE_MAX_TIME = 30000L
        private const val EXERCISE_COUNT_DOWN_INTERVAL = 1000L
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityExerciseBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        setSupportActionBar(binding?.toolbarExercise)
        if (supportActionBar != null) {
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
        }
        binding?.toolbarExercise?.setNavigationOnClickListener {
            onBackPressed()
        }

        setupRestView()
    }

    private fun setupRestView() {
        if (restTimer != null) {
            restTimer?.cancel()
            restProgress = 0
        }

        setRestProgressBar()
    }

    private fun setRestProgressBar() {
        binding?.progressBar?.progress = restProgress
        restTimer = object : CountDownTimer(REST_MAX_TIME, REST_COUNT_DOWN_INTERVAL) {
            override fun onTick(millisUntilFinished: Long) {
                restProgress++
                val progress = ((REST_MAX_TIME / REST_COUNT_DOWN_INTERVAL) - restProgress).toInt()
                binding?.progressBar?.progress = progress
                binding?.tvTimer?.text = progress.toString()
            }

            override fun onFinish() {
                setupExerciseView()
            }

        }.start()
    }

    private fun setupExerciseView() {
        binding?.flProgressBar?.visibility = View.INVISIBLE
        // TODO change to selection of exercises from list
        binding?.tvTitle?.text = "Exercise Name"
        binding?.flProgressBarExercise?.visibility = View.VISIBLE

        if (exerciseTimer != null) {
            exerciseTimer?.cancel()
            exerciseProgress = 0
        }

        setExerciseProgressBar()
    }

    private fun setExerciseProgressBar() {
        binding?.progressBarExercise?.progress = exerciseProgress
        exerciseTimer = object : CountDownTimer(EXERCISE_MAX_TIME, EXERCISE_COUNT_DOWN_INTERVAL) {
            override fun onTick(millisUntilFinished: Long) {
                exerciseProgress++
                val progress = ((EXERCISE_MAX_TIME / EXERCISE_COUNT_DOWN_INTERVAL) - exerciseProgress).toInt()
                binding?.progressBarExercise?.progress = progress
                binding?.tvTimerExercise?.text = progress.toString()
            }

            override fun onFinish() {
                Toast.makeText(
                    this@ExerciseActivity,
                    "30 Seconds are over, let's go to rest.",
                    Toast.LENGTH_SHORT
                ).show()
            }

        }.start()
    }

    override fun onDestroy() {
        super.onDestroy()

        if (restTimer != null) {
            restTimer?.cancel()
            restProgress = 0
        }

        if (exerciseTimer != null) {
            exerciseTimer?.cancel()
            exerciseProgress = 0
        }

        binding = null
    }
}