package br.senac.pr.api_pix_impresso.dtos;

public class UpdateCaixaDto {
    private String localicao;
    private Double saldo;

    public UpdateCaixaDto(String localicao, Double saldo) {
        this.localicao = localicao;
        this.saldo = saldo;
    }

    public String getLocalicao() {
        return localicao;
    }

    public void setLocalicao(String localicao) {
        this.localicao = localicao;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }
    
}
