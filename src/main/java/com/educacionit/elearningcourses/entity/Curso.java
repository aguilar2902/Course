package com.educacionit.elearningcourses.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cursos")
public class Curso {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="cur_id")
    private Long id;
    @Column(name="cur_nombre")
    private String nombre;
    @Column(name="cur_duracion")
    private int duracion;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name="cur_prof_id", nullable=false, referencedColumnName = "prof_id")
    private Profesor profesor;
    @ManyToMany
    @JoinTable(name="cursos_estudiantes",
            joinColumns = @JoinColumn(name="curso_id", referencedColumnName = "cur_id"),
            inverseJoinColumns = @JoinColumn(name = "estudiante_id", referencedColumnName = "est_id"))
    private List<Estudiante> estudiantes;
}
