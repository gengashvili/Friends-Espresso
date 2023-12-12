package com.atiurin.sampleapp.pages

import android.view.View
import androidx.test.espresso.matcher.ViewMatchers.*
import com.atiurin.sampleapp.R
import org.hamcrest.CoreMatchers
import org.hamcrest.Matcher
import org.hamcrest.Matchers

object UIElementPage {

    val radioBtnInvisible: Matcher<View> by lazy { withId(R.id.invisible) }
    val radioBtnVisible: Matcher<View> by lazy { withText("VISIBLE") }
    val mainManuBtn: Matcher<View> by lazy { withClassName(CoreMatchers.`is`("android.widget.ImageButton")) }
    val nameChandler: Matcher<View> by lazy { Matchers.allOf(withId(R.id.tv_name), withText("Chandler Bing")) }
    val messageInputText: Matcher<View> by lazy {
        Matchers.allOf(
            withId(R.id.message_input_text),
            withText("Enter text")
        )
    }
    val textInput: Matcher<View> by lazy { Matchers.allOf(withId(R.id.message_input_text)) }
    val clearTextOption: Matcher<View> by lazy { withClassName(CoreMatchers.`is`("android.widget.ImageView")) }
    val burgerMenuBtn: Matcher<View> by lazy { withContentDescription("Open navigation drawer") }
    val friendsChatContainer: Matcher<View> by lazy { withId(R.id.recycler_friends) }
}
