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
			
			// 输出面板
            System.out.println("\n---------------------3116005151 WC程序---------------------");
            System.out.println("|			  	    			  |");
            System.out.println("| 	      -all [文件路径]  返回字符数、单词数、行数         |");
            System.out.println("| 		-c [文件路径]  返回文件字符数  	          |");
            System.out.println("| 		-w [文件路径]  返回文件词的数目  	      	  |");
            System.out.println("| 		-l [文件路径]  返回文件行数		  |");
            System.out.println("| 		-s [文件夹路径/文件路径]  搜索文件名	  |");
            System.out.println("| 		-a [文件路径]  统计代码行/空行/注释行	  |");
            System.out.println("|			  	    			  |");
            System.out.println("-----------------------------------------------------------");
            
            // 获取输入指令
            System.out.print("[Please...] 请输入命令：");
            Scanner s = new Scanner(System.in);
            String m = s.nextLine();
            String arr[]= m.split("\\s");
            
            // 根据获取指令来执行函数
            try {
                switch (arr[0]){
                	case "-all": AllCount.wc(arr[1]);break; 	//返回字符数、单词数、行数
	                case "-c": StringCount.wc(arr[1]);break; 	//返回文件字符数
	                case "-w": WordCount.wc(arr[1]);break; 		//返回文件单词数目
	                case "-l": LineCount.wc(arr[1]);break;      //返回文件行数
	                case "-s": FindFile.findFile(arr[1]);break; 		//搜索文件名
	                case "-a": CodeCounter.code(arr[1]);break;    //统计代码行 / 空行 / 注释行
	                default: System.out.println("\n********  不存在该功能指令哟(＾Ｕ＾)ノ~ＹＯ！！！  **********");break;
                }
			} catch (FileNotFoundException e) {
	            System.out.println("\n********  发生错误：输入路径文件找不到！！！  **********");
	        } catch (IOException e){
	            System.out.println("\n********  发生错误：文件读入发生异常！！！  **********");
	        }
        }
	}

}
