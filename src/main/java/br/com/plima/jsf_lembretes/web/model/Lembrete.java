package br.com.plima.jsf_lembretes.web.model;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;

//É a entidade da aplicação
@Entity
public class Lembrete {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Size(min = 3, max = 255)
    @Column(nullable = false)
    private String titulo;

    @Size(min = 3, max = 255)
    @Column(nullable = false)
    private String descricao;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date criacao = new Date();

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date inicio = new Date();

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Prioridade prioridade;

    @Column(nullable = false,
            columnDefinition = "BIT(1) default 0")
    private boolean arquivado;

    //construtor da Entidade vazio
    public Lembrete() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getCriacao() {
        return criacao;
    }

    public void setCriacao(Date criacao) {
        this.criacao = criacao;
    }

    public Date getInicio() {
        return inicio;
    }

    public void setInicio(Date inicio) {
        this.inicio = inicio;
    }

    public Prioridade getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(Prioridade prioridade) {
        this.prioridade = prioridade;
    }

    public boolean isArquivado() {
        return arquivado;
    }

    public void setArquivado(boolean arquivado) {
        this.arquivado = arquivado;
    }

    //é para exibir esse valor lá na View
    public String getArquivadoAsString(){
        return arquivado ? "SIM" : "NÃO";
    }
}
