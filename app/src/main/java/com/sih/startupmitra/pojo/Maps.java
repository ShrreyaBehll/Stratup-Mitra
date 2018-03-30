package com.sih.startupmitra.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Maps {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("organisation")
    @Expose
    private String organisation;
    @SerializedName("sector")
    @Expose
    private String sector;
    @SerializedName("loan_range")
    @Expose
    private Integer loanRange;
    @SerializedName("collateral")
    @Expose
    private Boolean collateral;
    @SerializedName("location")
    @Expose
    private String location;
    @SerializedName("source")
    @Expose
    private String source;
    @SerializedName("latitude")
    @Expose
    private Double latitude;
    @SerializedName("longitude")
    @Expose
    private Double longitude;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrganisation() {
        return organisation;
    }

    public void setOrganisation(String organisation) {
        this.organisation = organisation;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public Integer getLoanRange() {
        return loanRange;
    }

    public void setLoanRange(Integer loanRange) {
        this.loanRange = loanRange;
    }

    public Boolean getCollateral() {
        return collateral;
    }

    public void setCollateral(Boolean collateral) {
        this.collateral = collateral;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

}