package application;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import javafx.application.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.*;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.*;

public class ResumeViewer extends Application {

    private TextArea resumeArea;
    private TextArea coverLetterArea;
    private TextArea skillsTextArea;
    private TextArea experienceTextArea;
    private TextArea educationTextArea;
    private TextArea APETextArea;
    private TabPane tabPane;
    private String[] detailsSelection = {"Resume", "Cover Letter", "Skills", "Experience", "Education",
    "Awards/ Projects/ Extracurricular"};
    private String[] downloadSelection = {"Download Text", "Download Pdf"};
    private static final int PORT = 2440;
    
    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) {
    	System.out.println("Starting application...");
    	ListView<String> lv1 = createListView(detailsSelection);
    	ListView<String> lv2 = createListView(detailsSelection);
    	ListView<String> lv3 = createListView(detailsSelection);
    	ListView<String> lv4 = createListView(detailsSelection);
    	ListView<String> lv5 = createListView(detailsSelection);
    	ListView<String> lv6 = createListView(detailsSelection);
    	
    	ListView<String> lv1D = createListView(downloadSelection);
    	ListView<String> lv2D = createListView(downloadSelection);
    	ListView<String> lv3D = createListView(downloadSelection);
    	ListView<String> lv4D = createListView(downloadSelection);
    	ListView<String> lv5D = createListView(downloadSelection);
    	ListView<String> lv6D = createListView(downloadSelection);
    	
        VBox listBox1 = new VBox();
        listBox1.getChildren().addAll(lv1,lv1D);
        VBox listBox2 = new VBox();
        listBox2.getChildren().addAll(lv2,lv2D);
        VBox listBox3 = new VBox();
        listBox3.getChildren().addAll(lv3,lv3D);
        VBox listBox4 = new VBox();
        listBox4.getChildren().addAll(lv4,lv4D);
        VBox listBox5 = new VBox();
        listBox5.getChildren().addAll(lv5,lv5D);
        VBox listBox6 = new VBox();
        listBox6.getChildren().addAll(lv6,lv6D);

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
        Tab APETab = new Tab("Awards/ Projects/ Extracurricular");
        APETab.setClosable(false);
        
        tabPane.getTabs().addAll(resumeTab, coverLetterTab);
        
        resumeArea = new TextArea();
        resumeArea.setEditable(false);
        resumeArea.setWrapText(true);
        //resumeArea.setPrefHeight(600);
        //resumeArea.setMinWidth(395);
        
        SplitPane content1 = new SplitPane();
        content1.setPadding(new Insets(10, 10, 10, 10));
        content1.setDividerPositions(0.34, 0.66);
        content1.setOrientation(Orientation.HORIZONTAL);
        content1.getItems().addAll(listBox1,resumeArea);
        
        resumeTab.setContent(content1);
        
        coverLetterArea = new TextArea();
        coverLetterArea.setWrapText(true);
        coverLetterArea.setEditable(false);
        //coverLetterArea.setPrefHeight(600);
        
        SplitPane content2 = new SplitPane();
        content2.setPadding(new Insets(10, 10, 10, 10));
        content2.setDividerPositions(0.34, 0.66);
        content2.setOrientation(Orientation.HORIZONTAL);
        content2.getItems().addAll(listBox2,coverLetterArea);
        
        coverLetterTab.setContent(content2);
        
        skillsTextArea = new TextArea();
        skillsTextArea.setWrapText(true);
        skillsTextArea.setEditable(false);
        //coverLetterArea.setPrefHeight(600);
        
        SplitPane content3 = new SplitPane();
        content3.setPadding(new Insets(10, 10, 10, 10));
        content3.setDividerPositions(0.34, 0.66);
        content3.setOrientation(Orientation.HORIZONTAL);
        content3.getItems().addAll(listBox3,skillsTextArea);
        
        skillsTab.setContent(content3);
        
        experienceTextArea = new TextArea();
        experienceTextArea.setWrapText(true);
        experienceTextArea.setEditable(false);
        //coverLetterArea.setPrefHeight(600);
        
        SplitPane content4 = new SplitPane();
        content4.setPadding(new Insets(10, 10, 10, 10));
        content4.setDividerPositions(0.34, 0.66);
        content4.setOrientation(Orientation.HORIZONTAL);
        content4.getItems().addAll(listBox4,experienceTextArea);
        
        experienceTab.setContent(content4);
        
        educationTextArea = new TextArea();
        educationTextArea.setWrapText(true);
        educationTextArea.setEditable(false);
        //coverLetterArea.setPrefHeight(600);
        
        SplitPane content5 = new SplitPane();
        content5.setPadding(new Insets(10, 10, 10, 10));
        content5.setDividerPositions(0.34, 0.66);
        content5.setOrientation(Orientation.HORIZONTAL);
        content5.getItems().addAll(listBox5,educationTextArea);
        
        educationTab.setContent(content5);
        
        APETextArea = new TextArea();
        APETextArea.setWrapText(true);
        APETextArea.setEditable(false);
        //coverLetterArea.setPrefHeight(600);
        
        SplitPane content6 = new SplitPane();
        content6.setPadding(new Insets(10, 10, 10, 10));
        content6.setDividerPositions(0.34, 0.66);
        content6.setOrientation(Orientation.HORIZONTAL);
        content6.getItems().addAll(listBox6,APETextArea);
        
        APETab.setContent(content6);
        
        
        listTabSelection(lv1,lv2,lv3,lv4,lv5,lv6,resumeTab,coverLetterTab,skillsTab,experienceTab,educationTab,APETab);
        listTabSelection(lv2,lv1,lv3,lv4,lv5,lv6,resumeTab,coverLetterTab,skillsTab,experienceTab,educationTab,APETab);
        listTabSelection(lv3,lv2,lv1,lv4,lv5,lv6,resumeTab,coverLetterTab,skillsTab,experienceTab,educationTab,APETab);
        listTabSelection(lv4,lv2,lv3,lv1,lv5,lv6,resumeTab,coverLetterTab,skillsTab,experienceTab,educationTab,APETab);
        listTabSelection(lv5,lv2,lv3,lv4,lv1,lv6,resumeTab,coverLetterTab,skillsTab,experienceTab,educationTab,APETab);
        listTabSelection(lv6,lv2,lv3,lv4,lv5,lv1,resumeTab,coverLetterTab,skillsTab,experienceTab,educationTab,APETab);
        
        downloadHandle (lv1D, resumeArea);
        downloadHandle (lv2D, coverLetterArea);
        downloadHandle (lv3D, skillsTextArea);
        downloadHandle (lv4D, experienceTextArea);
        downloadHandle (lv5D, educationTextArea);
        downloadHandle (lv6D, APETextArea);
        
        Scene scene = new Scene(tabPane, 600, 650);
        primaryStage.setTitle("Resume Viewer");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        // set up a socket server to receive messages
        new Thread(() -> {
        	try (ServerSocket serverSocket = new ServerSocket(PORT)) {
        		while (true) {
        			Socket socket = serverSocket.accept();
        			new Thread(() -> {
        				try {
        					
        					DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
        					String[][] data = new String[32][1];
        					for (int i = 0; i < 32;i++) {
        						data[i][0] = dataInputStream.readUTF();                              
        					}
        					
        					
        					Platform.runLater(() -> {
        						resumeArea.appendText(
        								data[0][0] + " " + data[1][0] + "\n" + data[2][0] + "\n" + data[3][0] + ", " + 
        						data[4][0] + " " + data[5][0] + "\n" + data[6][0] +"\n" + data[7][0] + "\n\n" + "SKILLS" + 
        										"\n\n" + data[8][0] + "\n\n" + "EXPERIENCE" + "\n\n" + data[9][0] + "\n\n" + 
        						"EDUCATION" + "\n\n" + data[10][0] + "\n\n" + data[11][0] + "\n\n" + data[12][0]
        									);
        						
        						skillsTextArea.appendText(data[13][0]);
        						experienceTextArea.appendText(data[14][0]);
        						educationTextArea.appendText(data[15][0]);
        						APETextArea.appendText(data[16][0]);
        						
        						coverLetterArea.appendText(
        								data[17][0] + " " + data[18][0] + "\n" +
        						data[23][0] + " \t|\t " + data[22][0]+ " \t|\t " + data[19][0] + ", " + data[20][0] +  " " + data[21][0] +  "\n\n" + 
        						// "\t\t" + 
        						data[25][0] + "\n\n" +	
        						data[26][0] + "\n" +
        						data[27][0] + "\n" +
        						data[28][0] + "\n" +
        						data[29][0] + "\n" +
        						data[30][0] + "\n" +
       							data[31][0] + "\n\n" +
       							data[24][0] + "\n"
       							);
        					});
                 
        				} catch (IOException e) {
        					e.printStackTrace();
        				}
        			}).start();
        		}
        	} catch (IOException e) {
        		e.printStackTrace();
        	}
	}).start();
    }

    public static ListView<String> createListView(String[] items) {
        ObservableList<String> observableItems = FXCollections.observableArrayList(items);
        ListView<String> listView = new ListView<>(observableItems);
        listView.setPrefSize(400, 400);
        listView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        return listView;
    }
    
    public static boolean tabExists(TabPane tabPane, String tabName) {
        for (Tab tab : tabPane.getTabs()) {
            if (tab.getText().equals(tabName)) {
                return true;
            }
        }
        return false;
    }
    
    private void downloadHandle (ListView<String> lv, TextArea downloadTextArea) {
    	lv.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
    		if (newVal == "Download Text")
    			handleDownloadText(downloadTextArea);
    		else if(newVal == "Download Pdf")
    			handleDownloadPdf(downloadTextArea);
    	});
    }
    
    
    private void listTabSelection(ListView<String> lv, ListView<String> lva, ListView<String> lvb,ListView<String> lvc,
    		ListView<String> lvd,ListView<String> lve,Tab resumeTab, Tab coverLetterTab, 
    		Tab skillsTab, Tab experienceTab, Tab educationTab, Tab APETab) {
    	
        lv.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
        	
        	// perform action for selected item            	
           	if(newVal == "Resume") {
           		tabPane.getSelectionModel().select(resumeTab);
                lva.setSelectionModel(lv.getSelectionModel());
                lvb.setSelectionModel(lv.getSelectionModel());
                lvc.setSelectionModel(lv.getSelectionModel());
                lvd.setSelectionModel(lv.getSelectionModel());
                lve.setSelectionModel(lv.getSelectionModel());
           	}
            	
           	else if(newVal == "Cover Letter") {
           		tabPane.getSelectionModel().select(coverLetterTab);
                lva.setSelectionModel(lv.getSelectionModel());
                lvb.setSelectionModel(lv.getSelectionModel());
                lvc.setSelectionModel(lv.getSelectionModel());
                lvd.setSelectionModel(lv.getSelectionModel());
                lve.setSelectionModel(lv.getSelectionModel());
           	}
            	
           	else if(newVal == "Skills") {
           		if(tabExists(tabPane,skillsTab.getText()) == false) {
           			tabPane.getTabs().add(skillsTab);
           			tabPane.getSelectionModel().select(skillsTab);
                    lva.setSelectionModel(lv.getSelectionModel());
                    lvb.setSelectionModel(lv.getSelectionModel());
                    lvc.setSelectionModel(lv.getSelectionModel());
                    lvd.setSelectionModel(lv.getSelectionModel());
                    lve.setSelectionModel(lv.getSelectionModel());
           		}
           		else {
           			tabPane.getSelectionModel().select(skillsTab);
                    lva.setSelectionModel(lv.getSelectionModel());
                    lvb.setSelectionModel(lv.getSelectionModel());
                    lvc.setSelectionModel(lv.getSelectionModel());
                    lvd.setSelectionModel(lv.getSelectionModel());
                    lve.setSelectionModel(lv.getSelectionModel());
           		}
            		
           	}
           	else if(newVal == "Experience") {
           		if(tabExists(tabPane,experienceTab.getText()) == false) {
           			tabPane.getTabs().add(experienceTab);
            		tabPane.getSelectionModel().select(experienceTab);
                    lva.setSelectionModel(lv.getSelectionModel());
                    lvb.setSelectionModel(lv.getSelectionModel());
                    lvc.setSelectionModel(lv.getSelectionModel());
                    lvd.setSelectionModel(lv.getSelectionModel());
                    lve.setSelectionModel(lv.getSelectionModel());
           		}
           		else {
           			tabPane.getSelectionModel().select(experienceTab);
                    lva.setSelectionModel(lv.getSelectionModel());
                    lvb.setSelectionModel(lv.getSelectionModel());
                    lvc.setSelectionModel(lv.getSelectionModel());
                    lvd.setSelectionModel(lv.getSelectionModel());
                    lve.setSelectionModel(lv.getSelectionModel());
           		}
           	}
           	else if(newVal == "Education") {
           		if(tabExists(tabPane,educationTab.getText()) == false) {
            		tabPane.getTabs().add(educationTab);
           			tabPane.getSelectionModel().select(educationTab);
                    lva.setSelectionModel(lv.getSelectionModel());
                    lvb.setSelectionModel(lv.getSelectionModel());
                    lvc.setSelectionModel(lv.getSelectionModel());
                    lvd.setSelectionModel(lv.getSelectionModel());
                    lve.setSelectionModel(lv.getSelectionModel());
           		}
           		else {
           			tabPane.getSelectionModel().select(educationTab);
                    lva.setSelectionModel(lv.getSelectionModel());
                    lvb.setSelectionModel(lv.getSelectionModel());
                    lvc.setSelectionModel(lv.getSelectionModel());
                    lvd.setSelectionModel(lv.getSelectionModel());
                    lve.setSelectionModel(lv.getSelectionModel());
           		}
           	}
           	else if(newVal == "Awards/ Projects/ Extracurricular") {
           		if(tabExists(tabPane,APETab.getText()) == false) {
            		tabPane.getTabs().add(APETab);
            		tabPane.getSelectionModel().select(APETab);
                    lva.setSelectionModel(lv.getSelectionModel());
                    lvb.setSelectionModel(lv.getSelectionModel());
                    lvc.setSelectionModel(lv.getSelectionModel());
                    lvd.setSelectionModel(lv.getSelectionModel());
                    lve.setSelectionModel(lv.getSelectionModel());
           		}
           		else {
           			tabPane.getSelectionModel().select(APETab);
                    lva.setSelectionModel(lv.getSelectionModel());
                    lvb.setSelectionModel(lv.getSelectionModel());
                    lvc.setSelectionModel(lv.getSelectionModel());
                    lvd.setSelectionModel(lv.getSelectionModel());
                    lve.setSelectionModel(lv.getSelectionModel());
           		}
           		
           	}
            
        });
    }

    private void handleDownloadText(TextArea downloadText) {
        try {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Save Document as Text");
            fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text Files", "*.txt"));
            File file = fileChooser.showSaveDialog(null);

            if (file != null) {
                FileWriter writer = new FileWriter(file);
                writer.write(downloadText.getText());
                writer.close();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    private void handleDownloadPdf(TextArea downloadPdf) {
       try {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Save Document as PDF");
            fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("PDF Files", "*.pdf"));
            File file = fileChooser.showSaveDialog(null);

            if (file != null) {
                Document document = new Document(PageSize.A4);
                PdfWriter.getInstance(document, new FileOutputStream(file));
                document.open();
                document.add(new Paragraph(downloadPdf.getText()));
                document.close();
            }
        } catch (IOException | DocumentException ex) {
           ex.printStackTrace();
        }
    }
}