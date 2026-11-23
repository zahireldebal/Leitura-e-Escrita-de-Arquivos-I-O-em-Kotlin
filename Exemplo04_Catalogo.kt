import java.io.File

fun main() {
    val arquivoProdutos = File("produtos.txt")

    // Criação inicial do arquivo estruturado tipo CSV (Nome;Preco)
    arquivoProdutos.writeText(
        "Mouse Gamer;120.0\n" +
        "Monitor 24pol;890.0\n" +
        "Mousepad Extra;45.5\n" +
        "Teclado Mecânico;310.0"
    )

    println("=== PRODUTOS EM PROMOÇÃO (ATÉ R$ 200,00) ===")

    // forEachLine: lê uma linha por vez da memória, descartando após o processamento
    // Ideal para arquivos médios e grandes com alta performance de RAM
    arquivoProdutos.forEachLine { linha ->
        // split(";"): divide a linha pelo delimitador de ponto e vírgula
        val dados = linha.split(";")
        val nome = dados[0]
        val preco = dados[1].toDouble() // Conversão explícita de String para Double

        // Aplicação de filtro: apenas produtos com preço <= 200.0
        if (preco <= 200.0) {
            println(String.format("Produto: %-15s | Preço: R$ %.2f", nome, preco))
        }
    }
}
