package com.afastamentos.Managedbens;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import lombok.Getter;
import lombok.Setter;
import org.primefaces.event.SelectEvent;

import java.time.*;
import java.time.format.DateTimeFormatter;

@Named
@ViewScoped
@Getter
@Setter

public class IndexManagedBean {
    private LocalDate date;
    private String dataSelecionada;

    public void onDateSelect(SelectEvent<LocalDate> event) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");


        facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Data Selecionada", event.getObject().format(formatter)));

         dataSelecionada = formatter.format(event.getObject());
    }



}