/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */


//Se o jogador fizer todas as jogadas corretas ele irá concluir em 31 jogadas

package jogotorredehanoi;

import java.util.Scanner;
import java.util.Stack;

public class JogoTorreDeHanoi {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int movimentos = 0;

       
        Stack<Integer> pinoA = new Stack<>();
        Stack<Integer> pinoB = new Stack<>();
        Stack<Integer> pinoC = new Stack<>();

        
        for (int i = 5; i >= 1; i--) {
            pinoA.push(i);
        }

       
        exibirEstadoDosPinos(pinoA, pinoB, pinoC);

       
        while (pinoC.size() < 5) {
            System.out.print("Digite o pino de origem (A, B, C): ");
            char origem = scanner.next().charAt(0);
            System.out.print("Digite o pino de destino (A, B, C): ");
            char destino = scanner.next().charAt(0);

            if (validarMovimento(origem, destino, pinoA, pinoB, pinoC)) {
                movimentarDisco(origem, destino, pinoA, pinoB, pinoC);
                movimentos++;
                exibirEstadoDosPinos(pinoA, pinoB, pinoC);
            } else {
                System.out.println("Movimento inválido. Tente novamente.");
            }
        }

        System.out.println("\nParabéns! Você completou o jogo em " + movimentos + " movimentos.");
    }

    static boolean validarMovimento(char origem, char destino, Stack<Integer> pinoA, Stack<Integer> pinoB, Stack<Integer> pinoC) {
        Stack<Integer> pinoOrigem = getPino(origem, pinoA, pinoB, pinoC);
        Stack<Integer> pinoDestino = getPino(destino, pinoA, pinoB, pinoC);

        return !pinoOrigem.isEmpty() && (pinoDestino.isEmpty() || pinoOrigem.peek() < pinoDestino.peek());
    }

    static void movimentarDisco(char origem, char destino, Stack<Integer> pinoA, Stack<Integer> pinoB, Stack<Integer> pinoC) {
        Stack<Integer> pinoOrigem = getPino(origem, pinoA, pinoB, pinoC);
        Stack<Integer> pinoDestino = getPino(destino, pinoA, pinoB, pinoC);

        pinoDestino.push(pinoOrigem.pop());
    }
 
    static Stack<Integer> getPino(char pino, Stack<Integer> pinoA, Stack<Integer> pinoB, Stack<Integer> pinoC) {
        switch (pino) {
            case 'A':
                return pinoA;
            case 'B':
                return pinoB;
            case 'C':
                return pinoC;
            default:
                return new Stack<>();
        }
    }

    static void exibirEstadoDosPinos(Stack<Integer> pinoA, Stack<Integer> pinoB, Stack<Integer> pinoC) {
        System.out.println("Estado Atual dos Pinos:");
        System.out.println("Pino A: " + pinoA);
        System.out.println("Pino B: " + pinoB);
        System.out.println("Pino C: " + pinoC);
        System.out.println();
    }
}

 
