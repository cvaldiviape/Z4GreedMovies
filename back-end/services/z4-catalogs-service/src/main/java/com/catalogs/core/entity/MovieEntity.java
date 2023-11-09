package com.catalogs.core.entity;

import com.shared.dto.custom.CommonEntity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
@Table(name = "movie")
public class MovieEntity extends CommonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_movie")
    private Integer idMovie;
    @Column(name = "synopsis", nullable = false)
    private String synopsis;
    @Column(name = "year", nullable = false)
    private Integer year;
    @Column(name = "duration", nullable = false)
    private LocalTime duration;
    @Column(name = "url_image", nullable = false)
    private String urlImage;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_studio")
    private StudioEntity studio;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "movie_audience")
    private MovieAudienceEntity movieAudience;
    @Builder.Default
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "movies_genres",
            joinColumns = @JoinColumn(name = "id_movie", referencedColumnName = "id_movie"),
            inverseJoinColumns = @JoinColumn(name = "id_genre", referencedColumnName = "id_genre"))
    private Set<GenreEntity> listGenres = new HashSet<>();
    @Builder.Default
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "movies_languages",
            joinColumns = @JoinColumn(name = "id_movie", referencedColumnName = "id_movie"),
            inverseJoinColumns = @JoinColumn(name = "id_language", referencedColumnName = "id_language"))
    private Set<LanguageEntity> listLanguages = new HashSet<>();
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_profit_agreements", referencedColumnName = "id_profit_agreements")
    private ProfitAgreementsEntity profitAgreements;

}