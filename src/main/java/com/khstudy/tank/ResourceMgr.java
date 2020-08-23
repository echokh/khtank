package main.java.com.khstudy.tank;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

public class ResourceMgr {
    private ResourceMgr() {
    }

    private static final ResourceMgr INSTANCE = new ResourceMgr();

    public static ResourceMgr getInstance() {
        return INSTANCE;
    }

    public static BufferedImage tankL, tankU, tankR, tankD;
    public static BufferedImage bulletL, bulletU, bulletR, bulletD;
    public static BufferedImage[] explode = new BufferedImage[16];

    static {
        try {
            tankL = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("main/java/images/tankL.gif"));
            tankU = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("main/java/images/tankU.gif"));
            tankR = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("main/java/images/tankR.gif"));
            tankD = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("main/java/images/tankD.gif"));
            bulletL = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("main/java/images/bulletL.gif"));
            bulletU = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("main/java/images/bulletU.gif"));
            bulletR = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("main/java/images/bulletR.gif"));
            bulletD = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("main/java/images/bulletD.gif"));
            for (int i = 0; i < 16; i++) {
                explode[i] = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("main/java/images/e" + (i + 1) + ".gif"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
