package models

import java.util.ArrayList
import java.io.File

/**
 * This class is responsible for reading item data
 * and filling up the rockets.
 */
class Simulation {

    /**
     * Returns the ArrayList of items.
     */
     fun loadItems(fileName: String): ArrayList<Item> {
        val filePath = "src/main/resources"
        val linesList: List<String> = File("$filePath/$fileName").readLines()
        val separator = '='
        val itemsList = arrayListOf<Item>()

        for (line in linesList) {
            val (name, weight) = line.split(separator)
            // Converting from kilograms to tons
            val weightTons = (weight.toFloat())/1000
            val item = Item(name, weightTons)
            itemsList.add(item)
        }
        return itemsList
    }

    /**
     * Returns the ArrayList of those U1 rockets that are fully loaded.
     */
    fun loadU1(itemsList: ArrayList<Item>): ArrayList<U1>{
        val totalItems = itemsList.size
        val u1Rockets: ArrayList<U1> = arrayListOf()
        var pos = 0

        do {
            val rocket = U1()
            for (i in pos..totalItems) {

                // When can carry
                if (rocket.canCarry(itemsList[i])) {
                    rocket.carry(itemsList[i])
                }
                // When can't carry
                else{
                    // If it's full
                    if (rocket.weight == rocket.maxWeight) {
                        pos = i + 1
                        break
                    }
                    // If it's not full
                    else if (rocket.weight < rocket.maxWeight) {
                        val difference = rocket.maxWeight - rocket.weight
                        rocket.weight += difference
                        itemsList[i].decreaseWeight(difference)
                        pos = i
                        break
                    }
                }
            }
            if (rocket.weight == rocket.maxWeight) {
                u1Rockets.add(rocket)
            }
        } while (pos + 1 < totalItems)

        return u1Rockets
    }

    fun loadU2(itemsList: ArrayList<Item>): ArrayList<U2>{
        val totalItems = itemsList.size
        val u2Rockets: ArrayList<U2> = arrayListOf()
        var pos = 0

        do {
            val rocket = U2()

            for (i in pos..totalItems) {

                // When can carry
                if (rocket.canCarry(itemsList[i])) {
                    rocket.carry(itemsList[i])
                }
                // When can't carry
                else{
                    // If it's full
                    if (rocket.weight == rocket.maxWeight) {
                        pos = i + 1
                        break
                    }
                    // When it's not full
                    else if (rocket.weight < rocket.maxWeight) {
                        val difference = rocket.maxWeight - rocket.weight
                        rocket.weight += difference
                        itemsList[i].decreaseWeight(difference)
                        pos = i
                        break
                    }
                }
            }
            if (rocket.weight == rocket.maxWeight) {
                u2Rockets.add(rocket)
            }
        } while (pos + 1 < totalItems)

        return u2Rockets
    }

    private fun sendLaunch(rocket: Rocket): Float {
        var budget = 0.0f
        val rocketCost: Float = rocket.cost

        if (rocket.launch()) {
            budget += rocketCost
        }
        else {
            while (!rocket.launch()) {
                budget += rocketCost
            }
        }
        return budget
    }

    private fun sendLand(rocket: Rocket): Float {
        var budget = 0.0f
        val rocketCost: Float = rocket.cost

        if (rocket.land()) {
            budget += rocketCost
        }
        else {
            while (!rocket.land()) {
                budget += rocketCost
            }
        }
        return budget
    }
    fun <T : Rocket> runSimulation(rocketList: ArrayList<T>): Float {
        var totalBudget = 0.0f

        for (rocket: Rocket in rocketList) {
            totalBudget += sendLaunch(rocket)
            totalBudget += sendLand(rocket)
        }
        return totalBudget
    }
}