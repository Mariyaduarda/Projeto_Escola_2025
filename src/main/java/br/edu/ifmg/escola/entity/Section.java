package br.edu.ifmg.escola.entity;

import jakarta.persistence.OneToMany;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Section {
    private int id;
    private String title;
    private String description;


    @OneToMany(mappedBy = "section")
    private Set<Lesson> lessons = new HashSet<Lesson>();
}
