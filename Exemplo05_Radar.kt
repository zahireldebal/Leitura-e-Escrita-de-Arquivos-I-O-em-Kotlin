import java.io.File

fun main() {
    val arquivoMapa = File("mapa_radar.txt")

    // Simulação do mapa via satélite salvo no arquivo (grade 4x4)
    // 0 = vazio/ignorar | 1 = vegetação | 2 = obstáculo | 9 = alvo prioritário
    arquivoMapa.writeText(
        "0 1 0 2\n" +
        "1 0 0 1\n" +
        "0 2 9 0\n" +
        "1 1 0 2"
    )

    // readLines(): lê todas as linhas do arquivo e retorna como List<String>
    val linhasArquivo = arquivoMapa.readLines()
    val n = linhasArquivo.size

    // 1. Criando a matriz 4x4 na memória e preenchendo a partir do arquivo lido
    val matrizRadar = Array(n) { IntArray(n) }

    for (i in 0 until n) {
        val colunasTexto = linhasArquivo[i].split(" ")
        for (j in 0 until n) {
            matrizRadar[i][j] = colunasTexto[j].toInt()
        }
    }

    // 2. Varrendo a matriz com controle de fluxo inteligente (continue e break)
    println("Iniciando varredura do radar...")
    var alvoEncontrado = false

    for (i in matrizRadar.indices) {
        for (j in matrizRadar[i].indices) {
            val setor = matrizRadar[i][j]

            // Se o setor for 0 (área vazia), pula para a próxima coluna sem processar
            if (setor == 0) {
                continue
            }

            println("Analisando setor [$i][$j] -> Código: $setor")

            // Se encontrar o código 9 (Alvo Prioritário), interrompe o laço interno (j)
            if (setor == 9) {
                println("\n>>> ALVO PRIORITÁRIO LOCALIZADO na coordenada [$i][$j]! <<<")
                alvoEncontrado = true
                break
            }
        }

        // Se o alvo já foi localizado no laço interno, interrompe também o laço externo (i)
        if (alvoEncontrado) {
            break
        }
    }
}
