package com.lzh.command;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CodeCounter {
	// ��ʼ�������������С�ע���С�����
	private static Integer code = 0;
    private static Integer codeComments = 0;
    private static Integer codeBlank = 0;
    
    public static void code(String src) {
        File file = new File(src);
        factFiles(file);
        System.out.println("[result] ����Ľ��Ϊ��");
        System.out.println("[print]  ����������" + code);
        System.out.println("[print]  �հ�������" + codeBlank);
        System.out.println("[print]  ע��������" + codeComments);
    }
    
    public static void factFiles(File file) {
        BufferedReader br = null;
        String s = null;
        
        // �����һ��Ŀ¼ ��ݹ�Ѱ�ҵ��·��ϵ��ļ�
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
                	// �ж��Ƿ�Ϊע����(��ʼ)
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
                     // �ж��Ƿ�Ϊע����(����)
                    } else if(s.trim().length() < 1) {
                    	// �ж�ȥ���ո�֮��ʣ����ַ������С��1����Ϊ����
                        codeBlank++;
                    } else {
                    	// ���հ��к�ע�����⣬�����Ϊ������
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
