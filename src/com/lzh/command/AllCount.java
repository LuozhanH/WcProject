package com.lzh.command;

import java.io.FileInputStream;
import java.io.IOException;

public class AllCount {
	public static int words = 1;
	public static int lines = 1;
	public static int chars = 0;
	
	// �㷨ʵ�ֺ���
	public static void wc(String p) throws IOException {
		// �����ƶ�ȡ
		FileInputStream f = new FileInputStream(p);
		int c = 0;
		// �����ж��Ƿ�Ϊһ������ ǰ��ո�
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
		System.out.println("[result] ����Ľ��Ϊ��");
		System.out.println("[print]  ������" + lines);
		System.out.println("[print]  ��������" + words);
		System.out.println("[print]  �ַ�����" + (chars - (lines-1)*2));
	}
}
