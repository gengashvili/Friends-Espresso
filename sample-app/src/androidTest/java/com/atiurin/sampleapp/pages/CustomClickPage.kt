package com.atiurin.sampleapp.pages

import android.view.View
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.atiurin.sampleapp.R
import org.hamcrest.Matcher

object CustomClickPage {

    val cornersContainer: Matcher<View> by lazy { withId(R.id.imageView) }

    val cornerButtons: List<Matcher<View>> by lazy {
        listOf(
            withId(R.id.rB_top_left),
            withId(R.id.rB_top_right),
            withId(R.id.rB_bottom_left),
            withId(R.id.rB_bottom_right)
        )
    }
}
