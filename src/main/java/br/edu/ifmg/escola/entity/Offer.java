package br.edu.ifmg.escola.entity;

import br.edu.ifmg.escola.resource.Resource;
import jakarta.persistence.*;
import lombok.*;

import java.time.*;
import java.util.*;

@Data
@Getter
@Setter
@ToString//eqaulsandhashcode campos explicitamente
@Entity
@Table(name = "tb_offer")
public class Offer {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String edition; //edicao do curso -> curso de verao

    //TIMESTAMP para o h2 ficar melhor definido
    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant starMoment;
    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant endMoment;

    @ManyToOne
    @JoinColumn(name = "course.id") //unindo o offer com o course enity
    private Course course;

    @OneToMany(mappedBy = "offer")
    private List<Resource> resources = new ArrayList<>();

    @OneToMany(mappedBy = "offer")
    private List<Topic> topics = new ArrayList<>();

}
