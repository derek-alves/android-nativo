class Pessoa (val nome: String, val idade: Int)

fun main(){
    val pessoa: Pessoa = Pessoa("Maria", 29)
    println(pessoa.idade)
}