package models

import java.util.ArrayList

class Main {
    fun main() {

        // U1 simulation

        val firstSimulation = Simulation()

        val phase1Items: ArrayList<Item> = firstSimulation.loadItems("phase-1.txt")
        val phase2Items: ArrayList<Item> = firstSimulation.loadItems("phase-2.txt")

        // U1 simulation

        val u1FleetPhase1: ArrayList<U1> = firstSimulation.loadU1(phase1Items)
        val u1FleetPhase2: ArrayList<U1> = firstSimulation.loadU1(phase2Items)
        val u1TotalBudget1 = firstSimulation.runSimulation(u1FleetPhase1)
        val u1TotalBudget2 = firstSimulation.runSimulation(u1FleetPhase2)

        println("Total budget for U1 in phase 1: \$${u1TotalBudget1} Million")
        println("Total budget for U1 in phase 2: \$${u1TotalBudget2} Million")

        // U2 simulation

        val u2FleetPhase1: ArrayList<U2> = firstSimulation.loadU2(phase1Items)
        val u2FleetPhase2: ArrayList<U2> = firstSimulation.loadU2(phase2Items)
        val u2TotalBudget1 = firstSimulation.runSimulation(u2FleetPhase1)
        val u2TotalBudget2 = firstSimulation.runSimulation(u2FleetPhase2)

        println("Total budget for U2 in phase 1: \$${u2TotalBudget1} Million")
        println("Total budget for U2 in phase 2: \$${u2TotalBudget2} Million")
    }
}

