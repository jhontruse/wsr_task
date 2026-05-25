package com.jhontruse.wsr_task.model.records;

import java.util.List;

public record GenericRespondePage<T>(
        List<T> content,
        int page,
        int size,
        long totalElements,
        int totalPages,
        boolean last
) {
}
