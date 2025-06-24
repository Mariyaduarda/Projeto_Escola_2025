package br.edu.ifmg.escola.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@Getter
@Setter
@ToString//eqaulsandhashcode campos explicitamente
@Entity
@Table(name = "tb_course")
public class Course {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String imgUrl;
    private String inmGrayUrl;

    @OneToMany(mappedBy = "course")
    private List<Offer> offers = new ArrayList<>();


}
