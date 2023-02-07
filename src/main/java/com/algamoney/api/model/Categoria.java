package com.algamoney.api.model;

import jakarta.persistence.*;

@Entity
@Table(name = "categoria")
public class Categoria
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    /**
     * getId
     *
     * @return Long
     */
    public Long getId()
    {
        return id;
    }

    /**
     * setId
     *
     * @param id Long
     */
    public void setId( Long id )
    {
        this.id = id;
    }

    /**
     * getName
     *
     * @return String
     */
    public String getNome()
    {
        return nome;
    }

    /**
     * setNome
     *
     * @param nome String
     */
    public void setNome( String nome )
    {
        this.nome = nome;
    }
}
