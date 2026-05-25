package com.jhontruse.wsr_task.repository;

import com.jhontruse.wsr_task.model.entity.Task;
import com.jhontruse.wsr_task.model.enums.EstadoTask;
import jakarta.annotation.Nullable;
import org.jspecify.annotations.NullMarked;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ITaskRepository extends CrudRepository<Task, String>,
        PagingAndSortingRepository<Task, String>
        //, ITaskRepositoryProcedure
{

    @Override
    @NullMarked
    List<Task> findAll();

    Page<Task> findTaskByTitulo(String titulo, Pageable pageable);

    Page<Task> findTaskByTituloContainingIgnoreCase(String titulo, Pageable pageable);

}
