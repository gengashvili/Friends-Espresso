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
        this.testChat(ConstantData.FRIEND_NAME1, ConstantData.FRIEND1_MESSAGE_TEXT)
    }

    @Test
    fun testChatWithFriend17() {
        this.testChat(ConstantData.FRIEND_NAME2, ConstantData.FRIEND2_MESSAGE_TEXT)
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

    private fun testChat(friendName: String, messageText: String) {
        HomeSteps.openChatByFriendName(friendName)

        ChatSteps
            .checkThatChatIsOpenCorrectly(friendName)
            .sendMessageFriend(messageText)
            .assertMessageSentSuccessfully(messageText)
    }

}