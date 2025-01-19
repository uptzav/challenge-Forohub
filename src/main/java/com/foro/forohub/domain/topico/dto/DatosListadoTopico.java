package com.foro.forohub.domain.topico.dto;

import com.foro.forohub.domain.topico.Topico;

import java.time.LocalDateTime;

public record DatosListadoTopico(

        String titulo,
        String mensaje,
        LocalDateTime fechaCreacion,
        String estado,
        String autor,
        String curso

    ) {

    public DatosListadoTopico(Topico topico) {

        this(topico.getTitulo(), topico.getMensaje(), topico.getFechaCreacion(),
                topico.getEstado(), topico.getAutor(), topico.getCurso());

    }

}
