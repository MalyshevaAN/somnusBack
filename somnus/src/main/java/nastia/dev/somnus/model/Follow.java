//package nastia.dev.somnus.model;
//
//
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//import java.util.HashSet;
//import java.util.Set;
//
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//@Entity
//@Table(name = "follow")
//public class Follow {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long Id;
//
//
//    @ManyToMany
//    @JoinTable(
//            name = "user_followers",
//            joinColumns = @JoinColumn(name = "follower_id"),
//            inverseJoinColumns = @JoinColumn(name = "user_id")
//    )
//    private Set<User> follower = new HashSet<>();
//}
