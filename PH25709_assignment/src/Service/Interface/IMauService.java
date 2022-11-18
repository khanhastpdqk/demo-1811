/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service.Interface;

import entity.Mau;
import java.util.List;

/**
 *
 * @author FPTSHOP
 */
public interface IMauService {

    public void insert(Mau mau);

    public List<Mau> getAll();
}
