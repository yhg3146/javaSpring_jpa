package com.fastcampus.jpa.bookmanager.domain;

import com.fastcampus.jpa.bookmanager.domain.listener.Auditable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class UserHistory extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

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

    @ManyToOne
    @ToString.Exclude
    private User user;


/*    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;*/
}
