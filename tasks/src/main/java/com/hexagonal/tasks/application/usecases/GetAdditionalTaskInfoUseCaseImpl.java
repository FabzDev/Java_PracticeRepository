package com.hexagonal.tasks.application.usecases;

import com.hexagonal.tasks.domain.models.AdditionalTaskInformation;
import com.hexagonal.tasks.domain.ports.in.GetAdditionalTaskInfoUseCase;
import com.hexagonal.tasks.domain.ports.out.ExternalServicePort;

public class GetAdditionalTaskInfoUseCaseImpl implements GetAdditionalTaskInfoUseCase {

    private final ExternalServicePort externalServicePort;

    public GetAdditionalTaskInfoUseCaseImpl(ExternalServicePort externalServicePort) {
        this.externalServicePort = externalServicePort;
    }

    @Override
    public AdditionalTaskInformation getAdditionalTaskInformation(Long id) {
        return externalServicePort.getAdditionalTaskInformation(id);
    }
}
