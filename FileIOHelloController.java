package com.example.labfileio;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class HelloController {
    @FXML
    private Text text;


    public void initialize() {    //throws IOException could be used instead of the try/catch statement but...it won't actually solve anything.
        File myFile = new File("src/main/resources/hello.txt");
        try {
            Scanner fileInput = new Scanner(myFile);    //anything relating to the Scanner must be in this section
            String input = fileInput.nextLine();
            text.setText(input);
        } catch (FileNotFoundException error) {  //needs to throw exception of else line 19 won't work
            System.out.println("File was not found");
        }


    }
}
