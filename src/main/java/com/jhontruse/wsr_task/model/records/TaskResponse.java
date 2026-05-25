package com.jhontruse.wsr_task.model.records;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jhontruse.wsr_task.model.enums.EstadoTask;
import com.jhontruse.wsr_task.model.enums.PrioridadTask;

import java.time.LocalDateTime;

public record TaskResponse(String titulo,
                           String descripcion,
                           EstadoTask estado,
                           PrioridadTask prioridad,
                           @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
                           LocalDateTime fecRegistro,
                           @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
                           LocalDateTime fecVencimiento) {
}