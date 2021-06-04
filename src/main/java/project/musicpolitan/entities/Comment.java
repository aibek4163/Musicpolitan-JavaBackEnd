package project.musicpolitan.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "comments")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "comment")
    private String comment;

    @Column(name = "date")
    @JsonFormat(pattern = "dd.MM.yyyy, HH:mm")
    private Date date;

    @ManyToOne(fetch = FetchType.EAGER)
    private Users author;

    @ManyToOne(fetch = FetchType.EAGER)
    private News news;

    @ManyToOne(fetch = FetchType.EAGER)
    private Release release;

    @ManyToOne(fetch = FetchType.EAGER)
    private Review review;

    @ManyToOne(fetch = FetchType.EAGER)
    private Article article;
}
