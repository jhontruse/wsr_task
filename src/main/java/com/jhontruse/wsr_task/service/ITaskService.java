package com.jhontruse.wsr_task.service;

import com.jhontruse.wsr_task.model.entity.Task;
import com.jhontruse.wsr_task.model.records.GenericRespondePage;
import com.jhontruse.wsr_task.model.records.TaskResponse;

import java.awt.print.Pageable;
import java.util.List;

public interface ITaskService {

    List<TaskResponse> findAll();

    GenericRespondePage<TaskResponse> findTaskByTitulo(String titulo, int page, int size);

    GenericRespondePage<TaskResponse> findTaskByTituloContainingIgnoreCase(String titulo, int page, int size);

}
