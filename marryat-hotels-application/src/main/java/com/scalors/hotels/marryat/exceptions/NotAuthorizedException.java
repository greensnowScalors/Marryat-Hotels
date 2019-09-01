package com.scalors.hotels.marryat.exceptions;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class NotAuthorizedException extends RuntimeException {
    public NotAuthorizedException(String s) {
        super(s);
    }
}
