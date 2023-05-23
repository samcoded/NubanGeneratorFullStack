package me.samuelanozie.nubangenerator.model;

import jakarta.persistence.*;

@Entity
@Table(name = "nuban")
public class NubanModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "bank_code")
    private String bankCode;
    @Column(name = "serial_number")
    private String serialNumber;
    @Column(name = "nuban_number")
    private String nubanNumber;


    public NubanModel() {
        super();
    }
    public NubanModel(String bankCode, String serialNumber, String nubanNumber) {
        super();
        this.bankCode = bankCode;
        this.serialNumber = serialNumber;
        this.nubanNumber = nubanNumber;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getNubanNumber() {
        return nubanNumber;
    }

    public void setNubanNumber(String nubanNumber) {
        this.nubanNumber = nubanNumber;
    }

    @Override
    public String toString() {
        return "NubanModel{" +
                "bankCode='" + bankCode + '\'' +
                ", serialNumber='" + serialNumber + '\'' +
                ", nubanNumber='" + nubanNumber + '\'' +
                '}';
    }
}
