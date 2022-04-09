package br.edu.gama.gamaster.model;

import java.time.LocalDate;

public class CartaoCredito {
    private String numero;
    private LocalDate validade;
    private String codigoSeguranca;
    private String bandeira;
    private String nomePortador;

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public LocalDate getValidade() {
        return validade;
    }

    public void setValidade(LocalDate validade) {
        this.validade = validade;
    }

    public String getCodigoSeguranca() {
        return codigoSeguranca;
    }

    public void setCodigoSeguranca(String codigoSeguranca) {
        this.codigoSeguranca = codigoSeguranca;
    }

    public String getBandeira() {
        return bandeira;
    }

    public void setBandeira(String bandeira) {
        this.bandeira = bandeira;
    }

    public String getNomePortador() {
        return nomePortador;
    }

    public void setNomePortador(String nomePortador) {
        this.nomePortador = nomePortador;
    }

    @Override
    public String toString() {
        return "CartaoCredito{" +
                "numero='" + numero + '\'' +
                ", validade=" + validade +
                ", codigoSeguranca=" + codigoSeguranca +
                ", bandeira='" + bandeira + '\'' +
                ", nomePortador='" + nomePortador + '\'' +
                '}';
    }


}
