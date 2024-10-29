package ua.kusakabe.desktopdemo.service;

import java.awt.*;

public class TransformService {

    public Color transformTextToColor(char c){
        return switch (c) {
            //regular letters
            case 'a' -> new Color(0, 1, 0);
            case 'b' -> new Color(0, 2, 0);
            case 'c' -> new Color(0, 3, 0);
            case 'd' -> new Color(0, 4, 0);
            case 'e' -> new Color(0, 5, 0);
            case 'f' -> new Color(0, 6, 0);
            case 'g' -> new Color(0, 7, 0);
            case 'h' -> new Color(0, 8, 0);
            case 'i' -> new Color(0, 9, 0);
            case 'j' -> new Color(0, 10, 0);
            case 'k' -> new Color(0, 11, 0);
            case 'l' -> new Color(0, 12, 0);
            case 'm' -> new Color(0, 13, 0);
            case 'n' -> new Color(0, 14, 0);
            case 'o' -> new Color(0, 15, 0);
            case 'p' -> new Color(0, 16, 0);
            case 'q' -> new Color(0, 17, 0);
            case 'r' -> new Color(0, 18, 0);
            case 's' -> new Color(0, 19, 0);
            case 't' -> new Color(0, 20, 0);
            case 'u' -> new Color(0, 21, 0);
            case 'v' -> new Color(0, 22, 0);
            case 'w' -> new Color(0, 23, 0);
            case 'x' -> new Color(0, 24, 0);
            case 'y' -> new Color(0, 25, 0);
            case 'z' -> new Color(0, 26, 0);
            //Capital letters
            case 'A' -> new Color(0, 0, 1);
            case 'B' -> new Color(0, 0, 2);
            case 'C' -> new Color(0, 0, 3);
            case 'D' -> new Color(0, 0, 4);
            case 'E' -> new Color(0, 0, 5);
            case 'F' -> new Color(0, 0, 6);
            case 'G' -> new Color(0, 0, 7);
            case 'H' -> new Color(0, 0, 8);
            case 'I' -> new Color(0, 0, 9);
            case 'J' -> new Color(0, 0, 10);
            case 'K' -> new Color(0, 0, 11);
            case 'L' -> new Color(0, 0, 12);
            case 'M' -> new Color(0, 0, 13);
            case 'N' -> new Color(0, 0, 14);
            case 'O' -> new Color(0, 0, 15);
            case 'P' -> new Color(0, 0, 16);
            case 'Q' -> new Color(0, 0, 17);
            case 'R' -> new Color(0, 0, 18);
            case 'S' -> new Color(0, 0, 19);
            case 'T' -> new Color(0, 0, 20);
            case 'U' -> new Color(0, 0, 21);
            case 'V' -> new Color(0, 0, 22);
            case 'W' -> new Color(0, 0, 23);
            case 'X' -> new Color(0, 0, 24);
            case 'Y' -> new Color(0, 0, 25);
            case 'Z' -> new Color(0, 0, 26);
            //Numbers
            case '1' -> new Color(1, 1, 0);
            case '2' -> new Color(1, 2, 0);
            case '3' -> new Color(1, 3, 0);
            case '4' -> new Color(1, 4, 0);
            case '5' -> new Color(1, 5, 0);
            case '6' -> new Color(1, 6, 0);
            case '7' -> new Color(1, 7, 0);
            case '8' -> new Color(1, 8, 0);
            case '9' -> new Color(1, 9, 0);
            case '0' -> new Color(1, 10, 0);
            //Special symbols
            case ' ' -> new Color(2, 1, 0);
            case '\n' -> new Color(2, 2, 0);
            case '.' -> new Color(2, 3, 0);
            case ',' -> new Color(2, 4, 0);
            case '/' -> new Color(2, 5, 0);
            case '?' -> new Color(2, 6, 0);
            case '!' -> new Color(2, 7, 0);
            case '@' -> new Color(2, 8, 0);
            case '#' -> new Color(2, 9, 0);
            case '$' -> new Color(2, 10, 0);
            case '%' -> new Color(2, 11, 0);
            default -> new Color(0, 0, 0);
        };
    }

    public char transformColorToText(Color color){
        return switch (color.getRed()){
            case 0 -> transformToLetter(color);
            case 1 -> transformToNumber(color);
            case 2 -> transformToSpecialSymbol(color);
            default -> ' ';
        };
    }

    private char transformToSpecialSymbol(Color color) {
        return switch (color.getGreen()){
            case 1 -> ' ';
            case 2 -> '\n';
            case 3 -> '.';
            case 4 -> ',';
            case 5 -> '/';
            case 6 -> '?';
            case 7 -> '!';
            case 8 -> '@';
            case 9 -> '#';
            case 10 -> '$';
            case 11 -> '%';
            default -> ' ';
        };
    }

    private char transformToNumber(Color color) {
        return switch (color.getGreen()){
            case 1 -> '1';
            case 2 -> '2';
            case 3 -> '3';
            case 4 -> '4';
            case 5 -> '5';
            case 6 -> '6';
            case 7 -> '7';
            case 8 -> '8';
            case 9 -> '9';
            case 10 -> '0';
            default -> ' ';
        };
    }

    private char transformToLetter(Color color) {
        if (color.getGreen() == 0) {
            return switch (color.getBlue()) {
                case 1 -> 'A';
                case 2 -> 'B';
                case 3 -> 'C';
                case 4 -> 'D';
                case 5 -> 'E';
                case 6 -> 'F';
                case 7 -> 'G';
                case 8 -> 'H';
                case 9 -> 'I';
                case 10 -> 'J';
                case 11 -> 'K';
                case 12 -> 'L';
                case 13 -> 'M';
                case 14 -> 'N';
                case 15 -> 'O';
                case 16 -> 'P';
                case 17 -> 'Q';
                case 18 -> 'R';
                case 19 -> 'S';
                case 20 -> 'T';
                case 21 -> 'U';
                case 22 -> 'V';
                case 23 -> 'W';
                case 24 -> 'X';
                case 25 -> 'Y';
                case 26 -> 'Z';
                default -> ' ';
            };
        } else {
            return switch (color.getGreen()) {
                case 1 -> 'a';
                case 2 -> 'b';
                case 3 -> 'c';
                case 4 -> 'd';
                case 5 -> 'e';
                case 6 -> 'f';
                case 7 -> 'g';
                case 8 -> 'h';
                case 9 -> 'i';
                case 10 -> 'j';
                case 11 -> 'k';
                case 12 -> 'l';
                case 13 -> 'm';
                case 14 -> 'n';
                case 15 -> 'o';
                case 16 -> 'p';
                case 17 -> 'q';
                case 18 -> 'r';
                case 19 -> 's';
                case 20 -> 't';
                case 21 -> 'u';
                case 22 -> 'v';
                case 23 -> 'w';
                case 24 -> 'x';
                case 25 -> 'y';
                case 26 -> 'z';
                default -> ' ';
            };
        }
    }

}
