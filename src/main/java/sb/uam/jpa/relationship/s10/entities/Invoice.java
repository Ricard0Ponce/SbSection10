package sb.uam.jpa.relationship.s10.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="invoices")
// Invoice significa factura
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String description;
    private Long total;

    // A continuacion se realiza la relacion entre las tablas
    // Para ello vamos a declarar el objeto cliente un atributo más
    @ManyToOne // La primera palabra se refiere a la clase en la que esta el atributo (En este caso el Many se relaciona al Invoice)
    // @JoinColumn(name = "id_cliente") // Usamos JoinColumn para indicar el nombre de la llave foranea en la tabla de Invoice, ya no se llamara client_id, si no lo que se indique
    private Client client; // Aquí se va a generar una llave foranea en la tabla de Invoice, en la tabla
    // de Invoice se va a generar un campo que se va a llamar client_id que va a ser la llave foranea que se va a relacionar con la tabla de Client

}
