package com.algamoney.api.event.listener;

import com.algamoney.api.event.CreatedResourceEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import java.net.URI;

@Component
public class CreatedResourceListener implements ApplicationListener<CreatedResourceEvent>
{
    /**
     * onApplicationEvent
     *
     * @param event CreatedResourceEvent
     */
    @Override
    public void onApplicationEvent( CreatedResourceEvent event )
    {
        HttpServletResponse response = event.getResponse();
        Long id = event.getId();

        addHeaderLocation( response, id );
    }

    /**
     * addHeaderLocation
     * @param response
     * @param id
     */
    private static void addHeaderLocation( HttpServletResponse response, Long id )
    {
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path( "/{id}" ).buildAndExpand( id ).toUri();

        response.setHeader( "Location", uri.toASCIIString() );
    }
}
