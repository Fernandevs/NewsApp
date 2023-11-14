package com.loc.newsapp.presentation.onboarding

import androidx.annotation.DrawableRes
import com.loc.newsapp.R

data class Page(
    val title: String,
    val description: String,
    @DrawableRes val image: Int
)

val pages: List<Page> = listOf(
    Page(
        title = "Ubi est bassus lumen?",
        description = "Rise darkly like a shiny cloud.",
        image = R.drawable.onboarding1
    ),
    Page(
        title = "Fermium moris, tanquam superbus adiurator.",
        description = "Abactuss sunt visuss de gratis assimilatio.",
        image = R.drawable.onboarding2
    ),
    Page(
        title = "Species de regius saga, gratia clinias!",
        description = "Messor, adiurator, et bulla.",
        image = R.drawable.onboarding3
    )
)
