package org;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Setter
@Getter

public class Inscripcion {
    private Alumno alumno;
    private List<Materia> materias;

    public Inscripcion(Alumno alumno) {
        this.alumno = alumno;
        this.materias = new ArrayList<>();
    }

    public boolean aprobada () {
        return this.materias
                .stream()
                .allMatch(m -> m.puedeCursar(alumno));
    }

    public void agregarMaterias(Materia ... materias){
        Collections.addAll(this.materias, materias);
    }


}
