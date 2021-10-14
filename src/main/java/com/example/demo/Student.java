package com.example.demo;

import javax.persistence.*;

//Nome não precisa ser o mesmo nome, mas é melhor colocar um nome prorprio
@Entity(name = "Student") //faz com que seja mapiado para uma tabela
@Table(
        name = "student",
        uniqueConstraints = { //colocar um nome amigavel para o constrain do email
                @UniqueConstraint(name = "student_email_unique", columnNames = "email")
        }
)
public class Student {

    @Id //preciso dizer quem é a primary key para a tabela ser criada
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1 //ir de 1,2,3,4
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    @Column(
            name = "id", //nome na tabela
            updatable = false
    )
    private Long id;

    @Column(
            name = "first_name", //nome na tabela
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String firstName;

    @Column(
            name = "last_name", //nome na tabela
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String lastName;

    @Column(
            name = "email", //nome na tabela
            nullable = false,
            columnDefinition = "TEXT"
            //unique = true
    )
    private String email;

    @Column(
            name = "age", //nome na tabela
            nullable = false
    )
    private Integer age;

//construções dos getters and setters - Constructor
    public Student(String firstName, String lastName, String email, Integer age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.age = age;
    }
    public Student(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                '}';
    }
}
