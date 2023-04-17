package models

/**
 * This class represents the U-1 Rocket.
 */
class U1(
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
    override fun launch(): Boolean {
        TODO("Not yet implemented")
    }

    override fun land(): Boolean {
        TODO("Not yet implemented")
    }
}