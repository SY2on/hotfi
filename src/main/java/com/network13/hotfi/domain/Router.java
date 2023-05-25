package com.network13.hotfi.domain;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
@AllArgsConstructor
@Builder
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

    @OneToMany(mappedBy = "router", cascade = CascadeType.ALL)
    private List<RouterLog> routerLogList = new ArrayList<>();

    @Column(nullable = false)
    @CreatedDate
    private LocalDateTime createdDate;
}
