package com.chris.accountservice.models;

import com.chris.accountservice.enums.CurrencyCode;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.Period;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


@Entity
@Table(name = "ACCOUNT")
@NamedQueries({
        @NamedQuery(name = Account.ACCOUNT_INFO, query = Account.ACCOUNT_INFO_JPQL)
})
public class Account {

    public static final String ACCOUNT_INFO = "accountInfo";
    public static final String ACCOUNT_INFO_JPQL = "SELECT new com.chris.accountservice.models.AccountInfoDto" +
            "(a.foreName, a.currencyCode, l.operationType) " +
            "from Account a, AccountLog l " +
            "where a.id = l.account.id";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @NotNull
    @Column(name = "FORE_NAME", length=50)
    private String foreName;
    @NotNull
    @Column(name = "SUR_NAME", length=50)
    private String surName;
    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @Column(name = "BIRTH_DATE")
    private LocalDate birthDate;
    // TODO use updatable=false on createdAt timestamp
    @Enumerated(EnumType.STRING)
    @Column(name="CURRENCY_CODE")
    private CurrencyCode currencyCode;

    @JsonManagedReference
    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<AccountLog> accountLogs = new HashSet<>();
    @Transient
    private Integer age;


    public Account() {
    }

    public Account(String foreName, String surName, LocalDate birthDate, CurrencyCode currencyCode) {
        this.foreName = foreName;
        this.surName = surName;
        this.birthDate = birthDate;
        this.currencyCode = currencyCode;
    }

    public Integer getAge() {
        if (birthDate != null) {
            LocalDate currentDate = LocalDate.now();
            return Period.between(birthDate, currentDate).getYears();
        }
        //TODO return something other than null?
        return null; // Or some default value if birthDate is null
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

    public void setAge(Integer age) {
        this.age = age;
    }

    public Set<AccountLog> getAccountLogs() {
        return accountLogs;
    }

    public void setAccountLogs(Set<AccountLog> accountLogs) {
        this.accountLogs = accountLogs;
    }
    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", foreName='" + foreName + '\'' +
                ", surName='" + surName + '\'' +
                ", birthDate=" + birthDate +
                ", currencyCode=" + currencyCode +
                ", accessLogs=" + accountLogs +
                ", age=" + age +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(id, account.id) && Objects.equals(foreName, account.foreName) && Objects.equals(surName, account.surName) && Objects.equals(birthDate, account.birthDate) && currencyCode == account.currencyCode && Objects.equals(accountLogs, account.accountLogs) && Objects.equals(age, account.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, foreName, surName, birthDate, currencyCode, accountLogs, age);
    }


}
