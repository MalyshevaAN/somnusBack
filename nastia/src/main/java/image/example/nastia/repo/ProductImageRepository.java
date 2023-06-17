package image.example.nastia.repo;

import image.example.nastia.model.ProductImage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductImageRepository extends JpaRepository<ProductImage, Long> {

    Optional<ProductImage> findByName (String fileName);

}
