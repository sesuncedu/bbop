package org.bbop.swing.autocomplete;

import java.util.Collection;
import java.util.LinkedList;

import org.apache.log4j.*;

public class StringListAutocompleteModel extends
	AbstractListAutocompleteModel<String> {

	//initialize logger
	protected final static Logger logger = Logger.getLogger(StringListAutocompleteModel.class);

	public StringListAutocompleteModel() {
		this(new LinkedList<String>());
	}

	public StringListAutocompleteModel(Collection<String> strings) {
		setValues(strings);
	}

	public String createValue(String val) {
		return val;
	}

	public Class<String> getDisplayType() {
		return String.class;
	}

	public Class<String> getOutputType() {
		return String.class;
	}

	public String toString(String val) {
		return val;
	}
}
