package fr.ubordeaux.ao.ricochetrobot;

import java.util.Set;

public class RicochetRobot {
    private boolean[][] grille;

    public RicochetRobot() {
        grille = new boolean[17][17];
        for (int i=0 ; i <= 16 ; i++) {
            grille[0][i] = true;
            grille[16][i] = true;
            grille[i][0] = true;
            grille[i][16] = true;
        }
    }

    private void genererGrilleSimple() {

    }

    public void afficheGrille() {
        for (int i=0 ; i <=16 ; i++) {
            for (int j=0 ; j <= 16 ; j++) {
                if (grille[i][j]) {
                    print
                }
            }
            println()
        }
    }

    
}