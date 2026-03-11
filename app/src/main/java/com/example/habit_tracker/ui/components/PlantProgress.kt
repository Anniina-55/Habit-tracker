package com.example.habit_tracker.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.habit_tracker.model.PlantPart
import com.example.habit_tracker.model.PlantPartInstance
import com.example.habit_tracker.ui.theme.LightGreen


@Composable
fun PlantDisplay(
    plantParts: List<PlantPartInstance>,
    progress: Float
) {

    Box(
        modifier = Modifier
            .padding(top = 30.dp)
            .height(800.dp)
            .background(
                LightGreen,
                shape = RoundedCornerShape(16.dp)),
        contentAlignment = Alignment.BottomCenter
    ) {
        plantParts.forEach { part ->
        // define if part is visible based on progress
        val visible = when (part.part) {
            PlantPart.POT -> progress >= 0f
            PlantPart.STEM -> progress >= 0.2f
            PlantPart.LEAF_SMALL_LEFT, PlantPart.LEAF_SMALL_RIGHT -> progress >= 0.4f
            PlantPart.LEAF_BIG_LEFT, PlantPart.LEAF_BIG_RIGHT -> progress >= 0.6f
            PlantPart.FLOWER -> progress >= 0.9f
        }

        if (!visible) return@forEach // if part isn't visible according to progress, skip it

            when (part.part) {
                // draw each plant part as an Image-composable with position, size and offset based on part data-type
                PlantPart.POT -> Image(
                    painter = painterResource(part.imageResource),
                    contentDescription = "pot",
                    modifier = Modifier
                        .size(400.dp)
                        .offset(x = (-10).dp)
                )

                PlantPart.STEM -> Image(
                    painter = painterResource(part.imageResource),
                    contentDescription = "stem",
                    modifier = Modifier
                        .size(350.dp)
                        .align(Alignment.BottomCenter)
                        .offset(y = (-250).dp)
                )

                PlantPart.LEAF_SMALL_RIGHT -> Image(
                    painter = painterResource(part.imageResource),
                    contentDescription = "leaf_small",
                    modifier = Modifier
                        .size(200.dp)
                        .align(Alignment.Center)
                        .offset(y = (-120).dp)
                        .offset(x = (40).dp)
                )

                PlantPart.LEAF_SMALL_LEFT -> Image(
                    painter = painterResource(part.imageResource),
                    contentDescription = "leaf_small",
                    modifier = Modifier
                        .size(200.dp)
                        .align(Alignment.Center)
                        .offset(y = (-125).dp)
                        .offset(x = (-40).dp)
                )

                PlantPart.LEAF_BIG_RIGHT -> Image(
                    painter = painterResource(part.imageResource),
                    contentDescription = "leaf_big",
                    modifier = Modifier
                        .size(300.dp)
                        .align(Alignment.Center)
                        .offset(y = (-50).dp)
                        .offset(x = (80).dp)
                )

                PlantPart.LEAF_BIG_LEFT -> Image(
                    painter = painterResource(part.imageResource),
                    contentDescription = "leaf_big",
                    modifier = Modifier
                        .size(300.dp)
                        .align(Alignment.Center)
                        .offset(y = (-50).dp)
                        .offset(x = (-60).dp)
                )

                PlantPart.FLOWER -> Image(
                    painter = painterResource(part.imageResource),
                    contentDescription = "flower",
                    modifier = Modifier
                        .size(400.dp)
                        .align(Alignment.TopCenter)
                        .offset(y = (-140).dp)
                )
            }
        }
    }
}

