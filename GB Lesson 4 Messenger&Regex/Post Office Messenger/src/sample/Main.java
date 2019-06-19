package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Main extends Application {

    private static Pattern pattern;
    private static Matcher matcher;
    private static int passWordLength = 8;

    @Override
    public void start(Stage primaryStage) throws Exception {


        primaryStage.setTitle("Welcome to registration form");
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.TOP_LEFT);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Text scenetitle = new Text("Welcome to Chat 'Post Office'");

        scenetitle.setId("welcome-text");
        grid.add(scenetitle, 0, 0, 2, 1);

        Label userName = new Label("User Name:");
        grid.add(userName, 0, 1);

        TextField userTextField = new TextField();
        grid.add(userTextField, 1, 1); // Поле для текста (была 1 строка)

        Label pw = new Label("Create Password:");
        grid.add(pw, 0, 2);

        PasswordField pwBox = new PasswordField();
        grid.add(pwBox, 1, 2);

        Button btn = new Button("Sign in");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(btn);
        grid.add(hbBtn, 1, 4);

        final Text actiontarget = new Text();
        grid.add(actiontarget, 1, 6);

        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {

                String s = pwBox.getText();
                // проверяем требование по количеству символов в пароле
                if (s.length() < passWordLength) {

                    actiontarget.setId("actiontarget");
                    actiontarget.setText("#1 Пароль должен быть не менее 8 символов");
                } else {
                    // проверяем наличие "маленьких" латинских букв.
                    pattern = Pattern.compile("[a-z]");
                    matcher = pattern.matcher(s);
                    if (!matcher.find()) {
                        actiontarget.setId("actiontarget");
                        actiontarget.setText("#2 Пароль должен содержать латинские буквы нижнего регистра");
                    } else {
                        // проверяем наличие "больших" латинских букв.
                        pattern = Pattern.compile("[A-Z]");
                        matcher = pattern.matcher(s);

                        if (!matcher.find()) {
                            actiontarget.setId("actiontarget");
                            actiontarget.setText("#3 Пароль должен содержать латинские буквы верхнего регистра");
                        } else {
                            // проверяем наличие цифр.
                            pattern = Pattern.compile("\\d");  //("[0-9]");
                            matcher = pattern.matcher(s);

                            if (!matcher.find()) {
                                actiontarget.setId("actiontarget");
                                actiontarget.setText("#4 Пароль должен содержать цифры");

                            } else {
                                // проверяем наличие спец.символов.
                                pattern = Pattern.compile("\\W");  //("[@#$%^&*~]")
                                matcher = pattern.matcher(s);

                                if (!matcher.find()) {
                                    actiontarget.setId("actiontarget");
                                    actiontarget.setText("#5 Пароль должен содержать спец.символы");

                                } else {
                                    actiontarget.setId("actiontarget");
                                    actiontarget.setText("Good Password!");

                                }
                            }
                        }
                    }
                }
            }
        });


        Scene scene = new Scene(grid, 700, 500);
        primaryStage.setScene(scene);
        scene.getStylesheets().

                add(Main.class.getResource("Mess.css").

                        toExternalForm());
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}