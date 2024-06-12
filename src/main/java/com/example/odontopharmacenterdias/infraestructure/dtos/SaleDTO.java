package com.example.odontopharmacenterdias.infraestructure.dtos;

import com.example.odontopharmacenterdias.entities.enums.PaymentMethod;
import com.example.odontopharmacenterdias.entities.Sale;
import com.example.odontopharmacenterdias.entities.SaleItem;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class SaleDTO implements Serializable {
    Long id;
    Date saleDate;
    CostumerDTO costumer;
    EmployeeDTO employee;
    List<SaleItemDTO> items;
    Double discount;
    Double totalAmount;
    PaymentMethod paymentMethod;
    String paymentReceipt;


    public SaleDTO getDTOfromEntity(Sale sale){
        SaleDTO dto = new SaleDTO();
        dto.id = sale.getId();
        dto.saleDate = sale.getSaleDate();
        dto.costumer = new CostumerDTO().getDTOfromEntity(sale.getCostumer());
        dto.employee = new EmployeeDTO().getDTOfromEntity(sale.getEmployee());
        dto.items = convertListItems(sale.getItems());
        dto.discount = sale.getDiscount();
        dto.totalAmount = sale.getTotalAmount();
        dto.paymentMethod = sale.getPaymentMethod();
        dto.paymentReceipt = sale.getPaymentReceipt();
        return dto;
    }

    public List<SaleItemDTO> convertListItems(List<SaleItem> items){
        List<SaleItemDTO> dtos = new ArrayList<>();
        for (SaleItem item : items){
            SaleItemDTO dto = new SaleItemDTO();
            dto = dto.getDTOfromEntity(item);
            dtos.add(dto);
        }
        return dtos;
    }

}
