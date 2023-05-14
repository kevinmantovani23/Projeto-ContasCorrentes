/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package contacorrente;

class InfoContaC {
    int codContaC;
    String nomeClientesC;
    double saldoContaC;
    double LimitecontaC;
    int tipoContaC;
    
    InfoContaC(){
        this(0, "", 0, 0, 0);
    }
    
    InfoContaC(int conta, String cliente, double saldo, double limite, int tipo){
        codContaC = conta;
        nomeClientesC = cliente;
        saldoContaC = saldo;
        LimitecontaC = limite;
        tipoContaC = tipo;
    }
}
