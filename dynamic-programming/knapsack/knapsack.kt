import java.lang.Integer.max
//input:
//  N: num of items
//  W: capacity of the bag
//  [V]: value of each item
//  [Wei]: weight of each item
//task:
//  maximize: ...
//  subject to: ...

fun main(args: Array<String>) {
    /* intput */
    val (N, W) = readLine()!!.split(" ").map{it.toInt()}
    var V: Array<Int> = Array(N) {0}
    var Wei: Array<Int> = Array(N) {0}
    for (index in V.indices) {
        val (a, b) = readLine()!!.split(" ").map{it.toInt()}
        V[index] = a
        Wei[index] = b
    }

    /* solve */
    var K: Array<Int> = Array(W+1) {0}
    for (w in 1..W) {
        for (i in 0..N-1) {
            if (w - Wei[i] >= 0) {
                K[w] = max(K[w], K[w - Wei[i]] + V[i])
            }
        }
    }
    
    /* output */
    println(K[W])
}
