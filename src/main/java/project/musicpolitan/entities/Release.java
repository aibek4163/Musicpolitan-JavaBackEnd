package project.musicpolitan.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "releases")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Release {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "short_description")
    private String shortDescription;

    @Column(name = "description")
    private String text;

    @Column(name = "image")
    private String image;

    @Column(name = "banner_image")
    private String banner_image;

    @Column(name = "date")
    @JsonFormat(pattern = "dd.MM.yyyy, HH:mm")
    private Date date;

    @OneToOne(fetch = FetchType.EAGER)
    private Artist artist;
}
