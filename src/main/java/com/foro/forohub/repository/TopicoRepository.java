package com.foro.forohub.repository;

import com.foro.forohub.model.Topico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TopicoRepository extends JpaRepository<Topico, Long> {

    boolean existsByTituloAndMensaje(String titulo, String mensaje);

    @Query("SELECT t FROM Topico t ORDER BY t.fechaCreacion ASC")
    List<Topico> findTop10ByOrderByFechaCreacionAsc();

    @Query("SELECT t FROM Topico t WHERE t.curso = :curso AND YEAR(t.fechaCreacion) = :anio")
    List<Topico> findByCursoAndAnio(@Param("curso") String curso, @Param("anio") int anio);
}
