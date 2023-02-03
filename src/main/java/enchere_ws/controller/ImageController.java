package enchere_ws.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.sql.SQLException;

@RestController
@CrossOrigin("*")

public class ImageController {

  /*  @PostMapping("/add")
    public ResponseEntity<String> addImage(@RequestParam("image") MultipartFile image,
                                           @RequestParam("imageUrl") String imageUrl) {
        try {
            // Enregistrer les données binaires de l'image dans la table
            byte[] imageData = image.getBytes();
            saveImageData(imageData);
            // Enregistrer l'URL de l'image dans la table
            saveImageUrl(imageUrl);

            return ResponseEntity.ok().body("Image added successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error adding image");
        }
    }

    private void saveImageData(byte[] imageData) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement("INSERT INTO images (image_data) VALUES (?)")) {
            statement.setBytes(1, imageData);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void saveImageUrl(String imageUrl) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement("UPDATE images SET image_url = ? WHERE id = ?")) {
            statement.setString(1, imageUrl);
            statement.setLong(2, getLastInsertedImageId());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private long getLastInsertedImageId() {
        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT MAX(id) FROM images")) {
            if (resultSet.next()) {
                return resultSet.getLong(1);
            }
            throw new RuntimeException("Error retrieving last inserted image id");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}*/
}
