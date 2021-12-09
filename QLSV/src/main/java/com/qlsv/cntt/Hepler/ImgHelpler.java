/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlsv.cntt.Hepler;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author NguyenCongPC
 */
public class ImgHelpler {
    public static Image resize(Image image, int targetWidth, int targetHeight){
        Image rsImg = image.getScaledInstance(targetWidth, targetHeight, Image.SCALE_SMOOTH);
        return rsImg;
    }
    
    public static byte[] toByte(Image img, String type) throws IOException{
        BufferedImage bimage = new BufferedImage(img.getWidth(null), 
                img.getHeight(null), BufferedImage.TYPE_INT_RGB);
        Graphics2D g = bimage.createGraphics();
        g.drawImage(img, 0, 0, null);
        g.dispose();
        
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(bimage, type, baos);
        
        byte[] imgInByte = baos.toByteArray();
        
        return imgInByte;
    }
    
    public static Image createImgFromByteArray(byte[] data, String type) throws IOException{
        ByteArrayInputStream bais = new ByteArrayInputStream(data);
        BufferedImage bi = ImageIO.read(bais);
        Image img = bi.getScaledInstance(bi.getWidth(), bi.getHeight(), Image.SCALE_SMOOTH);
        return img;
    }
}
