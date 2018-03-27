package ec.com.core.springrestfulservices.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@DynamicUpdate
@Table(name="STG_DIRECCIONES_ACT")
public class Address {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "ID_DIRECCION")
    private int idAdress;

    @Column(name = "PERSONA", length = 50, nullable = false)
    private int codePerson;

    @Column(name = "PRINCIPAL", length = 250, nullable = false)
    private String streetMain;

    @Column(name = "NUMERO", length = 10, nullable = false)
    private String numberStreet;

    @Column(name = "INTERSECCION", length = 200, nullable = false)
    private String intersection;

    @Column(name = "REFERENCIA", length = 100, nullable = false)
    private String referenceStreet;

    @Column(name = "FECHA_ACTUALIZACION", length = 50, nullable = false)
    private String dateUpdate;

    @Column(name = "FECHA_CREACION", length = 50, nullable = false)
    private String dateCreate;

    @Column(name = "DESCRIPCION", length = 250, nullable = false)
    private String descriptionAdress;

    @Column(name = "CIUDAD", length = 50, nullable = false)
    private String city;

    @Column(name = "PROVINCIA", length = 50, nullable = false)
    private String province;

    @Column(name = "BARRIO", length = 50, nullable = false)
    private String district;

    @Column(name = "ZONA", length = 50, nullable = false)
    private String zone;

    @Column(name = "REGION", length = 50, nullable = false)
    private String region;

}
