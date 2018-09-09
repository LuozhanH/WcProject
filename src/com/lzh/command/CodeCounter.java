package com.lzh.command;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CodeCounter {
	// 初始化变量：代码行、注释行、空行
	private static Integer code = 0;
    private static Integer codeComments = 0;
    private static Integer codeBlank = 0;
    
    public static void code(String src) {
        File file = new File(src);
        factFiles(file);
        System.out.println("[result] 输出的结果为：");
        System.out.println("[print]  代码行数：" + code);
        System.out.println("[print]  空白行数：" + codeBlank);
        System.out.println("[print]  注释行数：" + codeComments);
    }
    
    public static void factFiles(File file) {
        BufferedReader br = null;
        String s = null;
        
        // 如果是一个目录 则递归寻找底下符合的文件
        if(file.isDirectory()) {
            File[] files = file.listFiles();
            for(File f : files) {
                factFiles(f);
            }
        } else {
            try {
                br = new BufferedReader(new FileReader(file));
                boolean comm = false;
                while((s = br.readLine()) != null) {
                	// 判断是否为注释行(开始)
                    if(s.startsWith("/*") && s.endsWith("*/")) {
                        codeComments++;
                    } else if(s.trim().startsWith("//")) {
                        codeComments++;
                    } else if(s.startsWith("/*") && !s.endsWith("*/")) {
                        codeComments++;
                        comm = true;
                    } else if(!s.startsWith("/*") && s.endsWith("*/")) {
                        codeComments++;
                        comm = false;
                    } else if(comm) {
                        codeComments++;
                     // 判断是否为注释行(结束)
                    } else if(s.trim().length() < 1) {
                    	// 判断去掉空格之后剩余的字符数如果小于1，则为空行
                        codeBlank++;
                    } else {
                    	// 除空白行和注释行外，其余皆为代码行
                        code++;
                    }
                }
                br.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
