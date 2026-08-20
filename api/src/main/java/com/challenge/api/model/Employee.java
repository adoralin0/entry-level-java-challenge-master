package com.challenge.api.model;

import java.time.Instant;
import java.util.UUID;

public record Employee(
        UUID uuid,
        String firstName,
        String lastName,
        String email,
        String title,
        String department,
        Instant createdAt) {}
