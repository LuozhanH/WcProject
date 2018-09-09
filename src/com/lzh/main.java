package com.lzh;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import com.lzh.command.AllCount;
import com.lzh.command.CodeCounter;
import com.lzh.command.FindFile;
import com.lzh.command.LineCount;
import com.lzh.command.StringCount;
import com.lzh.command.WordCount;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		while (true) {		
			
			// ������
            System.out.println("\n---------------------3116005151 WC����---------------------");
            System.out.println("|			  	    			  |");
            System.out.println("| 	      -all [�ļ�·��]  �����ַ�����������������         |");
            System.out.println("| 		-c [�ļ�·��]  �����ļ��ַ���  	          |");
            System.out.println("| 		-w [�ļ�·��]  �����ļ��ʵ���Ŀ  	      	  |");
            System.out.println("| 		-l [�ļ�·��]  �����ļ�����		  |");
            System.out.println("| 		-s [�ļ���·��/�ļ�·��]  �����ļ���	  |");
            System.out.println("| 		-a [�ļ�·��]  ͳ�ƴ�����/����/ע����	  |");
            System.out.println("|			  	    			  |");
            System.out.println("-----------------------------------------------------------");
            
            // ��ȡ����ָ��
            System.out.print("[Please...] ���������");
            Scanner s = new Scanner(System.in);
            String m = s.nextLine();
            String arr[]= m.split("\\s");
            
            // ���ݻ�ȡָ����ִ�к���
            try {
                switch (arr[0]){
                	case "-all": AllCount.wc(arr[1]);break; 	//�����ַ�����������������
	                case "-c": StringCount.wc(arr[1]);break; 	//�����ļ��ַ���
	                case "-w": WordCount.wc(arr[1]);break; 		//�����ļ�������Ŀ
	                case "-l": LineCount.wc(arr[1]);break;      //�����ļ�����
	                case "-s": FindFile.findFile(arr[1]);break; 		//�����ļ���
	                case "-a": CodeCounter.code(arr[1]);break;    //ͳ�ƴ����� / ���� / ע����
	                default: System.out.println("\n********  �����ڸù���ָ��Ӵ(�ޣգ�)��~�٣ϣ�����  **********");break;
                }
			} catch (FileNotFoundException e) {
	            System.out.println("\n********  ������������·���ļ��Ҳ���������  **********");
	        } catch (IOException e){
	            System.out.println("\n********  ���������ļ����뷢���쳣������  **********");
	        }
        }
	}

}
