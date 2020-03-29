package de.stefanschade.PrimeFacesShowcase.backend.domain;


import com.fasterxml.jackson.annotation.JsonBackReference;
import de.stefanschade.PrimeFacesShowcase.backend.dto.FieldType;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;


@Slf4j
@Data
@Entity
@RequiredArgsConstructor
@NoArgsConstructor
@Table(uniqueConstraints={@UniqueConstraint(columnNames ={"templatename","name"})})
public class ConfigurableFieldEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "templatename", nullable = false)
    @NonNull
    @JsonBackReference
    ProductTemplateEntity template;

    @Column(nullable = false)
    @NonNull
    private String name;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    @NonNull
    private FieldType fieldType;

}