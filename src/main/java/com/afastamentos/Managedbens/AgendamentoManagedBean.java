package com.afastamentos.Managedbens;


import com.afastamentos.dto.UserDTO;
import com.afastamentos.model.TipoAfastamento;
import com.afastamentos.service.UserService;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import lombok.Getter;

import lombok.Setter;
import org.primefaces.event.SelectEvent;


import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


@Named
@RequestScoped
@Getter
@Setter

public class AgendamentoManagedBean implements Serializable {

    private Long idAgendamento;
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate dataAgendamento;
    @Enumerated(EnumType.STRING)
    private TipoAfastamento tipoAfastamento;
    private boolean confirmado;
    private UserDTO idUser;
    private String dataFormatada;
    private Long idUserAgendamento;
    private String nomeUser;



    @Inject
    private UserService userService;





    public void onDateSelect(SelectEvent<LocalDate> event) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");


        facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Data Selecionada", event.getObject().format(formatter)));

        dataFormatada = formatter.format(event.getObject());
    }




    public void cadastrarAgendamento() {
        System.out.println(dataAgendamento);
        if(idUser != null) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Cadastro efetuado com sucesso!"));

        }else{
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Cadastro Não Realizado!"));
        }
    }

    public List<String> listarUsers(){
        List<UserDTO> usuariosList = userService.listaUsuarios();
        if (usuariosList == null) {
            return Collections.emptyList();
        }
        return usuariosList.stream()
                .map(UserDTO::getUserName)
                .collect(Collectors.toList());
    }

    public List<Long> listarUsersId(){
        List<UserDTO> usuariosList = userService.listaUsuarios();
        if (usuariosList == null) {
            return Collections.emptyList();
        }
        return usuariosList.stream()
                .map(UserDTO::getIdUser)
                .collect(Collectors.toList());
    }



}
