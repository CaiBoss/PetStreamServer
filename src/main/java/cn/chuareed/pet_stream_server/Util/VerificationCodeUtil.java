package cn.chuareed.pet_stream_server.Util;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

/**
 * @author ： Gavin C
 * @date ： Created in 2021/1/18 16:13
 * @description ： 验证码生成工具类
 */
public class VerificationCodeUtil {
    private final int WIDTH = 100;      //生成验证码图片的宽度
    private final int HEIGHT = 30;      //生成验证码图片的高度
    private final String[] FONT_NAMES = {"宋体", "楷体", "隶书", "微软雅黑"};
    private final Color BG_COLOR = new Color(255, 255, 255);   //定义验证码图片的背景颜色为白色
    private final Random RANDOM = new Random();

    private String text;                //记录随机字符串

    /**
     * @return BufferedImage 验证码图片
     * @author Gavin C
     * @date 2021/1/18 16:18
     * @description 绘制Image
     */
    public BufferedImage getImage() {
        BufferedImage image = createBlankImage();
        Graphics2D g2 = (Graphics2D) image.getGraphics();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            String s = getRandomChar() + "";
            stringBuilder.append(s);
            g2.setColor(getRandomColor());
            g2.setFont(getRandomFont());
            float x = i * WIDTH * 1.0f / 4;
            g2.drawString(s, x, HEIGHT - 8);
        }
        this.text = stringBuilder.toString();
        drawLine(image);
        return image;
    }

    /**
     * @return String 验证码字符串
     * @author Gavin C
     * @date 2021/1/18 16:30
     * @description 获取验证码字符串
     */
    public String getText() {
        return text;
    }

    /**
     * @param image 验证码图片
     * @param out   预想是Response的输出流
     * @author Gavin C
     * @date 2021/1/18 16:30
     * @description 输出验证码图片
     */
    public void output(BufferedImage image, OutputStream out) throws IOException {
        ImageIO.write(image, "JPEG", out);
    }

    /**
     * @return Color 随机颜色
     * @author Gavin C
     * @date 2021/1/18 16:15
     * @description 获取一个任意颜色
     */
    private Color getRandomColor() {
        int red = RANDOM.nextInt(150);
        int green = RANDOM.nextInt(150);
        int blue = RANDOM.nextInt(150);
        return new Color(red, green, blue);
    }

    /**
     * @return Font 随机字体
     * @author Gavin C
     * @date 2021/1/18 16:16
     * @description 获取一个任意的字体
     */
    private Font getRandomFont() {
        String name = FONT_NAMES[RANDOM.nextInt(FONT_NAMES.length)];
        int style = RANDOM.nextInt(4);
        int size = RANDOM.nextInt(5) + 24;
        return new Font(name, style, size);
    }

    /**
     * @return char 随机字符
     * @author Gavin C
     * @date 2021/1/18 16:17
     * @description 获取一个随机字符
     */
    private char getRandomChar() {
        String codes = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        return codes.charAt(RANDOM.nextInt(codes.length()));
    }

    /**
     * @return BufferedImage
     * @author Gavin C
     * @date 2021/1/18 16:18
     * @description 创建一个空白的BufferedImage对象
     */
    private BufferedImage createBlankImage() {
        BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2 = (Graphics2D) image.getGraphics();
        g2.setColor(BG_COLOR);// 设置验证码图片的背景颜色
        g2.fillRect(0, 0, WIDTH, HEIGHT);
        return image;
    }

    /**
     * @param image 未绘制干扰线的验证码图片
     * @author Gavin C
     * @date 2021/1/18 16:22
     * @description 绘制干扰线
     */
    private void drawLine(BufferedImage image) {
        Graphics2D g2 = (Graphics2D) image.getGraphics();
        int num = 5;
        for (int i = 0; i < num; i++) {
            int x1 = RANDOM.nextInt(WIDTH);
            int y1 = RANDOM.nextInt(HEIGHT);
            int x2 = RANDOM.nextInt(WIDTH);
            int y2 = RANDOM.nextInt(HEIGHT);
            g2.setColor(getRandomColor());
            g2.setStroke(new BasicStroke(1.5f));
            g2.drawLine(x1, y1, x2, y2);
        }
    }
}
