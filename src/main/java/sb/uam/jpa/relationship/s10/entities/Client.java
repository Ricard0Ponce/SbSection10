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
    // Si lo dejamos solo con OneToMany va a crear la base de datos con clients_address, pero si queremos personalizar el nombre
    // Usamos: @JoinTable
// EXPLICACIÓN:
    /*
     * @JoinTable define una tabla intermedia para una relación muchos a muchos.
     * name = "tbl_clientes_to_direcciones": Nombre de la tabla intermedia.
     * joinColumns = Define las columnas de la tabla intermedia que referencian a la entidad actual (Client).
     * @JoinColumn(name = "id_cliente"): Columna en la tabla intermedia que hace referencia a la entidad Client.
     * inverseJoinColumns = Define las columnas de la tabla intermedia que referencian a la entidad relacionada (Address).
     * @JoinColumn(name = "id_direccion"): Columna en la tabla intermedia que hace referencia a la entidad Address.
     * uniqueConstraints = Agrega restricciones únicas a la tabla intermedia.
     * @UniqueConstraint(columnNames = {"id_direccion"}): Asegura que no haya duplicados en la columna id_direccion.
     */
    @JoinTable(name = "tbl_clientes_to_direcciones", joinColumns = @JoinColumn(name = "id_cliente"),
    inverseJoinColumns = @JoinColumn(name = "id_direccion"),
    uniqueConstraints = @UniqueConstraint(columnNames = {"id)direccion"}))
    private List<Address> addresses = new ArrayList<>(); // IMPORTANTE: La instancia siempre se debe inicializar.
    //JPA crea una tabla intermedia por defecto

}
