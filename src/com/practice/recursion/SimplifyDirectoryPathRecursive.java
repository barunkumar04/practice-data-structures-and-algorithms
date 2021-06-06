package com.practice.recursion;

// DO NOT USE THIS APPOROACH. Instead this is a neat approeach - 
public class SimplifyDirectoryPathRecursive {

	public static void main(String[] args) {
		System.out.println(simplifyPath("/a/./b/../../c/"));
		System.out.println(simplifyPath("/./.././ykt/xhp/nka/eyo/blr/emm/xxm/fuv/bjg/./qbd/./../pir/dhu/./../../wrm/grm/ach/jsy/dic/ggz/smq/mhl/./../yte/hou/ucd/vnn/fpf/cnb/ouf/hqq/upz/akr/./pzo/../llb/./tud/olc/zns/fiv/./eeu/fex/rhi/pnm/../../kke/./eng/bow/uvz/jmz/hwb/./././ids/dwj/aqu/erf/./koz/.."));
	}
	
	public static String simplifyPath(String A) {
        String result = "";
        result = simplifyPathRec(A, 1, result);
        return result;
    }
    
    private static String simplifyPathRec(String A, int index, String result){
        if(A.equals("/../") || A.equals("/..") || A.equals("/.")) {
        	return "/";
        }
    	if(index >= A.length()){
            return result;
        }
        
    	int i = A.indexOf('/', index);
    	String strBetweenTwoSlash = null;
    	if(i == -1 ) {
    		strBetweenTwoSlash = A.substring(index, A.length());
    		i=A.length();
		}else {
			strBetweenTwoSlash = A.substring(index, i);
		}
        
        if(strBetweenTwoSlash.equals("")) {
        	return simplifyPathRec(A, i+1, result);
        }else if(strBetweenTwoSlash.equals("."))
             return simplifyPathRec(A, i+1, result);
        else if(strBetweenTwoSlash.equals("..")){
            int j = result.length()-1;
            for(;j>=0;j--){
                if(result.charAt(j) == '/'){
                    break;
                }
            }
            if(j != -1)
            	result = result.substring(0, j);
            return simplifyPathRec(A, i+1, result);
        }else{
             return simplifyPathRec(A, i+1, result+"/"+strBetweenTwoSlash);
        }
        
        
    }
}
