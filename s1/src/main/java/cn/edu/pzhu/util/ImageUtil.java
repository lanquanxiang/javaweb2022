package cn.edu.pzhu.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.UnsupportedEncodingException;
import java.security.SecureRandom;


public class ImageUtil {
	private String ans;
	private BufferedImage image;
	public ImageUtil(String cn) {
		if(cn==null) {
			init();
		}else{
			initCN();
		}
	}
	public String getAns() {
		return ans;
	}
	public BufferedImage getImage() {
		return image;
	}
	/**
	 * 初始化验证码
	 */
	private void init() {
		BufferedImage img = new BufferedImage(100, 25, BufferedImage.TYPE_INT_RGB);
		Graphics g = img.getGraphics();//得到画笔
		g.setColor(Color.white);
		g.fillRect(0, 0, 100, 25); //将整个图填充为白色
		
		g.setColor(Color.black); //用黑色来写字
		
		SecureRandom random = new SecureRandom();
		for (int i = 0; i < 5; i++) {
			int x1 = random.nextInt(20);
			int y1 = random.nextInt(25);
			int x2 = random.nextInt(60, 100);
			int y2 = random.nextInt(25);
			g.drawLine(x1, y1, x2, y2);
		}
		g.setFont(new Font("Times new Roman", Font.BOLD, 20)); //加粗绘制验证码
		//0,1,i,l,o
		char[] eles = "qwertyupasdfghjkzxcvbnmQWERTYUPASDFGHJZXCVBNMK23456789".toCharArray();
		String key = "";
		
		for (int i = 0; i < 4; i++) {
			int index = random.nextInt(eles.length); //[0,length)
			key+= eles[index];
		}
		ans = key;
		g.drawString(key, 10, 20);
		image = img;
		
	}
	/**
	 * 初始化中文验证码
	 */
	private void initCN() {
		BufferedImage img = new BufferedImage(100, 25, BufferedImage.TYPE_INT_RGB);
		Graphics g = img.getGraphics();//得到画笔
		g.setColor(Color.white);
		g.fillRect(0, 0, 100, 25); //将整个图填充为白色
		
		g.setColor(Color.black); //用黑色来写字
		
		SecureRandom random = new SecureRandom();
		for (int i = 0; i < 5; i++) {
			int x1 = random.nextInt(20);
			int y1 = random.nextInt(25);
			int x2 = random.nextInt(60, 100);
			int y2 = random.nextInt(25);
			g.drawLine(x1, y1, x2, y2);
		}
		g.setFont(new Font("宋体", Font.BOLD, 20)); //加粗绘制验证码
		
		String key = "";
		
		
		for (int i = 0; i < 4; i++) {
			byte[] ans = new byte[2]; //使用两个字节来表示汉字
			int index = random.nextInt(3755); //随机一级汉字的下标 0-3755
			int h  = index/94+Integer.valueOf("B0", 16);
			int l = index%94 + Integer.valueOf("A1", 16);
			ans[0] = Integer.valueOf(h).byteValue(); //将十进制转换为区码字节
			ans[1] = Integer.valueOf(l).byteValue();
			
			try {
				String temp = new String(ans, "GB2312");
				key += temp;
			} catch (UnsupportedEncodingException e) {
				key += "";
			}
			
		}
		ans = key;
		System.out.println(key);
		g.drawString(key, 10, 20);
		image = img;
		
	}
	
	
	

}
