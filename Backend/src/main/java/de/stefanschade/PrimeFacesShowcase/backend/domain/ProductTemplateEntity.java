package de.stefanschade.PrimeFacesShowcase.backend.domain;

import lombok.*;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;

@Slf4j
@Data
@Entity
@RequiredArgsConstructor
@NoArgsConstructor
public class ProductTemplateEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long dbId;

    @Column(nullable = false)
    @NonNull
    private String id;

    @Column(nullable = false)
    @NonNull
    private String categoryName;
}
