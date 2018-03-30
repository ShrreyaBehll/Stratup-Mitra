package com.sih.startupmitra.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MyPojo {

    @SerializedName("serial_number")
    @Expose
    private String serialNumber;
    @SerializedName("scheme_name")
    @Expose
    private String schemeName;
    @SerializedName("headed_by")
    @Expose
    private String headedBy;
    @SerializedName("sector")
    @Expose
    private String sector;
    @SerializedName("loan_range")
    @Expose
    private String loanRange;
    @SerializedName("collateral")
    @Expose
    private String collateral;
    @SerializedName("city_location")
    @Expose
    private String cityLocation;
    @SerializedName("source_of_grants")
    @Expose
    private String sourceOfGrants;
    @SerializedName("lattitude")
    @Expose
    private String lattitude;
    @SerializedName("longitude")
    @Expose
    private String longitude;
    @SerializedName("reg_link")
    @Expose
    private String regLink;

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getSchemeName() {
        return schemeName;
    }

    public void setSchemeName(String schemeName) {
        this.schemeName = schemeName;
    }

    public String getHeadedBy() {
        return headedBy;
    }

    public void setHeadedBy(String headedBy) {
        this.headedBy = headedBy;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public String getLoanRange() {
        return loanRange;
    }

    public void setLoanRange(String loanRange) {
        this.loanRange = loanRange;
    }

    public String getCollateral() {
        return collateral;
    }

    public void setCollateral(String collateral) {
        this.collateral = collateral;
    }

    public String getCityLocation() {
        return cityLocation;
    }

    public void setCityLocation(String cityLocation) {
        this.cityLocation = cityLocation;
    }

    public String getSourceOfGrants() {
        return sourceOfGrants;
    }

    public void setSourceOfGrants(String sourceOfGrants) {
        this.sourceOfGrants = sourceOfGrants;
    }

    public String getLattitude() {
        return lattitude;
    }

    public void setLattitude(String lattitude) {
        this.lattitude = lattitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getRegLink() {
        return regLink;
    }

    public void setRegLink(String regLink) {
        this.regLink = regLink;
    }

}
