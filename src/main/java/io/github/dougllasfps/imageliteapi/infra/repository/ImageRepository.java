package io.github.dougllasfps.imageliteapi.infra.repository;

import io.github.dougllasfps.imageliteapi.domain.enums.ImageExtension;
import io.github.dougllasfps.imageliteapi.infra.repository.specs.GenericSpecs;
import io.github.dougllasfps.imageliteapi.infra.repository.specs.ImageSpecs;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import io.github.dougllasfps.imageliteapi.domain.entity.Image;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.util.StringUtils;

import java.util.List;

import static io.github.dougllasfps.imageliteapi.infra.repository.specs.GenericSpecs.conjunction;
import static org.springframework.data.jpa.domain.Specification.anyOf;
import static org.springframework.data.jpa.domain.Specification.where;

public interface ImageRepository extends JpaRepository<Image, String>, JpaSpecificationExecutor<Image> {

    default List<Image> findByExtensionAndNameOrTagsLike(ImageExtension extension, String query) {
        Specification<Image> spec =  where(conjunction());

        if(extension != null){
            // ADD EXTENSION EQUAL
            spec = spec.and(ImageSpecs.extensionEquall(extension));
        }

        if(StringUtils.hasText(query)){

            spec = spec.and(anyOf(ImageSpecs.nameLike(query), ImageSpecs.tagsLike(query)));
        }

        return findAll(spec);

    }
}