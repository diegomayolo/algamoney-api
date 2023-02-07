package com.algamoney.api.resource;

import com.algamoney.api.model.Category;
import com.algamoney.api.repository.CategoryRepository;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author dm
 */
@RestController
@RequestMapping("/categories")
public class CategoryResource
{
    @Autowired
    private CategoryRepository categoryRepository;

    /**
     * list
     *
     * @return List<Category>
     */
    @GetMapping
    public List<Category> list()
    {
        return categoryRepository.findAll();
    }

    /**
     * create
     *
     * @param category Category
     * @param response HttpServletResponse
     * @return ResponseEntity<Category>
     */
    @PostMapping
    public ResponseEntity<Category> create( @RequestBody Category category, HttpServletResponse response )
    {
        Category savedCategory = categoryRepository.save( category );
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path( "/{id}" ).buildAndExpand( savedCategory.getId() ).toUri();
        response.setHeader( "Location", uri.toASCIIString() );

        return ResponseEntity.created( uri ).body( savedCategory );
    }

    /**
     * findById
     *
     * @param id Long
     * @return ResponseEntity<Category>
     */
    @GetMapping("/{id}")
    public ResponseEntity<Category> findById( @PathVariable Long id )
    {
        Optional<Category> category = categoryRepository.findById( id );

        return category.isPresent() ? ResponseEntity.ok( category.get() ) : ResponseEntity.notFound().build();
    }
}
