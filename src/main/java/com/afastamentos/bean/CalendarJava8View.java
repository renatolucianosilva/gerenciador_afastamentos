package com.afastamentos.bean;

import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import jakarta.validation.constraints.Future;
import lombok.Getter;
import lombok.Setter;
import org.primefaces.PrimeFaces;
import org.primefaces.event.SelectEvent;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Named
@ViewScoped
@Getter
@Setter

public class CalendarJava8View {
    private LocalDate date;
    private LocalDate date1;
    @Future
    private LocalDate date2;
    private LocalDate date3;
    private LocalDate date4;
    private LocalDate date5;
    private LocalDate date6;
    private LocalDate date7;
    private LocalDate date8;
    private LocalDate date9;
    private LocalDate dateDe;
    private LocalDate date10;
    private LocalDate date11;
    private LocalDate date12;
    private LocalDate date13;
    private LocalDate date14;
    private LocalDate date15;
    private List<LocalDate> multi;
    private List<LocalDate> range;
    private List<LocalDate> invalidDates;
    private List<LocalDate> validDates;
    private List<Integer> invalidDays;
    private LocalDate minDate;
    private LocalDate maxDate;
    private LocalTime minTime;
    private LocalTime maxTime;
    private LocalDateTime minDateTime;
    private LocalDateTime maxDateTime;
    private ZonedDateTime zonedDateTime1;
    private YearMonth yearMonth;

    @PostConstruct
    public void init() {
        invalidDates = new ArrayList<>();
        invalidDates.add(LocalDate.now());
        for (int i = 0; i < 5; i++) {
            invalidDates.add(invalidDates.get(i).plusDays(1));
        }

        validDates = new ArrayList<>();
        validDates.add(LocalDate.now());
        for (int i = 0; i < 5; i++) {
            validDates.add(validDates.get(i).plusDays(1));
        }

        invalidDays = new ArrayList<>();
        invalidDays.add(0);
        /* the first day of week is disabled */
        invalidDays.add(3);

        minDate = LocalDate.now().minusYears(1);
        maxDate = LocalDate.now().plusYears(1);
        dateDe = LocalDate.of(2019, 7, 27);



    }

    public void onDateSelect(SelectEvent<LocalDate> event) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Date Selected", event.getObject().format(formatter)));
    }

    public void onDateTimeSelect(SelectEvent<LocalDateTime> event) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Date Selected", event.getObject().format(formatter)));
    }

    public void click() {
        PrimeFaces.current().ajax().update("form:display");
        PrimeFaces.current().executeScript("PF('dlg').show()");
    }
}
