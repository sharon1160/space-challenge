package models

/**
 * This class represents an item to be carried by the rockets.
 */
class Item (
            var name: String,
            var weight: Float
    ) {
    fun decreaseWeight(difference: Float) {
        weight -= difference
    }
}