package pageObjects;

public class Loc {

	/**
	 * 存放用于各个页面定位的的ui元素，保存为静态常量
	 */

	// login page
	static final String LIVE_LOGO = "logo_login";
	static final String PHONE_LOGINID = "ic login phone white";
	static final String PHONE_LOGINXP = "//UIAApplication[1]/UIAWindow[1]/UIAButton[5]";
	static final String INS_LOGINXPID = "ic login ins";
	static final String INS_LOGINXPXP = "//UIAApplication[1]/UIAWindow[1]/UIAButton[4]";
	
	static final String LOGIN_BAR="GLSignUpOrLoginView";
	static final String DO_LOGIN = "//UIAApplication[1]/UIAWindow[1]/UIAStaticText[1]";
	static final String MORE_LOGINID = "More";
	static final String COUNTRY_CODEID = "+62";
	static final String CHINA_CODEID = "China / +86";
	static final String CHINA_CODEXP = "//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[2]";
	static final String CHOSE_OTHER_LOGIN = "Log Into Another Account";
	static final String QUICK_LOGIN = "//UIAApplication[1]/UIAWindow[1]/UIAButton[8]";
	static final String CHANGE_LOGIN = "//UIAApplication[1]/UIAWindow[1]/UIAButton[3]";
	static final String ACCOUNT = "//UIAApplication[1]/UIAWindow[1]/UIATextField[1]";
	static final String PASSWORD = "//UIAApplication[1]/UIAWindow[1]/UIASecureTextField[1]";
	static final String NEXT_STEP = "";
	static final String LOGIN = "//UIAApplication[1]/UIAWindow[1]/UIAButton[2]";
	//FB
	static final String FB_ID = "ic login fb";
	static final String FB_XP = "//UIAApplication[1]/UIAWindow[1]/UIAButton[2]";
	static final String FB_LOGIN_PAGEID="URL";//URL VALUE = facebook.com
	static final String FB_LOGOID="facebook";
	static final String FB_SURE="//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[2]";
	static final String FB_DONE="DoneID";
	static final String FB_ACCOUNT="//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIATextField[1]";
	static final String FB_PASSWORD="//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIASecureTextField[1]";
	static final String FB_LOGINID="Log In";
	static final String FB_LOGINXP="//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAButton[1]";
	static final String FB_GOON="//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAButton[1]";
	//Twitter
	static final String TW_ID = "ic login twitter";
	static final String TW_XP = "//UIAApplication[1]/UIAWindow[1]/UIAButton[3]";
	static final String TW_LOGOID="Twitter";
	static final String TW_ACCOUNT="//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIATextField[1]";
	static final String TW_PASSWORD="//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIASecureTextField[1]";
	static final String REMEMBERXP="//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIASwitch[1]";
	static final String TW_LOGINID="Sign In";
	static final String TW_LOGINXP="//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAButton[1]";
	static final String TW_AUTH="//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAButton[1]";
	//Google
	static final String GOOGLEID = "ic login google";
	static final String GOOGLEXP = "//UIAApplication[1]/UIAWindow[1]/UIAButton[7]";
	static final String GOOGLE_LOGOID="GLive";
	static final String GOOGLE_ACCOUNT="//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIATextField[1]";
	static final String GOOGLE_NEXTID="NEXT";
	static final String GOOGLE_PASSWORD="Enter your password";
	static final String GOOGLE_LOGINID="NEXT";
	
	// homePage
	static final String USER_INFO = "//UIAApplication[1]/UIAWindow[1]/UIATabBar[1]/UIAButton[4]";
	static final String START_LIVEID = "ic golive";
	static final String START_LIVEXP = "//UIAApplication[1]/UIAWindow[1]/UIATabBar[1]/UIAButton[1]";
	static final String SIGN_TITLEID=" title_dialog_checkin";
	static final String SIGN_ID="Check in";
	static final String SIGN_DAYS="//UIAApplication[1]/UIAWindow[1]/UIAStaticText[1]";//String.subString(0) to get sign day;
	static final String SIGN_SUREID="Confirm";

	// userPage
	static final String SETTINGID = "ic_self_settings";
	static final String SETTINGXP = "//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIAImage[2]";
	static final String INFO_EDITID = "ic self edit";
	static final String INFO_EDITXP = "//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIAButton[2]";

	// settingPage
	static final String LOG_OUT = "//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[9]";
	static final String SURE = "//UIAApplication[1]/UIAWindow[1]/UIAAlert[1]/UIACollectionView[1]/UIACollectionCell[2]";
	static final String CANCLE = "//UIAApplication[1]/UIAWindow[1]/UIAAlert[1]/UIACollectionView[1]/UIACollectionCell[1]";

}
