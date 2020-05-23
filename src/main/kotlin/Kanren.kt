import org.junit.Assert

data class Var(val index: UInt)

data class State(val value: Map<Var, Any>) {

    fun walk(goal: Any): Any = when (goal) {
        is Var -> walk(value.getValue(goal))
        else -> goal
    }
}

fun main(args: Array<String>) {
    val s1 = State(mapOf(Var(0u) to 5, Var(1u) to true))
    val s2 = State(mapOf(Var(1u) to 5, Var(0u) to Var(1u)))

    Assert.assertEquals(5, s1.walk(Var(0u)))
    Assert.assertEquals(5, s2.walk(Var(0u)))
}
