package com.italobackend.springsecurityloginj21.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record RegisterRequest(
        @NotBlank
        @Size(max = 255 , message = "O nome não pode conter mais de 256 caracteres")
        String name,

        @NotBlank
        @Size(max = 255, message = "O usuário não pode conter mais de 256 caracteres.")
        String username,

        @NotBlank
        @Size(min = 8, max = 72, message = "A senha deve ter no mínimo 8 caracteres e no máximo 72 caracteres.")
        String password
) {
}
