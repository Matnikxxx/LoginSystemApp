/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Mr Mathebula
 */

    import java.util.ArrayList;
import java.util.List;

public class Message {

    private static boolean loggedIn = false;
    private static int messageCount = 0;

    private String messageID;
    private String recipient;
    private String message;
    private String messageHash;

    private static List<String> sentMessages = new ArrayList<>();

    public static void setLoginStatus(boolean status) {
        loggedIn = status;
    }

    public Message(String messageID, String recipient, String message) {
        this.messageID = messageID;
        this.recipient = recipient;
        this.message = message;
    }

    public boolean checkMessageID() {
        return messageID.length() <= 10;
    }

    public String checkRecipientCell() {
        if (recipient.startsWith("+27") && recipient.length() <= 13) {
            return "Cell phone number successfully captured.";
        }
        return "Invalid cellphone format";
    }

    public String validateMessage() {
        if (message.length() > 250) {
            return "Message exceeds 250 characters";
        }
        return "Message ready to send.";
    }

    public String createMessageHash() {

        String[] words = message.trim().split("\\s+");

        String first = words[0].toUpperCase();
        String last = words[words.length - 1].toUpperCase();

        String idPart = messageID.length() >= 2 ? messageID.substring(0, 2) : messageID;

        messageHash = idPart + ":" + messageCount + ":" + first + last;

        return messageHash;
    }

    public String sentMessage(int choice) {

        if (!loggedIn) {
            return "ERROR: Login required";
        }

        messageCount++;

        switch (choice) {
            case 1:
                sentMessages.add(message);
                return "Message successfully sent.";

            case 2:
                return "Press 0 to delete the message.";

            case 3:
                MessageStore.save(messageID + ":" + recipient + ":" + message);
                return "Message successfully stored.";

            default:
                return "Invalid option";
        }
    }

    public int returnTotalMessages() {
        return messageCount;

    
}
    }
