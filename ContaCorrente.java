/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package contacorrente;

import javax.swing.JOptionPane;


public class ContaCorrente {
    
    
    public static void main(String[] args) {
        int escolha = 0;
        escolha = Integer.parseInt(JOptionPane.showInputDialog("1 - Cadastra Contas Correntes.\n" +
"2 - Cadastra movimento.\n" +
"3 - Gera Contas Atualizadas.\n" +
"4 - Consulta cadastros.\n" +
"9 - FIM "));
        
    }
}