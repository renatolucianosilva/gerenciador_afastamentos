package com.afastamentos.bean;

import java.io.Serializable;


import com.afastamentos.dto.UserDTO;
import com.afastamentos.service.UserService;
import jakarta.inject.Named;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;


@Named
@Getter
@Setter

public class TesteBean implements Serializable {

    @Autowired
    private  UserService userService;

    public UserDTO listarUsuario(Long id){
        UserDTO usuario;
        return usuario = userService.listarPorId(id);
        
    }
    
}
