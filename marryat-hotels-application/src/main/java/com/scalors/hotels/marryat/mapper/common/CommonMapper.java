package com.scalors.hotels.marryat.mapper.common;

public interface CommonMapper<T, S> {
    T convertToDTO(S dto);

    S convertToEntity(T entity);
}
