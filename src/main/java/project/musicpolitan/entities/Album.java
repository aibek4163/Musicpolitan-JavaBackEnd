package project.musicpolitan.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "albums")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "image")
    private String image;

    @Column(name = "date")
    @JsonFormat(pattern = "dd.MM.yyyy, HH:mm")
    private Date date;

    @OneToMany(fetch = FetchType.EAGER)
    private List<Song> songs;

    @ManyToOne(fetch = FetchType.LAZY)
    private Artist artist;
}
