package de.stefanschade.PrimeFacesShowcase.backend.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.util.List;

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
    private String templatename;

    @OneToMany(mappedBy = "template", cascade = CascadeType.ALL, orphanRemoval = true)
    @Column(nullable = false)
    @JsonManagedReference
    // todo: i needed the transient to prevent a stackoverflow when generating hash codes
    private transient List<ConfigurableFieldEntity> fields;
}
