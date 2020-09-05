fun main() {
    println("Bem vindo ao ByteBank")

    //O uso de label permite mudar a ordem de entrada de valores no construtor da classe
    val contaMarcelo = Conta(titular = "Marcelo da Cruz Salvador", numeroConta = 1001)
    contaMarcelo.deposita(1500.0)

    //O uso de label permite mudar a ordem de entrada de valores no construtor da classe
    val contaVictor = Conta(numeroConta = 1002, titular = "Victor Hugo Salvador")
    contaVictor.deposita(1100.0)

    println("Deposito - Creditando valores nas contas")
    contaMarcelo.deposita(250.0)
    contaVictor.deposita(373.0)

    println("--%%%--")
    println(contaMarcelo.titular)
    println(contaMarcelo.numeroConta)
    println(contaMarcelo.saldo)
    println()
    println(contaVictor.titular)
    println(contaVictor.numeroConta)
    println(contaVictor.saldo)

    println()

    println("Saca - Sacando valores das contas")
    contaMarcelo.saca(93.5)
    contaVictor.saca(39.57)

    println("--%%%--")
    println(contaMarcelo.titular)
    println(contaMarcelo.numeroConta)
    println(contaMarcelo.saldo)
    println()
    println(contaVictor.titular)
    println(contaVictor.numeroConta)
    println(contaVictor.saldo)

    println()

    println("Transfere - Transferindo valores da conta do Marcelo para a conta do Victor")
    if (contaMarcelo.transfere(8300.50, contaVictor)) {
        println("Sucesso - Trnasferencia realizada.")
    } else {
        println("Falha - Trnasferencia não realizada.")
    }

    println("--%%%--")
    println(contaMarcelo.titular)
    println(contaMarcelo.numeroConta)
    println(contaMarcelo.saldo)
    println()
    println(contaVictor.titular)
    println(contaVictor.numeroConta)
    println(contaVictor.saldo)

//    testaCondicao(saldo)
}

class Conta(val titular: String,
            val numeroConta: Int
) {
    var saldo = 0.0
        private set

    fun deposita(valor: Double) {
        if (valor > 0) {
            saldo += valor
        }
    }

    fun saca(valor: Double) {
        if (saldo >= valor) {
            saldo -= valor
        }
    }

    fun transfere(valor: Double, destino: Conta): Boolean {
        if (saldo >= valor) {
            saldo -= valor
            destino.deposita(valor)
            return true
        }
        return false
    }
}
