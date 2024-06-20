package sb.uam.jpa.relationship.s10.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "clients")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    @Column(name = "last_name")
    private String lastname;

    //A continuacion realizamos una relacion OneToMany unidireccional.
    // En esta relacion Un cliente tiene muchas direcciones.
    // Un cliente tiene muchas direcciones. Extra: Primera palabra clase en la que estamos, segunda es la clase que estamos relacionando.
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true) // Con cascade = CascadeType.ALL, si eliminamos un cliente, se eliminan todas sus direcciones.
    // Ademas con orphanRemoval = true, si eliminamos un cliente se elimina en automatico la direccion.
    // Lo anteior provoca que se cree una tabla intermedia con la FK de cada uno de las entidades que se relacionan.
    private List<Address> addresses = new ArrayList<>(); // IMPORTANTE: La instancia siempre se debe inicializar.


}
