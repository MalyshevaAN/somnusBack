package nastia.dev.somnus.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "post")
public class Dream {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

//
//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "user_id", nullable = false)
//    private Long author;


    @Column(nullable = false)
    private String dreamText;

    @Basic
    @Column(name = "DateCreation")
    private LocalDateTime localDateTime = LocalDateTime.now();


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User author;

    @OneToMany(mappedBy = "dreamComment")
    private Set<Comment> postComments = new HashSet<>();

//    public Dream(Long author, String text){
//        this.author = author;
//        this.dreamText = text;
//    }

}