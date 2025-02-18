package com.afastamentos.dto;



import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserDTO {


    private Long idUser;
    @NotBlank
    private String userNameCompleto;
    @NotBlank
    private String userName;    
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate userNascimento;    
    private boolean userType;
    
    public UserDTO(String userNameCompleto, String userName, LocalDate userNascimento, boolean userType) {

        this.userNameCompleto = userNameCompleto;
        this.userName = userName;
        this.userNascimento = userNascimento;
        this.userType = userType;

    }

    
}
