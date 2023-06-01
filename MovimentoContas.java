
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
        return "\nCódigo da conta: " + codContaM + "| Valor do movimento: " + ValorMovimentoM + "| Tipo de movimento: " + TipoMovimentoM + "| Status: " + statusM;
    }
    
}