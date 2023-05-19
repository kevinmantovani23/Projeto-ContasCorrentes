
package contacorrente;

import javax.swing.JOptionPane;
import java.io.*;
import java.util.Arrays;

public class ContaCorrente {
    
    
    public static void main(String[] args) throws IOException {
        int escolha = 0;
        InfoContaC[] corrente = new InfoContaC[5];
        InfoContaC[] conta_atualizada= new InfoContaC[5];
        MovimentoContas[] movimento = new MovimentoContas[10];
        
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
                   
                   case 3:
                       herdar(corrente, conta_atualizada);
                       atualizar_conta(corrente, movimento);
                       
                }
        }
        
    
    
    public static void cadastrar(InfoContaC[] corrente){
        int i;
        for(i=0; i < corrente.length; i++){
            corrente[i] = new InfoContaC();
            corrente[i].codContaC = Integer.parseInt(JOptionPane.showInputDialog("Insira o código da conta."));
            corrente[i].nomeClientesC = JOptionPane.showInputDialog("Insira o nome.");
            corrente[i].saldoContaC = Double.parseDouble(JOptionPane.showInputDialog("Insira o saldo da conta."));
            corrente[i].LimitecontaC= Double.parseDouble(JOptionPane.showInputDialog("Insira o limite da conta."));
            corrente[i].tipoContaC = Integer.parseInt(JOptionPane.showInputDialog("Insira o tipo da conta\n 1 ----------- física\n" +
"   2 ----------- conjunta\n" +
"   3 ----------- jurídica\n" +
"   4 ----------- especial"));
        }   
        Arrays.sort(corrente, (c1, c2) -> c1.codContaC - c2.codContaC);
        
    }


    public static void cadastrar_movimento(MovimentoContas[] movimento){
        int i;
        for(i= 0; i < movimento.length; i++){
            movimento[i] = new MovimentoContas();
            movimento[i].codContaM = Integer.parseInt(JOptionPane.showInputDialog("Insira o código da conta."));
            movimento[i].ValorMovimentoM = Double.parseDouble(JOptionPane.showInputDialog("Insira o valor do movimento"));
            movimento[i].TipoMovimentoM = Integer.parseInt(JOptionPane.showInputDialog("Insira o tipo de movimento"));
            movimento[i].statusM = Integer.parseInt(JOptionPane.showInputDialog("Insira o status."));
            
        }
        Arrays.sort(movimento, (c1, c2) -> c1.codContaM - c2.codContaM);
    }
    public static void atualizar_conta(InfoContaC[] corrente, MovimentoContas[] movimento, InfoContaC[] conta_atualizada){
        int i, x, caso;
        for(i=0; i < corrente.length; i++){
            for(x=0; x < movimento.length; x++){
                if ((conta_atualizada[i].codContaC == movimento[x].codContaM) && (movimento[x].statusM == 1)){
                    conta_atualizada[i].saldoContaC = conta_atualizada[i].saldoContaC - movimento[x].ValorMovimentoM;
                }else if ((conta_atualizada[i].codContaC == movimento[x].codContaM) && (movimento[x].statusM == 2) && (conta_atualizada[i].codContaC < movimento[x].ValorMovimentoM) ){
                    caso = conta_atualizada[i].tipoContaC;
                    switch (caso){
                        
                    }
            }
                
            }
            
        }
    }
    
    public static void herdar (InfoContaC[] corrente, InfoContaC[] conta_atualizada){
        int i;
        for(i=0; i < corrente.length; i++){
            conta_atualizada[i]= new InfoContaC();
            conta_atualizada[i].codContaC = corrente[i].codContaC;
            conta_atualizada[i].nomeClientesC = corrente[i].nomeClientesC;
            conta_atualizada[i].saldoContaC = corrente[i].saldoContaC;
            conta_atualizada[i].LimitecontaC = corrente[i].LimitecontaC;
            conta_atualizada[i].tipoContaC = corrente[i].tipoContaC;
        }
        
    }
    
}