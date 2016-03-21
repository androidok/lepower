package com.lepower.utils;

import java.math.BigDecimal;

public class DataFormatUtil {
	
	
	
	public static String formatData(String dataString){
		if(dataString.equals("")){
			return "0";
		}
		if(!dataString.contains(".")){
			return dataString;
		}else{
			double dataDouble=Double.valueOf(dataString);
			BigDecimal bdBigDecimal=new BigDecimal(dataDouble);
			double dataDoubleResult=bdBigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
			return dataDoubleResult+"";//返回字符串
		}
		
	}
	
	
	
	
//	{"resCode":0,"resMsg":"","data":
//		[{"sportCal":"","sportCount":"0","sportDis":"","sportNum":"","sportSteps":"","sportTime":"","type":"run","userId":"","userName":""},
//		 {"sportCal":"2.4488848","sportCount":"4","sportDis":"35.239999999999995","sportNum":"","sportSteps":"185","sportTime":"103507","type":"walk","userId":"","userName":""},
//		 {"sportCal":"621.48","sportCount":"5","sportDis":"8.57","sportNum":"","sportSteps":"","sportTime":"1.67","type":"bike","userId":"","userName":""},
//		 {"sportCal":"","sportCount":"0","sportDis":"","sportNum":"","sportSteps":"","sportTime":"","type":"pushup","userId":"","userName":""},
//		 {"sportCal":"1.7404000000000002","sportCount":"7","sportDis":"","sportNum":"19","sportSteps":"","sportTime":"","type":"jump","userId":"","userName":""},
//		 {"sportCal":"","sportCount":"0","sportDis":"","sportNum":"","sportSteps":"","sportTime":"","type":"situp","userId":"","userName":""}
//		 ]}
}
