package ImageCompression;

import java.io.*;
import java.util.*;
import java.awt.image.*;

import javax.imageio.*;
import javax.imageio.stream.ImageOutputStream;

class Compression {

    public static void main(String[] args) throws IOException {
        File input = new File("/home/vedantu/GitHub/MyCodes/src/ImageCompression/digital_image_processing.jpg");
        BufferedImage image = ImageIO.read(input);

        File compressedImageFile = new File("/home/vedantu/GitHub/MyCodes/src/ImageCompression/digital_image_processing.jpg");
        OutputStream os =new FileOutputStream(compressedImageFile);

        Iterator<ImageWriter>writers =  ImageIO.getImageWritersByFormatName("jpg");
        ImageWriter writer = writers.next();

        ImageOutputStream ios = ImageIO.createImageOutputStream(os);
        writer.setOutput(ios);

        ImageWriteParam param = writer.getDefaultWriteParam();
        param.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
        param.setCompressionQuality(0.25f);

        writer.write(null, new IIOImage(image, null, null), param);

        os.close();
        ios.close();
        writer.dispose();
    }
}