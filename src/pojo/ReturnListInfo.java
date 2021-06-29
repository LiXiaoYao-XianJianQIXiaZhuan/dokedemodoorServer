package pojo;

import java.util.List;

public class ReturnListInfo<T> {
	private String msg;
	private boolean success;
	private List<T> dataList;
	
	public ReturnListInfo() {
	}
	
	public ReturnListInfo(String msg, boolean success, List<T> dataList) {
		this.msg = msg;
		this.success = success;
		this.dataList = dataList;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public List<T> getdataList() {
		return dataList;
	}

	public void setdataList(List<T> dataList) {
		this.dataList = dataList;
	}
	
	
	
	
}
