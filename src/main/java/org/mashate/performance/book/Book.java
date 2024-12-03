package org.mashate.performance.book;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "book")
public class Book implements Serializable  {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;

    private String author;

    private LocalDate publicationDate;

    private String isbn;


    public enum Genre {
        FICTION,
        NON_FICTION,
        SCIENCE_FICTION,
        MYSTERY,
        ROMANCE,
        FANTASY,
        THRILLER,
        HORROR,
        BIOGRAPHY,
        HISTORY,
        SELF_HELP,
        OTHER
    }

    @Enumerated(EnumType.STRING)
    private Genre genre;
}