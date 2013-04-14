package com.technotalkative.saxparsing;

import java.util.ArrayList;
/**
 * 
 * @author Paresh N. Mayani
 * email: pareshmayani@gmail.com
 *
 */
public class ItemList 
{
	ArrayList<String> item = new ArrayList<String>();
	ArrayList<String> manufacturer = new ArrayList<String>();
	ArrayList<String> model = new ArrayList<String>();
	ArrayList<String> cost = new ArrayList<String>();
	
	public ArrayList<String> getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item.add(item);
	}
	public ArrayList<String> getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer.add(manufacturer);
	}
	public ArrayList<String> getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model.add(model);
	}
	public ArrayList<String> getCost() {
		return cost;
	}
	public void setCost(String cost) {
		this.cost.add(cost);
	}
}
