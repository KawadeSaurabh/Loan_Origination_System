package com.backend.LOS.Entity;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Date;
import java.util.*;

@Getter
@Setter
@ToString
@Entity
@Table(name = "loan_applications")
public class LoanApplication {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String status;
    private Date dateCreated;
    private Date dateModified;
    
    // Relationships
    @ManyToOne
    @JoinColumn(name = "applicant_user_id")
    private User applicantUser;
    
    @ManyToOne
    @JoinColumn(name = "loan_id")
    private Loan loan; // This field must match the mappedBy value in Loan entity
    
    @OneToMany(mappedBy = "loanApplication")
    private List<Document> documents;
}

