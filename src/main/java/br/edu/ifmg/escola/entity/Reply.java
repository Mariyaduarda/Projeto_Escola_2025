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
@EqualsAndHashCode
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

        @ManyToOne
        @JoinColumn(name = "topic_id")
        private Topic topic;

        @ManyToMany
        @JoinTable(
                name = "tb_reply_likes",
                joinColumns = @JoinColumn(name = "reply_id"),
                inverseJoinColumns = @JoinColumn(name = "user_id")
        )
        private Set<User> likes = new HashSet<>();

        @Lob
        @Column(name = "SQL_STATEMENT")
        private String sqlStatement;

        @Column(name = "EXECUTION_COUNT")
        private Integer executionCount;

        @Column(name = "MIN_EXECUTION_TIME")
        private Double minExecutionTime;

        @Column(name = "MAX_EXECUTION_TIME")
        private Double maxExecutionTime;

        @Column(name = "CUMULATIVE_EXECUTION_TIME")
        private Double cumulativeExecutionTime;

        @Column(name = "AVERAGE_EXECUTION_TIME")
        private Double averageExecutionTime;

        @Column(name = "STD_DEV_EXECUTION_TIME")
        private Double stdDevExecutionTime;

        @Column(name = "MIN_ROW_COUNT")
        private Long minRowCount;

        @Column(name = "MAX_ROW_COUNT")
        private Long maxRowCount;

        @Column(name = "CUMULATIVE_ROW_COUNT")
        private Long cumulativeRowCount;

        @Column(name = "AVERAGE_ROW_COUNT")
        private Double averageRowCount;

        @Column(name = "STD_DEV_ROW_COUNT")
        private Double stdDevRowCount;

}


