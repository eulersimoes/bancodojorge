package br.com.bancodojorge.apirest.domain.util;
import java.util.Random;
public class GeradorNomesUtil {

    private static String[] Beginning = {"João","Jose","Caio","Guilherme",
            "Fabio","Lucas","Thiago", "Ivan", "Aurelio","Silas","Auxios","Geovane",
            "Marcelo","Rossbergue","Schumer","Alberto","Aline","Alice","Jeovana",
            "Carla","Thais","Gisele","Vivane","Kauam","Karem"};
    private static String[] Middle = {"Silva","Simon","Joanes","Melo","Barata","Rorxe","Sousa","Armas","Grixo","da Bota",
    "Porcão"};
    private static String[] End = {"de Luxemburgo", "Soares", "de Lexigthon","Alfenas","Whinter", "Summer" , "Ferreira",
    "da Conceição","Ponte Nova"};

    private static Random rand = new Random();

    public static String generateName() {

        String nome = Beginning[rand.nextInt(Beginning.length)] +  " " +
                Middle[rand.nextInt(Middle.length)] +  " " +
                End[rand.nextInt(End.length)];

        return nome.length() >= 50 ? nome.substring(0,49): nome;



    }
}
