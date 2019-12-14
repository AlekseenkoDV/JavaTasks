/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmGame;

import java.awt.Component;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author Kaktus
 */
public class AlgoritrmGame {

    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private int numberPlayer;
    private int robotNumber = new Random().nextInt(100);
    private int count = 0;

    public int getNumber() throws Exception {
        for (int i = 0; i < 7; i++) {
            numberPlayer = Integer.parseInt(reader.readLine());
            if (robotNumber > numberPlayer) {
                System.out.println("Мало");
                count++;
            } else if (robotNumber < numberPlayer) {
                System.out.println("Много");
                count++;
            } else if (robotNumber == numberPlayer) {
                System.out.println("Победа!");
                break;
            }
        }
        System.out.println("Ты проиграл!");
        System.out.println("Загаданное чило: " + robotNumber);
        System.out.println("Попыток было сделанно: " + count);
        return numberPlayer;
    }
}
