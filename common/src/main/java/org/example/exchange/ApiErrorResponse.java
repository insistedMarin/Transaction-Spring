package org.example.exchange;

public record ApiErrorResponse(ApiError error, String data, String message) {

}