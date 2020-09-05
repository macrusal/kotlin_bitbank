fun testaLacos() {
    var i = 0
    while (i < 5) {
        val titular: String = "Marcelo $i"
        val numeroConta: Int = 12009 + i
        var saldo = i + 10.0

        println("titular $titular")
        println("numeroConta $numeroConta")
        println("saldo $saldo")
        println()
        i++
    }
}