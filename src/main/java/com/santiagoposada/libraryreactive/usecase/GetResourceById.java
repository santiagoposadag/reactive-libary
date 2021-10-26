package com.santiagoposada.libraryreactive.usecase;


import com.santiagoposada.libraryreactive.dto.ResourceDTO;
import com.santiagoposada.libraryreactive.mapper.ResourceMapper;
import com.santiagoposada.libraryreactive.repository.ResourceRepository;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

import java.util.Objects;
import java.util.function.Function;

@Service
@Validated
public class GetResourceById implements Function<String, Mono<ResourceDTO>> {
    private ResourceMapper resourceMapper;
    private ResourceRepository resourceRepository;

    public GetResourceById(ResourceMapper resourceMapper, ResourceRepository resourceRepository){
        this.resourceMapper = resourceMapper;
        this.resourceRepository = resourceRepository;
    }

    @Override
    public Mono<ResourceDTO> apply(String id) {
        Objects.requireNonNull(id, "Id is required to get a resource");
        return resourceRepository
                .findById(id)
                .map(resource->resourceMapper
                        .fromResourceEntityToDTO()
                        .apply(resource));
    }
}
