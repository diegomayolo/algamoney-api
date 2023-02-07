package com.algamoney.api.resource;

import com.algamoney.api.model.Categoria;
import com.algamoney.api.repository.CategoriaRepository;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.swing.text.html.Option;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categorias")
public class CategoriaResource
{
    @Autowired
    private CategoriaRepository categoriaRepository;

    /**
     * listar
     *
     * @return List<Categoria>
     */
    @GetMapping
    public List<Categoria> listar()
    {
        return categoriaRepository.findAll();
    }

    /**
     * criar
     *
     * @param categoria Categoria
     * @param response HttpServletResponse
     * @return ResponseEntity<Categoria>
     */
    @PostMapping
    public ResponseEntity<Categoria> criar( @RequestBody Categoria categoria, HttpServletResponse response )
    {
        Categoria categoriaSalva = categoriaRepository.save( categoria );
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path( "/{id}" ).buildAndExpand( categoriaSalva.getId() ).toUri();
        response.setHeader( "Location", uri.toASCIIString() );

        return ResponseEntity.created( uri ).body( categoriaSalva );
    }

    /**
     * buscarPeloId
     *
     * @param id Long
     * @return ResponseEntity<Categoria>
     */
    @GetMapping("/{id}")
    public ResponseEntity<Categoria> buscarPeloId( @PathVariable Long id )
    {
        Optional<Categoria> categoria = categoriaRepository.findById( id );

        return categoria.isPresent() ? ResponseEntity.ok( categoria.get() ) : ResponseEntity.notFound().build();
    }
}
