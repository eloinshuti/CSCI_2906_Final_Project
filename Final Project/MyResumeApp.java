package application;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox; 
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
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
    private TextField cfirstNameTextField;
    private TextField clastNameTextField;
    private TextField ccityTextField;
    private TextField cstateTextField;
    private TextField czipCodeTextField;
    private TextField cphoneTextField;
    private TextField cemailTextField;
    private TabPane tabPane;
    private TextArea skillsLargeTextArea;
    private TextArea ExperienceLargeTextArea;
    private TextArea EducationLargeTextArea;
    private TextArea APELargeTextArea;
    DataOutputStream toServer = null;
    DataInputStream fromServer = null;
    DataOutputStream toServer2 = null;
    DataInputStream fromServer2 = null;
    
    private static final int PORT = 2440;
    
    @Override
    public void start(Stage primaryStage) {
    	System.out.println("Starting application...");
        // Create tabs
        tabPane = new TabPane();
        Tab resumeTab = new Tab("Resume");
        resumeTab.setClosable(false);
        Tab coverLetterTab = new Tab("Cover Letter");
        coverLetterTab.setClosable(false);
        Tab skillsTab = new Tab("Skills");
        skillsTab.setClosable(false);
        Tab experienceTab = new Tab("Experience");
        experienceTab.setClosable(false);
        Tab educationTab = new Tab("Education");
        educationTab.setClosable(false);
        Tab APETab = new Tab("Awards/Projects/Extracurricular");
        APETab.setClosable(false);
        Tab introTab = new Tab("CARP");
        introTab.setClosable(false);
        
        VBox introBox = new VBox(10);
        introBox.setPadding(new Insets(10,10,10,10));
        
        Label titleLabel = new Label("Comprehensive Alternate\r\tResume Profile\r\t       (CARP)");
        titleLabel.setFont(Font.font("System", FontWeight.BOLD, 30));
        titleLabel.setTextFill(Color.BLUE);
        
        Button btBegin = new Button("Begin");
        btBegin.setPrefWidth(100);
        btBegin.setPrefHeight(50);
        Button btSubmit = new Button("Submit");
        btSubmit.setPrefWidth(100);
        btSubmit.setPrefHeight(50);
        
        introBox.getChildren().addAll(titleLabel, btBegin, btSubmit);
        introBox.setAlignment(Pos.TOP_CENTER);
        introTab.setContent(introBox);
        tabPane.getTabs().addAll(introTab);
        //Tab detailsTab = new Tab("Details");

        // Resume tab
        // Create grid pane for Resume tab
        GridPane resumeGridPane = new GridPane();
        resumeGridPane.setHgap(5);
        resumeGridPane.setVgap(0);
        resumeGridPane.setPadding(new Insets(10, 10, 10, 10));

        // Add labels and text fields to Resume tab
        firstNameTextField = new TextField();
        firstNameTextField.setPromptText("First Name");

        lastNameTextField = new TextField();
        lastNameTextField.setPromptText("Last Name");
        
        HBox namesTextField = new HBox();
        namesTextField.getChildren().addAll(firstNameTextField, lastNameTextField);
        
        addressTextField = new TextField();
        addressTextField.setPromptText("Address (123 Your Street)");

        HBox locationTextField = new HBox();
        
        cityTextField = new TextField();
        cityTextField.setPromptText("City");

        stateTextField = new TextField();
        stateTextField.setPromptText("State");

        zipCodeTextField = new TextField();
        zipCodeTextField.setPromptText("Zip Code");
        
        locationTextField.getChildren().addAll(cityTextField, stateTextField, zipCodeTextField);
 
        phoneTextField = new TextField();
        phoneTextField.setPromptText("Phone");

        emailTextField = new TextField();
        emailTextField.setPromptText("Email");

        
        VBox personalDetails = new VBox();
        personalDetails.setPadding(new Insets(0, 350, 0, 0));
        personalDetails.getChildren().addAll(namesTextField, addressTextField, locationTextField, phoneTextField, emailTextField);
        resumeGridPane.add(personalDetails, 0, 1,5,1);
        
        resumeGridPane.add(new Label("SKILLS"), 0, 5);
        skillsTextArea = new TextArea();
        skillsTextArea.setPrefHeight(200);
        skillsTextArea.setWrapText(true);
        skillsTextArea.setPromptText("- Skill\r- Skill\r- Skill");
        
        resumeGridPane.add(skillsTextArea, 0, 6, 5, 1);
        // Add buttons to Resume tab
        Button seeDetails1Button = new Button("Enter Details");
        //seeDetails1Button.setOnAction(e -> openTab("SKILLS"));
        resumeGridPane.add(seeDetails1Button, 5, 6);
        resumeGridPane.setHalignment(seeDetails1Button, HPos.RIGHT);
       
        resumeGridPane.add(new Label("EXPERIENCE"), 0, 7);
        experienceTextArea = new TextArea();
        experienceTextArea.setPrefHeight(200);
        experienceTextArea.setWrapText(true);

        //experiencePrompt.setStyle(-fx-text-fill:white);
        experienceTextArea.setPromptText("Company Name, Location - Job Title\r"
        		+ "MONTH 20XX - MONTH 20XX/ PRESENT\r"
        		+ "\t- Description of experience.\r"
        		+ "\t- Description of experience.");
        resumeGridPane.add(experienceTextArea, 0, 8, 5, 1);
        // Add buttons to Resume tab
        Button seeDetails2Button = new Button("Enter Details");
        //seeDetails2Button.setOnAction(e -> openTab("EXPERIENCE"));
        resumeGridPane.add(seeDetails2Button, 5, 8);
        resumeGridPane.setHalignment(seeDetails2Button, HPos.RIGHT);
       
        resumeGridPane.add(new Label("EDUCATION"), 0, 9);
        educationTextArea = new TextArea();
        educationTextArea.setPrefHeight(200);
        educationTextArea.setWrapText(true);
        educationTextArea.setPromptText("School Name, Location - Degree\r"
        		+ "MONTH 20XX - MONTH 20XX\r"
        		+ "\t- Description of education.\r"
        		+ "\t- Description of education.");
        resumeGridPane.add(educationTextArea, 0, 10, 5, 1);
        // Add buttons to Resume tab
        Button seeDetails3Button = new Button("Enter Details");
        //seeDetails3Button.setOnAction(e -> openTab("EDUCATION"));
        resumeGridPane.add(seeDetails3Button, 5, 10);
        resumeGridPane.setHalignment(seeDetails3Button, HPos.RIGHT);

        ComboBox<String> cbo = new ComboBox<>();
        cbo.getItems().addAll("AWARDS", "PROJECTS", 
          "EXTRACURRICULAR");
        cbo.setValue("AWARDS");
        
        
        resumeGridPane.add(cbo, 0, 11);       ///ADD Drop down menu TO CHOOSE ONE OF THE TITLES
        otherTextArea = new TextArea();
        otherTextArea.setPrefHeight(200);
        otherTextArea.setWrapText(true);
        resumeGridPane.add(otherTextArea, 0, 12, 5, 1);
        
        // Add buttons to Resume tab
        Button seeDetails4Button = new Button("Enter Details");
        //seeDetails4Button.setOnAction(e -> openTab(cbo.getValue()));
        resumeGridPane.add(seeDetails4Button, 5, 12);
        resumeGridPane.setHalignment(seeDetails4Button, HPos.RIGHT);
        // Add grid pane to Resume tab
    
        resumeTab.setContent(resumeGridPane);

        // Cover Letter tab
        VBox coverLetterContent = new VBox();
        coverLetterContent.setPadding(new Insets(10));
        coverLetterContent.setSpacing(10);
        HBox coverLetterAddress = new HBox();
        HBox coverLetterName = new HBox();
        VBox details = new VBox();
        
        cfirstNameTextField = new TextField();
        cfirstNameTextField.setPromptText("First Name");
        clastNameTextField = new TextField();
        clastNameTextField.setPromptText("Last Name");
        coverLetterName.getChildren().addAll(cfirstNameTextField, clastNameTextField);
        
        ccityTextField = new TextField();
        ccityTextField.setPromptText("City");
        cstateTextField = new TextField();
        cstateTextField.setPromptText("State (GA)");
        czipCodeTextField = new TextField();
        czipCodeTextField.setPromptText("Zip Code");
        cphoneTextField = new TextField();
        cphoneTextField.setPromptText("Phone");
        cemailTextField = new TextField();
        cemailTextField.setPromptText("Email");
        coverLetterAddress.getChildren().addAll(cemailTextField,cphoneTextField,ccityTextField,cstateTextField,czipCodeTextField);
        
        details.getChildren().addAll(coverLetterName, coverLetterAddress);
        
        TextField dateField = new TextField();
        dateField.setPromptText("Date (Month Day, 20XX)");
        TextField employerNameField = new TextField();
        employerNameField.setPromptText("Employer Name (Mr. John Doe)");
        TextField employerPositionField = new TextField();
        employerPositionField.setPromptText("Employer Position");
        TextField employerCompanyField = new TextField();
        employerCompanyField.setPromptText("Company/ Organization");
        TextField addressField = new TextField();
        addressField.setPromptText("Address (123 Your Street)");
        TextField phoneNumberField = new TextField();
        phoneNumberField.setPromptText("Phone");
        TextField emailField = new TextField();
        emailField.setPromptText("Email");
        //emailField.setPrefColumnCount(1);
        
        VBox employerDetails = new VBox();
        employerDetails.getChildren().addAll(employerNameField, employerPositionField, employerCompanyField, 
        		addressField, phoneNumberField, emailField);
        employerDetails.setPadding(new Insets(0, 450, 0, 0));
        
        VBox dateBox= new VBox();
        dateBox.getChildren().addAll(dateField);
        dateBox.setPadding(new Insets(0, 450, 0, 0));
        TextArea coverLetterTextArea = new TextArea();
        coverLetterTextArea.setPromptText("Dear Mr. John, \r\rWrite your cover letter here.");
        coverLetterTextArea.setPrefRowCount(100);
        coverLetterTextArea.setWrapText(true);

        coverLetterContent.getChildren().addAll(details, dateBox, employerDetails, coverLetterTextArea);
        coverLetterName.setAlignment(Pos.BOTTOM_CENTER);
        coverLetterTab.setContent(coverLetterContent);
        
        // Create scene and show stage
        Scene scene = new Scene(tabPane, 700, 650);
        primaryStage.setScene(scene);
        primaryStage.setTitle("My Resume App");
        primaryStage.show();
        
        
        skillsLargeTextArea = new TextArea();
        skillsLargeTextArea.setPrefRowCount(100);
        skillsLargeTextArea.setWrapText(true);
        skillsLargeTextArea.setPromptText("Title\r\rDescription.....");
        ExperienceLargeTextArea = new TextArea();
        ExperienceLargeTextArea.setWrapText(true);
        ExperienceLargeTextArea.setPrefRowCount(100);
        ExperienceLargeTextArea.setPromptText("Title\r\rDescription.....");
        EducationLargeTextArea = new TextArea();
        EducationLargeTextArea.setWrapText(true);
        EducationLargeTextArea.setPrefRowCount(100);
        EducationLargeTextArea.setPromptText("Title\r\rDescription.....");
    	APELargeTextArea = new TextArea();
    	APELargeTextArea.setWrapText(true);
    	APELargeTextArea.setPrefRowCount(100);
    	APELargeTextArea.setPromptText("Title\r\rDescription.....");
    	
        VBox skillsVBox = new VBox(10);
        skillsVBox.getChildren().addAll(skillsLargeTextArea);skillsVBox.setPadding(new Insets(10, 10, 10, 10));
        
        VBox experienceVBox = new VBox(10);
        experienceVBox.getChildren().addAll(ExperienceLargeTextArea);experienceVBox.setPadding(new Insets(10, 10, 10, 10));
        
        VBox educationVBox = new VBox(10);
        educationVBox.getChildren().addAll(EducationLargeTextArea);educationVBox.setPadding(new Insets(10, 10, 10, 10));
        
        VBox APEVBox = new VBox(10);
        APEVBox.getChildren().addAll(APELargeTextArea);APEVBox.setPadding(new Insets(10, 10, 10, 10));
    	
    	skillsTab.setContent(skillsVBox);
    	experienceTab.setContent(experienceVBox);
    	educationTab.setContent(educationVBox);
    	APETab.setContent(APEVBox);
    	
    	btBegin.setOnAction(e -> {
    		openTab(resumeTab);
    		openTab(coverLetterTab);
    		openTab(resumeTab);
    		
    	});
    	seeDetails1Button.setOnAction(e -> {
    		openTab(skillsTab);
    	});
    	seeDetails2Button.setOnAction(e -> {
    		openTab(experienceTab);
    	});
    	seeDetails3Button.setOnAction(e -> {
    		openTab(educationTab);
    	});
    	seeDetails4Button.setOnAction(e -> {
    		openTab(APETab);
    	});
    	
    	
        
        btSubmit.setOnAction(e -> {
        	try {
        		// Send the values to the server
        		toServer.writeUTF(firstNameTextField.getText().trim());
        		toServer.writeUTF(lastNameTextField.getText().trim());
        		toServer.writeUTF(addressTextField.getText().trim());
        		toServer.writeUTF(cityTextField.getText().trim());
        		toServer.writeUTF(stateTextField.getText().trim());
        		toServer.writeUTF(zipCodeTextField.getText().trim());
        		toServer.writeUTF(phoneTextField.getText().trim());
        		toServer.writeUTF(emailTextField.getText().trim());
        		toServer.writeUTF(skillsTextArea.getText().trim());
        		toServer.writeUTF(experienceTextArea.getText().trim());
        		toServer.writeUTF(educationTextArea.getText().trim());
        		toServer.writeUTF(cbo.getValue());
        		toServer.writeUTF(otherTextArea.getText().trim());
        		
        		toServer.writeUTF(skillsLargeTextArea.getText().trim());
        		toServer.writeUTF(ExperienceLargeTextArea.getText().trim());
        		toServer.writeUTF(EducationLargeTextArea.getText().trim());
        		toServer.writeUTF(APELargeTextArea.getText().trim());
        		
        		toServer.writeUTF(cfirstNameTextField.getText().trim());
        		toServer.writeUTF(clastNameTextField.getText().trim());
        		toServer.writeUTF(ccityTextField.getText().trim());
        		toServer.writeUTF(cstateTextField.getText().trim());
        		toServer.writeUTF(czipCodeTextField.getText().trim());
        		toServer.writeUTF(cphoneTextField.getText().trim());
        		toServer.writeUTF(cemailTextField.getText().trim());
        		toServer.writeUTF(coverLetterTextArea.getText().trim());
        		toServer.writeUTF(dateField.getText().trim());
        		toServer.writeUTF(employerNameField.getText().trim());
        		toServer.writeUTF(employerPositionField.getText().trim());
        		toServer.writeUTF(employerCompanyField.getText().trim());
        		toServer.writeUTF(addressField.getText().trim());
        		toServer.writeUTF(phoneNumberField.getText().trim());
        		toServer.writeUTF(emailField.getText().trim());
        		toServer.flush();
    			//toServer.close();
        		
        		
    			firstNameTextField.clear();
    			lastNameTextField.clear();
    			addressTextField.clear();
    			cityTextField.clear();
    			stateTextField.clear();
    			zipCodeTextField.clear();
    			phoneTextField.clear();
    			emailTextField.clear();
    			skillsTextArea.clear();
    			experienceTextArea.clear();
    			educationTextArea.clear();
    			otherTextArea.clear();
    			skillsLargeTextArea.clear();
    			ExperienceLargeTextArea.clear();
    			EducationLargeTextArea.clear();
    			APELargeTextArea.clear();
        		cfirstNameTextField.clear();
        		clastNameTextField.clear();
        		ccityTextField.clear();
        		cstateTextField.clear();
        		czipCodeTextField.clear();
        		cphoneTextField.clear();
        		cemailTextField.clear();
        		coverLetterTextArea.clear();
        		dateField.clear();
        		employerNameField.clear();
        		employerPositionField.clear();
        		employerCompanyField.clear();
        		addressField.clear();
        		phoneNumberField.clear();
        		emailField.clear();
        		}
        	catch (IOException ex) {
        		System.err.println(ex);
        		}
        	});
        
        
        try {
        	// Create a socket to connect to the server
        	Socket socket = new Socket("localhost", PORT);   	
        	fromServer = new DataInputStream(socket.getInputStream());
        	toServer = new DataOutputStream(socket.getOutputStream());
        	}
        catch (IOException ex) {
        	
        	}   
      }
    public static boolean tabExists(TabPane tabPane, Tab tabName) {
        for (Tab tab : tabPane.getTabs()) {
            if (tab.equals(tabName)) {
                return true;
            }
        }
        return false;
    }
    
    private void openTab(Tab tabName) {
        // check if a tab for this button already exists
    	if(tabExists(tabPane, tabName) == false) {
			tabPane.getTabs().add(tabName);
			tabPane.getSelectionModel().select(tabName);
    	}
    	else
    		tabPane.getSelectionModel().select(tabName);
    }  

    public static void main(String[] args) {
        launch(args);
    }
}