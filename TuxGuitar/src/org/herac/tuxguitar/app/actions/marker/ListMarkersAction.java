/*
 * Created on 17-dic-2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package org.herac.tuxguitar.app.actions.marker;

import org.herac.tuxguitar.app.actions.Action;
import org.herac.tuxguitar.app.actions.ActionData;
import org.herac.tuxguitar.app.marker.MarkerList;

/**
 * @author julian
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class ListMarkersAction extends Action{
	
	public static final String NAME = "action.marker.list";
	
	public ListMarkersAction() {
		super(NAME, AUTO_LOCK | AUTO_UNLOCK | AUTO_UPDATE);
	}
	
	protected int execute(ActionData actionData){
		if(MarkerList.instance().isDisposed()){
			MarkerList.instance().show();
		}
		else{
			MarkerList.instance().dispose();
		}
		return 0;
	}
}
