package com.algamoney.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author dm
 */
@Embeddable
@JsonIgnoreProperties( ignoreUnknown = true )
public class Address
{
    private String street;
    private String number;
    private String complement;
    private String neighborhood;
    @Column(name = "postal_zip")
    private String postalZip;
    private String city;
    private String state;

    /**
     * getStreet
     *
     * @return String
     */
    public String getStreet()
    {
        return street;
    }

    /**
     * setStreet
     *
     * @param street String
     */
    public void setStreet( String street )
    {
        this.street = street;
    }

    /**
     * getNumber
     *
     * @return String
     */
    public String getNumber()
    {
        return number;
    }

    /**
     * setNumber
     *
     * @param number String
     */
    public void setNumber( String number )
    {
        this.number = number;
    }

    /**
     * getComplement
     *
     * @return String
     */
    public String getComplement()
    {
        return complement;
    }

    /**
     * setComplement
     *
     * @param complement String
     */
    public void setComplement( String complement )
    {
        this.complement = complement;
    }

    /**
     * getNeighborhood
     *
     * @return String
     */
    public String getNeighborhood()
    {
        return neighborhood;
    }

    /**
     * setNeighborhood
     *
     * @param neighborhood String
     */
    public void setNeighborhood( String neighborhood )
    {
        this.neighborhood = neighborhood;
    }

    /**
     * getPostalZip
     *
     * @return String
     */
    public String getPostalZip()
    {
        return postalZip;
    }

    /**
     * setPostalZip
     *
     * @param postalZip String
     */
    public void setPostalZip( String postalZip )
    {
        this.postalZip = postalZip;
    }

    /**
     * getCity
     *
     * @return String
     */
    public String getCity()
    {
        return city;
    }

    /**
     * setCity
     *
     * @param city String
     */
    public void setCity( String city )
    {
        this.city = city;
    }

    /**
     * getState
     *
     * @return String
     */
    public String getState()
    {
        return state;
    }

    /**
     * setState
     *
     * @param state String
     */
    public void setState( String state )
    {
        this.state = state;
    }
}
