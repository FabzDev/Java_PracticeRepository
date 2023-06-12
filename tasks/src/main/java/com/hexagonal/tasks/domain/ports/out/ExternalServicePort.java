package com.hexagonal.tasks.domain.ports.out;

import com.hexagonal.tasks.domain.models.AdditionalTaskInformation;

public interface ExternalServicePort {
    AdditionalTaskInformation getAdditionalTaskInformation(Long taskId);
}
