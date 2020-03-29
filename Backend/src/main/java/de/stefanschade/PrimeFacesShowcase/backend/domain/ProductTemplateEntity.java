package de.stefanschade.PrimeFacesShowcase.backend.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.util.Set;

@Slf4j
@Data
@Entity
@RequiredArgsConstructor
@NoArgsConstructor
public class ProductTemplateEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long dbId;

    @Column(nullable = false, unique=true)
    @NonNull
    private String name;

    @OneToMany(mappedBy = "template")
    @Column(nullable = false)
    private Set<ConfigurableFieldEntity> fields;
}
