
package com.example.backend.dto;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
public class CarRequest {
    private Long ownerId;
    @NotBlank
    private String brand;
    @NotBlank
    private String model;
    @Min(1900)
    private int year;
    public CarRequest(){

    }
   public CarRequest(String brand, String model, int year){
        this.brand=brand;
        this.model=model;
        this.year=year;
    }
    public String getBrand(){
        return brand;
    }
    public void setBrand(String brand){
        this.brand=brand;
    }
    public String getModel(){
        return model;
    }
    public void setModel(String model){
        this.model=model;
    }
    public int getYear(){
        return year;
    }
    public void setYear(int year){
        this.year=year;
    }
    public Long getOwnerId(){
        return ownerId;
    }
    public void setOwnerId(Long ownerId){
        this.ownerId=ownerId;
    }
}
