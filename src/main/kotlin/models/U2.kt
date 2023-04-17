package models

/**
 * This class represents the U-2 Rocket.
 */
class U2(
        cost: Float,
        weight: Float,
        maxWeight: Float,
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
        TODO("Not yet implemented")
    }

    /**
     * Returns either true or false based on the success
     * of the landing and on a random number using
     * the probability equation.
     */
    override fun land(): Boolean {
        TODO("Not yet implemented")
    }
}