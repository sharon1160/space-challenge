package models

import java.util.*

/**
 * This class represents the U-2 Rocket.
 */
class U2(
        cost: Float = 120.0f,
        weight: Float = 18.0f,
        maxWeight: Float = 29.0f,
        chanceLaunchExplosion: Float,
        chanceLandingCrash: Float,
    ): Rocket(
        cost,
        weight,
        maxWeight,
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
        chanceLaunchExplosion = 0.04f * (weight/maxWeight)

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
        chanceLandingCrash = 0.08f * (weight/maxWeight)

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