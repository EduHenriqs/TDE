package com.uri.pw.entities;


import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "TB_TAREFA")
public class Tarefa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "data_criacao")
    private Date dataCriacao;

    @Column(name = "finalizada")
    private boolean finalizada;

    @Column(name = "data_limite")
    private Date dataLimite;

    @Column(name = "descricao")
    private String descricao;
    public Tarefa() {
    }

    public Tarefa(Long id, Date dataCriacao, boolean finalizada, Date dataLimite, String descricao) {
        this.id = id;
        this.dataCriacao = dataCriacao;
        this.finalizada = finalizada;
        this.dataLimite = dataLimite;
        this.descricao = descricao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Date getDataLimite() {
        return dataLimite;
    }

    public void setDataLimite(Date dataLimite) {
        this.dataLimite = dataLimite;
    }
    public boolean isFinalizada() {
        return finalizada;
    }

    public void setFinalizada(boolean finalizada) {
        this.finalizada = finalizada;
    }

    @PrePersist
    protected void onCreate() {
        this.dataCriacao = new Date();
    }

}
