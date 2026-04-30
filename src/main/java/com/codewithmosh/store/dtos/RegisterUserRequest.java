package com.codewithmosh.store.dtos;

import com.codewithmosh.store.validation.Lowercase;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class RegisterUserRequest {
    @NotBlank(message = "Nombre es obligatorio")
    @Size(max = 255, message = "Nombre debe tener menos de 255 caracteres")
    private String name;

    @NotBlank(message = "Correo es obligatorio")
    @Email(message = "El correo debe ser valido")
    @Lowercase(message = "El correo debe estar en minusculas")
    private String email;

    @NotBlank(message = "Contraseña es obligatoria")
    @Size(min = 6, max = 25, message = "Contraseña debe ser entre 6 y 25 caracteres")
    private String password;
}
