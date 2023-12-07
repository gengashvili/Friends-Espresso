package com.atiurin.sampleapp.tests.espresso

import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import com.atiurin.sampleapp.activity.MainActivity
import com.atiurin.sampleapp.data.ConstantData
import com.atiurin.sampleapp.steps.ChatSteps
import com.atiurin.sampleapp.steps.CustomClickSteps
import com.atiurin.sampleapp.steps.HomeSteps
import com.atiurin.sampleapp.steps.MenuSteps
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class ChattingTests {

    @get:Rule
    val activityTestRule = ActivityScenarioRule(MainActivity::class.java)

    @Test()
    fun chatTest() {
        HomeSteps
            .checkThatTheDashboardIsLoaded()
            .openChatByFriendName(ConstantData.FRIEND_NAME)

        ChatSteps
            .checkThatChatIsOpenCorrectly(ConstantData.FRIEND_NAME)
            .greetFriend(ConstantData.GREETING_TEXT)
            .assertMessageSentSuccessfully(ConstantData.GREETING_TEXT)
    }

    @Test
    fun menuTest() {
        HomeSteps
            .checkThatTheDashboardIsLoaded()
            .openBurgerMenu()

        MenuSteps.chooseMenuOption(ConstantData.MENU_OPTION)

        CustomClickSteps
            .checkCustomClicksPageIsOpen()
            .markAllCornerCircles()
            .validateAllCornerCirclesAreMarked()
    }
}
