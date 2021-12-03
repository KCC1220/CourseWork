package main.java;


import java.awt.*;




public class ColourController {
    private static final ColourModel model = new ColourModel();

    public void clickedButton(int select){

        if (select==1){
            model.setPlayerColour(Color.yellow.darker());
            updatePlayerColour("     YELLOW");

        }
        if (select== 2){
            model.setPlayerColour(Color.blue);
            updatePlayerColour("           BLUE");

        }
        if (select== 3){
            model.setPlayerColour(Color.green);
            updatePlayerColour("       GREEN");

        }
        if (select== 4){
            model.setPlayerColour(Color.cyan);
            updatePlayerColour("        CYAN");

        }
        if (select== 5){
            model.setPlayerColour(Color.red);

            updatePlayerColour("           RED");
        }
        if (select== 6){
            model.setPlayerColour(Color.magenta);
            updatePlayerColour("MAGENTA");

        }
        if (select== 7){
            model.setPlayerColour(Color.pink);
            updatePlayerColour("           PINK");

        }
        if (select== 8){
            model.setBallColour(Color.yellow.darker());
            updateBallColor("     YELLOW");

        }
        if (select== 9){
            model.setBallColour(Color.blue);
            updateBallColor("       BLUE");

        }
        if (select== 10){
            model.setBallColour(Color.green);
            updateBallColor("   GREEN     ");
        }
        if (select== 11){
            model.setBallColour(Color.cyan);
            updateBallColor("CYAN        ");

        }
        if (select== 12){
            model.setBallColour(Color.red);
            updateBallColor("RED        ");
        }
        if (select== 13){
            model.setBallColour(Color.magenta);
            updateBallColor("MAGENTA");

        }
        if (select== 14){
            model.setBallColour(Color.pink);
            updateBallColor("PINK        ");

        }
    }
    public void updatePlayerColour(String name){
        model.setPColour(name);
    }
    public void updateBallColor(String name){model.setBColour(name);}



}
