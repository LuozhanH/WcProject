package com.lzh.command;

import java.io.FileInputStream;
import java.io.IOException;

public class StringCount {
	public static int words = 1;
	public static int lines = 1;
	public static int chars = 0;
	
	// 算法实现函数
	public static void wc(String p) throws IOException {
		FileInputStream f = new FileInputStream(p);
		int c = 0;
		while ((c = f.read()) != -1) {
			chars++;
			if(c == '\n') {
				lines++;
			}
		}
		System.out.println("[result] 输出的结果为：");
		System.out.println("[print]  字符数：" + (chars - (lines-1)*2));
	}
}
