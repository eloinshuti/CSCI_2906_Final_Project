import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.ScrollPane;
import javafx.stage.Stage;

public class MyResumeApp extends Application {
    private TextField firstNameTextField;
    private TextField lastNameTextField;
    private TextField addressTextField;
    private TextField cityTextField;
    private TextField stateTextField;
    private TextField zipCodeTextField;
    private TextField phoneTextField;
    private TextField emailTextField;
    private TextArea skillsTextArea;
    private TextArea experienceTextArea;
    private TextArea educationTextArea;
    private TextArea otherTextArea;
    private ScrollPane scrolltext;
    @Override
    public void start(Stage primaryStage) {

        // Create tabs
        TabPane tabPane = new TabPane();
        Tab resumeTab = new Tab("Resume");
        Tab coverLetterTab = new Tab("Cover Letter");
        Tab detailsTab = new Tab("Details");

        // Resume tab
        // Create grid pane for Resume tab
        GridPane resumeGridPane = new GridPane();
        resumeGridPane.setHgap(10);
        resumeGridPane.setVgap(10);
        resumeGridPane.setPadding(new Insets(20, 20, 20, 20));

        // Add labels and text fields to Resume tab
        firstNameTextField = new TextField();
        firstNameTextField.setPromptText("First Name");
        resumeGridPane.add(firstNameTextField, 0, 0);

        lastNameTextField = new TextField();
        lastNameTextField.setPromptText("Last Name");
        resumeGridPane.add(lastNameTextField, 1, 0);

        addressTextField = new TextField();
        addressTextField.setPromptText("Address");
        resumeGridPane.add(addressTextField, 0, 1, 2, 1);

        cityTextField = new TextField();
        cityTextField.setPromptText("City");
        resumeGridPane.add(cityTextField, 0, 2);

        //resumeGridPane.add(new Label("State:"), 2, 2);
        stateTextField = new TextField();
        stateTextField.setPromptText("State");
        resumeGridPane.add(stateTextField, 1, 2);

        //resumeGridPane.add(new Label("Zip Code:"), , 2);
        zipCodeTextField = new TextField();
        zipCodeTextField.setPromptText("Zip Code");
        resumeGridPane.add(zipCodeTextField, 2, 2);

        //resumeGridPane.add(new Label("Phone:"), 0, 3);
        phoneTextField = new TextField();
        phoneTextField.setPromptText("Phone");
        resumeGridPane.add(phoneTextField, 0, 3);

        //resumeGridPane.add(new Label("Email:"), 2, 3);
        emailTextField = new TextField();
        emailTextField.setPromptText("Email");
        resumeGridPane.add(emailTextField, 0, 4);
       /////////////////////////////////////////////////////////////////
        resumeGridPane.add(new Label("SKILLS"), 0, 5);
        skillsTextArea = new TextArea();
        skillsTextArea.setPrefHeight(200);
        resumeGridPane.add(skillsTextArea, 0, 6, 5, 1);
        // Add buttons to Resume tab
        Button seeDetails1Button = new Button("See Details");
        resumeGridPane.add(seeDetails1Button, 5, 6);
        resumeGridPane.setHalignment(seeDetails1Button, HPos.RIGHT);
       
        resumeGridPane.add(new Label("EXPERIENCE"), 0, 7);
        experienceTextArea = new TextArea();
        experienceTextArea.setPrefHeight(200);
        String experiencePrompt = "Company Name,  Location - Job Title\r"
        		+ "MONTH 20XX - MONTH 20XX/ PRESENT\r"
        		+ "\tDescription of experience.";
        experiencePrompt.setStyle(-fx-text-fill:white);
        experienceTextArea.setPromptText("Company Name,  Location - Job Title\r"
        		+ "MONTH 20XX - MONTH 20XX/ PRESENT\r"
        		+ "\tDescription of experience.");
        resumeGridPane.add(experienceTextArea, 0, 8, 5, 1);
        // Add buttons to Resume tab
        Button seeDetails2Button = new Button("See Details");
        resumeGridPane.add(seeDetails2Button, 5, 8);
        resumeGridPane.setHalignment(seeDetails2Button, HPos.RIGHT);
       
        resumeGridPane.add(new Label("EDUCATION"), 0, 9);
        educationTextArea = new TextArea();
        educationTextArea.setPrefHeight(200);
        educationTextArea.setPromptText("School Name, Location - Degree\r"
        		+ "MONTH 20XX - MONTH 20XX\r"
        		+ "\tDescription of education.");
        resumeGridPane.add(educationTextArea, 0, 10, 5, 1);
        // Add buttons to Resume tab
        Button seeDetails3Button = new Button("See Details");
        resumeGridPane.add(seeDetails3Button, 5, 10);
        resumeGridPane.setHalignment(seeDetails3Button, HPos.RIGHT);

        resumeGridPane.add(new Label("AWARDS/ PROJECTS/ EXTRACURRICULAR"), 0, 11);       ///ADD RADIO BUTTON TO CHOOSE ONE OF THE TITLES
        otherTextArea = new TextArea();
        otherTextArea.setPrefHeight(200);
        resumeGridPane.add(otherTextArea, 0, 12, 5, 1);
        
        // Add buttons to Resume tab
        Button seeDetails4Button = new Button("See Details");
        resumeGridPane.add(seeDetails4Button, 5, 12);
        resumeGridPane.setHalignment(seeDetails4Button, HPos.RIGHT);
        
        // Add grid pane to Resume tab
    
        resumeTab.setContent(resumeGridPane);

        // Cover Letter tab
        VBox coverLetterContent = new VBox();
        coverLetterContent.setPadding(new Insets(10));
        coverLetterContent.setSpacing(10);
        TextField recipientField = new TextField();
        recipientField.setPromptText("Recipient");
        TextField subjectField = new TextField();
        subjectField.setPromptText("Subject");
        TextArea coverLetterTextArea = new TextArea();
        coverLetterTextArea.setPromptText("Write your cover letter here");
        coverLetterTextArea.setPrefRowCount(10);
        Button upload2Button = new Button("Upload");
        coverLetterContent.getChildren().addAll(recipientField, subjectField, coverLetterTextArea,upload2Button);
        coverLetterTab.setContent(coverLetterContent);

        // Details tab
        VBox detailsContent = new VBox();
        detailsContent.setPadding(new Insets(10));
        detailsContent.setSpacing(10);
        TextField thinTextField = new TextField();
        thinTextField.setPromptText("Title Text Field");
        TextArea largeTextArea = new TextArea();
        largeTextArea.setPromptText("Description Text Field");
        largeTextArea.setPrefRowCount(10);
        Button uploadButton = new Button("Upload");

        detailsContent.getChildren().addAll(thinTextField, largeTextArea, uploadButton);
        detailsTab.setContent(detailsContent);

        // Add tabs to tab pane
        tabPane.getTabs().addAll(resumeTab, coverLetterTab, detailsTab);

        // Create scene and show stage
        Scene scene = new Scene(tabPane, 750, 1000);
        primaryStage.setScene(scene);
        primaryStage.setTitle("My Resume App");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}