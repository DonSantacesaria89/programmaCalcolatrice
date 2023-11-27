package org.example;

import java.util.Scanner;

public class Calculator {

    /**
     * Esegue un'operazione aritmetica tra due numeri.
     *
     * @param num1 primo numero in formato stringa
     * @param num2 secondo numero in formato stringa
     * @param operator operatore aritmetico (+, -, *, /)
     * @return risultato dell'operazione o messaggio di errore
     */

    public static String performOperation(String num1, String num2, char operator) {
        try {
            // Tentativo di conversione degli operandi in double
            double operand1 = Double.parseDouble(num1);
            double operand2 = Double.parseDouble(num2);

            // Verifica se l'operatore è valido
            if (operator != '+' && operator != '-' && operator != '*' && operator != '/') {
                return "Errore: Operatore non valido.";
            }

            switch (operator) {
                case '+':
                    return String.valueOf(operand1 + operand2);
                case '-':
                    return String.valueOf(operand1 - operand2);
                case '*':
                    return String.valueOf(operand1 * operand2);
                case '/':
                    if (operand2 != 0) {
                        return String.valueOf(operand1 / operand2);
                    } else {
                        return "Errore: Impossibile dividere per zero.";
                    }
                default:
                    return "Errore: Operatore non valido.";
            }
        } catch (NumberFormatException e) {
            return "Errore: Operando non valido.";
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Input del primo numero
        System.out.print("Inserisci il primo numero (q - per chiudere): ");
        String num1 = scanner.next();

        do{

            // Input dell'operatore
            System.out.print("Inserisci l'operatore (+, -, *, /): ");
            char operator = scanner.next().charAt(0);

            // Input del secondo numero
            System.out.print("Inserisci il secondo numero: ");
            String num2 = scanner.next();

            // Esegui l'operazione e stampa il risultato
            String risultato = performOperation(num1, num2, operator);
            System.out.println("Il risultato dell'operazione è: " + risultato);

            // Input del primo numero
            System.out.print("\nInserisci il primo numero (q - per chiudere): ");
            num1 = scanner.next();

        }while((!num1.equals("q")));

        System.out.println("\n+++CHIUSURA PROGRAMMA IN CORSO+++");

        scanner.close();

    }
}
