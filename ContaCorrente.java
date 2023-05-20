
package contacorrente;

import javax.swing.JOptionPane;
import java.io.*;
import java.util.Arrays;

public class ContaCorrente {
    
    
    public static void main(String[] args) throws IOException {
        int escolha=0, escolha_cadastro, i;
        InfoContaC[] corrente = new InfoContaC[2];
        InfoContaC[] conta_atualizada= new InfoContaC[corrente.length];
        MovimentoContas[] movimento = new MovimentoContas[2];
        
        while(true){
            if (escolha==9){
                break;
            }
            escolha = Integer.parseInt(JOptionPane.showInputDialog("......................................................\n" +
                                                                                                          ".                MENU PRINCIPAL           .\n" +
                                                                                                          "......................................................\n" +
                                                                                                          ". 1 - Cadastra Contas Correntes    . \n" +
                                                                                                          ". 2 - Cadastra movimento              .\n" +
                                                                                                          ". 3 - Gera Contas Atualizadas       .\n" +
                                                                                                          ". 4 - Consulta cadastros                .\n" +
                                                                                                          ". 9 - FIM                                           .\n" +
                                                                                                          "...................................................."));
               switch (escolha){
                   case 1:
                        cadastrar(corrente);
                        break;
                        
                   case 2:
                        cadastrar_movimento(movimento);
                        break;
                        
                   case 3:
                       herdar(corrente, conta_atualizada);
                       atualizar_conta(corrente, movimento, conta_atualizada);
                       gravar(corrente, movimento, conta_atualizada);
                       break;
                   case 4:
                       escolha_cadastro = Integer.parseInt(JOptionPane.showInputDialog("............................................\n" +
                                                                                                                                  ".    Consulta Cadastros         .\n" +
                                                                                                                                  "...........................................\n" +
                                                                                                                                  ". 1 - Contas Correntes         .\n" +
                                                                                                                                  ". 2 - Movimento                   .\n" +
                                                                                                                                  ". 3 - Atualizado                    .\n" +
                                                                                                                                  ". 9 - FIM                                .\n" +
                                                                                                                                  ".........................................."));
                       switch(escolha_cadastro){
                           case 1:
                               for(i=0; i < corrente.length; i++){
                                   System.out.print(corrente[i]);
                               }break;
                           case 2:
                               for(i=0; i < movimento.length; i++){
                                   System.out.print(movimento[i]);
                               }break;
                           case 3:
                               for(i=0; i < conta_atualizada.length; i++){
                                   System.out.print(conta_atualizada[i]);
                               }break;
                       }
                       break;
                }
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
                }else if ((conta_atualizada[i].codContaC == movimento[x].codContaM) && (movimento[x].statusM == 2) && (conta_atualizada[i].saldoContaC < movimento[x].ValorMovimentoM) ){
                    caso = conta_atualizada[i].tipoContaC;
                    switch (caso){
                        case 1:
                            conta_atualizada[i].saldoContaC = conta_atualizada[i].saldoContaC - movimento[x].ValorMovimentoM;
                            break;
                        case 2:
                           if ((-conta_atualizada[i].LimitecontaC) <= (conta_atualizada[i].saldoContaC - movimento[x].ValorMovimentoM)){
                               conta_atualizada[i].saldoContaC = conta_atualizada[i].saldoContaC - movimento[x].ValorMovimentoM;
                           }break;
                        case 3:
                           if (((-conta_atualizada[i].LimitecontaC) + (0.5 * corrente[i].saldoContaC)) <= (conta_atualizada[i].saldoContaC - movimento[x].ValorMovimentoM)){
                               conta_atualizada[i].saldoContaC = conta_atualizada[i].saldoContaC - movimento[x].ValorMovimentoM;
                           }break;
                        case 4:
                           if (((-conta_atualizada[i].LimitecontaC) + corrente[i].saldoContaC) <= (conta_atualizada[i].saldoContaC - movimento[x].ValorMovimentoM)){
                               conta_atualizada[i].saldoContaC = conta_atualizada[i].saldoContaC - movimento[x].ValorMovimentoM; 
                               
                    }break;
            }    
            }else if ((conta_atualizada[i].codContaC == movimento[x].codContaM) && (movimento[x].statusM == 2) && (conta_atualizada[i].saldoContaC > movimento[x].ValorMovimentoM)){
                  if(conta_atualizada[i].saldoContaC - movimento[x].ValorMovimentoM >= 0){
                      conta_atualizada[i].saldoContaC = conta_atualizada[i].saldoContaC - movimento[x].ValorMovimentoM;
                  }else{
                     caso = conta_atualizada[i].tipoContaC;
                    switch (caso){
                        case 1:
                            conta_atualizada[i].saldoContaC = conta_atualizada[i].saldoContaC - movimento[x].ValorMovimentoM;
                            break;
                        case 2:
                           if ((-conta_atualizada[i].LimitecontaC) <= (conta_atualizada[i].saldoContaC - movimento[x].ValorMovimentoM)){
                               conta_atualizada[i].saldoContaC = conta_atualizada[i].saldoContaC - movimento[x].ValorMovimentoM;
                           }break;
                        case 3:
                           if (((-conta_atualizada[i].LimitecontaC) + (0.5 * corrente[i].saldoContaC)) <= (conta_atualizada[i].saldoContaC - movimento[x].ValorMovimentoM)){
                               conta_atualizada[i].saldoContaC = conta_atualizada[i].saldoContaC - movimento[x].ValorMovimentoM;
                           }break;
                        case 4:
                           if (((-conta_atualizada[i].LimitecontaC) + corrente[i].saldoContaC) <= (conta_atualizada[i].saldoContaC - movimento[x].ValorMovimentoM)){
                               conta_atualizada[i].saldoContaC = conta_atualizada[i].saldoContaC - movimento[x].ValorMovimentoM; 
                               
                    }break;
                  }
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
    
    public static void gravar(InfoContaC[] corrente, MovimentoContas[] movimento, InfoContaC[] conta_atualizada) throws IOException{
        
        int i;
        BufferedWriter conta_corrente = new BufferedWriter(new FileWriter("ContaCorrente.txt"));
            for(i=0; i < corrente.length; i++){
                  conta_corrente.write(corrente[i].toString());
            }
            conta_corrente.close();
            
         BufferedWriter movimento_arq = new BufferedWriter(new FileWriter("Movimento.txt"));
            for(i=0; i < movimento.length; i++){
                  movimento_arq.write(movimento[i].toString());
            }
            movimento_arq.close();
            
         BufferedWriter atualizada = new BufferedWriter(new FileWriter("ContaAtualizada.txt"));
            for(i=0; i < conta_atualizada.length; i++){
                  atualizada.write(conta_atualizada[i].toString());
            }
            atualizada.close();
               
    }
    
}