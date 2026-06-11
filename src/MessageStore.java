/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Mr Mathebula
 */
    

import java.io.FileWriter;
import java.io.IOException;

public class MessageStore {

    public static void save(String data) {

        try (FileWriter fw = new FileWriter("messages.json", true)) {
            fw.write(data + "\n");
        } catch (IOException e) {
            System.out.println("File error");
        }
    }
}
    

