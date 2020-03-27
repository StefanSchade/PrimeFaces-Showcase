package de.stefanschade.PrimeFacesShowcase.backend.domain;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import de.stefanschade.PrimeFacesShowcase.backend.dto.FieldType;
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
@Table(uniqueConstraints={@UniqueConstraint(columnNames ={"template_name","field_name"})})
public class ConfigurableFieldEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long dbId;

    @Column(nullable = false)
    @NonNull
    private String id;

    @Column(nullable = false, name="template_name")
    @NonNull
    @JsonManagedReference
    String productTemplateName;

    @Column(nullable = false, name="field_name")
    @NonNull
    private String fieldName;

    @Column(nullable = false)
    @NonNull
    private Integer fieldLength;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    @NonNull
    private FieldType fieldType;
}