package org;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InscripcionTest {

    @Test

    @DisplayName("Este Test verifica que Juan puede cursar DDS si tiene aprobada IT1,AYED y SYPN y cursadas ADS Y PDP")
    public void primerTest(){

        Alumno alumno = new Alumno("Juan",123);
        Materia sypn = new Materia("Sistemas y Procesos de Negocios",113);
        Materia ayed = new Materia("Algoritmos y Estructuras de Datos",103);
        Materia ads = new Materia("Analisis de Sistemas",100);
        Materia dds = new Materia("Diseño de Sistemas",101);
        Materia ingles1 = new Materia("Ingles 1",102);
        Materia pdp = new Materia("Paradigmas de Programación",104);

        ads.agregarCursadaCorrelativas(sypn,ayed);
        dds.agregarCursadaCorrelativas(ads,pdp);
        dds.agregarAprobadasCorrelativas(ingles1,sypn,ayed);

        alumno.agregarMateriasCursadas(ads,pdp);
        alumno.agregarMateriasAprobadas(ingles1,sypn,ayed);

        Inscripcion ins = new Inscripcion(alumno);
        ins.agregarMaterias(dds);

        Assertions.assertTrue(ins.aprobada());
    }

    @Test
    @DisplayName("En este test se demuestra que Juan no puede cursar DDS ya que no aprobó el final de AYED")
    public void segundoTest(){
        Alumno alumno = new Alumno("Juan",123);
        Materia sypn = new Materia("Sistemas y Procesos de Negocios",113);
        Materia ayed = new Materia("Algoritmos y Estructuras de Datos",103);
        Materia ads = new Materia("Analisis de Sistemas",100);
        Materia dds = new Materia("Diseño de Sistemas",101);
        Materia ingles1 = new Materia("Ingles 1",102);
        Materia pdp = new Materia("Paradigmas de Programación",104);

        ads.agregarCursadaCorrelativas(sypn,ayed);
        dds.agregarCursadaCorrelativas(ads,pdp);
        dds.agregarAprobadasCorrelativas(ingles1,sypn,ayed);

        alumno.agregarMateriasCursadas(ads,pdp,ayed);
        alumno.agregarMateriasAprobadas(ingles1,sypn);

        Inscripcion ins = new Inscripcion(alumno);
        ins.agregarMaterias(dds);

        Assertions.assertFalse(ins.aprobada());
    }

    @Test
    @DisplayName("En este test se demuestra que Juan puede cursar SYPN ya que no tiene correlativas")
    public void tercerTest(){
        Alumno alumno = new Alumno("Juan",123);
        Materia sypn = new Materia("Sistemas y Procesos de Negocios",113);

        Inscripcion ins = new Inscripcion(alumno);
        ins.agregarMaterias(sypn);

        Assertions.assertTrue(ins.aprobada());
    }

}