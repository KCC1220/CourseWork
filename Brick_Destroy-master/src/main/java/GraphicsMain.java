/*
 *  Brick Destroy - A simple Arcade video game
 *   Copyright (C) 2017  Filippo Ranza
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package main.java;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class GraphicsMain {
    static String [] values;
    static List list= new List();
    static String line ="";
    static String path = "Brick_Destroy-master/src/main/resources/score.txt";
    static Audio thread1 = new Audio();
    public static void main(String[] args) throws Exception {

        EventQueue.invokeLater(() -> new GameFrame().initialize());
        FileReader file = new FileReader(path);
        BufferedReader bf = new BufferedReader(file);
        String st = bf.readLine();
        startBGM();






    }
    public static void startBGM(){
        thread1.run();
    }
    public static void stopBGM() throws InterruptedException {
        System.out.println("Itu Dia");
        Audio.clip.stop();
    }





}
