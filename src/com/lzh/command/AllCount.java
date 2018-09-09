package com.lzh.command;

import java.io.FileInputStream;
import java.io.IOException;

public class AllCount {
	public static int words = 1;
	public static int lines = 1;
	public static int chars = 0;
	
	// 算法实现函数
	public static void wc(String p) throws IOException {
		// 二进制读取
		FileInputStream f = new FileInputStream(p);
		int c = 0;
		// 用来判断是否为一个单词 前后空格
		boolean lastNoWhite = false;
		String whiteSpace = " \t\n\r";
		while ((c = f.read()) != -1) {
			chars++;
			if(c == '\n') {
				lines++;
			}
			if(whiteSpace.indexOf(c) != -1) {
				if(lastNoWhite) {
					words++;
				}
				lastNoWhite = false;
			} else {
				lastNoWhite = true;
			}
		}
		System.out.println("[result] 输出的结果为：");
		System.out.println("[print]  行数：" + lines);
		System.out.println("[print]  单词数：" + words);
		System.out.println("[print]  字符数：" + (chars - (lines-1)*2));
	}
}
