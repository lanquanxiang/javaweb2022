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
			init();//初始化验证码
		}else {
			initCN();//初始化中文验证码
		}
		
	}
	private void init() {
		BufferedImage img = new BufferedImage(100, 25, BufferedImage.TYPE_INT_RGB);
		Graphics g = img.getGraphics();//得到画笔
		//画背景
		g.setColor(Color.white);
		g.fillRect(0, 0, 100, 25);
		//画字
		g.setColor(Color.black);
		
		SecureRandom random = new SecureRandom();
		
		//随机生成干扰
		for (int i = 0; i < 5; i++) {
			int x1 = random.nextInt(30);
			int y1 = random.nextInt(25);
			int x2 = random.nextInt(70,100);
			int y2 = random.nextInt(25);
			g.drawLine(x1, y1, x2, y2);
		}
		
		
		
		char[] eles = "23456789qwertyupasdfghjkmnbvcxzQWERTYUPKJHGFDSAZXCVBNM".toCharArray();
		String key = "";
		for (int i = 0; i < 4; i++) {
			int index = random.nextInt(eles.length);//随机一个数组下标
			key+=eles[index];
		}
		g.setFont(new Font("Times new Roman", Font.BOLD, 20));
		g.drawString(key, 10, 20);
		ans = key;
		image = img;
		
	}
	public String getAns() {
		return ans;
	}
	public BufferedImage getImage() {
		return image;
	}
	
	
	private void initCN() {
		BufferedImage img = new BufferedImage(100, 25, BufferedImage.TYPE_INT_RGB);
		Graphics g = img.getGraphics();//得到画笔
		//画背景
		g.setColor(Color.white);
		g.fillRect(0, 0, 100, 25);
		//画字
		g.setColor(Color.black);
		
		SecureRandom random = new SecureRandom();
		
		//随机生成干扰
		for (int i = 0; i < 5; i++) {
			int x1 = random.nextInt(30);
			int y1 = random.nextInt(25);
			int x2 = random.nextInt(70,100);
			int y2 = random.nextInt(25);
			g.drawLine(x1, y1, x2, y2);
		}
		
		
		
		
		String key = "";
		for (int i = 0; i < 4; i++) {
			byte[] bytes = new byte[2];//使用双字节表示汉字
			int index = random.nextInt(3755);//随机一级汉字3755个的下标
			int h = index / 94 + Integer.valueOf("B0", 16); //区码
			int l = index % 94 + Integer.valueOf("A1", 16); //位码
			bytes[0] = Integer.valueOf(h).byteValue();
			bytes[1] = Integer.valueOf(l).byteValue();
			
			try {
				String f = new String(bytes,"GB2312");
				key+=f;//将随机的汉字拼接到key中
			} catch (UnsupportedEncodingException e) {
				key+="";
			}
		}
		System.out.println(key);//测试生产的汉字
		g.setFont(new Font("宋体", Font.BOLD, 20));
		g.drawString(key, 10, 20);
		ans = key;
		image = img;
		
	}
	

}
