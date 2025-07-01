package br.edu.ifmg.escola.entity;

import br.edu.ifmg.escola.entity.pk.EnrollmentPK;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "tb_enrollment")
public class Enrollment {
    @EmbeddedId
    private EnrollmentPK id = new EnrollmentPK();
    private Instant enrolMoment;
    private Instant refundMoment;
    private boolean available;
    private boolean onlyUpdate;

    @ManyToMany(mappedBy = "enrollmentsDone")
    private Set<Lesson> lessonsDone = new HashSet<>();

    @OneToMany(mappedBy = "enrollment")
    private List<Deliver> deliveries = new ArrayList<>();

    public User getUser() { return id.getUser(); }
    public void setUser(User user) {id.setUser(user);}

    public Offer getOffer() { return id.getOffer(); }
    public void setOffer(Offer offer) {id.setOffer(offer);}

    public Enrollment(User user, Offer offer, Instant enrolMoment, Instant refundMoment, boolean available, boolean onlyUpdate) {
        this.id.setUser(user);
        this.id.setOffer(offer);
        this.enrolMoment = enrolMoment;
        this.refundMoment = refundMoment;
        this.available = available;
        this.onlyUpdate = onlyUpdate;
    }
}
