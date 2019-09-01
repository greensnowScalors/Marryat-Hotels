package com.scalors.hotels.marryat.exceptions;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class ErrorResponseDTO {
    private String message;
    private long code;
    @JsonFormat(pattern="dd-MM-yyyy HH:mm:ss")
    private Date date;
}
