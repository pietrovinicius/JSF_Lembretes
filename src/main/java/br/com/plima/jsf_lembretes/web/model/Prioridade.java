package br.com.plima.jsf_lembretes.web.model;

public enum Prioridade {
    ALTA("Alta"),
    MEDIA("Média"),
    BAIXA("Baixa");

    private String descricao;

    Prioridade(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
