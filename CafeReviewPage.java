// I worked on this homework myself using only the course material.

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Label;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Alert;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.scene.effect.DropShadow;

/**
 * This class represent CafeReviewPage class.
 * People can write review for Cafe 1331
 * @author tnguyen624@gatech.edu
 * @version 1.3.3.1
 */
public class CafeReviewPage extends Application {
    private Button submitButton;
    private TextField textFieldName;
    private TextField textFieldColor;
    private TextArea textAreaReview;
    private String message = "";

    @Override
    public void start(Stage primaryStage) {
        // Create title for the Stage Window
        primaryStage.setTitle("Cafe1331 Reviews");

        // Create a Title Text
        Text text1 = new Text(10, 40, "Customer Review");
        text1.setFont(Font.font("Arial", FontWeight.BOLD, 25));

        // Create a Border Pane
        BorderPane borderPane = new BorderPane();

        // Set the Border Pane size;
        borderPane.setPrefSize(510, 650);

        // Add Text 1 to the border pane top
        borderPane.setTop(text1);
        borderPane.setMargin(text1, new Insets(15, 15, 5, 15));

        // Set the text to center of the border pane
        borderPane.setAlignment(text1, Pos.CENTER);

        // Set the V-Box into the border Pane Bottom
        VBox vBoxBottom = getVBox();

        // Create an H-Box at the bottom
        HBox hBoxBottom = getHBox();

        // Consider creating a method that add all the UI to hBoxBottom and VBoxBottom
        vBoxBottom.getChildren().add(hBoxBottom);

        // Set the VBox to the bottom of the border pane
        borderPane.setBottom(vBoxBottom);

        // Create a VBox ChatBox
        VBox chatBox = new VBox(8);
        chatBox.setStyle("-fx-font-size: 14");
        chatBox.setPrefWidth(450);
        chatBox.setMaxWidth(520);
        chatBox.setAlignment(Pos.TOP_LEFT);

        // Create a Scroll Pane
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(chatBox);
        scrollPane.setMinViewportHeight(250);
        scrollPane.setMinViewportWidth(350);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);

        // Create margin for the borderPane Center
        borderPane.setCenter(scrollPane);
        borderPane.setMargin(scrollPane, new Insets(10, 15, 0, 15));
        //borderPane.setPadding(new Insets(5,5,5,5));

        // Message
        message(chatBox);

        // Create a Scene
        Scene scene = new Scene(borderPane);
        primaryStage.setScene(scene);
        primaryStage.setResizable(true);
        primaryStage.sizeToScene();
        primaryStage.show();
    }

    // Create a V-Box

    /**
     * This instance method create a VBox to hold chat box.
     * Include Label, TextField, and Text Area
     * @return vBox
     */
    private VBox getVBox() {
        String[] cs1331TA = {"Iced Caramel Cloud Macchiato", "Green Tea Latte",
                             "Cold Brew", "Pink Drink", "Salted Caramel Mocha",
                             "White Chocolate Mocha", "Pumpkin Spice Latte", "Iced coffee",
                             "Strawberry Frappuccino", "Nitro Cold Brew",
                             "Cappuccino", "Caffè Americano", "Flat White", "Iced Coconutmilk Latte",
                             "Iced Green Tea", "Caffè Latte"};
        // Create a VBox
        VBox vBox = new VBox(3);
        vBox.setPadding(new Insets(15, 5, 5, 5));

        // Create TA Label
        Label labelTA = new Label("Choose your drink");
        labelTA.setFont(Font.font("Arial", FontWeight.BOLD, 18));
        //Label labelVote = new Label("(Your response will be anonymous)");
        //labelVote.setFont(Font.font("Arial",FontWeight.LIGHT,12));

        // Create a Combo Box
        ComboBox<String> comboTA = new ComboBox<>();
        comboTA.setPrefWidth(220);
        ObservableList<String> items = FXCollections.observableArrayList(cs1331TA);
        comboTA.getItems().addAll(items);
        comboTA.setValue("Iced Caramel Cloud Macchiato");

        // Create a Label
        Label labelName = new Label("Choose your name");
        labelName.setFont(Font.font("Arial", FontWeight.BOLD, 18));

        // Creating a textField for Name
        this.textFieldName = new TextField();
        textFieldName.setEditable(true);
        textFieldName.setStyle("-fx-text-fill: black");
        textFieldName.setFont(Font.font("Times", 13));
        textFieldName.setAlignment(Pos.BOTTOM_LEFT);
        textFieldName.setPromptText("Enter your name");

        // Create a Label Color
        Label labelColor = new Label("Choose your color");
        labelColor.setFont(Font.font("Arial", FontWeight.BOLD, 18));

        // Creating a textField for Color
        textFieldColor = new TextField();
        textFieldColor.setEditable(true);
        textFieldColor.setStyle("-fx-text-fill: black");
        textFieldColor.setFont(Font.font("Times", 13));
        textFieldColor.setAlignment(Pos.BOTTOM_LEFT);
        textFieldColor.setPromptText("Enter your favorite color");

        // Create a Label Review
        Label labelReview = new Label("Write your review");
        labelReview.setFont(Font.font("Arial", FontWeight.BOLD, 18));

        // Creating a textArea for Review
        textAreaReview = new TextArea();
        textAreaReview.setEditable(true);
        textAreaReview.setStyle("-fx-text-fill: black");
        textAreaReview.setFont(Font.font("Times", 13));
        textAreaReview.setPrefHeight(75);
        textAreaReview.setPrefWidth(150);
        textAreaReview.setWrapText(true);
        textAreaReview.setPromptText("What did you like or dislike? What do you want us to improve? ");

        // Setting margins to the nodes
        vBox.setMargin(labelTA, new Insets(0, 15, 0, 15));
        //vBox.setMargin(labelVote, new Insets(0, 15, 0, 15));
        vBox.setMargin(comboTA, new Insets(5, 15, 5, 15));
        vBox.setMargin(labelName, new Insets(5, 15, 0, 15));
        vBox.setMargin(textFieldName, new Insets(5, 15, 0, 15));
        vBox.setMargin(labelColor, new Insets(5, 15, 0, 15));
        vBox.setMargin(textFieldColor, new Insets(5, 15, 0, 15));
        vBox.setMargin(labelReview, new Insets(5, 15, 0, 15));
        vBox.setMargin(textAreaReview, new Insets(5, 15, 0, 15));

        vBox.getChildren().addAll(labelTA, comboTA, labelName, textFieldName,
                labelColor, textFieldColor, labelReview, textAreaReview);
        return vBox;
    }

    /**
     * This instance method returns an HBox
     * Include Button within the hBox
     * @return hBox
     */
    private HBox getHBox() {
        // Create a HBox
        HBox hBox = new HBox();
        // Create submit Button
        submitButton = new Button("Submit");
        submitButton.setStyle("-fx-background-color: linear-gradient(#FF9900, #FACC2E); "
                + "-fx-border-width: 1px; -fx-font-size: 13.5; "
                + "-fx-background-radius: 100; -fx-background-insets: -5; -fx-text-fill: black");

        DropShadow dropShadow = new DropShadow();
        dropShadow.setRadius(5.0);
        dropShadow.setOffsetX(3.0);
        dropShadow.setOffsetY(3.0);
        dropShadow.setColor(Color.color(0.4, 0.5, 0.5));

        submitButton.setOnMouseEntered(e -> {
            submitButton.setStyle("-fx-background-color: linear-gradient(#FF9900, #FACC2E);"
                    + "-fx-border-width: 1px; -fx-font-size: 13.5;"
                    + "-fx-background-radius: 100; -fx-background-insets: -5; -fx-text-fill: black");
            // background-color: white;
            submitButton.setEffect(dropShadow);
        });

        submitButton.setOnMouseExited(e -> {
            submitButton.setStyle("-fx-background-color: linear-gradient(#FACC2E, #FF9900);"
                    + "-fx-border-width: 1px; -fx-font-size: 13.5;"
                    + "-fx-background-radius: 100; -fx-background-insets: -5; -fx-text-fill: black");
        });

        submitButton.setOnMousePressed(e -> {
            submitButton.setStyle("-fx-background-color: linear-gradient(#FACC2E, #FF9900);"
                    + "-fx-background-radius: 150; -fx-background-insets: -5; -fx-text-fill: black");
        });

        hBox.setMargin(submitButton, new Insets(10, 15, 10, 10));

        hBox.getChildren().add(submitButton);
        hBox.setAlignment(Pos.BOTTOM_RIGHT);

        return hBox;
    }

    /**
     * This instance method shows the button's action.
     * Get the text from ReviewArea, ColorArea, NameArea
     * and produce the message on the vBox
     * @param chatBox - a vBox
     */
    private void message(VBox chatBox) {
        submitButton.setOnAction(e -> {
            String name;
            String color;
            Color colorObject = Color.BLACK;
            if (textAreaReview.getText().length() > 0) {
                if (textFieldName.getText() == null || textFieldName.getText().length() == 0) {
                    name = "Anonymous";
                } else {
                    name = textFieldName.getText();
                }

                if (textFieldColor.getText() == null || textFieldColor.getText().length() == 0) {
                    color = "black";
                } else {
                    color = textFieldColor.getText().toLowerCase();
                }
                //System.out.println(color);
                try {
                    colorObject = Color.valueOf(color);
                } catch (NullPointerException ex) {
                    System.out.println("Null Pointer Exception");
                } catch (IllegalArgumentException ex) {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Warning Dialog");
                    alert.setHeaderText("An error has occurred");
                    alert.setContentText("Oooops! The color " + color + " does not exist!");
                    alert.showAndWait();
                }
                message = name + ":\n" + textAreaReview.getText() + "\n";
                System.out.println(message);
                Label result = new Label(message);
                result.setPrefWidth(520);
                result.setWrapText(true);
                result.setTextAlignment(TextAlignment.JUSTIFY);
                result.setTextFill(colorObject);
                chatBox.getChildren().add(result);
                chatBox.setMargin(result, new Insets(5, 5, 5, 10));
                textAreaReview.setText("");
                textFieldName.setText("");
                textFieldColor.setText("");
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Dialog");
                alert.setHeaderText("Warning");
                alert.setContentText("Please enter a review !");
                alert.showAndWait();
            }
        });
    }

    /**
     * This static main method is used to test the program.
     * @param args - String arrays
     */
    public static void main(String[] args) {
        launch(args);
    }
}

