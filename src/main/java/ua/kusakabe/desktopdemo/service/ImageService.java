package ua.kusakabe.desktopdemo.service;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class ImageService {

    TransformService transformService = new TransformService();

    public BufferedImage loadFile(String absolutePath) {
        try{
            File file = new File(absolutePath);
            return ImageIO.read(file);
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Color> generateColorScheme(String text){
        ArrayList<Color> colorList = new ArrayList<>();

        for(char c : text.toCharArray()) {
            Color color = transformService.transformTextToColor(c);
            colorList.add(color);
        }
        return colorList;
    }

    public BufferedImage writeImage(ArrayList<Color> colorList){

        double sqrt = Math.sqrt(colorList.size());
        int roundSqrt = (int)Math.ceil(sqrt);

        BufferedImage image = new BufferedImage(roundSqrt, roundSqrt, BufferedImage.TYPE_INT_RGB);

        int row = 0;
        int col = 0;
        int colIndex = 0;
        while(colIndex < colorList.size()) {
            if(col != roundSqrt) {
                Color color = colorList.get(colIndex);
                image.setRGB(col, row, color.getRGB());
                colIndex++;
                col++;
            } else {
                row++;
                col = 0;
            }
        }
        return image;
    }

    public void saveFile(BufferedImage image, String absolutePath){
        try {
            File outputfile = new File(absolutePath);
            ImageIO.write(image, "png", outputfile);
            System.out.println("Image written successfully.");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String decodeImage(BufferedImage image){
        ArrayList<Character> charList = new ArrayList<>();
        for(int y = 0; y < image.getHeight(); y++){
            for(int x = 0; x < image.getWidth(); x++){
                int rgb = image.getRGB(x, y);

                int red = (rgb >> 16) & 0xff;
                int green = (rgb >> 8) & 0xff;
                int blue = rgb & 0xff;

                Color color = new Color(red, green, blue);
                char c = transformService.transformColorToText(color);
                charList.add(c);
            }
        }
        String decodedString = "";
        StringBuilder stringBuilder = new StringBuilder(decodedString);
        for(char c : charList){
            stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }

}
