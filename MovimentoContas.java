/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package contacorrente;


class MovimentoContas {
    int codContaM;
    double ValorMovimentoM;
    int TipoMovimentoM;
    int statusM;
    
    MovimentoContas(){
        this(0, 0, 0, 0);
    }
    
    MovimentoContas(int conta, String cliente, double saldo, double limite, int tipo){
        codContaC = conta;
        nomeClientesC = cliente;
        saldoContaC = saldo;
        LimitecontaC = limite;
        tipoContaC = tipo;
}
