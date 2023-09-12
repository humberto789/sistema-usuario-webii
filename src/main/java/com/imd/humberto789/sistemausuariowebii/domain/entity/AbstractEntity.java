package com.imd.humberto789.sistemausuariowebii.domain.entity;

import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@MappedSuperclass
@EntityListeners({AuditingEntityListener.class})
public abstract class AbstractEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(
            nullable = true,
            updatable = false,
            name = "DATA_CRIACAO"
    )
    @CreatedDate
    @DateTimeFormat(
            pattern = "yyyy-MM-dd"
    )
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCriacao = new Date();
    @LastModifiedDate
    @DateTimeFormat(
            pattern = "yyyy-MM-dd"
    )
    @Temporal(TemporalType.TIMESTAMP)
    @Column(
            name = "DATA_MODIFICACAO"
    )
    private Date dataModificacao;
    @Column
    private Boolean ativo = true;

    public AbstractEntity() {
    }

    public abstract Integer getId();

    public abstract void setId(Integer id);

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Date getDataModificacao() {
        return dataModificacao;
    }

    public void setDataModificacao(Date dataModificacao) {
        this.dataModificacao = dataModificacao;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }
}
