// 18.6 회로 시뮬레이션

import org.stairwaybook.simulation._

object MySimulation extends CircuitSimulation {
  def InverterDelay = 1
  def AndGateDelay = 3
  def OrGateDelay = 5
}

import MySimulation._

val input1, input2, sum, carry = new Wire
probe("sum", sum)
probe("carry", carry)

halfAdder(input1, input2, sum, carry)

input1 setSignal true
run()
input2 setSignal true
run()
