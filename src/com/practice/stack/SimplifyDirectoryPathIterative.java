package com.practice.stack;

import java.util.Stack;

/**
 * 
Simplify Directory Path
Given a string A representing an absolute path for a file (Unix-style).
Return the string A after simplifying the absolute path.

Note:
	Absolute path always begin with '/' ( root directory ).
	Path will not have whitespace characters.


Input Format
	The only argument given is string A.
Output Format
	Return a string denoting the simplified absolue path for a file (Unix-style).
	For Example

Input 1:
    A = "/home/"
Output 1:
    "/home"

Input 2:
    A = "/a/./b/../../c/"
Output 2:
    "/c"
 * 
 * 
 * @author Barun
 *
 */

public class SimplifyDirectoryPathIterative {

	public static void main(String[] args) {
		System.out.println(simplifyPath("/a/./b/../../c/"));
		System.out.println(simplifyPath("/./.././ykt/xhp/nka/eyo/blr/emm/xxm/fuv/bjg/./qbd/./../pir/dhu/./../../wrm/grm/ach/jsy/dic/ggz/smq/mhl/./../yte/hou/ucd/vnn/fpf/cnb/ouf/hqq/upz/akr/./pzo/../llb/./tud/olc/zns/fiv/./eeu/fex/rhi/pnm/../../kke/./eng/bow/uvz/jmz/hwb/./././ids/dwj/aqu/erf/./koz/.."));
	}
	
	public static String simplifyPath(String A) {
		if(A.equals("/../") || A.equals("/..") || A.equals("/.")) {
        	return "/";
        }
		Stack<String> dirStack = new Stack<String>();
        
		String[] directories = A.split("/");
		for (String dir : directories) {
			if(dir.equals(".") || dir.equals("")) { // case - /./ or /a//c
				continue;
			}else if(dir.equals("..")) {
				if(!dirStack.isEmpty()) {
					dirStack.pop();
				}
			}else {//it a directory
				dirStack.push(dir);
			}
		}
		
		//dirStack has the result but in reversed order
		Stack<String> tempDirStack = new Stack<String>();
		while(!dirStack.isEmpty()) {
			tempDirStack.push(dirStack.pop());
		}
		
		
		StringBuilder resultSB = new StringBuilder();
		while(!tempDirStack.isEmpty()) {
			resultSB.append("/").append(tempDirStack.pop());
		}
		
		return resultSB.toString();
		
    }
    
}
