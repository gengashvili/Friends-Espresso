package com.atiurin.sampleapp.steps

import androidx.test.espresso.matcher.ViewMatchers.isNotChecked
import com.atiurin.sampleapp.helper.assertIfViewIsNotDisplayed
import com.atiurin.sampleapp.helper.assertIsNotViewDisplayed
import com.atiurin.sampleapp.helper.assertIsViewDisplayed
import com.atiurin.sampleapp.helper.tap
import com.atiurin.sampleapp.pages.UiElementsPage


object UiElementsSteps {

    fun checkThatPageIsOpen(): UiElementsSteps {
        UiElementsPage.eventStatus.assertIsViewDisplayed()
        UiElementsPage.defaultContent.assertIsViewDisplayed()

        return this
    }

    fun unMarkButtons(): UiElementsSteps {
        UiElementsPage.enableButton.tap()
        UiElementsPage.clickableButton.tap()

        return this
    }

    fun checkThatButtonsAreUnMarked(): UiElementsSteps {
        with(UiElementsPage) {
            enableButton.matches(isNotChecked())
            clickableButton.matches(isNotChecked())
        }

        return this
    }

    fun chooseOptionInvisible(): UiElementsSteps {
        UiElementsPage.radioButtonInvisible.tap()
        return this
    }

    fun validateButtonIsInvisible(): UiElementsSteps {
        UiElementsPage.simpleButton.assertIfViewIsNotDisplayed()
        return this
    }

}