
package contacorrente;

import javax.swing.JOptionPane;
import java.io.*;

public class ContaCorrente {
    
    
    public static void main(String[] args) throws IOException {
        int escolha = 0;
        InfoContaC[] corrente = new InfoContaC[4];
        MovimentoContas[] movimento = new MovimentoContas[9];
        
            escolha = Integer.parseInt(JOptionPane.showInputDialog("1 - Cadastra Contas Correntes.\n" +
                "2 - Cadastrar movimento.\n" +
                "3 - Gera Contas Atualizadas.\n" +
                "4 - Consulta cadastros.\n" +
                "9 - FIM "));
               switch (escolha){
                   case 1:
                        cadastrar(corrente);
                   
                   case 2:
                        cadastrar_movimento(movimento);
                       
                }
        }
        
    
    
    public static void cadastrar(InfoContaC[] corrente){
        int i;
        for(i=0; i<5; i++){
            corrente[i] = new InfoContaC();
            corrente[i].codContaC = Integer.parseInt(JOptionPane.showInputDialog("Insira o código da conta."));
            corrente[i].nomeClientesC = JOptionPane.showInputDialog("Insira o nome.");
            corrente[i].saldoContaC = Double.parseDouble(JOptionPane.showInputDialog("Insira o saldo da conta."));
            corrente[i].LimitecontaC= Double.parseDouble(JOptionPane.showInputDialog("Insira o código da conta."));
            corrente[i].tipoContaC = Integer.parseInt(JOptionPane.showInputDialog("Insira o tipo da conta\n 1 ----------- física\n" +
"   2 ----------- conjunta\n" +
"   3 ----------- jurídica\n" +
"   4 ----------- especial"));
        }   
    }


    public static void cadastrar_movimento(MovimentoContas[] movimento){
        int i;
        for(i= 0; i<10; i++){
            movimento[i] = new MovimentoContas();
            movimento[i].codContaM = Integer.parseInt(JOptionPane.showInputDialog("Insira o código da conta."));
            movimento[i].ValorMovimentoM = Double.parseDouble(JOptionPane.showInputDialog("Insira o valor do movimento"));
            movimento[i].TipoMovimentoM = Integer.parseInt(JOptionPane.showInputDialog("Insira o tipo de movimento"));
            movimento[i].statusM = Integer.parseInt(JOptionPane.showInputDialog("Insira o status."));
            
        }
    }
    
}