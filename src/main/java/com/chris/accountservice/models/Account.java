package com.chris.accountservice.models;

import com.chris.accountservice.enums.CurrencyCode;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;


@Entity
@Table(name = "ACCOUNT")
public class Account {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column(name = "FORE_NAME", length=50, nullable=false, unique=false)
    private String foreName;
    @Column(name = "SUR_NAME", length=50, nullable=false, unique=false)
    private String surName;
    @Column(name = "BIRTH_DATE", nullable=false, unique=false)
    private LocalDate birthDate;
    // TODO use updatable=false on createdAt timestamp - remove it from below true is the default
    @Enumerated(EnumType.STRING)
    @Column(name="CURRENCY_CODE", nullable = true, updatable = true)
    private CurrencyCode currencyCode;
    @Transient
    private Integer age;


    public Account() {
    }

    public Account(Long id, String foreName, String surName, LocalDate birthDate, CurrencyCode currencyCode) {
        this.id = id;
        this.foreName = foreName;
        this.surName = surName;
        this.birthDate = birthDate;
        this.currencyCode = currencyCode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getForeName() {
        return foreName;
    }

    public void setForeName(String foreName) {
        this.foreName = foreName;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public CurrencyCode getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(CurrencyCode currencyCode) {
        this.currencyCode = currencyCode;
    }

    public Integer getAge() {
        // TODO workout age from dob
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }


    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", foreName='" + foreName + '\'' +
                ", surName='" + surName + '\'' +
                ", birthDate=" + birthDate +
                ", currencyCode='" + currencyCode + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(id, account.id) && Objects.equals(foreName, account.foreName) && Objects.equals(surName, account.surName) && Objects.equals(birthDate, account.birthDate) && Objects.equals(currencyCode, account.currencyCode) && Objects.equals(age, account.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, foreName, surName, birthDate, currencyCode, age);
    }
}
