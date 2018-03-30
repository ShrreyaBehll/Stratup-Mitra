package com.sih.startupmitra.pojo;

public class MyPojo
{
    private String sector;

    private String headed_by;

    private String source_of_grants;

    private String reg_link;

    private String collateral;

    private String scheme_name;

    private String lattitude;

    private String longitude;

    private String city_location;

    private String loan_range;

    private String serial_number;

    public String getSector ()
    {
        return sector;
    }

    public void setSector (String sector)
    {
        this.sector = sector;
    }

    public String getHeaded_by ()
    {
        return headed_by;
    }

    public void setHeaded_by (String headed_by)
    {
        this.headed_by = headed_by;
    }

    public String getSource_of_grants ()
    {
        return source_of_grants;
    }

    public void setSource_of_grants (String source_of_grants)
    {
        this.source_of_grants = source_of_grants;
    }

    public String getReg_link ()
    {
        return reg_link;
    }

    public void setReg_link (String reg_link)
    {
        this.reg_link = reg_link;
    }

    public String getCollateral ()
    {
        return collateral;
    }

    public void setCollateral (String collateral)
    {
        this.collateral = collateral;
    }

    public String getScheme_name ()
    {
        return scheme_name;
    }

    public void setScheme_name (String scheme_name)
    {
        this.scheme_name = scheme_name;
    }

    public String getLattitude ()
    {
        return lattitude;
    }

    public void setLattitude (String lattitude)
    {
        this.lattitude = lattitude;
    }

    public String getLongitude ()
    {
        return longitude;
    }

    public void setLongitude (String longitude)
    {
        this.longitude = longitude;
    }

    public String getCity_location ()
    {
        return city_location;
    }

    public void setCity_location (String city_location)
    {
        this.city_location = city_location;
    }

    public String getLoan_range ()
    {
        return loan_range;
    }

    public void setLoan_range (String loan_range)
    {
        this.loan_range = loan_range;
    }

    public String getSerial_number ()
    {
        return serial_number;
    }

    public void setSerial_number (String serial_number)
    {
        this.serial_number = serial_number;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [sector = "+sector+", headed_by = "+headed_by+", source_of_grants = "+source_of_grants+", reg_link = "+reg_link+", collateral = "+collateral+", scheme_name = "+scheme_name+", lattitude = "+lattitude+", longitude = "+longitude+", city_location = "+city_location+", loan_range = "+loan_range+", serial_number = "+serial_number+"]";
    }
}
