import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.StackPane;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Circle;
import javafx.stage.FileChooser;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import java.io.File;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Register");

        TextField textnick = new TextField();
        textnick.setPromptText("Nickname");
        textnick.setMaxWidth(200);

        TextField textfull = new TextField();
        textfull.setPromptText("Fullname");
        textfull.setMaxWidth(200);

        Button butUp = new Button("Upload Profile Image");
        Button butSub = new Button("Submit");

        ImageView profil = new ImageView();
        profil.setFitWidth(100);
        profil.setFitHeight(100);
        profil.setPreserveRatio(false);

        Circle bundar = new Circle(50, 50, 50);
        profil.setClip(bundar);

        final String[] pathFoto = {null};

        butUp.setOnAction(e -> {
            FileChooser pilihfoto = new FileChooser();
            pilihfoto.setTitle("Select profile image");

            // Tambahkan baris ini untuk mengatur direktori awal ke Downloads
            String userHome = System.getProperty("user.home");
            pilihfoto.setInitialDirectory(new File(userHome, "Downloads"));

            FileChooser.ExtensionFilter imageFilter =
                    new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg");
            pilihfoto.getExtensionFilters().add(imageFilter);

            File ambilfoto = pilihfoto.showOpenDialog(primaryStage);
            if (ambilfoto != null) {
                Image profilimage = new Image(ambilfoto.toURI().toString());
                profil.setImage(profilimage);
                pathFoto[0] = ambilfoto.toURI().toString();
            }
        });

        butSub.setOnAction(e -> {
            if (textnick.getText().isEmpty() || textfull.getText().isEmpty()) {
                Alert peringatan = new Alert(Alert.AlertType.WARNING);
                peringatan.setTitle("PERINGATAN");
                peringatan.setHeaderText(null);
                peringatan.setContentText("WOEEE NDA BOLEH KOSOOOONG!!");
                peringatan.showAndWait();
            } else {
                User user = new User(textnick.getText(), textfull.getText(), pathFoto[0]);
                Home home = new Home();
                primaryStage.setTitle("Home");
                home.show(primaryStage, user);
            }
        });

        VBox root1 = new VBox(20);
        Scene scene = new Scene(root1, 400, 500);
        root1.setAlignment(Pos.CENTER);
        root1.setPadding(new Insets(50));
        root1.getChildren().addAll(textnick, textfull, butUp, profil, butSub);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public class Home {
        public void show(Stage primaryStage, User user) {
            Label nicklab = new Label(user.getNickname());
            Label fulllab = new Label(user.getFullname());
            Button butadd = new Button("Add Photo");

            ImageView profil = new ImageView(new Image(user.getImage()));
            profil.setFitWidth(100);
            profil.setFitHeight(100);
            profil.setPreserveRatio(false);
            Circle bundar = new Circle(50, 50, 50);
            profil.setClip(bundar);

            VBox inprof = new VBox(10, nicklab, fulllab);
            HBox layout = new HBox(20, profil, inprof, butadd);
            layout.setPadding(new Insets(20));

            // IG STYLE POST LAYOUT
            TilePane postlay = new TilePane();
            postlay.setPadding(new Insets(20));
            postlay.setHgap(10);
            postlay.setVgap(10);
            postlay.setPrefColumns(3);

            for (Post p : user.getPosts()) {
                ImageView postimage = new ImageView(new Image(p.getPostImage()));
                postimage.setFitWidth(120);
                postimage.setFitHeight(120);
                postimage.setPreserveRatio(false);

                VBox singlePost = new VBox(postimage);
                singlePost.setAlignment(Pos.CENTER);
                postlay.getChildren().add(singlePost);

                postimage.setOnMouseClicked(e -> {
                    Preview preview = new Preview();
                    preview.show(primaryStage, user, p);
                });
            }

            VBox layout1 = new VBox(20, layout, postlay);
            Scene scene1 = new Scene(layout1, 450, 650);
            primaryStage.setScene(scene1);

            butadd.setOnAction(e -> {
                AddPost add = new AddPost();
                add.show(primaryStage, user);
            });
        }
    }

    public class AddPost {
        public void show(Stage primaryStage, User user) {
            Button uploadButton = new Button("Upload Post");

            TextArea captionTextArea = new TextArea();
            captionTextArea.setPromptText("Add caption");
            captionTextArea.setPrefHeight(200);
            captionTextArea.setPrefWidth(200);

            ImageView postImageView = new ImageView();
            postImageView.setFitWidth(200);
            postImageView.setFitHeight(200);
            postImageView.setPreserveRatio(false);
            postImageView.setStyle("-fx-border-color: lightgray; -fx-border-width: 1;"); // Optional: visual cue

            Label imagePlaceholder = new Label("Click to select image");
            StackPane imageContainer = new StackPane(postImageView, imagePlaceholder);
            imageContainer.setPrefSize(200, 200);
            postImageView.imageProperty().addListener((obs, oldImage, newImage) -> {
                imagePlaceholder.setVisible(newImage == null);
            });

            final String[] pathFoto = {null};

            imageContainer.setOnMouseClicked(event -> {
                FileChooser fileChooser = new FileChooser();
                fileChooser.setTitle("Select Post Image");
                FileChooser.ExtensionFilter imageFilter = new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg");
                // Tambahkan baris ini untuk mengatur direktori awal ke Downloads
                String userHome = System.getProperty("user.home");
                fileChooser.setInitialDirectory(new File(userHome, "Downloads"));

                fileChooser.getExtensionFilters().add(imageFilter);

                File selectedFile = fileChooser.showOpenDialog(primaryStage);
                if (selectedFile != null) {
                    Image image = new Image(selectedFile.toURI().toString());
                    postImageView.setImage(image);
                    pathFoto[0] = selectedFile.toURI().toString();
                    imagePlaceholder.setVisible(false); 
                }
            });

            uploadButton.setOnAction(e -> {
                String captionText = captionTextArea.getText().trim();
                if (pathFoto[0] != null && !captionText.isEmpty()) {
                    // Corrected constructor arguments: caption first, then image path
                    Post postBaru = new Post(captionText, pathFoto[0]);
                    user.addPost(postBaru);
                    Home home = new Home();
                    home.show(primaryStage, user);
                } else {
                    Alert peringatan = new Alert(Alert.AlertType.WARNING);
                    peringatan.setTitle("Peringatan");
                    peringatan.setHeaderText(null);
                    if (pathFoto[0] == null) {
                        peringatan.setContentText("Silakan pilih gambar untuk diunggah.");
                    } else { // captionText is empty
                        peringatan.setContentText("Caption tidak boleh kosong.");
                    }
                    peringatan.showAndWait();
                }
            });
            HBox contentBox = new HBox(10, imageContainer, captionTextArea);
            VBox layout = new VBox(20, contentBox, uploadButton);
            layout.setAlignment(Pos.CENTER);
            layout.setPadding(new Insets(10));

            Scene scene2 = new Scene(layout, 450, 500);
            primaryStage.setScene(scene2);
        }
    }

    public class Preview {
        public void show(Stage primaryStage, User user, Post postData) {
            ImageView fullPost = new ImageView(new Image(postData.getPostImage()));
            fullPost.setFitWidth(300);
            fullPost.setFitHeight(300);
            fullPost.setPreserveRatio(false);

            Label caption = new Label(postData.getCaption());
            Button back = new Button("Back");

            VBox layout = new VBox(20, fullPost, caption, back);
            layout.setAlignment(Pos.CENTER);
            layout.setPadding(new Insets(20));

            Scene scene3 = new Scene(layout, 450, 500);
            primaryStage.setScene(scene3);

            back.setOnAction(e -> {
                Home home = new Home();
                home.show(primaryStage, user);
            });
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
