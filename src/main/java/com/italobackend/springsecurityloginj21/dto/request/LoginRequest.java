package com.italobackend.springsecurityloginj21.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record LoginRequest(
        @NotBlank
        @Size(max = 255, message = "Você tentou usar um usuário muito grande..")
        String username,
        @NotBlank
        @Size(max = 72, message = "Você tentou usar uma senha muito grande.")
        String password
) {
}
