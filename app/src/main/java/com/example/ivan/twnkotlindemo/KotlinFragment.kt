package com.example.ivan.twnkotlindemo

import android.animation.Animator
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewPropertyAnimator
import android.widget.TextView
import java.util.*

class KotlinFragment : Fragment() {

    companion object {
        const val TAG = "tag"
        const val KEY_DATA = "data"
        const val KEY_NAME = "name"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // ...

        // 1. Null Safety
        Log.d(TAG, arguments?.getBundle(KEY_DATA)?.getString(KEY_NAME))

        // 3. Default arguments/implementations
        sendInfo("content", time = Date().time)
    }

    // 3. Default arguments/implementations
    private fun sendInfo(
        content: String,
        time: Long = Date().time,
        tag: String = TAG
    ) {
        // send it!
    }

    // 3. Default arguments/implementations
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val textView = view.findViewById<TextView>(R.id.text)
        textView.animate()
            .alpha(0f)
            .setListener(
                onAnimationStart = {
                    // animation started!
                },
                onAnimationEnd = {
                    // animation ended!
                }
            )
    }

    // 3. Default arguments/implementations
    private inline fun ViewPropertyAnimator.setListener(
        crossinline onAnimationRepeat: (Animator?) -> Unit = {},
        crossinline onAnimationEnd: (Animator?) -> Unit = {},
        crossinline onAnimationCancel: (Animator?) -> Unit = {},
        crossinline onAnimationStart: (Animator?) -> Unit = {}
    ) {
        setListener(object : Animator.AnimatorListener{
            override fun onAnimationRepeat(animation: Animator?) {
                onAnimationRepeat.invoke(animation)
            }

            override fun onAnimationEnd(animation: Animator?) {
                onAnimationEnd.invoke(animation)
            }

            override fun onAnimationCancel(animation: Animator?) {
                onAnimationCancel.invoke(animation)
            }

            override fun onAnimationStart(animation: Animator?) {
                onAnimationStart.invoke(animation)
            }
        })
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_demo, container, false)
    }

}
