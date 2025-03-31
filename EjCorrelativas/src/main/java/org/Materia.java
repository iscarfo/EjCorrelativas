package org;

import java.util.ArrayList;
import lombok.Getter;
import lombok.Setter;

import java.util.Collections;
import java.util.List;

@Setter
@Getter

public class Materia {
    private String nombre;
    private Integer nroMateria;
    private List<Materia> cursadasCorrelativas;
    private List<Materia> aprobadasCorrelativas;

    public Materia(String nombre, Integer nroMateria) {
        this.nombre = nombre;
        this.nroMateria = nroMateria;
        this.cursadasCorrelativas = new ArrayList<>();
        this.aprobadasCorrelativas = new ArrayList<>();
    }

    public void agregarCursadaCorrelativas(Materia ... materiasCursadas) {
        Collections.addAll(this.cursadasCorrelativas, materiasCursadas);
    }

    public void agregarAprobadasCorrelativas(Materia ... materiasAprobadas) {
        Collections.addAll(this.aprobadasCorrelativas, materiasAprobadas);
    }

    public boolean puedeCursar (Alumno alumno) {
        return this.cursadasCorrelativas
                .stream()
                .allMatch(alumno::cursoMateria) &&
                this.aprobadasCorrelativas.stream().allMatch(alumno::aproboMateria);
    }







}
