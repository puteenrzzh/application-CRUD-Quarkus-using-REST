package org.acme;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "putri")
public class Tugas6 extends PanacheEntityBase {
    @Id
    @Column(unique = true,nullable = false)
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid",strategy = "org.hibernate.id.UUIDGenerator")
    public String id;
    public String field;
    public String nama;
    public String bias;
    @Column(name = "product_name",nullable = false)
    public String productName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
