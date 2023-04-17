package models

import interfaces.SpaceShip

/**
 * This is a Rocket base class that can be inherited by classes U1 and U2.
 */
open class Rocket(
        val cost: Float,
        val weight: Float,
        val maxWeight: Float,
        val chanceLaunchExplosion: Float,
        val chanceLandingCrash: Float,
    ): SpaceShip {

    override fun launch(): Boolean {
        return true
    }

    override fun land(): Boolean {
        return true
    }

    override fun canCarry(item: Item): Boolean {
        TODO("Not yet implemented")
    }

    override fun carry(item: Item) {
        TODO("Not yet implemented")
    }
}