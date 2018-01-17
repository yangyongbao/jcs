package com.yz.jcs.util;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HttpUtils {

	/**
	 * 生成签名
	 * @param method
	 * @param url
	 * @param params
	 * @param secretKey
	 * @return
	 */
	protected String generateSign(String method, String url, Map<String, Object> params,String secretKey) {
		List<Map.Entry<String, Object>> paramList = new ArrayList<Map.Entry<String, Object>>(params.entrySet());
		Collections.sort(paramList, new Comparator<Map.Entry<String, Object>>() {
			public int compare(Map.Entry<String, Object> o1, Map.Entry<String, Object> o2) {
				return ((String) o1.getKey()).toString().compareTo((String) o2.getKey());
			}
		});
		
		String paramStr = "";
		String md5Str = "";
		for (Map.Entry<String, Object> entry : paramList) {
			paramStr = paramStr + (String) entry.getKey() + "=" + entry.getValue().toString();
		}
		try {
			URL u = new URL(url);
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			String s = method + u.getHost() + u.getPath() + paramStr + secretKey;
			byte[] bArr = s.getBytes("UTF-8");
			byte[] md5Value = md5.digest(bArr);
			BigInteger bigInt = new BigInteger(1, md5Value);
			md5Str = bigInt.toString(16);
			while (md5Str.length() < 32) {
				md5Str = "0" + md5Str;
			}
		} catch (Exception e) {
			return "";
		}
		return md5Str;
	}

	/**
	 * HTTP请求
	 * @param url
	 * @param params
	 * @param method
	 * @return
	 */
	public static Map<String, String> callRestful(String url, Map<String, String> params,String method) {
		Map<String, String> ret = new HashMap<String, String>();
		ret.put("code", "-1");
		ret.put("msg", null);
		ret.put("result", null);

		try {
			URL u = new URL(url);
			HttpURLConnection conn = (HttpURLConnection) u.openConnection();
			if(method.equals("POST")) {
				conn.setRequestMethod("POST");
			}else {
				conn.setRequestMethod("GET");
			}
			conn.setConnectTimeout(10000);
			conn.setReadTimeout(5000);
			conn.setDoOutput(true);
			conn.setDoInput(true);
			conn.setUseCaches(false);
			

			if(method.equals("POST")) {
				StringBuffer param = new StringBuffer();
				for (String key : params.keySet()) {
					param.append(key).append("=").append(URLEncoder.encode(params.get(key).toString(), "UTF-8"))
							.append("&");
				}
				conn.getOutputStream().write(param.toString().getBytes("UTF-8"));
				conn.getOutputStream().flush();
				conn.getOutputStream().close();
			}
			
			StringBuffer response = new StringBuffer();
			
			InputStreamReader isr = new InputStreamReader(conn.getInputStream());
			BufferedReader br = new BufferedReader(isr);
			String temp;
			while ((temp = br.readLine()) != null) {
				response.append(temp);
			}
			ret.put("result", response.toString());
			ret.put("code", "1");
			br.close();
			isr.close();
			conn.disconnect();
		} catch (Exception e) {
			ret.put("msg", e.getMessage());
		}
		return ret;
	}
	
	
	public static void main(String[] args) {
		Map<String, String> rs = HttpUtils.callRestful("http://www.baidu.com", null, "GET");
		System.out.println(rs);
	}
	
	
	
	

}
