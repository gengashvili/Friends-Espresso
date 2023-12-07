package com.atiurin.sampleapp.steps

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import com.atiurin.sampleapp.helper.assertIsViewDisplayed
import com.atiurin.sampleapp.helper.isChecked
import com.atiurin.sampleapp.pages.CustomClickPage
import org.junit.Assert

object CustomClickSteps {

    fun checkCustomClicksPageIsOpen(): CustomClickSteps {
        CustomClickPage.cornersContainer.assertIsViewDisplayed()
        return this
    }

    fun markAllCornerCircles(): CustomClickSteps {
        for (btn in CustomClickPage.cornerButtons) {
            onView(btn).perform(click())
        }

        return this
    }

    fun validateAllCornerCirclesAreMarked(): CustomClickSteps {
        for (btn in CustomClickPage.cornerButtons) {
            Assert.assertTrue(btn.isChecked())
        }

        return this
    }
}
