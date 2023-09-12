package com.imd.humberto789.sistemausuariowebii.domain.entity;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;

import java.io.Serial;
import java.util.Objects;

@Entity
public class Papel extends AbstractEntity implements GrantedAuthority {

    @Serial
    private static final long serialVersionUID = 1L;

    public static final int ROLE_USER = 1;
    public static final int ROLE_ADMIN = 2;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_PAPEL")
    @SequenceGenerator(name = "SEQ_PAPEL",
        sequenceName = "id_seq_papel",
        allocationSize = 1)
    @Column
    private Integer id;

    @Column
    private String codigo;

    @Column
    private String descricao;


    public Papel (){
    }

    @Override
    public Integer getId() {
        return this.id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Papel papel = (Papel) o;
        return Objects.equals(id, papel.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String getAuthority() {
        return this.codigo;
    }
}
