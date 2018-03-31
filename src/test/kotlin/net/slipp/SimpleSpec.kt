package net.slipp

import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on
import org.junit.Assert
import org.junit.platform.runner.JUnitPlatform
import org.junit.runner.RunWith

//import org.junit.Assert
//import org.junit.platform.runner.JUnitPlatform
//import org.junit.runner.RunWith

@RunWith(JUnitPlatform::class)
object CalculatorSpec: Spek({

    given("a calculator") {
        val calculator = SampleCalculator()
        on("addition") {
            val sum = calculator.sum(2, 4)
            it("should return the result of adding the first number to the second number") {
                Assert.assertEquals(6, sum)
            }
        }
        on("subtraction") {
            val subtract = calculator.subtract(4, 2)
            it("should return the result of subtracting the second number from the first number") {
                Assert.assertEquals(2, subtract)
            }
        }
    }
})