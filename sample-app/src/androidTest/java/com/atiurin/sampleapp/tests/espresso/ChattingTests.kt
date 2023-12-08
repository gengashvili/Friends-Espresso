package com.atiurin.sampleapp.tests.espresso

import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import com.atiurin.sampleapp.activity.MainActivity
import com.atiurin.sampleapp.data.ConstantData
import com.atiurin.sampleapp.steps.ChatSteps
import com.atiurin.sampleapp.steps.HomeSteps
import com.atiurin.sampleapp.steps.MenuSteps
import com.atiurin.sampleapp.steps.UiElementsSteps
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class ChattingTests {

    @get:Rule
    val activityTestRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun testChatWithEmmetBrown() {
        HomeSteps.openChatByFriendName(ConstantData.FRIEND_NAME1)

        ChatSteps
            .checkThatChatIsOpenCorrectly(ConstantData.FRIEND_NAME1)
            .sendMessageFriend(ConstantData.FRIEND1_MESSAGE_TEXT)
            .assertMessageSentSuccessfully(ConstantData.FRIEND1_MESSAGE_TEXT)
    }

    @Test
    fun testChatWithFriend17() {
        HomeSteps.openChatByFriendName(ConstantData.FRIEND_NAME2)

        ChatSteps
            .checkThatChatIsOpenCorrectly(ConstantData.FRIEND_NAME2)
            .sendMessageFriend(ConstantData.FRIEND2_MESSAGE_TEXT)
            .assertMessageSentSuccessfully(ConstantData.FRIEND2_MESSAGE_TEXT)
    }

    @Test
    fun testUiElementsPage() {
        HomeSteps
            .checkThatTheDashboardIsLoaded()
            .openBurgerMenu()

        MenuSteps.chooseMenuOption(ConstantData.MENU_OPTION)

        UiElementsSteps
            .checkThatPageIsOpen()
            .unMarkButtons()
            .checkThatButtonsAreUnMarked()
            .chooseOptionInvisible()
            .validateButtonIsInvisible()
    }

}