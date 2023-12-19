package com.example.cukcukspring.repositories;

import com.example.cukcukspring.models.Position;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PositionRepository extends JpaRepository<Position, UUID> {
}
