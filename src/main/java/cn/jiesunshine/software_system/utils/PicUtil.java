package cn.jiesunshine.software_system.utils;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class PicUtil {
	public static int HEAD_WIDTH=120;
	/***
	 * 通过width图片重置尺寸（保持纵横比），如果图片宽度小于指定宽度就拉伸
	 * @param is
	 * @param path
	 * @param size
	 * @param format
	 * @return
	 * @throws IOException
	 */
	public static boolean resizeAndSaveImage(InputStream is , String path, int size, String format) throws IOException {  
	    BufferedImage prevImage = ImageIO.read(is);  
	    double width = prevImage.getWidth();  
	    double height = prevImage.getHeight();  
	    double percent = size/width;  
	    int newWidth = (int)(width * percent);  
	    int newHeight = (int)(height * percent);  
	    BufferedImage image = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_BGR);  
	    Graphics graphics = image.createGraphics();  
	    graphics.drawImage(prevImage, 0, 0, newWidth, newHeight , Color.WHITE, null);  
	    return ImageIO.write(image, format , new File(path));  
	}  
	/***
	 * 通过height图片重置尺寸（保持纵横比），如果图片高度小于指定高度就不处理
	 * @param is
	 * @param path
	 * @param size
	 * @param format
	 * @return
	 * @throws IOException
	 */
	public static boolean resizeAndSaveImageForHeight(InputStream is , String path, int size, String format) throws IOException {
		BufferedImage prevImage = ImageIO.read(is);  
	    double width = prevImage.getWidth();  
	    double height = prevImage.getHeight();  
	    double percent = size/height;  
	    if (percent>=1)
	    	return false;
	    int newWidth = (int)(width * percent);  
	    int newHeight = (int)(height * percent);  
	    BufferedImage image = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_BGR);  
	    Graphics graphics = image.createGraphics();  
	    graphics.drawImage(prevImage, 0, 0, newWidth, newHeight , Color.WHITE, null);  
	    return ImageIO.write(image, format , new File(path));  
	}
	public static boolean resizeAndSaveImageForHead(InputStream is , String path, int size, String format) throws IOException {
		BufferedImage prevImage = ImageIO.read(is);  
	    double width = prevImage.getWidth();  
	    double height = prevImage.getHeight();  
	    double percent = 1;
	    if (width>height)
	    	percent = size/width; 
	    else 
	    	percent = size/height; 
	    int newWidth = (int)(width * percent);  
	    int newHeight = (int)(height * percent);  
	    BufferedImage image = new BufferedImage(size, size, BufferedImage.TYPE_INT_BGR);  
	    Graphics graphics = image.createGraphics();  
	    graphics.setColor(Color.WHITE);
	    graphics.fillRect(0,0,size,size);
	    graphics.drawImage(prevImage, (size-newWidth)/2 , (size-newHeight)/2, newWidth, newHeight , Color.WHITE, null);  
	    return ImageIO.write(image, format , new File(path));  
	}
}
