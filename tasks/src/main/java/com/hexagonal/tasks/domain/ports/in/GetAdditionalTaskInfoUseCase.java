package com.hexagonal.tasks.domain.ports.in;

import com.hexagonal.tasks.domain.models.AdditionalTaskInformation;
import com.hexagonal.tasks.domain.models.Task;

import java.util.List;

public interface GetAdditionalTaskInfoUseCase {
    AdditionalTaskInformation getAdditionalTaskInformation(Long id);

}
