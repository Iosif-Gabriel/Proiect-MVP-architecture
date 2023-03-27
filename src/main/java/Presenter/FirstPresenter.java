package Presenter;

import View.FirstInterface;
import View.FirstView;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FirstPresenter {

    private FirstInterface firstView;
    public FirstPresenter(FirstView view){
        firstView=view;

    }

    public void writeFile(String message, String path) throws IOException {
        File file = new File(path);
        FileWriter fr = new FileWriter(file, true);
        BufferedWriter br = new BufferedWriter(fr);
        br.write(message+"\n");

        br.close();
        fr.close();
    }

    public void displayBoard(){
        firstView.showBoard();
    }

    public void displayLogInGui(){
        firstView.showLogInGUI();
    }

    public void displaySolAccount(){
        firstView.solAccount();
    }
}
