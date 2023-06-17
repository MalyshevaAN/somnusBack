package image.example.nastia.Service;


import image.example.nastia.model.ProductImage;
import image.example.nastia.repo.ProductImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Optional;

@Service
public class ProductImageService {

    @Autowired
    ProductImageRepository repo;

    private final String PATH = "/home/nastia/images/";

    public ProductImage uploadImage(MultipartFile file) throws IOException {
        String fullPath = PATH + file.getOriginalFilename();
        ProductImage pImage = new ProductImage();
        pImage.setName(file.getOriginalFilename());
        pImage.setType(file.getContentType());
        pImage.setImagePath(fullPath);

        file.transferTo(new File(fullPath));
        return repo.save(pImage);
    }

    public byte[] downloadImage(String fileName) throws IOException {
        Optional<ProductImage> image = repo.findByName(fileName);
        String fullPath = image.get().getImagePath();
        return Files.readAllBytes(new File(fullPath).toPath());
    }
}
