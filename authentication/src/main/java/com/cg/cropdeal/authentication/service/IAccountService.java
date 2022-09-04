package com.cg.cropdeal.authentication.service;


import com.cg.cropdeal.authentication.model.MyRequestModel;
import com.cg.cropdeal.authentication.model.MyResponseModel;

interface IAccountService {
//	INTERFACE WITH NECESSARY METHODS
	
	MyResponseModel signInWithEmail(MyRequestModel req);
	
	MyResponseModel signUpWithEmail(MyRequestModel req);
	
	MyResponseModel resetPassword(MyRequestModel req);
	
}
