package com.ppqa.util;

public class AtrributePostionTO {

	
	/**
	 * 
	 * @author Saurabh Kumar
	 * @version 1.0 
	 * 
	 *
	 */
	
	
	private String attribute;
	private int position;

	/**
	 * Default Constructor
	 */
	public AtrributePostionTO() {
	}

	/**
	 * @param attribute
	 * @param position
	 */
	public AtrributePostionTO(String attribute, int position) {
		this.attribute = attribute;
		this.position = position;
	}

	/**
	 * @return the attribute
	 */
	public String getAttribute() {
		return attribute;
	}

	/**
	 * @param attribute
	 *            the attribute to set
	 */
	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}

	/**
	 * @return the position
	 */
	public int getPosition() {
		return position;
	}

	/**
	 * @param position
	 *            the position to set
	 */
	public void setPosition(int position) {
		this.position = position;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((attribute == null) ? 0 : attribute.hashCode());
		result = prime * result + position;
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof AtrributePostionTO))
			return false;
		AtrributePostionTO other = (AtrributePostionTO) obj;
		if (attribute == null) {
			if (other.attribute != null)
				return false;
		} else if (!attribute.equals(other.attribute))
			return false;
		if (position != other.position)
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AtrributePostion [attribute=" + attribute + ", position=" + position + "]";
	}

	
	
	
}
