package br.edu.ifmg.escola.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode( = true)
@Entity
@Table(name = "tb_reply")
public class Reply {

        @EqualsAndHashCode.Include
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String body;
        private Instant moment;

        @ManyToOne
        @JoinColumn(name = "author_id")
        private User author;

        @ManyToMany
        @JoinTable(name = "tb_topic_likes"),
        joinColumns = @JoinColumn(name = "topic_id"),
        inverseJoinColumns = @JoinColumn(name = "")
        private Set<User> likes = new HashSet<>();

    }


