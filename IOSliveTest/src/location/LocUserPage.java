package location;

public class LocUserPage {

	public static final String COMMON = "//UIAApplication[1]/UIAWindow[1]/";
	// userPage
	public static final String SETTINGID = "ic_self_settings";
	public static final String SETTINGXP = COMMON + "UIANavigationBar[1]/UIAImage[2]";
	public static final String INFO_EDITID = "ic self edit";
	public static final String INFO_EDITXP = "COMMON+UIANavigationBar[1]/UIAButton[2]";

	public static final String MY_BADGE_ID = "My badge";
	public static final String MY_BADGETITLE_ID = "My badge";
	public static final String MY_BADGENUMBER = COMMON + "UIAStaticText[2]";
	public static final String MY_BADGE_CLASS = "UIACollectionCell";// not end with badge
	public static final String MY_BADGE_TYPE_CLASS = "UIACollectionCell";// end wth badge
	public static final String BADGE_NOT_OBTAIN = COMMON + "UIAButton[1]";

	public static final String COINS_ID = "Coins";// 包含金币信息
	public static final String COINS_CLASS = "UIAStaticText";// value 值为［1］
	public static final String COIN_PAGES_COIN = COMMON + "UIATableView[1]/UIAStaticText[2]";
	public static final String COINS_TITLEID = "My Coins";
	public static final String CONIS_BACKID = "ic back";
	public static final String COINS_RECORDID = "ic record";
	public static final String COINS_RECHARGE_TITLEID = "Recharge record";
	public static final String ABLE_CHARGE_CLASS = "UIATableCell";
	public static final String RECHARGE_WINDOWID = "Sign In";
	public static final String CANCEL_RECHARGEID = "Cancel";
	// 钻石
	public static final String DIAMONDS_ID = "Diamonds";// 包含钻石信息
	public static final String DIAMONDS_EXCHANGE_RECORDID = "ic record";
	public static final String DIAMONDS_TITLEID = "pic_diamonds";
	public static final String DIAMONDS_NUM_INPAGE = COMMON + "UIAScrollView[1]/UIAStaticText[2]";
	public static final String DIAMONSA_NUM_CLASS = "UIAStaticText";
	public static final String DIAMONDS_EXCHANGEID = "Exchange";
	public static final String DIAMONDS_CASHOUTID = "Cash out";
	public static final String DIAMONDS_EXCHANGE_PRICE_CLASS = "UIATableCell";
	public static final String DIAMONDS_PRICECLASS = "UIAButton";
	public static final String DIAMONDS_ECHANGEOK = "Ok";
	public static final String ABLECASH = COMMON + "UIAScrollView[1]/UIAStaticText[3]";
	public static final String EXCHANGE_PAGE_DIAMOND = COMMON + "UIATableView[1]/UIAStaticText[2]";
	public static final String CASHNUM_CLASS = "UIATextField";
	public static final String CASH_BACKID = "ic back";
	public static final String CASH_INFO_FIRSTNAME = COMMON + "UIATableView[1]/UIATableCell[1]/UIATextField[1]";
	public static final String CASH_INFO_LASTNAME = COMMON + "UIATableView[1]/UIATableCell[2]/UIATextField[1]";
	public static final String CASH_INFO_EMAIL = COMMON + "UIATableView[1]/UIATableCell[3]/UIATextField[1]";
	public static final String CASH_INFO_CARDNUM = COMMON + "UIATableView[1]/UIATableCell[4]/UIATextField[1]";
	public static final String CASH_INFO_BANKNAME = COMMON + "UIATableView[1]/UIATableCell[4]/UIATextField[1]";
	public static final String CASH_NEXTID = "Next";

	// public static final String

	public static final String RECHARGE_ID = "Recharge";
	public static final String LEVEL_ID = "Level";// 用户等级

	public static final String BROADCAST_LEVEL_ID = "Broadcast Level";// 主播等级
	public static final String BROADCAST_LEVEL_TITLEID = "Broadcast Level";
	public static final String BROADCAST_CONTINUELY_DAY = COMMON + "UIATableView[1]/UIATableGroup[1]/UIAButton[1]";
	public static final String BROADCAST_DAY = COMMON + "UIATableView[1]/UIAStaticText[2]";
	public static final String BROADCAST_TITLE = COMMON + "UIATableView[1]/UIACollectionView[1]/UIACollectionCell[5]";
	public static final String ANCHOR_CERTIFICATION = "Anchor certification";
	public static final String ANCHOR_CERTIFICATION_ONE = COMMON + "UIAButton[2]";
	public static final String ANCHOR_CERTIFICATION_CONDITIONS = "UIATableCell";

	public static final String CONTRIBUTE_RANK_ID = "Contribute Rank";
	public static final String CONTRIBUTE_USER_CLASS="UIATableCell";
	public static final String CONTRIBUTE_USER_INFO_CLASS="UIAStaticText";//[0],[1],[2]
	public static final String OTHER_USER_INFO_CLASS="UIANavigationBar";
	public static final String CONTRIBUTE_FIRST="ic_rank_first";
	public static final String USER_MOREID="btn more";//其他用户个人信息页面操作按钮
	public static final String ACTION_USER="UIACollectionView";
	public static final String CANCLE_USER_ACTIONID="Cancel";
	
	public static final String EDIT_TITLEID = "Edit";
	public static final String USER_NAME_CLASS = "UIANavigationBar";// get name /get value
	public static final String EDIT_USERNAME = COMMON + "UIATableView[1]/UIATableCell[1]/UIATextField[1]";
	public static final String EDIT_SEX = COMMON + "UIATableView[1]/UIATableCell[2]";
	public static final String EDIT_BIRTHDAY = COMMON + "UIATableView[1]/UIATableCell[3]";
	public static final String BIRTHDAY = EDIT_BIRTHDAY + "/UIATextField[1]";
	public static final String BIRTHDAY_PICK_CALSS = "UIAPickerWheel";// 0:month ,1:day, 2:year
	public static final String DONE_ID = "Done";

	public static final String BACK_ID = "ic back";
	public static final String NOW_SEX = COMMON + "UIATableView[1]/UIATableCell[2]/UIATextField[1]";
	public static final String SAVE_INFOID = "Save";
	public static final String EDIT_PICID = "ic edit pic";
	public static final String CANCLE_ID = "Cancle";
	public static final String CHOSE_PHOTOID = "Choose a photo";
	public static final String TAKE_PHOTOID = "Take a picture";

	public static final String SEX_SECRETID = "Secret";
	public static final String SEX_FEMALEID = "Female";
	public static final String SEX_MALEID = "Male";
	// public static final String

}
