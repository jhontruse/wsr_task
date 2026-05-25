package com.jhontruse.wsr_task.model.mapper;

import com.jhontruse.wsr_task.model.entity.Task;
import com.jhontruse.wsr_task.model.records.TaskResponse;

public class TaskMapper {

    private TaskMapper() {
    }

    public static TaskResponse toResponseFind(Task task) {
        return new TaskResponse(
                task.getTitulo(),
                task.getDescripcion(),
                task.getEstado(),
                task.getPrioridad(),
                task.getFecRegistro(),
                task.getFecVencimiento()
        );
    }

}
