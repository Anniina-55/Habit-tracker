package com.example.habit_tracker.model

// plant parts, called from the generator
enum class PlantPart {
    POT,
    STEM,
    LEAF_SMALL_RIGHT,
    LEAF_SMALL_LEFT,
    LEAF_BIG_RIGHT,
    LEAF_BIG_LEFT,
    FLOWER
}

data class PlantPartInstance(
    val part: PlantPart,
    val imageResource: Int
)
