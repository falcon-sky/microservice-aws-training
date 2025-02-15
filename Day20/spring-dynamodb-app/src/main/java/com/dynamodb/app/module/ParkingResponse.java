package com.dynamodb.app.module;

import java.io.Serializable;
import java.util.Date;

public class ParkingResponse implements Serializable {
  private static final long serialVersionUID = 1L;
  private final String carRegNo;
  private final String parkingNo;
  private final Date startTime;
  private final Date endTime;
  private final String parkingStatus;

  private ParkingResponse(Builder builder) {
    carRegNo = builder.carRegNo;
    parkingNo = builder.parkingNo;
    startTime = builder.startTime;
    endTime = builder.endTime;
    parkingStatus = builder.parkingStatus;
  }

  public static Builder builder() {
    return new Builder();
  }

  public String getParkingNo() {
    return parkingNo;
  }

  public String getCarRegNo() {
    return carRegNo;
  }

  public Date getStartTime() {
    return startTime;
  }

  public Date getEndTime() {
    return endTime;
  }

  public String getParkingStatus() {
    return parkingStatus;
  }

  public static class Builder {
    private String carRegNo;
    private String parkingNo;
    private Date startTime;
    private Date endTime;
    private String parkingStatus;

    public Builder carRegNo(String carRegNo) {
      this.carRegNo = carRegNo;
      return this;
    }

    public Builder parkingNo(String parkingNo) {
      this.parkingNo = parkingNo;
      return this;
    }

    public Builder startTime(Date startTime) {
      this.startTime = startTime;
      return this;
    }

    public Builder endTime(Date endTime) {
      this.endTime = endTime;
      return this;
    }

    public Builder parkingStatus(String parkingStatus) {
      this.parkingStatus = parkingStatus;
      return this;
    }

    public ParkingResponse build() {
      return new ParkingResponse(this);
    }
  }
}
