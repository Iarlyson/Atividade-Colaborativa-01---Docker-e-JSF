package br.edu.ifpb.model;

public class CPF {
    private static int Tamanho = 11;
    private String numero;

    public CPF(){
    }

    public CPF(String numero){
        this.numero = numero;
    }

    public boolean ehValido(){
        return this.numero.length()== Tamanho;
    }

    public String formatadoString() {
        return String.format(
                "%s.%s.%s-%s",
                this.numero.substring(0,3),
                this.numero.substring(3,6),
                this.numero.substring(6,9),
                this.numero.substring(9,11)
        );
    }
    public String valor() {
        return this.numero;
    }

}
