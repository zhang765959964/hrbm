package com.xunfeng.core.sms;

import java.util.List;

public interface IShortMessage {
	public boolean sendSms(List<String> mobiles, String message);
}
