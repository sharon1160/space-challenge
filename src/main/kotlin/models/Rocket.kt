package models

import interfaces.SpaceShip
import java.util.ArrayList

/**
 * This is a Rocket base class that can be inherited by classes U1 and U2.
 */
open class Rocket(
        val cost: Int,
        var weight: Int,
        val maxWeight: Int,
        var currentLoad: Int,
        val maxLoad: Int,
        val itemsList: ArrayList<Item>,
        var chanceLaunchExplosion: Float? = null,
        var chanceLandingCrash: Float? = null,
    ): SpaceShip {

    override fun launch(): Boolean {
        return true
    }

    override fun land(): Boolean {
        return true
    }

    override fun canCarry(item: Item): Boolean {
        return (currentLoad + item.weight) <= maxLoad
    }

    override fun carry(item: Item) {
        currentLoad += item.weight
        itemsList.add(item)
    }
}