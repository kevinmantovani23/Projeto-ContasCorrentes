
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

    @Override
    public String toString() {
        return "\nCódigo da conta: " + codContaC + "| Cliente: " + nomeClientesC + "| Saldo: " + saldoContaC + "| Limite: " + LimitecontaC + "| Tipo: " + tipoContaC;
    }

    
    
}
