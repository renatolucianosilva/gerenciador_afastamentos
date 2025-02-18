package com.afastamentos.bean;




import com.afastamentos.dto.UserDTO;
import com.afastamentos.service.UserService;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;


import java.io.Serializable;
import java.time.LocalDate;


@Named
@RequestScoped
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CadastroManagedBean implements Serializable {

    @NotBlank
    private String userNameCompleto;
    @NotBlank
    private String userName;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate userNascimento;
    private boolean userType;

    @Autowired
    private UserService userService;



    public void cadastroUsuario() {
        this.userType = false;
        UserDTO userDTO = new UserDTO(userNameCompleto, userName, userNascimento, userType);

        userService.cadastrarUsuario(userDTO);



    }

}
