package br.edu.ifmg.escola.entity;

import jakarta.persistence.ManyToMany;

import java.util.ArrayList;
import java.util.List;

public class Enrollment {
    private boolean onlyUpdate;

    @ManyToMany(mappedBy = "enrollmentsDone")
    private List<Deliver> delivers = new ArrayList<>();

    public User
}
