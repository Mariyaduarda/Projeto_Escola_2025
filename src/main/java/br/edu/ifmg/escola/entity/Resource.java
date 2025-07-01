package br.edu.ifmg.escola.entity;

import br.edu.ifmg.escola.constant.ResourceType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.boot.model.source.spi.FetchCharacteristics;

import java.util.ArrayList;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = false)
@Entity
@Table(name = "tb_resource")
public class Resource {
@GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Id
    private Long id;
    private String title;
    private String description;
    private String position;
    private String Imgurl;

    @Enumerated(EnumType.STRING)
    private ResourceType resourceType;
    private String externalLink;

   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "offer_id")
   private Offer offer;

   @OneToMany(mappedBy = "resource")
   List<Section> sections = new ArrayList<>();
}
