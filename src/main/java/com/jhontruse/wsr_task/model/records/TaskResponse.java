package com.jhontruse.wsr_task.model.records;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jhontruse.wsr_task.model.enums.EstadoTask;
import com.jhontruse.wsr_task.model.enums.PrioridadTask;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.data.relational.core.mapping.Column;

import java.time.LocalDateTime;

public record TaskResponse(
        @NotBlank(message = "El título del task es obligatorio.")
        @Size(min = 3, max = 250, message = "El título debe tener entre 3 y 250 caracteres.")
        @Column("TITULO")
        @Schema(description = "Título de task", example = "Tarea de geometría")
        String titulo,

        @Size(min = 3, max = 800, message = "La descripción debe tener entre 3 y 800 caracteres.")
        @Column("DESCRIPCION")
        @Schema(description = "Descripcion de task", example = "Tarea de física")
        String descripcion,

        @NotBlank(message = "El estado del task es obligatorio.")
        @Size(min = 1, max = 20, message = "El estado debe tener entre 3 y 20 caracteres.")
        @Column("ESTADO")
        @Schema(description = "Estado de task", example = "PROGRESO")
        EstadoTask estado,

        @NotBlank(message = "La prioridad del task es obligatorio.")
        @Size(min = 1, max = 20, message = "La prioridad debe tener entre 3 y 20 caracteres.")
        @Column("PRIORIDAD")
        @Schema(description = "Prioridad de task", example = "MEDIO")
        PrioridadTask prioridad,

        @Column("FEC_REGISTRO")
        @JsonFormat(
                shape = JsonFormat.Shape.STRING,
                pattern = "yyyy-MM-dd HH:mm:ss",
                timezone = "America/Lima"
        )
        @Schema(
                description = "Fecha de registro del task",
                example = "2026-04-27 10:00:00"
        )
        LocalDateTime fecRegistro,

        @Column("FEC_VENCIMIENTO")
        @JsonFormat(
                shape = JsonFormat.Shape.STRING,
                pattern = "yyyy-MM-dd HH:mm:ss",
                timezone = "America/Lima"
        )
        @Schema(
                description = "Fecha de vencimiento del task",
                example = "2026-04-27 10:00:00"
        )
        LocalDateTime fecVencimiento) {
}