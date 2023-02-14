package com.algamoney.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.IOException;

/**
 *
 * @author dm
 */
@Entity
@Table(name = "peoples")
public class People
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 3, max = 50)
    private String name;

    @Embedded
    @JsonProperty("address")
    private Address address;

    @NotNull
    private Boolean active;

    /**
     * People
     */
    public People() {}

    /**
     * People
     *
     * @param id Long
     * @param name String
     * @param address Address
     * @param active active
     */
    public People( Long id, String name, Address address, Boolean active )
    {
        this.id = id;
        this.name = name;
        this.address = address;
        this.active = active;
    }

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

    /**
     * isActive
     *
     * @return boolean
     */
    public boolean isActive()
    {
        return active;
    }

    /**
     * setActive
     *
     * @param active boolean
     */
    public void setActive( boolean active )
    {
        this.active = active;
    }

    /**
     * isInactive
     *
     * @return boolean
     */
    @JsonIgnore
    @Transient
    public boolean isInactive() {
        return !this.active;
    }
}
