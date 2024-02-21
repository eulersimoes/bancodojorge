package br.com.bancodojorge.apirest.domain.util;

import java.util.Random;

public class GeradorEnderecoUtil {

    private static String[] Beginning = {"Rua","Alameda","Avenida","Travessa","Esplanada"};
    private static String[] Middle = {"Contagem","Uberlandia","Juíz de Fora","Barbacena","Bahia",
            "Salvador","Acm","Santos"};
    private static String[] End = {"Lourdes","Tijuca","São João","Ipanema","Pituba","Paripe","Cambridge","Nova Aclimação",
    "Savassi" , "Cidade Baixa"};

    private static Random rand = new Random();

    public static String gerarEndereco() {

        String endereco= Beginning[rand.nextInt(Beginning.length)] + " " +
                Middle[rand.nextInt(Middle.length)] +  " " +
                "número " + rand.nextInt(1000) + " bairro " +
                End[rand.nextInt(End.length)];

        return endereco.length() >=50 ? endereco.substring(0,49): endereco;


    }
}
