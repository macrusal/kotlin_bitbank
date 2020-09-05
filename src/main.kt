fun main() {
    println("Bem vindo ao ByteBank")

    val contaMarcelo = Conta()
    contaMarcelo.titular = "Marcelo da Cruz Salvador"
    contaMarcelo.numeroConta = 1001
    contaMarcelo.setSaldo(1500.0)

    val contaVictor = Conta()
    contaVictor.titular = "Victor Hugo Salvador"
    contaVictor.numeroConta = 1002
    contaVictor.setSaldo(1100.0)

    println("Deposito - Creditando valores nas contas")
    contaMarcelo.deposita(250.0)
    contaVictor.deposita(373.0)

    println("--%%%--")
    println(contaMarcelo.titular)
    println(contaMarcelo.numeroConta)
    println(contaMarcelo.getSaldo())
    println()
    println(contaVictor.titular)
    println(contaVictor.numeroConta)
    println(contaVictor.getSaldo())

    println()

    println("Saca - Sacando valores das contas")
    contaMarcelo.saca(93.5)
    contaVictor.saca(39.57)

    println("--%%%--")
    println(contaMarcelo.titular)
    println(contaMarcelo.numeroConta)
    println(contaMarcelo.getSaldo())
    println()
    println(contaVictor.titular)
    println(contaVictor.numeroConta)
    println(contaVictor.getSaldo())

    println()

    println("Transfere - Transferindo valores da conta do Marcelo para a conta do Victor")
    if(contaMarcelo.transfere(8300.50, contaVictor)) {
        println("Sucesso - Trnasferencia realizada.")
    } else {
        println("Falha - Trnasferencia não realizada.")
    }

    println("--%%%--")
    println(contaMarcelo.titular)
    println(contaMarcelo.numeroConta)
    println(contaMarcelo.getSaldo())
    println()
    println(contaVictor.titular)
    println(contaVictor.numeroConta)
    println(contaVictor.getSaldo())

//    testaCondicao(saldo)
}

class Conta {

    var titular = ""
    var numeroConta = 0
    private var saldo  = 0.0

    fun deposita(valor: Double) {
        saldo += valor
    }

    fun saca(valor: Double) {
        if (saldo >= valor) {
            saldo -= valor
        }
    }

    fun transfere(valor: Double, destino: Conta) : Boolean{
        if (saldo >= valor) {
            saldo -= valor
            destino.deposita(valor)
            return true
        }
        return false
    }

    fun getSaldo(): Double {
        return saldo
    }

    fun setSaldo(valor: Double) {
        if(valor > 0) {
            saldo = valor
        }
    }
}
