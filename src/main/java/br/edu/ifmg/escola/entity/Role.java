package br.edu.ifmg.escola.entity;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import jakarta.persistence.*;
import lombok.*;

@Data
@Getter
@Setter
@ToString//eqaulsandhashcode campos explicitamente
@Entity
@Table(name = "tb_role")
public class Role {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    //@Getter(value = AccessLevel.PRIVATE) -> dominio sobre o lombok
    private String authority;

}
