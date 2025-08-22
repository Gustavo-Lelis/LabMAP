package br.com.gus.model;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Horario {
    private String diaSemana;
    private LocalTime horaInicio;
    private LocalTime horaFim;

    public Horario(String diaSemana, LocalTime horaInicio, LocalTime horaFim) {
        this.diaSemana = diaSemana;
        this.horaInicio = horaInicio;
        this.horaFim = horaFim;
    }

    public String getDiaSemana() {
        return diaSemana;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public LocalTime getHoraFim() {
        return horaFim;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        return diaSemana + " " + horaInicio.format(formatter) + " - " + horaFim.format(formatter);
    }
}
