package com.technotalkative.saxparsing.adapter;

import java.util.ArrayList;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.technotalkative.saxparsing.R;

public class myAdapter extends BaseAdapter 
{
	ArrayList<String> listItem;
	ArrayList<String> listManufacturer;
	ArrayList<String> listModel;
	ArrayList<String> listCost;
	
	Activity activity;
	
	public myAdapter(Activity activity, ArrayList<String> listItem,ArrayList<String> listManufacturer, 
			ArrayList<String> listModel, ArrayList<String> listCost) {
		super();
		this.listItem = listItem;
		this.listManufacturer = listManufacturer;
		this.listModel = listModel;
		this.listCost = listCost;
		
		this.activity = activity;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return listItem.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	private class ViewHolder
	{
		TextView txtViewItem;
		TextView txtViewManu;
		TextView txtViewModel;
		TextView txtViewCost;
	}
	
	@Override
	public View getView(int position, View view, ViewGroup parent) {
		// TODO Auto-generated method stub
		
		ViewHolder item;
		LayoutInflater inflater = activity.getLayoutInflater();
		
		if(view==null)
		{
			view = inflater.inflate(R.layout.lview_row, null);
			item = new ViewHolder();
			
			item.txtViewItem = (TextView) view.findViewById(R.id.txtItem);
			item.txtViewManu = (TextView) view.findViewById(R.id.txtManufacturer);
			item.txtViewModel = (TextView) view.findViewById(R.id.txtModel);
			item.txtViewCost = (TextView) view.findViewById(R.id.txtCost);
			
			view.setTag(item);
		}
		else
		{
			item = (ViewHolder) view.getTag();
		}
		
		item.txtViewItem.setText(listItem.get(position));
		item.txtViewManu.setText(listManufacturer.get(position));
		item.txtViewModel.setText(listModel.get(position));
		item.txtViewCost.setText(listCost.get(position));
		
		return view;
	}
}
