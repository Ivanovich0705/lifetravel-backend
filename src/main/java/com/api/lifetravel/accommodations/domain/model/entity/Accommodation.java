package com.api.lifetravel.accommodations.domain.model.entity;
import com.api.lifetravel.accommodations.domain.service.AccommodationService;
import com.api.lifetravel.trip_plan.domain.model.entity.Plan;
import com.api.lifetravel.users.domain.model.entity.Agency;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "accommodations")
public class Accommodation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Create a new attribute for the returnDate
    @NotNull
    @NotBlank
    private String details;

    // Create a new attribute for the returnDate
    @NotNull
    @NotBlank
    private String location;

    // Create a new attribute for the price
    @NotNull
    @NotBlank
    private String price;

    // Create a OneToOne relation with the Agency
    @OneToOne
    @JoinColumn(name = "agency_id",referencedColumnName="id")
    private Agency agency;

//    @OneToMany(mappedBy = "accommodation")
//    private List<AccommodationServiceEntity> services;
//
//    @OneToMany(mappedBy = "accommodation")
//    private List<AccommodationCondition> conditions;
//
//    @OneToMany(mappedBy = "accommodation")
//    private List<AccommodationImages> accommodationImages;

}