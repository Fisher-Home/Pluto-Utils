package com.fisher.interfacetest.utils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by Fisher on 10/16/2015.
 */
public class DataStream {

	public static String getString(InputStream in, String charset){
		StringBuilder sb=new StringBuilder(  );
		try{
			BufferedReader br=new BufferedReader( new InputStreamReader( in, charset ) );
			String line;
			while ( (line=br.readLine())!=null ){
				sb.append( line );
			}
		}catch ( Exception e ){
			e.printStackTrace();
		}
		return sb.toString();
	}
}
