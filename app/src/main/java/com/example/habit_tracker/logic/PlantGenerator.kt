package com.example.habit_tracker.logic

import com.example.habit_tracker.model.PlantPart

// generate a plant with random parts
fun generatePlant(): List<PlantPart> {
    val parts = mutableListOf<PlantPart>()

    parts.add(PlantPart.POT)

    parts.add(PlantPart.STEM)

    val leafCount = (1..4).random()
    repeat(leafCount) {
        parts.add(listOf(
            PlantPart.LEAF_SMALL,
            PlantPart.LEAF_BIG
        ).random())
    }

    parts.add(PlantPart.FLOWER)

    return parts
}