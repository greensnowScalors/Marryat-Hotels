package com.scalors.hotels.marryat.mapper.common;

public interface CommonMapper<T, S> {
    T convert(S source);
}
