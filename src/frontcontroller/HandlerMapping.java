package frontcontroller;

import java.util.HashMap;

import arduino.controller.Coupon;
import arduino.controller.Echo;
import arduino.controller.QrCode;
import arduino.controller.TrashRfid;
import arduino.controller.Vending;
import controller.Controller;
import controller.GoStoryImage;
import controller.LoginController;
import controller.LoginForm;
import controller.LogoutController;
import controller.ServiceInfoController;
import controller.UserMain;
import controller.joinController;
import controller.joinFormController;
import controller.mainController;
import controller.viewtest;
import user.controller.MemberIdConfirm;
import user.controller.MyInfoController;
import user.controller.MyInfoIframeController;
import user.controller.NoticeController;
import user.controller.UserBoardContentController;
import user.controller.UserBoardContentDeleteController;
import user.controller.UserBoardInsertController;
import user.controller.UserBoardInsertFormController;
import user.controller.UserBoardListController;
import user.controller.UserBoardRealController;
import user.controller.UserBoardUpdateController;
import user.controller.UserNoticeListController;
import user.controller.UserUpdateController;

public class HandlerMapping {

	private HashMap<String, Controller> mappings;

	public HandlerMapping() {
		mappings = new HashMap<String, Controller>();

		initUrl();

	}

	public void initUrl() {

		
		// 아두이노
		mappings.put("/trashrfid.do",new TrashRfid());
		mappings.put("/echo.do",new Echo());
		mappings.put("/vending.do",new Vending());
		
		
		mappings.put("/qrcode.do",new QrCode());
		mappings.put("/coupon.do",new Coupon());
		
		
		
		// 게시판
		mappings.put("/userboard.do", new UserBoardListController());
		mappings.put("/usernotice.do", new UserNoticeListController());
		mappings.put("/boardwriteform.do", new UserBoardInsertFormController());
		mappings.put("/boardwrite.do", new UserBoardInsertController());
		mappings.put("/boardcontent.do", new UserBoardContentController());
		mappings.put("/boardupdate.do", new UserBoardUpdateController());
		mappings.put("/noticelist.do", new UserNoticeListController());
		mappings.put("/notice.do", new NoticeController());
		mappings.put("/userboarddelete.do", new UserBoardContentDeleteController());
		
		

		// mainpage 관련 모음
		mappings.put("/main.do", new mainController());
		mappings.put("/joinform.do", new joinFormController());		
		mappings.put("/memberinsert.do", new joinController());
		mappings.put("/memberidconfirm.do", new MemberIdConfirm());
		mappings.put("/loginform.do", new LoginForm());
		mappings.put("/login.do", new LoginController());
		mappings.put("/viewtest.do", new viewtest());
		mappings.put("/usermain.do", new UserMain());
		mappings.put("/boardreal.do", new UserBoardRealController());
		mappings.put("/serviceinfo.do", new ServiceInfoController());
		mappings.put("/myinfo.do", new MyInfoController());
		mappings.put("/userinfoiframe.do", new MyInfoIframeController());
		mappings.put("/logout.do", new LogoutController());
		mappings.put("/memberupdate.do", new UserUpdateController());
		mappings.put("/gostoryimage.do", new GoStoryImage());
		

	}

	public Controller getController(String key) {

		return mappings.get(key);
	}

}
