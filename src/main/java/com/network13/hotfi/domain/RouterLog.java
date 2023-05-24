package com.network13.hotfi.domain;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
@AllArgsConstructor
@Builder
public class RouterLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "router_log_id")
    private Long id;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "router_id")
    private Router router;

    private Double downloadSpeed;

    private Double uploadSpeed;

    private Double gitter;

    private Double ping;

}
