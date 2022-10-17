package org.example;

import java.time.*;

public class Main {
    public static void main(String[] args) {
        LocalDateTime dataNascimento = LocalDateTime.of(2000,12,11,5,0);
        Pessoa pessoa = new Pessoa(dataNascimento);
        System.out.println("idade: " + pessoa.getIdade());
        System.out.println("data nascimento: " + pessoa.getDataNascimentoFormatada());
        System.out.println("Zoneoffset: " + pessoa.getZoneOffSet());
        System.out.println("Ano de nascimento bissexto:  " + pessoa.isAnoBissexto());
        System.out.println("signo: " + pessoa.getSigno());
        System.out.println("ascedente: " + pessoa.getAscendente());
        System.out.println("signo lunar: " + pessoa.getSignoLunar());
    }
}