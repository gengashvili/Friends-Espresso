package com.atiurin.sampleapp.steps

import com.atiurin.sampleapp.pages.ChatPage

object ChatSteps {

    fun checkThatChatIsOpenCorrectly(expectedChatName: String): ChatSteps {
        ChatPage.assertToolbarTitle(expectedChatName)
        return this
    }

    fun greetFriend(message: String): ChatSteps {
        ChatPage.sendMessage(message)
        return this
    }

    fun assertMessageSentSuccessfully(message: String): ChatSteps {
        ChatPage.assertMessageDisplayed(message)
        return this
    }
}
