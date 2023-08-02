package com.example.demo.talent;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.Period;

@Entity
@Table
public class Talent {
    @Id
    @SequenceGenerator(
            name = "talent_sequence",
            sequenceName = "talent_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "talent_sequence"
    )
    private Long id;
    private String name;
    private String email;
    private String school;
    private String grade_level;
    private LocalDate dob;
    @Transient
    private Integer age;

    public Talent() {
    }

    public Talent(Long id,
                  String name,
                  String email,
                  String school,
                  String grade_level,
                  LocalDate dob) {
        this.id = id;
        this.name = name;
        this.school = school;
        this.grade_level = grade_level;
        this.email = email;
        this.dob = dob;
    }

    public Talent(String name,
                  String email,
                  String school,
                  String grade_level,
                  LocalDate dob) {
        this.name = name;
        this.school = school;
        this.grade_level = grade_level;
        this.email = email;
        this.dob = dob;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getSchool(){ return school;}
    public void setSchool(String school){ this.school = school; }
    public String getGrade_level(){return grade_level;}
    public void setGrade_level(String grade_level){this.grade_level = grade_level;}
    public LocalDate getDob() {
        return dob;
    }
    public void setDob(LocalDate dob) {
        this.dob = dob;
    }
    public Integer getAge() {
        return Period.between(this.dob, LocalDate.now()).getYears();
    }
    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Talent{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", school='" + school + '\'' +
                ", grade_level='" + grade_level + '\'' +
                ", dob=" + dob +
                ", age=" + age +
                '}';
    }
}
