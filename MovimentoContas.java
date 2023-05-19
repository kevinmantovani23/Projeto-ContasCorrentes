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
    
    MovimentoContas(int contaM, double valorM, int tipoM, int status){
        codContaM = contaM;
        ValorMovimentoM = valorM;
        TipoMovimentoM = tipoM;
        statusM = status;
        
}

    @Override
    public String toString() {
        return "MovimentoContas{" + "codContaM=" + codContaM + ", ValorMovimentoM=" + ValorMovimentoM + ", TipoMovimentoM=" + TipoMovimentoM + ", statusM=" + statusM + '}';
    }
    
}