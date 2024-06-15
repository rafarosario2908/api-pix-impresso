package br.senac.pr.api_pix_impresso.dtos;

public class CreateContaDto {
    private Long agencia;
    private Long numeroConta;
    private Long digitoVerificador;
    private String nome;
    private String CPF;
    private long tipoConta;
    private String numeroCartao;
    private String senha;
    private long saldo;
    public CreateContaDto(Long agencia, Long numeroConta, Long digitoVerificador, String nome, String CPF,
            long tipoConta, String numeroCartao, String senha, long saldo) {
        this.agencia = agencia;
        this.numeroConta = numeroConta;
        this.digitoVerificador = digitoVerificador;
        this.nome = nome;
        this.CPF = CPF;
        this.tipoConta = tipoConta;
        this.numeroCartao = numeroCartao;
        this.senha = senha;
        this.saldo = saldo;
    }
    public Long getAgencia() {
        return agencia;
    }
    public void setAgencia(Long agencia) {
        this.agencia = agencia;
    }
    public Long getNumeroConta() {
        return numeroConta;
    }
    public void setNumeroConta(Long numeroConta) {
        this.numeroConta = numeroConta;
    }
    public Long getDigitoVerificador() {
        return digitoVerificador;
    }
    public void setDigitoVerificador(Long digitoVerificador) {
        this.digitoVerificador = digitoVerificador;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCPF() {
        return CPF;
    }
    public void setCPF(String cPF) {
        CPF = cPF;
    }
    public long getTipoConta() {
        return tipoConta;
    }
    public void setTipoConta(long tipoConta) {
        this.tipoConta = tipoConta;
    }
    public String getNumeroCartao() {
        return numeroCartao;
    }
    public void setNumeroCartao(String numeroCartao) {
        this.numeroCartao = numeroCartao;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
    public long getSaldo() {
        return saldo;
    }
    public void setSaldo(long saldo) {
        this.saldo = saldo;
    }

    
}
