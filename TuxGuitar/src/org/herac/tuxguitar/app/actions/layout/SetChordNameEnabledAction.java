/*
 * Created on 17-dic-2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package org.herac.tuxguitar.app.actions.layout;

import org.herac.tuxguitar.app.actions.Action;
import org.herac.tuxguitar.app.actions.ActionData;
import org.herac.tuxguitar.graphics.control.TGLayout;

/**
 * @author julian
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class SetChordNameEnabledAction extends Action{
	
	public static final String NAME = "action.view.layout-set-chord-name-enabled";
	
	public SetChordNameEnabledAction() {
		super(NAME, AUTO_LOCK | AUTO_UNLOCK | AUTO_UPDATE | KEY_BINDING_AVAILABLE);
	}
	
	protected int execute(ActionData actionData){
		TGLayout layout = getEditor().getTablature().getViewLayout();
		layout.setStyle( ( layout.getStyle() ^ TGLayout.DISPLAY_CHORD_NAME ) );
		updateTablature();
		return 0;
	}
}
