package models

import java.util.*

/**
 * This class represents the U-2 Rocket.
 */
class U2(
        cost: Int = 120,
        weight: Int = 18,
        maxWeight: Int = 29,
        itemsList: ArrayList<Item> = arrayListOf(),
        chanceLaunchExplosion: Float? = null,
        chanceLandingCrash: Float? = null,
    ): Rocket(
        cost,
        weight,
        maxWeight,
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
        chanceLaunchExplosion = 0.04f * (weight/maxWeight) * 100

        // random number between 1 and 100
        val randomNumber = Random().nextInt(100) + 1

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
        chanceLandingCrash = 0.08f * (weight/maxWeight) * 100

        // random number between 1 and 100
        val randomNumber = Random().nextInt(100) + 1

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