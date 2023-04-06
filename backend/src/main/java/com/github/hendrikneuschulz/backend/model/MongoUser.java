package com.github.hendrikneuschulz.backend.model;

public record MongoUser(
        String id,
        String username,
        String password,
        String role) {

}
