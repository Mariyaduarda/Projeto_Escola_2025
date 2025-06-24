package br.edu.ifmg.escola.resource;

import br.edu.ifmg.escola.constant.ResourceType;
import br.edu.ifmg.escola.entity.Offer;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;

import java.util.List;

public class Resource {

    @EqualsAndHashCode.Include
    @Id
    private String title;
    private String description;
    private String position;
    private String Imgurl;

    @Enumerated(EnumType.STRING)
    private ResourceType resourceType;

    @ManyToMany
    @JoinColumn(name = "offer_id")
    private List<Offer> offers;
}
