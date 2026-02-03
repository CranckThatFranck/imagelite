package io.github.dougllasfps.imageliteapi.infra.repository.specs;

import io.github.dougllasfps.imageliteapi.domain.entity.Image;
import io.github.dougllasfps.imageliteapi.domain.enums.ImageExtension;
import org.springframework.data.jpa.domain.Specification;

public class ImageSpecs {

    private ImageSpecs(){

    }

    public static Specification<Image> extensionEquall(ImageExtension extension){
        return (root, query, cb) -> cb.equal(root.get("extension"), extension);
    }

    public static Specification<Image> nameLike(String name){
        return (root, query, cb) -> cb.like(
                cb.upper(root.get("name").as(String.class)),
                "%" + name.toUpperCase() + "%"
        );
    }

    public static Specification<Image> tagsLike(String tags){
        return (root, query, cb) -> cb.like(
                cb.upper(root.get("tags").as(String.class)),
                "%" + tags.toUpperCase() + "%"
        );
    }
}
