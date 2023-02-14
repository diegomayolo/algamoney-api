package com.algamoney.api.resource;

import com.algamoney.api.event.CreatedResourceEvent;
import com.algamoney.api.model.People;
import com.algamoney.api.repository.CategoryRepository;
import com.algamoney.api.repository.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author dm
 */
@RestController
@RequestMapping("/peoples")
public class PeopleResource
{
    @Autowired
    private PeopleRepository peopleRepository;

    @Autowired
    private ApplicationEventPublisher publisher;

    /**
     * findAll
     *
     * @return List<People>
     */
    @GetMapping
    public List<People> findAll()
    {
        return peopleRepository.findAll();
    }

    /**
     * create
     *
     * @param people People
     * @param response HttpServletResponse
     * @return ResponseEntity<People>
     */
    @PostMapping
    public ResponseEntity<People> create( @Valid @RequestBody People people, HttpServletResponse response )
    {
        People savedPeople = peopleRepository.save( people );

        publisher.publishEvent( new CreatedResourceEvent( this, response, savedPeople.getId() ) );

        return ResponseEntity.status( HttpStatus.CREATED ).body( savedPeople );
    }

    /**
     * findById
     *
     * @param id Long
     * @return ResponseEntity<People>
     */
    @GetMapping("/{id}")
    public ResponseEntity<People> findById( @PathVariable Long id )
    {
        Optional<People> optional = peopleRepository.findById( id );

        return optional.isPresent() ? ResponseEntity.ok( optional.get() ) : ResponseEntity.notFound().build();
    }
}
