//import org.junit.Assert.assertEquals
//
//fun <T> emptyCons() = consOf<T>()
//
//fun <T> consOf(vararg elements: T): Cons = when {
//    elements.isEmpty() -> Cons.Nil
//    else -> Cons.Cell(elements[0], consOf(*elements.sliceArray(1..elements.lastIndex)))
//}
//
//sealed class Cons {
//
//    data class Cell<T>(val head: T, val tail: Cons) : Cons()
//
//    object Nil : Cons()
//}
//
//fun walk(u: Any, s: Map<Var, Any>): Any =
//        when (u) {
//            is Var -> s[u]?.let { a -> walk(a, s) } ?: u
//            else -> u
//        }
//
//fun extS(x: Var, v: Any, s: Map<Var, Any>): Map<Var, Any> {
//    val s = s.toMutableMap()
//    s[x] = v
//    return s
//}
//
//fun unify(u: Any, v: Any, s: Map<Var, Any>): Any {
//    val u = walk(u, s)
//    val v = walk(v, s)
//    return when {
//        u is Var && v is Var && u == v -> s
//        u is Var -> extS(u, v, s)
//        v is Var -> extS(v, u, s)
////        u is Cons && v is Cons -> {
////            val s = unify(u.value.first, v.value.first, s)
////            val t = unify(u.value.second, v.value.second, s as Map<Var, Any>)
////            if (t != false) t else s
////        }
//        u == v -> s
//        else -> false
//    }
//}
//
//fun main(args: Array<String>) {
//
//    val s1 = mapOf(Var(0u) to 5, Var(1u) to true)
//    val s2 = mapOf(Var(1u) to 5, Var(0u) to Var(1u))
//
//    assertEquals(5, walk(Var(0u), s1))
//    assertEquals(5, walk(Var(0u), s2))
//
//    assertEquals(false, unify(Unit, 1, emptyMap()))
//    assertEquals(mapOf(Var(0u) to Unit), unify(Unit, Var(0u), emptyMap()))
//    assertEquals(false, unify(Unit, listOf(1, Var(0u)), emptyMap()))
//    assertEquals(false, unify(1, Unit, emptyMap()))
//    assertEquals(emptyMap<Any, Var>(), unify(1, 1, emptyMap()))
//    assertEquals(false, unify(1, 2, emptyMap()))
//    assertEquals(mapOf(Var(0u) to 1), unify(1, Var(0u), emptyMap()))
//    assertEquals(false, unify(1, emptyList<Any>(), emptyMap()))
//    assertEquals(mapOf(Var(0u) to 1), unify(Var(0u), 1, emptyMap()))
//    assertEquals(mapOf(Var(0u) to Var(1u)), unify(Var(0u), Var(1u), emptyMap()))
//    assertEquals(mapOf(Var(0u) to emptyList<Any>()), unify(Var(0u), emptyList<Any>(), emptyMap()))
//    assertEquals(mapOf(Var(0u) to consOf(1, 2, 3)), unify(Var(0u), consOf(1, 2, 3), emptyMap()))
//    assertEquals(emptyMap<Var, Any>(), unify(consOf(1, 2, 3), consOf(1, 2, 3), emptyMap()))
////    assertEquals(false, unify(l(1, 2, 3), l(3, 2, 1), emptyMap()))
//}
