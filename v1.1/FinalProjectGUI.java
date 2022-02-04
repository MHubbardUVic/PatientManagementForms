/* Made by Madelyn Hubbard, C0344379, as a learning exercise
 * Last modified 2019-07-19
 * 
 */
package finalproject_javafx;


import javafx.application.Application;
import static javafx.application.Application.launch;

import javafx.event.ActionEvent;
import javafx.scene.input.MouseEvent;
import javafx.event.EventHandler;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.text.*;
import javafx.scene.control.TextArea;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
//import javafx.scene.layout.StackPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

//import javafx.event.Event;

/**
 * @author Matthew Hubbard
 */
public class FinalProjectGUI extends Application {
    @Override // Override the start method in the Application class
    
    public void start(Stage primaryStage) {
        //Create this here????
        CareFacility cf = new CareFacility("Peaceful Rest");
        
        //Create event handler for buttons
        EventHandler<ActionEvent> buttonHandler = new EventHandler<ActionEvent>() {
            
            public void handle(ActionEvent event) {
                //Implement logic for what button does what here
                /*if(){
                    
                }else if{
                    
                }else{
                    
                } */
                //event.consume();
            }
        };
        
        //Create master, outer pane
        GridPane pane = new GridPane();
        pane.setAlignment(Pos.TOP_CENTER);
        pane.setVgap(10);
	pane.setHgap(30);
        
        //Create children by row they will occupy in outer pane, place them
        
        //Labels on top row: Row 0
        Label pIntLabel = new Label("Enter patient info below");
        Label bEntryLabel = new Label("Register new bed info below");
        Label enterPatientLabel = new Label("Click below to register patient");
        Label dischargeLabel = new Label ("Discharge patient by entering"
                + " their patient number");
        pane.addRow(0, pIntLabel);
        pane.addRow(0, bEntryLabel);
        pane.addRow(0, enterPatientLabel);
        pane.addRow(0, dischargeLabel);
        
        
        
        //Data entry panes: Row 1
        
        //Patient entry pane
        GridPane pEntryPane = new GridPane();
        
        Label pFirstName = new Label("First Name:");
        Label pLastName = new Label("Last Name:");
        Label pPriority = new Label("Priority (1-10):");
        pEntryPane.add(pLastName,0,1);
        pEntryPane.add(pFirstName,0,0);
        pEntryPane.add(pPriority,0,2);
        
        TextField pFNEntry = new TextField("June");         //**********
        TextField pLNEntry = new TextField("Smith");
        TextField pPEntry = new TextField("2");
        pEntryPane.add(pFNEntry,1,0);
        pEntryPane.add(pLNEntry,1,1);
        pEntryPane.add(pPEntry,1,2);
        
        pane.add(pEntryPane,0,1);
        
        //Bed entry pane
        GridPane bEntryPane = new GridPane();
        
        Label bNameLabel = new Label("Bed's name:");
        Label bLocLabel = new Label("Bed's location:");
        bEntryPane.add(bNameLabel,0,0);
        bEntryPane.add(bLocLabel,0,1);
        
        TextField bNameEntry = new TextField("Rosewood");
        TextField bLocEntry = new TextField("Room 2");
        bEntryPane.add(bNameEntry,1,0);
        bEntryPane.add(bLocEntry,1,1);
        pane.add(bEntryPane,1,1);
        
        //Patient discharge pane
        GridPane disPane = new GridPane();
        
        Label disLabel = new Label("Patient #:");
        TextField disEntry = new TextField();
        disPane.add(disLabel,0,0);
        disPane.add(disEntry,0,1);
        
        pane.add(disPane,3,1);
        
        
        
        //Function buttons: Row 2
        Button pIntButton = new Button("Intake Patient");
        Button bButton = new Button("Enter bed into system");
        Button inButton = new Button("ENTER A PATIENT IN TO CARE");
        Button disButton = new Button("Discharge entered patient");
        pane.add(pIntButton,0,2);
        pane.add(bButton,1,2);
        pane.add(inButton,2,2);
        pane.add(disButton,3,2);
        
        
        
        //Labels over data lists: Row 3
        Label intakeLabel = new Label("Patient Intakes");
        Label availBedsLabel = new Label("Available Beds");
        Label pInCareLabel = new Label("Patients in Care");
        pane.addRow(3, intakeLabel);
        pane.addRow(3, availBedsLabel);
        pane.add(pInCareLabel,3,3);
        
        
        
        //Data lists: Row 4
        Text pIntList = new Text("");
        //pIntList.setY(600);
        Text bList = new Text("");
        Text assignBedText = new Text("");
        Text pICList = new Text("");
        
        pane.addRow(4, pIntList);
        pane.addRow(4, bList);
        pane.add(assignBedText,2,4);
        pane.add(pICList,3,4);
        
        
        
        
        //Event handlers
        //Event to intake new patient into waiting room
        pIntButton.setOnAction(new EventHandler<ActionEvent>() {
 
            @Override
            public void handle(ActionEvent event) {
                //Try to parse entered priority...
                int tempPriority;
                try {
                    tempPriority = Integer.parseInt(pPEntry.getText());
                }catch (NumberFormatException e){
                    tempPriority = 1;
                }
                //...make patient record...
                Patient tempPatient = new Patient(pFNEntry.getText(),
                                            pLNEntry.getText(),tempPriority);
                //...and intake this new patient
                cf.intakePatient(tempPatient);
                
                //Fill in visible list of patients in UI
                pIntList.setText(cf.getIntakeList());
                
                //Clear entry fields
                //pFNEntry.setText("");
                //pLNEntry.setText("");
                //pPEntry.setText("");
            }
        });
        
        //Event to place new bed into bed database
        bButton.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                //Add new bed to list
                cf.addBed(new Bed(bNameEntry.getText(),bLocEntry.getText()));
                //Update display of beds
                bList.setText(cf.beds.toString());
            }
        });
        
        //Event to intake patient
        inButton.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                assignBedText.setText(cf.assignBed());
                pIntList.setText(cf.getIntakeList());
                bList.setText(cf.beds.toString());
            }
        });
        
        
        //Event to discharge the indicated patient
        disButton.setOnAction(buttonHandler);
        
        
        
        //Create scene using the pane
        Scene scene = new Scene(pane, 1000, 800);
        
        //Stage settings
        primaryStage.setTitle("Care Facility UI"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
    }//End class Start

    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
        
    }//End main class
    
}
