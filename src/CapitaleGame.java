import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;

public class CapitaleGame {
    public static void main(String[] args) {

        final int NOMBRE_OF_QUESTIONS= 4;  //constante
        int index;
        String pays,capital;
        String userAnswer;
        int score=0;
        ArrayList<Integer> indexAlreadyTaken=new ArrayList<>();//contient les indices deja utilise
        String[][] data = getdata();
        long startime=System.currentTimeMillis();
        for(int i=0;i< NOMBRE_OF_QUESTIONS;i++){
            //choisir un pays de maniere aleatoire
            do{
                Random random=new Random();
                index= random.nextInt(data.length);  //indice aleatoire du pays
            }while(indexAlreadyTaken.contains(index));
            indexAlreadyTaken.add(index);

            pays=data[index][0];
            capital=data[index][1];

            //Demander a l'utilisateur d'entrer la capital de ce pays
             userAnswer=JOptionPane.showInputDialog(String.format("Quelle la capital de ce pays: %s?\n",pays));
            //on compare les reponses
            if(userAnswer.equalsIgnoreCase(capital)){
                JOptionPane.showMessageDialog(null,"Bonne reponse!");
                score++;
            }else{
                JOptionPane.showMessageDialog(null,String.format("Mauvaise reponse.Il fallait repondre %s \n",capital));
            }
        }
        long endtime=System.currentTimeMillis();
        int duree=(int)((endtime-startime)/1000);
        //on affiche notre verdict
        JOptionPane.showMessageDialog(null,String.format("c'est termine.<<Score: %d/%d >>",score,NOMBRE_OF_QUESTIONS));
        JOptionPane.showMessageDialog(null,String.format("Il vous a fallu environ %d pour repondre aux %d questions",duree,NOMBRE_OF_QUESTIONS));


    }
    static String[][] getdata(){
       String[][] data= {
            {"Senegal", "Dakar"},
            {"France", "Paris"},
            {"Maroc", "Rabat"},
            {"Qatar","Doubai"},
            {"Espagne","Barcelona"}};
       return data;
    }
}