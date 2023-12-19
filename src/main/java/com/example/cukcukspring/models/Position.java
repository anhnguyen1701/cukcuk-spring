package com.example.cukcukspring.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "Positions")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID PositionId;
    @Column(nullable = false)
    private String PositionCode;
    @Column(nullable = false)
    private String PositionName;
    private String Description;
}
