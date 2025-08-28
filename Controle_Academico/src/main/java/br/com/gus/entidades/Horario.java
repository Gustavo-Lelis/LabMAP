package br.com.gus.entidades;

import java.time.LocalTime;

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
        return diaSemana + " " + horaInicio + " - " + horaFim;
    }
}
