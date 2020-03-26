package de.stefanschade.PrimeFacesShowcase.backend.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;

@Slf4j
@Data
@Entity
@RequiredArgsConstructor
@NoArgsConstructor
public class CarEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    @NonNull
    private String brand;

    @Column(nullable = false)
    @NonNull
    private int year;

    @Column(nullable = false)
    @NonNull
    private String color;

    @Column(nullable = false)
    @NonNull
    private int price;

    @Column(nullable = false)
    @NonNull
    private boolean soldState;

}
