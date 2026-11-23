import java.io.File

fun main() {
    // Arrays contendo os itens do cardápio e seus respectivos preços
    val itens = arrayOf("Hambúrguer Artesanal", "Batata Rústica", "Suco Natural")
    val precos = doubleArrayOf(32.00, 15.50, 9.00)
    var total = 0.0

    val recibo = File("recibo_pedido.txt")

    // Usamos writeText no início para limpar recibos antigos e gravar o cabeçalho
    recibo.writeText("=== RECIBO DO PEDIDO (FOODEXPRESS) ===\n")

    // Percorremos os itens com o laço for e usamos appendText para anexar linha a linha
    for (i in itens.indices) {
        recibo.appendText("${i + 1}. ${itens[i]} - R$ ${precos[i]}\n")
        total += precos[i]
    }

    // Rodapé com o total a pagar da compra
    recibo.appendText("------------------------------------\n")
    recibo.appendText(String.format("TOTAL A PAGAR: R$ %.2f\n", total))

    println("Recibo gerado com sucesso!")
    println("Caminho do recibo: ${recibo.absolutePath}")
    println("\n=== CONTEÚDO DO RECIBO GERADO ===")
    println(recibo.readText())
}
