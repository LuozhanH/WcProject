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
			System.out.println("[result] 这是一个文件夹：" + file.getPath());
			// 递归输出里面的文件
            File[] files = file.listFiles();
            for(File f : files) {
            	selectFiles(f);
            }
        } else {
        	if (file.exists()) {
    			System.out.println("\n[result] 输出的结果为：");
    			System.out.println("[print]  FileName:" + file.getName());
    			System.out.println("[print]  FilePath:" + file.getPath());
    			System.out.println("[print]  文件可读性:" + file.canRead());
    			System.out.println("[print]  文件可写性:" + file.canWrite());
    		} else {
    			if (!file.isFile()) {
    				System.out.println("[error] 这不是个正确或完整的文件名!!!");
    			} else {
    				System.out.println("[error] 找不到文件!!!");
    			}
    		}
        }
    }
}
