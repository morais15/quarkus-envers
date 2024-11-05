package com.quarkus.model;

import com.quarkus.interceptor.RevisionInfoInterceptor;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.envers.RevisionEntity;
import org.hibernate.envers.RevisionNumber;
import org.hibernate.envers.RevisionTimestamp;

import java.time.Instant;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "revision_info")
@RevisionEntity(RevisionInfoInterceptor.class)
public class RevisionInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @RevisionNumber
    @Column
    private Long id;

    @RevisionTimestamp
    @Column
    private Instant timestamp;

    @Column
    private String userName;
}
