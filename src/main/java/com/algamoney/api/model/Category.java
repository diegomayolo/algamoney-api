package com.algamoney.api.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author dm
 */
@Entity
@Table(name = "categories")
public class Category
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 3, max = 20 )
    private String name;

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
    public String getName()
    {
        return name;
    }

    /**
     * setName
     *
     * @param name String
     */
    public void setName( String name )
    {
        this.name = name;
    }
}
