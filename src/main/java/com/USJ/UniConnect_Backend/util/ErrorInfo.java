package com.USJ.UniConnect_Backend.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorInfo {

    private String errorMessage;
    private int errorCode;
    private LocalDateTime timestamp;

}
