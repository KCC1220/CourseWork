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


import java.awt.*;



public class GraphicsMain{

    static Audio thread1 = new Audio();
    public static void main(String[] args) throws Exception {
        EventQueue.invokeLater(() -> new GameFrame().initialize());
        startBGM();






    }
    public static void startBGM(){
        thread1.start();
    }
    public static void stopBGM() throws InterruptedException {
        Audio.clip.stop();
    }
    public static void resumeBGM(){
        Audio.clip.start();
    }




}
