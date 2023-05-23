package com.network13.hotfi.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
public class Router {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "router_id")
    private Long id;

    @Column(unique = true)
    private String ip;

    private String locateName;

    private Double longitude;

    private Double latitude;

    private Double downloadSpeed;

    private Double uploadSpeed;

    private Double gitter;

    private Double ping;

    @Column(nullable = false)
    @CreatedDate
    private LocalDateTime createdDate;
}
