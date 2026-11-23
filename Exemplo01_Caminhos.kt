import java.io.File

fun main() {
    // Aponta para um arquivo utilizando caminho relativo (na raiz do projeto)
    val arquivo = File("dados.txt")

    // Verificações úteis antes de realizar qualquer operação de leitura ou escrita
    println("=== VERIFICAÇÃO DA CLASSE FILE E CAMINHOS ===")
    
    // exists(): retorna true se o arquivo físico já existe no disco, senão false
    println("O arquivo existe? ${arquivo.exists()}")
    
    // absolutePath: retorna o caminho completo no sistema de arquivos do sistema operacional
    println("Caminho absoluto: ${arquivo.absolutePath}")
    
    // name: retorna apenas o nome do arquivo com a extensão
    println("Nome do arquivo: ${arquivo.name}")
}
