package com.jhontruse.wsr_task.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.jhontruse.wsr_task.model.enums.EstadoTask;
import com.jhontruse.wsr_task.model.enums.PrioridadTask;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@Schema(description = "Entidad que representa un menú en el sistema")
@Table("TASK")
public class Task implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @Column("ID_TASK")
    @Schema(description = "ID único de task", example = "550e8400-e29b-41d4-a716-446655440000")
    private String idTask;

    @NotBlank(message = "El título del task es obligatorio.")
    @Size(min = 3, max = 250, message = "El título debe tener entre 3 y 250 caracteres.")
    @Column("TITULO")
    @Schema(description = "Título de task", example = "Tarea de física")
    private String titulo;

    @Size(min = 3, max = 800, message = "La descripción debe tener entre 3 y 800 caracteres.")
    @Column("DESCRIPCION")
    @Schema(description = "Descripcion de task", example = "Tarea de física")
    private String descripcion;

    @NotBlank(message = "El estado del task es obligatorio.")
    @Size(min = 1, max = 20, message = "El estado debe tener entre 3 y 20 caracteres.")
    @Column("ESTADO")
    @Schema(description = "Estado de task", example = "PROGRESO")
    private EstadoTask estado;

    @NotBlank(message = "La prioridad del task es obligatorio.")
    @Size(min = 1, max = 20, message = "La prioridad debe tener entre 3 y 20 caracteres.")
    @Column("PRIORIDAD")
    @Schema(description = "Prioridad de task", example = "MEDIO")
    private PrioridadTask prioridad;

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
    private LocalDateTime fecRegistro;

    @Column("FEC_ACTUALIZACION")
    @JsonFormat(
            shape = JsonFormat.Shape.STRING,
            pattern = "yyyy-MM-dd HH:mm:ss",
            timezone = "America/Lima"
    )
    @Schema(
            description = "Fecha de actualización del task",
            example = "2026-04-27 10:00:00"
    )
    private LocalDateTime fecActualizacion;

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
    private LocalDateTime fecVencimiento;

}
