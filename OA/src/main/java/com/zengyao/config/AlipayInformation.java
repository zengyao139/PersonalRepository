package com.zengyao.config;

import javax.servlet.http.HttpServletRequest;

import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipaySystemOauthTokenRequest;
import com.alipay.api.request.AlipayUserInfoShareRequest;
import com.alipay.api.response.AlipaySystemOauthTokenResponse;
import com.alipay.api.response.AlipayUserInfoShareResponse;
import com.zengyao.util.AlipayUser;
import com.zengyao.util.ExcelUtil;
public class AlipayInformation {

	private AlipayClient alipayClient=null;
	
	public void init() {
		alipayClient=new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id, AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key, AlipayConfig.sign_type);
	}
	
	
	
	//根据auth_code获取用户的user_Id和access_token
	public String getAccess_Token(String auth_code) {
		init();
		AlipaySystemOauthTokenRequest request=new AlipaySystemOauthTokenRequest();
		request.setCode(auth_code);
		request.setGrantType("authorization_code");
		try {
			AlipaySystemOauthTokenResponse response=alipayClient.execute(request);
			String access_token=response.getAccessToken();
			System.out.println("access_token="+access_token);
			return access_token;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "error";
		}
	}
		//获取用户信息
	public String getUserInfoByToken(String access_token,HttpServletRequest req) {
		AlipayUserInfoShareRequest request=new AlipayUserInfoShareRequest();
		try {
            AlipayUserInfoShareResponse response =  alipayClient.execute(request, access_token);
            if (response.isSuccess()) {
                //封装支付宝对象信息
            	AlipayUser user1=new AlipayUser(response.getAddress(), response.getCertNo(), response.getCity(), response.getCountryCode(),
            			response.getEmail(), response.getMobile(), response.getPhone(), response.getProvince(), 
            					response.getUserName(), response.getNickName());
            	ExcelUtil.writeObject(user1,req);
                return "yes";
            }
            System.out.println("根据 access_token获取用户信息失败!");
            return null;

        } catch (Exception e) {
        	 e.printStackTrace();
        	  System.out.println("根据 access_token获取用户信息抛出异常！");
            return null;
        }
    }
}
