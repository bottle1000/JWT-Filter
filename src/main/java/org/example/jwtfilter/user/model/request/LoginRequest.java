package org.example.jwtfilter.user.model.request;

public record LoginRequest(
    String userName,
    String password
) {

}
