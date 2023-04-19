package models

import java.util.ArrayList
import java.util.Random

/**
 * This class represents the U-1 Rocket.
 */
class U1(
    cost: Int = 100,
    weight: Int = 10,
    maxWeight: Int = 18,
    currentLoad: Int = 0,
    maxLoad: Int = maxWeight - weight,
    itemsList: ArrayList<Item> = arrayListOf(),
    chanceLaunchExplosion: Float? = null,
    chanceLandingCrash: Float? = null,
    ): Rocket(
        cost,
        weight,
        maxWeight,
        currentLoad,
        maxLoad,
        itemsList,
        chanceLaunchExplosion,
        chanceLandingCrash
    ) {

    /**
     * Returns either true or false indicating if the
     * launch was successful or if the rocket has crashed,
     * based on a random number using the probability equation.
     */
    override fun launch(): Boolean {
        // probability equation
        chanceLaunchExplosion = 0.05f * (currentLoad.toFloat()/maxLoad.toFloat()) * 100

        // random number between 1 and 100
        val randomNumber = Random().nextFloat(100.0f) + 1.0f

        // True if the launch was successful
        // otherwise, False
        return if (chanceLaunchExplosion != null) {
            chanceLaunchExplosion!! <  randomNumber
        }
        else {
            false
        }
    }

    /**
     * Returns either true or false based on the success
     * of the landing and on a random number using
     * the probability equation.
     */
    override fun land(): Boolean {
        // probability equation
        chanceLandingCrash = 0.01f * (currentLoad.toFloat()/maxLoad.toFloat()) * 100

        // random number between 1 and 100
        val randomNumber = Random().nextFloat(100.0f) + 1.0f

        // True if the landing was successful
        // otherwise, False
        return if (chanceLandingCrash != null) {
            chanceLandingCrash!! <  randomNumber
        }
        else {
            false
        }
    }
}