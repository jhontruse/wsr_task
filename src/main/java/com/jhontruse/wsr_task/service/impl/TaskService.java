package com.jhontruse.wsr_task.service.impl;

import com.jhontruse.wsr_task.model.entity.Task;
import com.jhontruse.wsr_task.model.mapper.TaskMapper;
import com.jhontruse.wsr_task.model.records.GenericRespondePage;
import com.jhontruse.wsr_task.model.records.TaskResponse;
import com.jhontruse.wsr_task.repository.ITaskRepository;
import com.jhontruse.wsr_task.service.ITaskService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = false)
public class TaskService implements ITaskService {

    private final ITaskRepository taskRepository;

    @Override
    public List<TaskResponse> findAll() {
        log.info("TaskService - findAll ");
        List<TaskResponse> tasksResponse = taskRepository.findAll().
                stream().
                map(TaskMapper::toResponseFind).
                toList();
        log.info("tasksResponse = {}", tasksResponse);
        if (tasksResponse == null) {
            return tasksResponse;
        }
        return tasksResponse;
    }

    @Override
    @Transactional(readOnly = true)
    public GenericRespondePage<TaskResponse> findTaskByTitulo(String titulo, int page, int size) {
        log.info("TaskService - findByTituloContainingIgnoreCase ");
        log.info("titulo = {}", titulo);
        log.info("page = {}", page);
        log.info("size = {}", size);
        Pageable pageable = PageRequest.of(page, size, Sort.by("fecRegistro").descending());
        log.info("pageable = {}", pageable);
        Page<Task> taskPage = taskRepository.findTaskByTitulo(titulo, pageable);
        List<TaskResponse> content =
                taskPage.stream().map(TaskMapper::toResponseFind).toList();
        log.info("content = {}", content);
        return new GenericRespondePage<>(
                content,
                taskPage.getNumber(),
                taskPage.getSize(),
                taskPage.getTotalElements(),
                taskPage.getTotalPages(),
                taskPage.isLast()
        );
    }

    @Override
    public GenericRespondePage<TaskResponse> findTaskByTituloContainingIgnoreCase(String titulo, int page, int size) {
        log.info("TaskService - findTaskByTituloContainingIgnoreCase ");
        log.info("titulo = {}", titulo);
        log.info("page = {}", page);
        log.info("size = {}", size);
        Pageable pageable = PageRequest.of(page, size, Sort.by("fecRegistro").descending());
        log.info("pageable = {}", pageable);
        Page<Task> taskPage = taskRepository.findTaskByTituloContainingIgnoreCase(titulo, pageable);
        List<TaskResponse> content =
                taskPage.stream().map(TaskMapper::toResponseFind).toList();
        log.info("content = {}", content);
        return new GenericRespondePage<TaskResponse>(
                content,
                taskPage.getNumber(),
                taskPage.getSize(),
                taskPage.getTotalElements(),
                taskPage.getTotalPages(),
                taskPage.isLast()
        );
    }
}
