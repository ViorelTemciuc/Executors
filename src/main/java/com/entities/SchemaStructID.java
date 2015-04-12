package com.entities;
import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
public class SchemaStructID implements Serializable{
	
	private Fschema schema;
	private players player;
	@ManyToOne
	public Fschema getSchema() {
		return schema;
	}
	public void setSchema(Fschema schema) {
		this.schema = schema;
	}
	@ManyToOne
	public players getPlayer() {
		return player;
	}
	public void setPlayer(players player) {
		this.player = player;
	}
	 public boolean equals(Object o)
	 {
		 if (this == o) return true;
	        if (o == null || getClass() != o.getClass()) return false;
	 
	        SchemaStructID that = (SchemaStructID) o;
	 
	        if (schema != null ? !schema.equals(that.schema) : that.schema != null) return false;
	        if (player != null ? !player.equals(that.player) : that.player != null)
	            return false;
	 
	        return true;
	 }
	 public int hashCode() {
	        int result;
	        result = (schema != null ? schema.hashCode() : 0);
	        result = 31 * result + (player != null ? player.hashCode() : 0);
	        return result;
	    }

}
