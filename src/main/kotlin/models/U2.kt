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
    override fun launch(): Boolean {
        TODO("Not yet implemented")
    }

    override fun land(): Boolean {
        TODO("Not yet implemented")
    }
}