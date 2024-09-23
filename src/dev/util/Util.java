package dev.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Util {

    // Método para validar datas no formato dd/MM/yyyy
    public static boolean validarData(String data) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false);  // O método setLenient(false) força a validação rigorosa da data.
        try {
            Date d = sdf.parse(data);  // Tenta converter a string em uma data
            return true;  // Data válida
        } catch (ParseException e) {
            System.out.println("Data inválida: " + data);
            return false;  // Data inválida
        }
    }

    // Método para verificar se uma string está vazia ou nula
    public static boolean stringVaziaOuNula(String str) {
        return str == null || str.trim().isEmpty();
    }

    // Método para validar o número de matrícula ou identificação
    public static boolean validarNumeroIdentificacao(String numero) {
        if (stringVaziaOuNula(numero)) {
            System.out.println("Número de identificação ou matrícula não pode ser vazio.");
            return false;
        }
        if (!numero.matches("\\d+")) {  // Verifica se o número contém apenas dígitos
            System.out.println("Número de identificação ou matrícula deve conter apenas números.");
            return false;
        }
        return true;
    }

    // Método para formatar datas para exibição (ex: dd/MM/yyyy para yyyy-MM-dd)
    public static String formatarDataParaISO(String data) throws ParseException {
        SimpleDateFormat sdfEntrada = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat sdfSaida = new SimpleDateFormat("yyyy-MM-dd");
        Date dataFormatada = sdfEntrada.parse(data);
        return sdfSaida.format(dataFormatada);
    }
}

