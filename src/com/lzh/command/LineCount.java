package com.lzh.command;

import java.io.FileInputStream;
import java.io.IOException;

public class LineCount {
	public static int lines = 1;
	
	// �㷨ʵ�ֺ���
	public static void wc(String p) throws IOException {
		FileInputStream f = new FileInputStream(p);
		int c = 0;
		while ((c = f.read()) != -1) {
			if(c == '\n') {
				lines++;
			}
		}
		System.out.println("[result] ����Ľ��Ϊ��");
		System.out.println("[print]  ������" + lines);
	}
}
