package models

import interfaces.SpaceShip

class Rocket: SpaceShip {
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