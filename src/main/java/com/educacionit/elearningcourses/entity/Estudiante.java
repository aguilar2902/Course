package com.educacionit.elearningcourses.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Estudiante {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="est_id")
    private Long id;
    @Column(name = "est_nombre")
    private String nombre;
    @Column(name = "est_email")
    private String email;
    @ManyToMany(mappedBy = "estudiantes")
    private List<Curso> cursos;
}
