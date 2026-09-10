# 🎨 Guia de ANSI Escape Codes (Java & C)

Os códigos de escape ANSI são sequências de caracteres que controlam a formatação (cor, negrito) e a movimentação do cursor no terminal. Eles começam com o caractere `ESC` (em decimal 27, em octal `\033`).

---

## 📍 Comandos de Cursor e Tela


| Comando | Ação |
| :--- | :--- |
| `\033[s` | **Save:** Salva a posição atual do cursor. |
| `\033[u` | **Unsave:** Restaura o cursor para a última posição salva. |
| `\033[H` | Move o cursor para a posição inicial (topo/esquerda). |
| `\033[L;CH` | Move o cursor para uma **Linha** (L) e **Coluna** (C) específica. |
| `\033[2J` | Limpa a tela inteira. |
| `\033[K` | Limpa a linha do cursor até o final dela. |

---

## 🌈 Cores e Estilos Básicos


| Efeito | Código | Reset (Obrigatório) |
| :--- | :--- | :--- |
| **Negrito** | `\033[1m` | `\033[0m` |
| **Vermelho** | `\033[31m` | `\033[0m` |
| **Verde** | `\033[32m` | `\033[0m` |
| **Amarelo** | `\033[33m` | `\033[0m` |
| **Ciano** | `\033[36m` | `\033[0m` |

---

## 💻 Exemplos Práticos

### ☕ No Java
Em Java, usamos strings com o prefixo Unicode `\u001B` ou octal `\033`.

```java
public class Jogo {
    public static void main(String[] args) {
        // 1. Salva onde o usuário está digitando
        System.out.print("\033[s");

        // 2. Sobe para o topo e desenha um HUD
        System.out.print("\033[1;1H"); // Linha 1, Coluna 1
        System.out.print("\033[33m[ TEMPO: 30s ]\033[0m");

        // 3. Volta para o local original para não atrapalhar o Scanner
        System.out.print("\033[u");
        System.out.flush(); // Garante que o terminal processe os comandos
    }
}


EXEMPLO EM C:

#include <stdio.h>

int main() {
    // Limpa a tela
    printf("\033[2J\033[H");

    // Texto em negrito e verde
    printf("\033[1;32mSISTEMA INICIALIZADO...\033[0m\n");

    // Exemplo de atualização na mesma linha usando \r (Carriage Return)
    for(int i = 0; i <= 100; i += 10) {
        printf("\rCarregando mapa: %d%%", i);
        fflush(stdout);
        // sleep(1);
    }

    return 0;
}



⚠️ Dicas de Ouro
Reset sempre: Se você não usar o \033[0m ao final de uma cor, todo o texto seguinte do terminal (até o nome do seu usuário no prompt) ficará daquela cor.
Buffer: Em ambas as linguagens, o terminal pode "segurar" o texto para otimizar a performance. Use System.out.flush() (Java) ou fflush(stdout) (C) para forçar a renderização imediata de elementos como timers.
Compatibilidade: Se rodar no IntelliJ e vir caracteres como ←[s, execute o programa pelo terminal nativo do Windows (CMD/PowerShell) ou Linux/Mac.


