package com.fmatheus.app.controller.util;

import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.caelum.stella.format.CNPJFormatter;
import br.com.caelum.stella.format.CPFFormatter;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.File;
import java.util.Base64;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.io.FileUtils;


public class AppUtil {

    private static final Logger logger = LoggerFactory.getLogger(AppUtil.class);

    private AppUtil() {
    }


    /**
     * Converte o primeiro caracterde cada palavra em maiusculo.
     *
     * @param value String a ser convertida
     * @return String
     * @author Fernando Matheus
     */
    public static String convertFirstUppercaseCharacter(String value) {
        return Objects.nonNull(value) ? removeDuplicateSpace(CapitalizeUtil.capitalizeFully(value).trim()) : null;
    }

    /**
     * Converte todos os caracteres em maiusculo.
     *
     * @param value String a ser convertida
     * @return String
     * @author Fernando Matheus
     */
    public static String convertAllUppercaseCharacters(String value) {
        return Objects.nonNull(value) ? removeDuplicateSpace(value.toUpperCase().trim()) : null;
    }


    /**
     * Converte todos os caracteres em minusculo.
     *
     * @param value String a ser convertida
     * @return String
     * @author Fernando Matheus
     */
    public static String convertAllLowercaseCharacters(String value) {
        return Objects.nonNull(value) ? removeDuplicateSpace(value.toLowerCase().trim()) : null;
    }

    /**
     * Remove todos os espacos.
     *
     * @param value String a ser convertida
     * @return String
     * @author Fernando Matheus
     */
    public static String removeAllSpaces(String value) {
        return value.replace(" ", "");
    }


    /**
     * Remove espacos duplicados
     *
     * @param value String a ser convertida
     * @return String
     * @author Fernando Matheus
     */
    public static String removeDuplicateSpace(String value) {
        return Objects.nonNull(value) ? value.replaceAll("\\s+", " ").trim() : null;
    }

    public static String returnFirstWord(String texto) {
        String pattern = "^([a-zA-ZÈ-Úè-ú]+)\\s";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(texto);
        if (m.find()) {
            return m.group(0);
        }
        return null;
    }


    /**
     * Remove qualquer caracter, exeto numeros e letras.
     *
     * @param value String a ser convertida
     * @return String
     * @author Fernando Matheus
     */
    public static String removeSpecialCharacters(@NotNull @NotBlank String value) {
        return value.replaceAll("[^a-zA-Z0-9]", "");
    }


    public static String converterImagetoBase64(File file) {
        return Objects.requireNonNull(converterImageToBase64(file.getAbsolutePath())).replace("data:image/png;base64,", "");
    }

    @SneakyThrows
    private static String converterImageToBase64(String path) {
        logger.info("Procurando pela imagem {}", path);
        File file = new File(path);
        if (file.exists()) {
            logger.info("Convertendo imagem para base64: {}", path);
            byte[] fileContent = FileUtils.readFileToByteArray(file);
            return Base64.getEncoder().encodeToString(fileContent);
        }
        return null;

    }


    /**
     * Cria uma mascara para uma string.
     *
     * @param valor   Valor a ser convertido
     * @param mascara Mascara
     * @return String
     * @author Fernando Matheus
     */
    public static String formatMask(String valor, String mascara) {

        StringBuilder dado = new StringBuilder();
        for (var i = 0; i < valor.length(); i++) {
            var c = valor.charAt(i);
            if (Character.isDigit(c)) {
                dado.append(c);
            }
        }
        int indMascara = mascara.length();
        int indCampo = dado.length();

        while (indCampo > 0 && indMascara > 0) {
            if (mascara.charAt(--indMascara) == '#') {
                indCampo--;
            }
        }

        StringBuilder saida = new StringBuilder();
        for (; indMascara < mascara.length(); indMascara++) {
            saida.append((mascara.charAt(indMascara) == '#') ? dado.charAt(indCampo++) : mascara.charAt(indMascara));
        }
        return saida.toString();
    }

    /**
     * Conta os caracteres uma string.
     *
     * @param value Valor a ser convertido
     * @return int
     * @author Fernando Matheus
     */
    public static int countCharacter(String value) {
        return Objects.nonNull(value) ? value.length() : 0;
    }

    /**
     * Cria uma mascara para CPF.
     *
     * @param value Valor a ser convertido
     * @return String
     * @author Fernando Matheus
     */
    public static String formatCPF(String value) {
        return Objects.nonNull(value) ? new CPFFormatter().format(value) : null;
    }

    /**
     * Cria uma mascara para CNPJ.
     *
     * @param value Valor a ser convertido
     * @return String
     * @author Fernando Matheus
     */
    public static String formatCNPJ(String value) {
        return Objects.nonNull(value) ? new CNPJFormatter().format(value) : null;
    }

}


