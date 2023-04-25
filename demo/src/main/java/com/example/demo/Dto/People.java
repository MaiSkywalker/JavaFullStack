package com.example.demo.Dto;
import lombok.*;
import javax.persistence.*;

@Table(name="people")
@Entity
@Getter @Setter
@ToString
public class People {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column
    private Long ID;
    @Column
    private String Name;
    @Column
    private String Surname;
    @Column
    private int Age;
    @Column
    private String City;

    public People(){

    }
    public People(String name, String surname, int age, String city) {
        super();
        this.Name = name;
        this.Surname = surname;
        this.Age = age;
        this.City = city ;
    }

}
