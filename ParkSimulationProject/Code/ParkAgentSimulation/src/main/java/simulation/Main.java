package simulation;

import simulation.GUI.InitialWindow;

import java.io.IOException;

import static simulation.Configuration.setUpConfiguration;

public class Main {

    public static void main(String[] args) throws IOException {

        setUpConfiguration();

        InitialWindow initialWindow = new InitialWindow();
        initialWindow.display();
    }


}
