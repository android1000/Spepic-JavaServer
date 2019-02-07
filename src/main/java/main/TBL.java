package main;

import javax.persistence.*;

@Entity
@Table(name = "SRVPRJCT.TBL")
public class TBL{
    @Id
    @Column(name="ID")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "my_id_seq_gen")
    @SequenceGenerator(name = "my_id_seq_gen", sequenceName = "id_seq")
    private long id;
    @Column(name="NAME")
    private String name;

    public TBL(){
    }

    public TBL(long id, String name) {
        this.id = id;
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getIdName() {
        return "id";
    }

    public String getNameName() {
        return "name";
    }
}