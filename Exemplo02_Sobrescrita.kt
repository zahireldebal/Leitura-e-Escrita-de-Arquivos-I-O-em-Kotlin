import java.io.File

fun main() {
    val arquivo = File("boas_vindas.txt")

    // 3.1. writeText: cria o arquivo se ele não existir
    // ATENÇÃO: se já existir, todo o conteúdo anterior será apagado e substituído
    arquivo.writeText("Olá, turma de Kotlin!\nEsta é a primeira linha salva no disco.")
    println("Arquivo gravado inicialmente com writeText!")

    // 3.2. appendText: adiciona texto ao final preservando o que já foi escrito
    // O caractere '\n' garante uma nova linha antes de acrescentar o novo texto
    arquivo.appendText("\nNova linha adicionada com appendText sem apagar as anteriores.")
    println("Nova linha adicionada com sucesso!")

    // Lendo o arquivo para confirmar o conteúdo em tela
    println("\n=== CONTEÚDO ATUAL DO ARQUIVO ===")
    println(arquivo.readText())
}
