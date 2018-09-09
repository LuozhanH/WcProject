package com.lzh.command;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class FindFile {
	public static void findFile(String p) {
        
		File dir = new File(p);
		
		selectFiles(dir);
	}
	
	public static void selectFiles(File file) {
		if(file.isDirectory()) {
			System.out.println("[result] ����һ���ļ��У�" + file.getPath());
			// �ݹ����������ļ�
            File[] files = file.listFiles();
            for(File f : files) {
            	selectFiles(f);
            }
        } else {
        	if (file.exists()) {
    			System.out.println("\n[result] ����Ľ��Ϊ��");
    			System.out.println("[print]  FileName:" + file.getName());
    			System.out.println("[print]  FilePath:" + file.getPath());
    			System.out.println("[print]  �ļ��ɶ���:" + file.canRead());
    			System.out.println("[print]  �ļ���д��:" + file.canWrite());
    		} else {
    			if (!file.isFile()) {
    				System.out.println("[error] �ⲻ�Ǹ���ȷ���������ļ���!!!");
    			} else {
    				System.out.println("[error] �Ҳ����ļ�!!!");
    			}
    		}
        }
    }
}
