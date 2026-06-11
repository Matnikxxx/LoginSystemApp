/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.loginsystem;

import org.junit.Test;
import static org.junit.Assert.*;

public class LoginSystemAppTest {
//unit tests
    @Test
    public void testUsernameValid() {
        LoginSystem ls = new LoginSystem();
        assertTrue(ls.checkUserName("k_b"));
    }

    @Test
    public void testPasswordValid() {
        LoginSystem ls = new LoginSystem();
        assertTrue(ls.checkPasswordComplexity("Abc@1234"));
    }

    @Test
    public void testLoginFail() {
        LoginSystem ls = new LoginSystem();
        ls.registerUser("k_b", "Abc@1234", "John", "Doe", "+271234567890");
        assertFalse(ls.loginUser("wrong", "wrong"));
    }

    @Test
    public void testLoginSuccess() {
        LoginSystem ls = new LoginSystem();
        ls.registerUser("k_b", "Abc@1234", "John", "Doe", "+271234567890");
        assertTrue(ls.loginUser("k_b", "Abc@1234"));
    }

    @Test
    public void testMessageSendRequiresLogin() {
        Message.setLoginStatus(false);

        Message msg = new Message("12", "+271234567890", "Hello");

        assertEquals("ERROR: Login required", msg.sentMessage(1));
    }
}