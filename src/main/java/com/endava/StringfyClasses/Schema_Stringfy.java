package com.endava.StringfyClasses;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.entities.Fschema;
import com.entities.Positions;
import com.entities.SchemaStruct;
import com.entities.players;

public class Schema_Stringfy {
	private int id_schema;
	private String schema_name;
	private List players=new ArrayList();
	public Schema_Stringfy(Fschema fschema) {
		set_proprietes(fschema);//
	}
	
	private void set_proprietes(Fschema fschema)
	{
		
		this.id_schema=fschema.getId_schema();
		this.schema_name=fschema.getName();
		List<SchemaStruct> ss=fschema.getSchemastruct();
		for(int i=0;i<ss.size();i++)
		{
			Map<String,String> positions=new HashMap<String,String>();
			Map<String,String> data=new HashMap<String,String>();
			Map<String,String> qName=new HashMap<String,String>();
			List forOne=new ArrayList();
			SchemaStruct s=ss.get(i);
			positions.put("px", s.getPosition_X());
			positions.put("py", s.getPosition_Y());
			players pl=s.getPlayer();
			data.put("id_player", pl.getId_player().toString());
			data.put("name", pl.getName());
			Positions po=pl.getPosition();
			qName.put("id_pos",po.getId_pos().toString());
			qName.put("name",po.getName() );
			forOne.add(positions);
			forOne.add(data);
			forOne.add(qName);
			players.add(forOne);
		   
		}
		
	}

}
