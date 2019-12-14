/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textlength;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *
 * @author Kaktus
 */
public class AlgoritmTextLength {

    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    String text;

    public int getLength() throws Exception {
        text = reader.readLine();
        return text.length();
    }
}
