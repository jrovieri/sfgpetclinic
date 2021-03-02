package io.jrovieri.sfgpetclinic.model;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "visits")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Visit extends BaseEntity {

  private static final long serialVersionUID = 1L;

  @Column(name = "date")
  private LocalDate date;

  @Column(name = "description")
  private String description;

  @ManyToOne
  @JoinColumn(name = "pet_id")
  private Pet pet;
}
