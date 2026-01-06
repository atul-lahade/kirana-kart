package com.kirana_kart.backend.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GenericMapper {

    private final ModelMapper modelMapper;

    public GenericMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    /**
     * Converts an Entity object to a DTO object of the specified DTO class.
     *
     * @param entity   The source entity object.
     * @param dtoClass The target DTO class.
     * @return The converted DTO object.
     */
    public <E, D> D mapToDto(E entity, Class<D> dtoClass) {
        return modelMapper.map(entity, dtoClass);
    }

    /**
     * Converts a DTO object to an Entity object of the specified Entity class.
     *
     * @param dto         The source DTO object.
     * @param entityClass The target entity class.
     * @return The converted Entity object.
     */
    public <D, E> E mapToEntity(D dto, Class<E> entityClass) {
        return modelMapper.map(dto, entityClass);
    }

    /**
     * Converts a list of Entities to a list of DTOs.
     *
     * @param entities The list of source entity objects.
     * @param dtoClass The target DTO class.
     * @return The list of converted DTO objects.
     */
    public <E, D> List<D> mapListToDto(List<E> entities, Class<D> dtoClass) {
        return entities.stream()
                .map(entity -> modelMapper.map(entity, dtoClass))
                .collect(Collectors.toList());
    }
}
