package com.librarymanagment.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;


@Data
public class BookRequest {
    @NotBlank(message = "El titulo es obligatorio")
    @Size(min = 3, max = 50)
    String title;
    @NotBlank(message = "El autor es obligatorio")
    @Size(min = 3, max = 50)
    String author;
    @Size(min = 3, max = 20)
    @NotNull(message = "El isbn es obligatorio")
    String isbn;
    @Size( max = 10)
    @NotBlank(message = "La fecha es obligatoria")
    @Size( max = 4)
    String year;
    @NotEmpty(message = "El estado es obligatorio")
    @Size(max = 11)
    String status;
}
