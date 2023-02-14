package com.algamoney.api.event;

import org.springframework.context.ApplicationEvent;

import javax.servlet.http.HttpServletResponse;

public class CreatedResourceEvent extends ApplicationEvent
{
    private HttpServletResponse response;
    private Long id;

    /**
     * CreatedResourceEvent
     *
     * @param source Object
     */
    public CreatedResourceEvent( Object source, HttpServletResponse response,  Long id )
    {
        super( source );
        this.response = response;
        this.id = id;
    }

    /**
     * getResponse
     *
     * @return HttpServletResponse
     */
    public HttpServletResponse getResponse()
    {
        return response;
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
}
