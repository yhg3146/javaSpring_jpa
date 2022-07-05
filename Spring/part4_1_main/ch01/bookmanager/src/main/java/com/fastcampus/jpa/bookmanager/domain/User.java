package com.fastcampus.jpa.bookmanager.domain;

import com.fastcampus.jpa.bookmanager.domain.listener.Auditable;
import com.fastcampus.jpa.bookmanager.domain.listener.UserEntityListener;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
//@Table(name="user",indexes = {@Index(columnList = "name")},uniqueConstraints = {@UniqueConstraint(columnNames = {"email"})})
@EntityListeners(value = {UserEntityListener.class})


public class User  extends  BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String name;

    @NonNull
    private String email;

    @Enumerated(value = EnumType.STRING)
    private Gender gender;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name="city",column = @Column(name="home_city")),
            @AttributeOverride(name="district",column = @Column(name="home_district")),
            @AttributeOverride(name="detail",column = @Column(name="home_detail")),
            @AttributeOverride(name="zipCode",column = @Column(name="home_zip_code"))
}
    )
    private Address homeAddress;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name="city",column = @Column(name="company_city")),
            @AttributeOverride(name="district",column = @Column(name="company_district")),
            @AttributeOverride(name="detail",column = @Column(name="company_detail")),
            @AttributeOverride(name="zipCode",column = @Column(name="company_zip_code"))
    }
    )
    private Address companyAddress;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name="user_id",insertable = false,updatable = false)
    @ToString.Exclude
    private List<UserHistory> userHistories = new ArrayList<>();

    @OneToMany
    @JoinColumn(name="user_id")
    @ToString.Exclude
    private List<Review> reviews = new ArrayList<>();







    /*
    @Column(updatable = false)
    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;
*/

//    @Transient
//    private String testData;
//    @OneToMany(fetch= FetchType.EAGER)
//    private List<Address> address;

    //5-1
 /*   @PrePersist
    public void prePersist(){
        this.createdAt =LocalDateTime.now();
        this.updatedAt=LocalDateTime.now();
    }


    @PostPersist
    public void postPersist(){
        System.out.println(">>>postPersist");
    }

    @PreUpdate
    public void PreUpdate(){

        this.updatedAt=LocalDateTime.now();
    }
*/
/*
    @PostUpdate
    public void PostUpdate(){
        System.out.println(">>>PostUpdate");
    }

    @PreRemove
    public void PreRemove(){
        System.out.println(">>> PreRemove");
    }


    @PostRemove
    public void PostRemove(){
        System.out.println(">>>PostRemove");
    }

    @PostLoad
    public void PostLoad(){
        System.out.println(">>>PostLoad");
    }*/
}
