package com.entities;

import java.io.Serializable;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import javax.persistence.Transient;

@Entity
@Table(name = "schema_struct_position")
@AssociationOverrides({
	@AssociationOverride(name = "pk.schema", 
		joinColumns = @JoinColumn(name = "id_schema")),
	@AssociationOverride(name = "pk.player", 
		joinColumns = @JoinColumn(name = "id_player")) })
public class SchemaStruct {
	
	
	private SchemaStructID pk=new SchemaStructID();
	private String position_X;
	private String position_Y;
	
	@EmbeddedId
	public SchemaStructID getPk() {
		return pk;
	}
	public void setPk(SchemaStructID pk) {
		this.pk = pk;
	}
	
	@Transient
	public Fschema getSchema()
	{
		return getPk().getSchema();
	}
	public void setSchema(Fschema schema)
	{
		getPk().setSchema(schema);
	}
	
	@Transient
	public players getPlayer()
	{
		return getPk().getPlayer();
	}
	public void setPlayer(players player)
	{
		getPk().setPlayer(player);
	}
	@Column(name="position_X")
	public String getPosition_X() {
		return position_X;
	}
	public void setPosition_X(String position_X) {
		this.position_X = position_X;
	}
	@Column(name="position_Y")
	public String getPosition_Y() {
		return position_Y;
	}
	public void setPosition_Y(String position_Y) {
		this.position_Y = position_Y;
	}
	
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
 
		SchemaStruct that = (SchemaStruct) o;
 
		if (getPk() != null ? !getPk().equals(that.getPk())
				: that.getPk() != null)
			return false;
 
		return true;
	}
 
	public int hashCode() {
		return (getPk() != null ? getPk().hashCode() : 0);
	}
	
	
		

}
