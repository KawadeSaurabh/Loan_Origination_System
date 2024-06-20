package com.backend.LOS.Entity;

import java.sql.Date;
import java.util.List;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "loans")
public class Loan {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private double amount;
    private double interestRate;
    private int termMonths;
    private String status;
    private Date dateOpened;
    private Date dateClosed;
    
 // Relationships
    @OneToMany(mappedBy = "loan")
    private List<LoanApplication> loanApplications;
    
    @OneToMany(mappedBy = "loan")
    private List<Payment> payments;
}

