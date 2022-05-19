//package com.demo.main.common;
//
//import java.net.ConnectException;
//import java.sql.SQLException;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.dao.DataAccessException;
//import org.springframework.dao.DuplicateKeyException;
//import org.springframework.http.HttpStatus;
//import org.springframework.validation.BindException;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.ResponseStatus;
//import org.springframework.web.bind.annotation.RestControllerAdvice;
//
//import org.geopaas.api.common.util.CodeType;
//import org.geopaas.api.common.vo.ResponseModel;
//
//@RestControllerAdvice
//public class RestControllerExceptionAdvice {
//
//	private Logger logger = LoggerFactory.getLogger(this.getClass());
//	
//	private String getLocationMessage(Exception e) {
//		StackTraceElement[] stes = e.getStackTrace();
//		if(stes==null||stes.length==0) {
//			return e.getClass().getName();
//		}
//		StackTraceElement ste = stes[0];
//		String fileName = ste.getFileName();
//		String className = ste.getClassName();
//		String methodName = ste.getMethodName();
//		int lineNumber = ste.getLineNumber();
//		String locationMessage = "Exception Occured at file "+fileName+" line "+lineNumber+" class "+className+"."+methodName+"()";
//		return locationMessage;
//	}
//
//	public void console(Exception e) {
//		logger.error(getLocationMessage(e)+"\nmessage : "+e.getMessage());
//	}
//	
//	/**
//	 * 에러 유형 - ConnectException 
//	 * 500 상태
//	 * */
//	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
//	@ExceptionHandler(ConnectException.class)
//	public Object handleConnectException(HttpServletRequest request, HttpServletResponse response, ConnectException e) {
//		console(e);
//		ResponseModel<String> responseModel = new ResponseModel<>(); 
//		responseModel.setCode(CodeType.ERROR_ETC.code);
//		responseModel.setMessage(CodeType.ERROR_ETC.message);
//		responseModel.setResult(e.getMessage());
//		return new ResponseModel<>();	
//	}
//	/**
//	 * 에러 유형 - SQLException 
//	 * 500 상태
//	 * */
//	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
//	@ExceptionHandler(SQLException.class)
//	public Object handlerSQLException(HttpServletRequest request, HttpServletResponse response, SQLException e) {
//		console(e);
//		ResponseModel<String> responseModel = new ResponseModel<>(); 
//		responseModel.setCode(CodeType.ERROR_ETC.code);
//		responseModel.setMessage(CodeType.ERROR_ETC.message);
//		responseModel.setResult(e.getMessage());
//		return responseModel;	
//	}
//	
//	/**
//	 * 에러 유형 - DuplicateKeyException 
//	 * 500 상태
//	 * */
//	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
//	@ExceptionHandler(DuplicateKeyException.class)
//	public Object handlerSQLException(HttpServletRequest request, HttpServletResponse response, DuplicateKeyException e) {
//		console(e);
//		ResponseModel<String> responseModel = new ResponseModel<>(); 
//		responseModel.setCode(CodeType.ERROR_ETC.code);
//		responseModel.setMessage(CodeType.ERROR_ETC.message);
//		responseModel.setResult(e.getMessage());
//		return responseModel;	
//	}
//	
//	@ResponseStatus(HttpStatus.BAD_REQUEST)
//	@ExceptionHandler(BindException.class)
//	public Object handlerSQLException(HttpServletRequest request, HttpServletResponse response, BindException e) {
//		console(e);
//		ResponseModel<String> responseModel = new ResponseModel<>(); 
//		responseModel.setCode(CodeType.ERROR_BAD_PARAM.code);
//		responseModel.setMessage(CodeType.ERROR_BAD_PARAM.message);
//		responseModel.setResult(e.getMessage());
//		return responseModel;
//	}
//	
//	/**
//	 * 에러 유형 - DataAccessException 
//	 * 500 상태
//	 * */
//	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
//	@ExceptionHandler(DataAccessException.class)
//	public Object handlerDataAccessException(HttpServletRequest request, HttpServletResponse response, DataAccessException e) {
//		console(e);
//		ResponseModel<String> responseModel = new ResponseModel<>(); 
//		responseModel.setCode(CodeType.ERROR_ETC.code);
//		responseModel.setMessage(CodeType.ERROR_ETC.message);
//		responseModel.setResult(e.getMessage());
//		return responseModel;
//	}
//	
//	/**
//	 * 에러 유형 - Exception 
//	 * 500 상태
//	 * */
//	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
//	@ExceptionHandler(Exception.class)
//	public Object handlerException(HttpServletRequest request, HttpServletResponse response, Exception e) {
//		console(e);
//		ResponseModel<String> responseModel = new ResponseModel<>(); 
//		responseModel.setCode(CodeType.ERROR_ETC.code);
//		responseModel.setMessage(CodeType.ERROR_ETC.message);
//		responseModel.setResult(e.getMessage());
//		return responseModel;
//	}
//	
//	/**
//	 * 에러 유형 - ApiException 
//	 * 400 상태
//	 * */
//	@ResponseStatus(HttpStatus.BAD_REQUEST)
//	@ExceptionHandler(ApiException.class)
//	public Object handlerApiException(HttpServletRequest request, HttpServletResponse response, ApiException e) {
//		console(e);
//		ResponseModel<String> responseModel = new ResponseModel<>();
//		CodeType codeType = e.getCodeType();
//		if (codeType != null) {
//			responseModel.setCode(codeType.getCode());
//			responseModel.setMessage(codeType.getMessage());
//			responseModel.setResult(e.getMessage());
//		}else {
//			responseModel.setCode(CodeType.ERROR.code);
//			responseModel.setMessage(CodeType.ERROR.message);
//			responseModel.setResult(e.getMessage());
//		}
//		return responseModel;
//	}
//}
