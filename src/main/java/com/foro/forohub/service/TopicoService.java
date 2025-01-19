package com.foro.forohub.service;

import com.foro.forohub.model.Topico;
import com.foro.forohub.repository.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.Optional;

import java.util.List;

@Service
public class TopicoService {

    @Autowired
    private TopicoRepository repository;

    public Topico crearTopico(Topico topico) {
        if (repository.existsByTituloAndMensaje(topico.getTitulo(), topico.getMensaje())) {
            throw new IllegalArgumentException("El tópico ya existe");
        }
        return repository.save(topico);
    }

    public List<Topico> listarTopicos() {
        return repository.findAll();
    }

    public List<Topico> listarPrimeros10() {
        return repository.findTop10ByOrderByFechaCreacionAsc();
    }

    public List<Topico> listarPorCursoYAnio(String curso, int anio) {
        return repository.findByCursoAndAnio(curso, anio);
    }

    public Page<Topico> listarConPaginacion(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public Optional<Topico> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public Topico actualizarTopico(Long id, Topico topicoActualizado) {
        return repository.findById(id).map(topico -> {
            topico.setTitulo(topicoActualizado.getTitulo());
            topico.setMensaje(topicoActualizado.getMensaje());
            topico.setStatus(topicoActualizado.getStatus());
            topico.setAutor(topicoActualizado.getAutor());
            topico.setCurso(topicoActualizado.getCurso());
            return repository.save(topico);
        }).orElseThrow(() -> new IllegalArgumentException("El tópico con ID " + id + " no existe."));
    }

    public void eliminarTopico(Long id) {
        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("El tópico con ID " + id + " no existe.");
        }
        repository.deleteById(id);
    }

}
