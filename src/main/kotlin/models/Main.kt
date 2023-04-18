package models

import java.util.ArrayList

class Main {

    /**
     * This function prints a fleet of rockets with their items
     */
    fun <T : Rocket> printFleet(fleet: ArrayList<T>) {
        var i = 1
        for (rocket: T in fleet) {
            println("Rocket #$i")
            var j = 1
            for (item: Item in rocket.itemsList) {
                println("Item #$j name: ${item.name}")
                println("Item #$j weight: ${item.weight}")
                j += 1
            }
            i += 1
            println()
        }
    }
    fun main() {

        /* SIMULATION */

        // Creating the simulation
        val firstSimulation = Simulation()

        // Loading items for phase 1 and phase 2
        val phase1Items: ArrayList<Item> = firstSimulation.loadItems("phase-1.txt")
        val phase2Items: ArrayList<Item> = firstSimulation.loadItems("phase-2.txt")

        /* U1 SIMULATION */

        // Loading U1 rockets
        val u1FleetPhase1: ArrayList<U1> = firstSimulation.loadU1(phase1Items)
        val u1FleetPhase2: ArrayList<U1> = firstSimulation.loadU1(phase2Items)

        printFleet(u1FleetPhase1)

        // Running simulation for the two phases
        val u1TotalBudget1 = firstSimulation.runSimulation(u1FleetPhase1)
        val u1TotalBudget2 = firstSimulation.runSimulation(u1FleetPhase2)

        println("Total budget for U1 in phase 1: \$${u1TotalBudget1} Million")
        println("Total budget for U1 in phase 2: \$${u1TotalBudget2} Million")

        /* U2 simulation */

        // Loading U2 rockets
        val u2FleetPhase1: ArrayList<U2> = firstSimulation.loadU2(phase1Items)
        val u2FleetPhase2: ArrayList<U2> = firstSimulation.loadU2(phase2Items)

        // Running simulation for the two phases
        val u2TotalBudget1 = firstSimulation.runSimulation(u2FleetPhase1)
        val u2TotalBudget2 = firstSimulation.runSimulation(u2FleetPhase2)

        println("Total budget for U2 in phase 1: \$${u2TotalBudget1} Million")
        println("Total budget for U2 in phase 2: \$${u2TotalBudget2} Million")
    }
}

