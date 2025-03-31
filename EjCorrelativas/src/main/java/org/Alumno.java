package org;

import java.util.ArrayList;
import lombok.Getter;
import lombok.Setter;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Setter
@Getter

public class Alumno {
    private String nombre;
    private Integer nroLegajo;
    private List<Materia> materiasAprobadas;
    private List<Materia> materiasCursadas;

    public Alumno(String nombre, Integer nroLegajo) {
        this.nombre = nombre;
        this.nroLegajo = nroLegajo;
        this.materiasAprobadas = new ArrayList<>();
        this.materiasCursadas = new ArrayList<>();
    }

    public void agregarMateriasCursadas(Materia ... materias) {
        Collections.addAll(this.materiasCursadas, materias);
    }

    public void agregarMateriasAprobadas(Materia ... materias) {
        Collections.addAll(this.materiasAprobadas, materias);
        Collections.addAll(this.materiasCursadas, materias); // En caso de alguna promoción, tambien agrega la materia a las cursadas
    }

    public boolean cursoMateria(Materia materia){
        List<Materia> cursadasSinRepetidos = this.materiasCursadas.
                stream()
                .distinct()
                .collect(Collectors.toList());
        return materiasCursadas.contains(materia);
    }

    public boolean aproboMateria(Materia materia){
        return this.materiasAprobadas.contains(materia);
    }
}
