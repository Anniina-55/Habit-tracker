package com.example.habit_tracker.logic

import com.example.habit_tracker.R
import com.example.habit_tracker.model.PlantPart
import com.example.habit_tracker.model.PlantPartInstance

// List of all plant part images
object PlantResources {
    val plantImages = mapOf(
        PlantPart.POT to listOf(
            R.drawable.punainen_ruukku,
            R.drawable.ruskea_ruukku,
            R.drawable.keltainen_ruukku
        ),
        PlantPart.STEM to listOf(
            R.drawable.varsi
        ),
        PlantPart.LEAF_SMALL_RIGHT to listOf(
            R.drawable.pieni_lehti_oikea,
            R.drawable.sahalaita_pieni_oikea),

        PlantPart.LEAF_SMALL_LEFT to listOf(
            R.drawable.sahalaita_pieni_vasen,
            R.drawable.pieni_lehti_vasen
        ),
        PlantPart.LEAF_BIG_RIGHT to listOf(
            R.drawable.sahalaita_iso_oikea,
            R.drawable.silea_iso_oikea),

        PlantPart.LEAF_BIG_LEFT to listOf(
            R.drawable.silea_iso_vasen,
            R.drawable.sahalaita_iso_vasen
        ),
        PlantPart.FLOWER to listOf(
            R.drawable.violetti_kukka,
            R.drawable.punainen_kukka,
            R.drawable.sininen_kukka
        )
    )
}

// generate a plant with random parts
fun generatePlant(): List<PlantPartInstance> {
    val parts = mutableListOf<PlantPartInstance>()

    parts.add(
        PlantPartInstance(
            PlantPart.POT,
            PlantResources.plantImages[PlantPart.POT]!!.random()
        )
    )

    parts.add(
        PlantPartInstance(
        PlantPart.STEM,
            PlantResources.plantImages[PlantPart.STEM]!!.random()
        )
    )

    // 3 leafs: 1 left side, 1 right side and 1 random left/right leaf
    val firstLeaf = PlantPart.LEAF_SMALL_LEFT
    val secondLeaf = PlantPart.LEAF_SMALL_RIGHT
    val thirdLeaf = listOf(
        PlantPart.LEAF_BIG_LEFT,
        PlantPart.LEAF_BIG_RIGHT
    ).random()

    parts.add(PlantPartInstance(
        firstLeaf,
        PlantResources.plantImages[firstLeaf]!!.random()
    ))

    parts.add(PlantPartInstance(
        secondLeaf,
        PlantResources.plantImages[secondLeaf]!!.random()
    ))

    parts.add(PlantPartInstance(
        thirdLeaf,
        PlantResources.plantImages[thirdLeaf]!!.random()
    ))

    parts.add(
        PlantPartInstance(
            PlantPart.FLOWER,
            PlantResources.plantImages[PlantPart.FLOWER]!!.random()
        )
    )

    return parts
}