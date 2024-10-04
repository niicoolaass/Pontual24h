package br.com.ponto.model;

import java.sql.Time;

public class HorarioTrabalho {
    private int id;
    private String diasSemana;
    private Time horarioEntrada;
    private Time horarioSaida;
    private Time intervalo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDiasSemana() {
        return diasSemana;
    }

    public void setDiasSemana(String diasSemana) {
        this.diasSemana = diasSemana;
    }

    public Time getHorarioEntrada() {
        return horarioEntrada;
    }

    public void setHorarioEntrada(Time horarioEntrada) {
        this.horarioEntrada = horarioEntrada;
    }

    public Time getHorarioSaida() {
        return horarioSaida;
    }

    public void setHorarioSaida(Time horarioSaida) {
        this.horarioSaida = horarioSaida;
    }

    public Time getIntervalo() {
        return intervalo;
    }

    public void setIntervalo(Time intervalo) {
        this.intervalo = intervalo;
    }
}



