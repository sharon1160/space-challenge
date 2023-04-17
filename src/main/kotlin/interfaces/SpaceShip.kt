package interfaces

import models.Item

interface SpaceShip {
    /**
     * This method returns either true or false indicating
     * if the launch was successful or if the rocket has crashed.
     */
    fun launch(): Boolean

    /**
     * This method returns either true or false based on the
     * success of the landing.
     */
    fun land(): Boolean

    /**
     * This method takes an Item as an argument and returns
     * true if the rocket can carry such item or false if it
     * will exceed the weight limit.
     */
    fun canCarry(item: Item): Boolean

    /**
     * This method takes an Item object and updates the current
     * weight of the rocket.
     */
    fun carry(item: Item)
}