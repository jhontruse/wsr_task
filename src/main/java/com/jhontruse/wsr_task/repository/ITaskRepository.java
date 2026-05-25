package com.jhontruse.wsr_task.repository;

import com.jhontruse.wsr_task.model.entity.Task;
import jakarta.annotation.Nullable;
import org.jspecify.annotations.NullMarked;
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

}
