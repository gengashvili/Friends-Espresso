package com.atiurin.sampleapp.steps

import com.atiurin.sampleapp.helper.assertIsViewDisplayed
import com.atiurin.sampleapp.pages.FriendsListPage
import com.atiurin.sampleapp.pages.MainManuPage
import com.atiurin.sampleapp.pages.UIElementPage
import com.atiurin.ultron.extensions.tap

object HomeSteps {

    fun checkThatTheDashboardIsLoaded(): HomeSteps {
        MainManuPage.mainManuBtn.assertIsViewDisplayed()
        UIElementPage.friendsChatContainer.assertIsViewDisplayed()
        return this
    }

    fun openChatByFriendName(friendName: String): HomeSteps {
        FriendsListPage.openChat(friendName)
        return this
    }

    fun openBurgerMenu(): HomeSteps {
        UIElementPage.burgerMenuBtn.tap()
        return this
    }
}
