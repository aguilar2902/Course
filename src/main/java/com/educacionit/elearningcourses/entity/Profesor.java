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
@Table(name="profesores")
public class Profesor {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="prof_id")
    private Long id;
    @Column(name="prof_nombre")
    private String nombre;
    @Column(name="prof_especialidad")
    private String especialidad;
    @OneToMany(mappedBy = "profesor", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Curso> cursos;
}
