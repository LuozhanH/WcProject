package com.lzh.command;
import java.io.*;

public class WordCount {
	public static int words = 1;
	
	// 算法实现函数
	public static void wc(String p) throws IOException {
		FileInputStream f = new FileInputStream(p);
		int c = 0;
		boolean lastNoWhite = false;
		String whiteSpace = " \t\n\r";
		while ((c = f.read()) != -1) {
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
		System.out.println("[print]  单词数：" + words);
	}
}
