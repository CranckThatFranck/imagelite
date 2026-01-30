package io.github.dougllasfps.imageliteapi.infra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import io.github.dougllasfps.imageliteapi.domain.entity.Image;

public interface ImageRepository extends JpaRepository<Image, String> {
}