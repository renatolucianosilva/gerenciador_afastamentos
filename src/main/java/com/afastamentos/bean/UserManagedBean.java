package com.afastamentos.bean;



import jakarta.inject.Named;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;


@Named
@Getter
@Setter
public class UserManagedBean {

    private String userNameCompleto;
    private String userName;
    private LocalDate userNascimento;
    private boolean userType;
}
