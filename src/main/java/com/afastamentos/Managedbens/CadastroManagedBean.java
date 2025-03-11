package com.afastamentos.Managedbens;




import com.afastamentos.dto.UserDTO;
import com.afastamentos.service.UserService;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;

import jakarta.inject.Named;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import org.springframework.beans.factory.annotation.Autowired;



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

        UserDTO userDTOok = userService.cadastrarUsuario(userDTO);

        if(userDTOok != null) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Cadastro efetuado com sucesso!"));

        }else{
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Cadastro Não Realizado!"));
        }





    }

}
