package com.example.demo.config;
import java.net.URL;
import javax.imageio.ImageIO;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageUtil {
    public void save(String path) throws IOException {
        URL url = new URL(path);
        String fileName = path.substring(path.lastIndexOf("/") + 1);
        String fileExt = path.substring(path.lastIndexOf(".") + 1);

        BufferedImage img = ImageIO.read(url);
        ImageIO.write(img, fileExt, new File(fileName));

    }
}
