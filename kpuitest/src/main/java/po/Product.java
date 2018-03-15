package po;

import java.util.List;

/**
 * product 对应的实体类
 */
public class Product {

    String pName;
    String pNum;
    String pBrand;
    String pLocation;
    String pSize;
    String[] mupltiProductSize;
    String wholeSalePrice;
    String salePrice;
    String pUnit;
    String pCost;
    String[] pTag;
    String pNote;

    //constructor

    public Product(String pName, String pNum, String pBrand, String pLocation, String pSize, String[] mupltiProductSize, String wholeSalePrice, String salePrice, String pUnit, String pCost, String[] pTag, String pNote) {
        this.pName = pName;
        this.pNum = pNum;
        this.pBrand = pBrand;
        this.pLocation = pLocation;
        this.pSize = pSize;
        this.mupltiProductSize = mupltiProductSize;
        this.wholeSalePrice = wholeSalePrice;
        this.salePrice = salePrice;
        this.pUnit = pUnit;
        this.pCost = pCost;
        this.pTag = pTag;
        this.pNote = pNote;
    }

    //without size and tag
    public Product(String pName, String pNum, String pBrand, String pLocation, String wholeSalePrice, String salePrice, String pUnit, String pCost) {
        this.pName = pName;
        this.pNum = pNum;
        this.pBrand = pBrand;
        this.pLocation = pLocation;
        this.wholeSalePrice = wholeSalePrice;
        this.salePrice = salePrice;
        this.pUnit = pUnit;
        this.pCost = pCost;
    }

    public Product(){

    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getPnum() {
        return pNum;
    }

    public void setPnum(String pNum) {
        pNum = pNum;
    }

    public String getpBrand() {
        return pBrand;
    }

    public void setpBrand(String pBrand) {
        this.pBrand = pBrand;
    }

    public String getpLocation() {
        return pLocation;
    }

    public void setpLocation(String pLocation) {
        this.pLocation = pLocation;
    }

    public String getpSize() {
        return pSize;
    }

    public void setpSize(String pSize) {
        this.pSize = pSize;
    }

    public String[] getMupltiProductSize() {
        return mupltiProductSize;
    }

    public void setMupltiProductSize(String[] mupltiProductSize) {
        this.mupltiProductSize = mupltiProductSize;
    }

    public String getWholeSalePrice() {
        return wholeSalePrice;
    }

    public void setWholeSalePrice(String wholeSalePrice) {
        this.wholeSalePrice = wholeSalePrice;
    }

    public String getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(String salePrice) {
        this.salePrice = salePrice;
    }

    public String getpUnit() {
        return pUnit;
    }

    public void setpUnit(String pUnit) {
        this.pUnit = pUnit;
    }

    public String getpCost() {
        return pCost;
    }

    public void setpCost(String pCost) {
        this.pCost = pCost;
    }

    public String[] getpTag() {
        return pTag;
    }

    public void setpTag(String[] pTag) {
        this.pTag = pTag;
    }

    public String getpNote() {
        return pNote;
    }

    public void setpNote(String pNote) {
        this.pNote = pNote;
    }
}
